/**
 * 
 */
package guru.springframework.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;

/**
 * @author vijayakumar
 * @Since  26-Jan-2022
 *
 */
@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
	
	private final PetTypeService petTypeService;
	private final PetService petService;

	public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
	public Owner findByLastName(String lastName) {
		return this.findAll().stream().filter(o -> o.getLastName().equalsIgnoreCase(lastName)).findFirst().orElse(null);
	}
	
	public Owner save(Owner o) {
		
		if (o != null) {
			if (o.getPets().size() > 0) {
				o.getPets().forEach(pet -> {
					//iterate each pet and check whether the PetType and Pet has Id field.
					
					//check the PetType
					if (pet.getPetType() != null) {
						if (pet.getPetType().getId() == null) {
							pet.setPetType(petTypeService.save(pet.getPetType()));
						}
					} else {
						throw new RuntimeException("PetType cannot be null.");
					}
					
					//check the Pet
					if (pet.getId() == null) {
						Pet savedPet = petService.save(pet);
						pet.setId(savedPet.getId());
					}
				});
			}
			return super.save(o);
		} else {
			return null; // if Owner is null
		}
	}

}
