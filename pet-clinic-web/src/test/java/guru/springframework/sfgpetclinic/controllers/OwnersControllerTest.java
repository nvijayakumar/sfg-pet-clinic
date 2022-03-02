/**
 * 
 */
package guru.springframework.sfgpetclinic.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;

/**
 * @author vijayakumar
 * @Since  02-Mar-2022
 *
 */
@ExtendWith(MockitoExtension.class)
class OwnersControllerTest {

	@Mock
	OwnerService ownerService;
	
	@InjectMocks
	OwnersController controller;
	
	Set<Owner> owners;
	
	MockMvc mockMvc;
	
	@BeforeEach
	void setUp() throws Exception {
		owners = new HashSet<Owner>();
		owners.add(Owner.builder().id(1l).build());
		owners.add(Owner.builder().id(2l).build());
		
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	void testOwnersList() throws Exception {
		
		when(ownerService.findAll()).thenReturn(owners);
		
		mockMvc.perform(get("/owners/index")).andExpect(status().isOk())
			.andExpect(model().attribute("owners", hasSize(2)))
			.andExpect(view().name("owners/index"));
	}

	@Test
	void testFindOwner() throws Exception {
		mockMvc.perform(get("/owners/find")).andExpect(status().isOk())
			.andExpect(view().name("notimplementedyet"));
		
		verifyNoInteractions(ownerService);
	}

}
