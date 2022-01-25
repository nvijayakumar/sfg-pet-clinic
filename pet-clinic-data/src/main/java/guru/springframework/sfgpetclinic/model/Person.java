/**
 * 
 */
package guru.springframework.sfgpetclinic.model;

/**
 * @author vijayakumar
 * @Since  24-Jan-2022
 *
 */
public class Person extends BaseEntity {

	private String firstName;
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
