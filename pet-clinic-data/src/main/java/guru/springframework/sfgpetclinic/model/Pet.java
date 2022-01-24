/**
 * 
 */
package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;

/**
 * @author vijayakumar
 * @Since  24-Jan-2022
 *
 */
public class Pet {
	
	private PetType petType;
	private Owner owner;
	private LocalDate localDate;
	
	public PetType getPetType() {
		return petType;
	}
	public Owner getOwner() {
		return owner;
	}
	public LocalDate getLocalDate() {
		return localDate;
	}
	public void setPetType(PetType petType) {
		this.petType = petType;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
}
