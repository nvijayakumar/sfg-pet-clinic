/**
 * 
 */
package guru.springframework.sfgpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.PetService;

/**
 * @author vijayakumar
 * @Since  26-Jan-2022
 *
 */
@Service
@Profile({"default", "map"})
public class PetServiceMap extends AbstractMapService<Pet> implements PetService {

}
