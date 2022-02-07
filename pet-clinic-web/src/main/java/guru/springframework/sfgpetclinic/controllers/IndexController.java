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
@Controller
public class IndexController {

	@RequestMapping({"", "/", "index", "index.html"})
	public String index() {
		return "index";
	}
	
	@RequestMapping({"/oups"})
	public String oups() {
		return "notimplementedyet";
	}
}
