/**
 * 
 */
package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.sfgpetclinic.services.OwnerService;

/**
 * @author vijayakumar
 * @Since  26-Jan-2022
 *
 */
@RequestMapping("/owners")
@Controller
public class OwnersController {
	
	private final OwnerService ownerService;
	
	public OwnersController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}

	@RequestMapping({"", "/index", "/index.html"})
	public String ownersList(Model model) {
		System.out.println(model.getClass().getName());
		model.addAttribute("owners", ownerService.findAll());
		return "owners/index";
	}
}
