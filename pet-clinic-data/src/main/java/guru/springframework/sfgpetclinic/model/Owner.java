/**
 * 
 */
package guru.springframework.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author vijayakumar
 * @Since  24-Jan-2022
 *
 */
public class Owner extends Person {

	private String address;
	private String city;
	private String telephone;
	private Set<Pet> pets = new HashSet<>();

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}
	
}
