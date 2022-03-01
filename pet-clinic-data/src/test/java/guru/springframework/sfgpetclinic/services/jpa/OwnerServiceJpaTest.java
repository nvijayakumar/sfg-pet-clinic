/**
 * 
 */
package guru.springframework.sfgpetclinic.services.jpa;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;

/**
 * @author vijayakumar
 * @Since  28-Feb-2022
 *
 */
@ExtendWith(MockitoExtension.class)
class OwnerServiceJpaTest {

	private static final String LAST_NAME = "Smith";

	@Mock
	OwnerRepository ownerRepository;
	
	@InjectMocks
	OwnerServiceJpa ownerServiceJpa;
	
	@BeforeEach
	void setUp() throws Exception {
		ownerServiceJpa.save(Owner.builder().id(1l).lastName(LAST_NAME).build());
	}

	@Test
	void testFindByLastName() {
		Owner o = ownerServiceJpa.findByLastName(LAST_NAME);
		assertNull(o);
		verify(ownerRepository, times(1)).findByLastName(anyString());
	}

	@Test
	void testFindById() {
		Optional<Owner> owner = Optional.of(Owner.builder().id(1l).build());
				
		when(ownerRepository.findById(anyLong())).thenReturn(owner);
		
		Owner o = ownerServiceJpa.findById(1l);
		
		assertNotNull(o);
		
		verify(ownerRepository).findById(anyLong());
	}

	@Test
	void testFindAll() {
		Set<Owner> owners = new HashSet<Owner>();
		owners.add(Owner.builder().id(1l).build());
		owners.add(Owner.builder().id(2l).build());

		when(ownerRepository.findAll()).thenReturn(owners);
		
		Set<Owner> returnedOwner = ownerServiceJpa.findAll();
		
		assertEquals(2, returnedOwner.size());
	}

	@Test
	void testSave() {
		Owner ownerToSave = Owner.builder().id(1l).build();
		
		when(ownerRepository.save(any())).thenReturn(ownerToSave);
		
		Owner savedOwner = ownerServiceJpa.save(ownerToSave);
		
		assertEquals(1l, savedOwner.getId());
		
		verify(ownerRepository, times(2)).save(any());
	}

	@Test
	void testDelete() {
		Owner ownerToDelete = Owner.builder().id(1l).build();
		
		ownerServiceJpa.delete(ownerToDelete);
		
		verify(ownerRepository).delete(any());
	}

	@Test
	void testDeleteById() {
		ownerServiceJpa.deleteById(1l);
		
		verify(ownerRepository).deleteById(anyLong());
	}

}
