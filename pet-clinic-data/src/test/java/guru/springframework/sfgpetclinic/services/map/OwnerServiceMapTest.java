/**
 * 
 */
package guru.springframework.sfgpetclinic.services.map;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.model.Owner;

/**
 * @author vijayakumar
 * @Since  25-Feb-2022
 *
 */
class OwnerServiceMapTest {

	OwnerServiceMap ownerServiceMap;
	
	Long ownerId = 1l;
	String lastName = "Smith";
	
	@BeforeEach
	void setUp() throws Exception {
		ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
		ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
	}

	@Test
	void testFindByLastName() {
		Owner smith = ownerServiceMap.findByLastName(lastName);
		assertNotNull(smith);
		assertEquals(ownerId, smith.getId());
	}

	@Test
	void testSaveOwner() {
		Long id = 2l;
		Owner savedOwner = ownerServiceMap.save(Owner.builder().id(id).build());
		assertNotNull(savedOwner);
		assertEquals(id, savedOwner.getId());
	}

	@Test
	void testSaveWithNoId() {
		Owner savedOwner = ownerServiceMap.save(Owner.builder().build());
		assertNotNull(savedOwner);
		assertNotNull(savedOwner.getId());
	}
	
	@Test
	void testFindById() {
		Owner o = ownerServiceMap.findById(ownerId);
		assertEquals(ownerId, o.getId());
	}

	@Test
	void testFindAll() {
		Set<Owner> owners = ownerServiceMap.findAll();
		assertEquals(1, owners.size());
	}

	@Test
	void testDeleteById() {
		ownerServiceMap.deleteById(ownerId);
		assertEquals(0, ownerServiceMap.findAll().size());
	}

	@Test
	void testDelete() {
		ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
		assertEquals(0, ownerServiceMap.findAll().size());
	}

}
