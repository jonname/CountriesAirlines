package BackEnd.CountriesAirlines.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import BackEnd.CountriesAirlines.domain.AirlinesRepository;
import BackEnd.CountriesAirlines.domain.Country;
import BackEnd.CountriesAirlines.domain.CountryRepository;


@Controller
public class CountryController {
	
@Autowired
private CountryRepository countryRep;
@Autowired
private AirlinesRepository airlineRep;


		@RequestMapping("/countries")
	public String countries(Model model) {
	model.addAttribute("countries", countryRep.findAll()); 
		return "countries";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteCountry(@PathVariable("id") Long id, Model model) {
		countryRep.deleteById(id);
		return "redirect:/countries";
	}

	@RequestMapping(value = "/add")
	public String addCountry(Model model) {
		model.addAttribute("country", new Country());
		model.addAttribute("airlines", airlineRep.findAll());
		countryRep.findAll();
		return "addcountries";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCountry(Country country){
        countryRep.save(country);
        return "redirect:/countries";
    } 
	
    @RequestMapping(value={"/", "/home"})
	public String homeSecure() {
		return "redirect:/countries";
	}  
    
    @RequestMapping(value="/hello")
	public String helloSecure() {
		return "hello";
	}
    
    @RequestMapping(value="/login")
	public String login() {
		return "login";
	}    

}