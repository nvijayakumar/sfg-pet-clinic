/**
 * 
 */
package guru.springframework.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;

/**
 * @author vijayakumar
 * @Since  26-Jan-2022
 *
 */
@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

	@Override
	public Owner findByLastName(String lastName) {
		return this.findAll().stream().filter(o -> o.getLastName().equalsIgnoreCase(lastName)).findFirst().orElse(null);
	}

}
