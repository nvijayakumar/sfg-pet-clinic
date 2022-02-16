/**
 * 
 */
package guru.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.sfgpetclinic.model.Pet;

/**
 * @author vijayakumar
 * @Since  16-Feb-2022
 *
 */
public interface PetRepository extends CrudRepository<Pet, Long> {

}
