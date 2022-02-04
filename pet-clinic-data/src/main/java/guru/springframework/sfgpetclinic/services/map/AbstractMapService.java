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

/**
 * @author vijayakumar
 * @Since  26-Jan-2022
 *
 */
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

	Map<Long, T> map = new HashMap<Long, T>();
	
	public T findById(ID id) {
		return map.get(id);
	}

	public Set<T> findAll() {
		return new HashSet<T>(map.values());
	}

	public T save(T o) {
		//Optional.ofNullable(o).ifPresentOrElse(e -> e.setId(getNextId()), () -> new RuntimeException("Entity is null."));
		Optional.ofNullable(o).orElseThrow(() -> new RuntimeException("Entity is null."));
		
		if (o.getId() == null) 
			o.setId(getNextId());
		
		map.put(o.getId(), o);
		return o;
	}

	public void deleteById(ID id) {
		map.remove(id);
	}
	
	public void delete(T object) {
		map.entrySet().removeIf(e -> e.getValue().equals(object));
	}
	
	private Long getNextId() {
		return map.isEmpty() ? 1L : Collections.max(map.keySet())+1L;
	}
}
