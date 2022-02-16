/**
 * 
 */
package guru.springframework.sfgpetclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.services.PetService;

/**
 * @author vijayakumar
 * @Since  16-Feb-2022
 *
 */
@Service
@Profile("jpa")
public class PetServicejpa extends AbstractJpaService<Pet, PetRepository> implements PetService {

	public PetServicejpa(PetRepository repository) {
		super(repository);
	}

	
}
