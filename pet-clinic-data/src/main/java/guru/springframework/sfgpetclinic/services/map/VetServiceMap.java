/**
 * 
 */
package guru.springframework.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.VetService;

/**
 * @author vijayakumar
 * @Since  26-Jan-2022
 *
 */
@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

	@Override
	public Vet save(Vet vet) {
		super.save(vet.getId(), vet);
		return vet;
	}

}
