/**
 * 
 */
package guru.springframework.sfgpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.services.VisitService;

/**
 * @author vijayakumar
 * @Since  17-Feb-2022
 *
 */
@Service
@Profile({"default", "map"})
public class VisitServiceMap extends AbstractMapService<Visit> implements VisitService {

	@Override
	public Visit save(Visit visit) {
		
		if (visit == null || visit.getPet() == null || visit.getPet().getOwner() == null
				|| visit.getPet().getId() == null || visit.getPet().getOwner().getId() == null) {
			throw new NullPointerException("Visit entity is null and cannot be persisted.");
		}
			
		return super.save(visit);
	}
}
