/**
 * 
 */
package guru.springframework.sfgpetclinic.formatters;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetTypeService;

/**
 * @author vijayakumar
 * @Since  31-May-2022
 *
 */
@Component
public class PetTypeFormatter implements Formatter<PetType> {

	@Autowired
	private PetTypeService petTypeService;
	
	@Override
	public String print(PetType object, Locale locale) {
		return object.getName();
	}

	@Override
	public PetType parse(String text, Locale locale) throws ParseException {
		Collection<PetType> types = petTypeService.findAll();
		return types.stream().filter(t -> t.getName().equals(text)).findFirst().orElseThrow(() -> new ParseException("type not found. "+text, 0));
	}

}
