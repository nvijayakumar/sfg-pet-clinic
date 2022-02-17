/**
 * 
 */
package guru.springframework.sfgpetclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import guru.springframework.sfgpetclinic.services.VisitService;

/**
 * @author vijayakumar
 * @Since  17-Feb-2022
 *
 */
@Service
@Profile("jpa")
public class VisitServiceJpa extends AbstractJpaService<Visit, VisitRepository> implements VisitService {

	public VisitServiceJpa(VisitRepository repository) {
		super(repository);
	}

}
