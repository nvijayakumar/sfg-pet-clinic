/**
 * 
 */
package guru.springframework.sfgpetclinic.services;

import java.util.Set;

/**
 * @author vijayakumar
 * @Since  26-Jan-2022
 *
 */
public interface CurdService<T, ID> {
	
	T findById(ID id);
	
	Set<T> findAll();
	
	T save(T object);
}
