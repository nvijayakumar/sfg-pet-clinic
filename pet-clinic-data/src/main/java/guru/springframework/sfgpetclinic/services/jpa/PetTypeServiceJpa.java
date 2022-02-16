/**
 * 
 */
package guru.springframework.sfgpetclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinic.services.PetTypeService;

/**
 * @author vijayakumar
 * @Since  16-Feb-2022
 *
 */
@Service
@Profile("jpa")
public class PetTypeServiceJpa extends AbstractJpaService<PetType, PetTypeRepository> implements PetTypeService {

	public PetTypeServiceJpa(PetTypeRepository repository) {
		super(repository);
	}

}
