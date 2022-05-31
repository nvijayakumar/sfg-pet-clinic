/**
 * 
 */
package guru.springframework.sfgpetclinic.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;

/**
 * @author vijayakumar
 * @Since  31-May-2022
 *
 */
@ExtendWith(MockitoExtension.class)
class PetControllerTest {
	
	@Mock
	PetService petService;
	
	@Mock
	OwnerService ownerService;
	
	@Mock
	PetTypeService petTypeService;

	@InjectMocks
	PetController controller;
	
	MockMvc mockMvc;
	
	Owner owner;
	
	Set<PetType> petTypes;
	
	@BeforeEach
	void setUp() throws Exception {
		owner = Owner.builder().id(1L).build();
		
		petTypes = new HashSet<>();
		petTypes.add(PetType.builder().id(1L).name("Dog").build());
		petTypes.add(PetType.builder().id(1L).name("Cat").build());
		
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	void testInitCreationForm() throws Exception {
		when(petTypeService.findAll()).thenReturn(petTypes);
		when(ownerService.findById(anyLong())).thenReturn(owner);
		
		mockMvc.perform(get("/owners/1/pets/new"))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("owner"))
			.andExpect(model().attributeExists("pet"))
			.andExpect(view().name("/pets/createOrUpdatePetForm"));
	}

	@Test
	void testProcessCreationForm() throws Exception {
		when(petTypeService.findAll()).thenReturn(petTypes);
		when(ownerService.findById(anyLong())).thenReturn(owner);
		
		mockMvc.perform(post("/owners/1/pets/new"))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/owners/1"));
		
		verify(petService, times(1)).save(any());
	}

	@Test
	void testInitUpdateForm() throws Exception {
		when(petTypeService.findAll()).thenReturn(petTypes);
		when(ownerService.findById(anyLong())).thenReturn(owner);
		when(petService.findById(anyLong())).thenReturn(Pet.builder().id(1L).build());
		
		mockMvc.perform(get("/owners/1/pets/1/edit"))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("owner"))
			.andExpect(model().attributeExists("pet"))
			.andExpect(view().name("/pets/createOrUpdatePetForm"));
	}

	@Test
	void testProcessUpdateForm() throws Exception {
		when(petTypeService.findAll()).thenReturn(petTypes);
		when(ownerService.findById(anyLong())).thenReturn(owner);
		when(petService.findById(anyLong())).thenReturn(Pet.builder().id(1L).name("Sample name").build());
		
		mockMvc.perform(post("/owners/1/pets/1/edit").param("name", "some name"))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/owners/1"));
		
		verify(petService, times(1)).save(any());
	}

}
