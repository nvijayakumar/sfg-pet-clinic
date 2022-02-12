/**
 * 
 */
package guru.springframework.sfgpetclinic.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * This class is marked with @MappedSuperClass, so no entity
 * will be exist for this class. But the property of this class
 * will be exist in all its child class entity.
 * 
 * @author vijayakumar
 * @Since  25-Jan-2022
 *
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
