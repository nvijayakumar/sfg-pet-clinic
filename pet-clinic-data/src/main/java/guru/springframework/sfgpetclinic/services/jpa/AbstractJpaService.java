/**
 * 
 */
package guru.springframework.sfgpetclinic.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.sfgpetclinic.model.BaseEntity;
import guru.springframework.sfgpetclinic.services.CurdService;

/**
 * @author vijayakumar
 * @Since  16-Feb-2022
 *
 */
public abstract class AbstractJpaService<T extends BaseEntity, R extends CrudRepository<T, Long>> implements CurdService<T> {

	protected R repository;
	
	public AbstractJpaService(R repository) {
		this.repository = repository;
	}

	@Override
	public T findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Set<T> findAll() {
		Set<T> all = new HashSet<>();
		repository.findAll().forEach(all::add);
		return all;
	}

	@Override
	public T save(T object) {
		return repository.save(object);
	}
	
	@Override
	public void delete(T object) {
		repository.delete(object);
	}
	
	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
