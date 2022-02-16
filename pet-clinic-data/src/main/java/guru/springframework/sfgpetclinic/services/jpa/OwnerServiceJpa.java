/**
 * 
 */
package guru.springframework.sfgpetclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.services.OwnerService;

/**
 * @author vijayakumar
 * @Since  16-Feb-2022
 *
 */
@Component
@Profile("jpa")
public class OwnerServiceJpa extends AbstractJpaService<Owner, OwnerRepository> implements OwnerService {

	public OwnerServiceJpa(OwnerRepository ownerRepository) {
		super(ownerRepository);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return repository.findByLastName(lastName);
	}

}
