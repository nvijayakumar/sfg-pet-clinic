/**
 * 
 */
package guru.springframework.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import guru.springframework.sfgpetclinic.services.VetService;

/**
 * @author vijayakumar
 * @Since  26-Jan-2022
 *
 */
@Service
public class VetServiceMap extends AbstractMapService<Vet> implements VetService {

	private final SpecialityService specialityService;
	
	public VetServiceMap(SpecialityService specialityService) {
		this.specialityService = specialityService;
	}

	public Vet save(Vet vet) {
		
		if (vet.getSpecialities().size() > 0) {
			vet.getSpecialities().forEach(speciality -> {
				if (speciality.getId() == null) {
					speciality.setId(specialityService.save(speciality).getId());
				}
			});
		}
		return super.save(vet);
	}
}
