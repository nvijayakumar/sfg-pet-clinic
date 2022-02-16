/**
 * 
 */
package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Owner;

/**
 * @author vijayakumar
 * @Since  25-Jan-2022
 *
 */
public interface OwnerService extends CurdService<Owner> {

	Owner findByLastName(String lastName);
	
}
