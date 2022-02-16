/**
 * 
 */
package guru.springframework.sfgpetclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialityRepository;
import guru.springframework.sfgpetclinic.services.SpecialityService;

/**
 * @author vijayakumar
 * @Since  16-Feb-2022
 *
 */
@Service
@Profile("jpa")
public class SpecialityServiceJpa extends AbstractJpaService<Speciality, SpecialityRepository> implements SpecialityService {

	public SpecialityServiceJpa(SpecialityRepository repository) {
		super(repository);
	}

}
