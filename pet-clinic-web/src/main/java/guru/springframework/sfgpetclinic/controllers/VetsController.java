/**
 * 
 */
package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.sfgpetclinic.services.VetService;

/**
 * @author vijayakumar
 * @Since  26-Jan-2022
 *
 */
@Controller
public class VetsController {

	private final VetService vetService;
	
	public VetsController(VetService vetService) {
		this.vetService = vetService;
	}

	@RequestMapping({"/vet", "/vet/index", "/vet/index.html", "/vets.html"})
	public String vetsList(Model model) {
		model.addAttribute("vets", vetService.findAll());
		return "vets/index";
	}
}
