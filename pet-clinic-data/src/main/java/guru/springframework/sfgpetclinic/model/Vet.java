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
public class Vet extends Person {

	private Set<Speciality> specialities;

	public Set<Speciality> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(Set<Speciality> specialities) {
		this.specialities = specialities;
	}
	
}
