/**
 * 
 */
package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author vijayakumar
 * @Since  24-Jan-2022
 *
 */
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "type_id")
	private PetType petType;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;
	
	@Column(name = "birth_date")
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
