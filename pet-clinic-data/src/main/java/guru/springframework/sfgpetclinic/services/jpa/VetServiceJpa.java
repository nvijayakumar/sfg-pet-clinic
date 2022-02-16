/**
 * 
 */
package guru.springframework.sfgpetclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repositories.VetRepository;
import guru.springframework.sfgpetclinic.services.VetService;

/**
 * @author vijayakumar
 * @Since  16-Feb-2022
 *
 */
@Service
@Profile("jpa")
public class VetServiceJpa extends AbstractJpaService<Vet, VetRepository> implements VetService {

	public VetServiceJpa(VetRepository vetRepository) {
		super(vetRepository);
	}
}
