/**
 * 
 */
package guru.springframework.sfgpetclinic.controllers;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.net.URI;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.UriTemplate;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.VisitService;

/**
 * @author vijayakumar
 * @Since  09-Jun-2022
 *
 */
@ExtendWith(MockitoExtension.class)
class VisitControllerTest {

	@Mock
	PetService petService;
	
	@Mock
	VisitService visitService;
	
	@InjectMocks
	VisitController visitController;
	
	MockMvc mockMvc;
	
	UriTemplate uriTemplate = new UriTemplate("/owners/{ownerId}/pets/{petId}/visits/new");
	Map<String, String> uriVariables = new HashMap<>();
	URI uri;
	
	@BeforeEach
	void setUp() throws Exception {
		Long ownerId = 1L;
		Long petId = 1L;
		
		when(petService.findById(anyLong())).thenReturn(Pet.builder()
				.id(petId)
				.birthDate(LocalDate.of(2018, 11, 13))
				.name("Cutie")
				.visits(new HashSet<>())
				.owner(Owner.builder()
						.id(ownerId)
						.lastName("Due")
						.firstName("Joe")
						.build())
				.petType(PetType.builder()
						.name("Dog")
						.build())
				.build());
		
		uriVariables.clear();
		uriVariables.put("ownerId", ownerId.toString());
		uriVariables.put("petId", petId.toString());
		uri = uriTemplate.expand(uriVariables);
		
		mockMvc = MockMvcBuilders.standaloneSetup(visitController).build();
	}

	@Test
	void testInitNewVisitForm() throws Exception {
		mockMvc.perform(get(uri))
			.andExpect(status().isOk())
			.andExpect(view().name("pets/createOrUpdateVisitForm"));
	}

	@Test
	void testProcessNewVisitForm() throws Exception {
		mockMvc.perform(post(uri).contentType(MediaType.APPLICATION_FORM_URLENCODED))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/owners/{ownerId}"))
			.andExpect(model().attributeExists("visit"));
	}

}
