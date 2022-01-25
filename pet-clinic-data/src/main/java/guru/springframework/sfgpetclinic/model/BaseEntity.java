/**
 * 
 */
package guru.springframework.sfgpetclinic.model;

import java.io.Serializable;

/**
 * @author vijayakumar
 * @Since  25-Jan-2022
 *
 */
public class BaseEntity implements Serializable {

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
