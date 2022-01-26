/**
 * 
 */
package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;

/**
 * @author vijayakumar
 * @Since  26-Jan-2022
 *
 */
public class OwnerServiceMap extends AbstractMapService<Owner, Long> {

	@Override
	public Owner save(Owner owner) {
		super.save(owner.getId(), owner);
		return owner;
	}

}
