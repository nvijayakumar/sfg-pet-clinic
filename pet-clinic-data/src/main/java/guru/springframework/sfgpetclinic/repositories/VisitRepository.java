/**
 * 
 */
package guru.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.sfgpetclinic.model.Visit;

/**
 * @author vijayakumar
 * @Since  16-Feb-2022
 *
 */
public interface VisitRepository extends CrudRepository<Visit, Long> {

}
