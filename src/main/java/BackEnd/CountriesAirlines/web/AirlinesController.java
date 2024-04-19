package BackEnd.CountriesAirlines.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import BackEnd.CountriesAirlines.domain.Airlines;
import BackEnd.CountriesAirlines.domain.AirlinesRepository;




@Controller
public class AirlinesController {

@Autowired
private AirlinesRepository airlineRep;

@RequestMapping(value = "/airlines", method=RequestMethod.GET)
public String airlineList(Model model) {
    List<Airlines> airlinesList = (List<Airlines>) airlineRep.findAll();
    model.addAttribute("airlines", airlinesList);
    return "airlines";
}

@RequestMapping(value = "/addairlines", method = RequestMethod.GET)
public String addAirlines(Model model) {
    model.addAttribute("airlines", new Airlines());
    return "addairlines";
}
	@RequestMapping(value = "/saveairlines", method = RequestMethod.POST)
    public String saveAirlines(Airlines airlines){
        airlineRep.save(airlines);
        return "redirect:/airlines";
    } 

    @GetMapping("/airlines/{airlineid}")
    public Airlines getAirlinesById(@PathVariable String airlineid) {
        List<Airlines> airlinesList = airlineRep.findByAirlineid(airlineid);
        return airlinesList.isEmpty() ? null : airlinesList.get(0);
}
}