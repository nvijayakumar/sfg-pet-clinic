/**
 * 
 */
package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;

/**
 * @author vijayakumar
 * @Since  04-Feb-2022
 *
 */
public class Visit extends BaseEntity {

	private LocalDate localDate;
	private String description;
	private Pet pet;
	
	public LocalDate getLocalDate() {
		return localDate;
	}
	public String getDescription() {
		return description;
	}
	public Pet getPet() {
		return pet;
	}
	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	
}
