/**
 * 
 */
package guru.springframework.sfgpetclinic.services;

import java.util.Set;

import guru.springframework.sfgpetclinic.model.Vet;

/**
 * @author vijayakumar
 * @Since  25-Jan-2022
 *
 */
public interface VetService {

	Vet findById();
	
	Vet save(Vet vet);
	
	Set<Vet> findAll();
}
