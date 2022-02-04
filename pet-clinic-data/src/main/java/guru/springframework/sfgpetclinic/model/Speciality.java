/**
 * 
 */
package guru.springframework.sfgpetclinic.model;

/**
 * @author vijayakumar
 * @Since  04-Feb-2022
 *
 */
public class Speciality extends BaseEntity {

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
