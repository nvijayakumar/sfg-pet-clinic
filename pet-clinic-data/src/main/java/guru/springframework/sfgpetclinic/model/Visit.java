/**
 * 
 */
package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author vijayakumar
 * @Since  04-Feb-2022
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

	@Column(name = "date")
	private LocalDate localDate;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;
	
}
