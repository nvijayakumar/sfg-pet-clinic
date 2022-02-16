/**
 * 
 */
package guru.springframework.sfgpetclinic.services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import guru.springframework.sfgpetclinic.model.BaseEntity;
import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.CurdService;

/**
 * @author vijayakumar
 * @Since  26-Jan-2022
 *
 */
public abstract class AbstractMapService<T extends BaseEntity> implements CurdService<T> {

	private final Map<Long, T> map = new HashMap<Long, T>();
	
	@Override
	public T findById(Long id) {
		return map.get(id);
	}

	@Override
	public Set<T> findAll() {
		return new HashSet<T>(map.values());
	}

	@Override
	public T save(T o) {
//		Optional.ofNullable(o).filter(o -> o.getId() == null);
		Optional.ofNullable(o).orElseThrow(() -> new RuntimeException("Entity is null."));
		
		if (o.getId() == null) 
			o.setId(getNextId());
		
		map.put(o.getId(), o);
		return o;
	}

	public void deleteById(Long id) {
		map.remove(id);
	}
	
	public void delete(T object) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}
	
	private Long getNextId() {
		return map.isEmpty() ? 1L : Collections.max(map.keySet())+1L;
	}
	
}
