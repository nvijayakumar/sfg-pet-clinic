/**
 * 
 */
package guru.springframework.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import guru.springframework.sfgpetclinic.services.VetService;

/**
 * @author vijayakumar
 * @Since  28-Jan-2022
 *
 */
@Component
public class BootstrapDataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	
	public BootstrapDataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialityService specialityService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		if (petTypeService.findAll().size() == 0  ) {
			loadData();
		}
	}

	/**
	 * 
	 */
	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedcatPetType = petTypeService.save(cat);

		System.out.println("Loaded PetTypes....");
		
		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");
		Speciality savedRadiology = specialityService.save(radiology);
		
		Speciality surgery = new Speciality();
		surgery.setDescription("Surgery");
		Speciality savedSurgery = specialityService.save(surgery);
		
		Speciality dentistry = new Speciality();
		dentistry.setDescription("Dentistry");
		Speciality savedDentistry = specialityService.save(dentistry);
		
		Owner o1 = new Owner();
		o1.setFirstName("Micheal");
		o1.setLastName("Weston");
		o1.setAddress("123 Brickerel");
		o1.setCity("Miami");
		o1.setTelephone("12345678");
		
		Pet michealPet = new Pet();
		michealPet.setName("Rosco");
		michealPet.setOwner(o1);
		michealPet.setBirthDate(LocalDate.now());
		michealPet.setPetType(savedDogPetType);
		o1.getPets().add(michealPet);
		
		ownerService.save(o1);
		
		Owner o2 = new Owner();
		o2.setFirstName("Fiona");
		o2.setLastName("Glenanne");
		o2.setAddress("123 Brickerel");
		o2.setCity("Miami");
		o2.setTelephone("12345678");
		
		Pet fionaPet = new Pet();
		fionaPet.setName("Just Cat");
		fionaPet.setOwner(o2);
		fionaPet.setBirthDate(LocalDate.now());
		fionaPet.setPetType(savedcatPetType);
		o2.getPets().add(fionaPet);
		
		ownerService.save(o2);
		
		System.out.println("Loaded Owners....");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vet1.getSpecialities().add(savedRadiology);
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		vet2.getSpecialities().add(savedDentistry);
		
		vetService.save(vet2);
		
		System.out.println("Loaded Vets....");
	}

}
