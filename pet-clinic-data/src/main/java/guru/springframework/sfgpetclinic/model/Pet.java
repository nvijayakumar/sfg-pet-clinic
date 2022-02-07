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
public class Pet extends BaseEntity {
	
	private String name;
	private PetType petType;
	private Owner owner;
	private LocalDate birthDate;
	
	public String getName() {
		return name;
	}
	public PetType getPetType() {
		return petType;
	}
	public Owner getOwner() {
		return owner;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPetType(PetType petType) {
		this.petType = petType;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
}
