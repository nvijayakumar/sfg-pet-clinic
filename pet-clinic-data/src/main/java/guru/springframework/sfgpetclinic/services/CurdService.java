/**
 * 
 */
package guru.springframework.sfgpetclinic.services;

import java.util.Set;

import guru.springframework.sfgpetclinic.model.BaseEntity;

/**
 * @author vijayakumar
 * @Since  26-Jan-2022
 *
 */
public interface CurdService<T extends BaseEntity> {
	
	T findById(Long id);
	
	Set<T> findAll();
	
	T save(T object);
	
	void delete(T object);
	
	void deleteById(Long id);
}
