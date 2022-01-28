/**
 * 
 */
package guru.springframework.sfgpetclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import guru.springframework.sfgpetclinic.services.CurdService;

/**
 * @author vijayakumar
 * @param <T>
 * @Since  26-Jan-2022
 *
 */
public abstract class AbstractMapService<T, ID> implements CurdService<T, ID> {

	Map<ID, T> map = new HashMap<ID, T>();
	
	@Override
	public T findById(ID id) {
		return map.get(id);
	}

	@Override
	public Set<T> findAll() {
		return new HashSet<T>(map.values());
	}

	public T save(ID id, T object) {
		map.put(id, object);
		return object;
	}

	public void deleteById(ID id) {
		map.remove(id);
	}
	
	public void delete(T object) {
		map.entrySet().removeIf(e -> e.getValue().equals(object));
	}
}
