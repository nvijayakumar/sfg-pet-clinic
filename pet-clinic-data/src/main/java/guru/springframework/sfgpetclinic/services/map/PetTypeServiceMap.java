/**
 * 
 */
package guru.springframework.sfgpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetTypeService;

/**
 * @author vijayakumar
 * @Since  04-Feb-2022
 *
 */
@Service
@Profile({"default", "map"})
public class PetTypeServiceMap extends AbstractMapService<PetType> implements PetTypeService {

}
