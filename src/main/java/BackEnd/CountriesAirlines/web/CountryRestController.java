package BackEnd.CountriesAirlines.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import BackEnd.CountriesAirlines.domain.Country;
import BackEnd.CountriesAirlines.domain.CountryRepository;





@CrossOrigin
@Controller
public class CountryRestController {
	
	
	@Autowired
	private CountryRepository countryRep; 

	
  

    @RequestMapping(value="/countries", method = RequestMethod.GET)
    public @ResponseBody List<Country> countriesRest() {
        return (List<Country>) countryRep.findAll();
    }
    
    @RequestMapping(value="/countries/{id}", method=RequestMethod.GET)
    public @ResponseBody Optional<Country> findCountriesRest
    (@PathVariable("id") Long id) {
        return countryRep.findById(id);
    }
    
    @RequestMapping(value="/countries", method=RequestMethod.POST)
    public @ResponseBody Country saveCountryRest(@RequestBody Country countries) {
        return countryRep.save(countries);

    }
}
