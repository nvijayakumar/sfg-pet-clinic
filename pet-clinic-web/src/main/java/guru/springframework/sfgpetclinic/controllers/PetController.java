/**
 * 
 */
package guru.springframework.sfgpetclinic.controllers;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author vijayakumar
 * @Since  31-May-2022
 *
 */
@Slf4j
@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {

	private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "/pets/createOrUpdatePetForm";
	
	private final PetService petService;
	private final OwnerService ownerService;
	private final PetTypeService petTypeService;
	
	public PetController(PetService petService, OwnerService ownerService, PetTypeService petTypeService) {
		this.petService = petService;
		this.ownerService = ownerService;
		this.petTypeService = petTypeService;
	}
	
	@ModelAttribute("types")
	public Collection<PetType> populatePetTypes() {
		return petTypeService.findAll();
	}
	
	@ModelAttribute("owner")
	public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
		return ownerService.findById(ownerId);
	}
	
    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
	
	@GetMapping("/pets/new")
	public String initCreationForm(Owner owner, Model model) {
		Pet pet = new Pet();
		owner.getPets().add(pet);
		pet.setOwner(owner);
		model.addAttribute("pet", pet);
		return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
	}
	
	@PostMapping("/pets/new")
	public String processCreationForm(Owner owner, @Validated Pet pet, BindingResult result, ModelMap modelMap) {
		
		if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null) {
			result.rejectValue("name", "duplicate", "already exists");
		}
		
		owner.getPets().add(pet);
		pet.setOwner(owner);
		
		if (result.hasErrors()) {
			log.debug("Error Occurred.");
			modelMap.put("pet", pet);
			return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
		} else {
			petService.save(pet);
			return "redirect:/owners/"+owner.getId();
		}
	}
	
	@GetMapping("pets/{petId}/edit")
	public String initUpdateForm(@PathVariable Long petId, Model model) {
		Pet pet = petService.findById(petId);
		model.addAttribute("pet", pet);
		return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
	}
	
	@PostMapping("/pets/{petId}/edit")
	public String processUpdateForm(@Validated Pet pet, BindingResult result, 
			Owner owner, @PathVariable Long petId, Model model) {
		
		if (StringUtils.hasLength(pet.getName())) {
			Pet foundPet = owner.getPet(pet.getName());
			if (foundPet != null && !foundPet.getId().equals(petId)) {
				result.rejectValue("name", "duplicate", "already used for other pets for this owner");
			}
		}
		
		if (!StringUtils.hasLength(pet.getName())) {
			result.rejectValue("name", "null", "name of the pet cannot be empty");
		}
		
		pet.setOwner(owner);

		if (result.hasErrors()) {
			log.debug("Error Occurred." + result.getErrorCount());
			model.addAttribute("pet", pet);
			return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
		} else {
			// update the pet information in database
			// when apply the hibernate db, data store in db in sql style,
			// all the java model only created after apply CrudRepository to retrieve
			// data from database; or created before apply crudRepository to store data to database
			// Therefore, there is no need to update the pet set in owner model.
			// Instead of it, only to maintain the relationship between pet and owner in hibernate db.
			
			Pet foundPet = petService.findById(petId);
			foundPet.setOwner(owner);
			foundPet.setName(pet.getName());
			foundPet.setPetType(pet.getPetType());
			foundPet.setBirthDate(pet.getBirthDate());
			
			petService.save(foundPet);
			return "redirect:/owners/"+owner.getId(); 
		}
	}
}
