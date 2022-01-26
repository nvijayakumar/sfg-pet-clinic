/**
 * 
 */
package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author vijayakumar
 * @Since  26-Jan-2022
 *
 */
@RequestMapping("/vets")
@Controller
public class VetsController {

	@RequestMapping({"", "/index", "i/ndex.html"})
	public String vetsList() {
		return "vets/index";
	}
}
