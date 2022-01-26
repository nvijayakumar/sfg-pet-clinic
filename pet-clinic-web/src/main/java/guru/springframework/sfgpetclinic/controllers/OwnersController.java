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
@RequestMapping("/owners")
@Controller
public class OwnersController {

	@RequestMapping({"", "/index", "/index.html"})
	public String ownersList() {
		return "owners/index";
	}
}
