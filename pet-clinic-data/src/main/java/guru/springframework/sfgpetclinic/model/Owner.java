/**
 * 
 */
package guru.springframework.sfgpetclinic.model;

import java.util.Set;

/**
 * @author vijayakumar
 * @Since  24-Jan-2022
 *
 */
public class Owner extends Person {

	private Set<Pet> pets;

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}
	
}
