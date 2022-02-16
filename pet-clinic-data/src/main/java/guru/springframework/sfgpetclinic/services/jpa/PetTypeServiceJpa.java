/**
 * 
 */
package guru.springframework.sfgpetclinic.services.jpa;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinic.services.PetTypeService;

/**
 * @author vijayakumar
 * @Since  16-Feb-2022
 *
 */
public class PetTypeServiceJpa extends AbstractJpaService<PetType, PetTypeRepository> implements PetTypeService {

	public PetTypeServiceJpa(PetTypeRepository repository) {
		super(repository);
	}

}
