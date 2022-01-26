/**
 * 
 */
package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Vet;

/**
 * @author vijayakumar
 * @Since  26-Jan-2022
 *
 */
public class VetServiceMap extends AbstractMapService<Vet, Long> {

	@Override
	public Vet save(Vet vet) {
		super.save(vet.getId(), vet);
		return vet;
	}

}
