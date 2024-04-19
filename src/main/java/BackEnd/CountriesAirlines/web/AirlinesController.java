package BackEnd.CountriesAirlines.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import BackEnd.CountriesAirlines.domain.Airlines;
import BackEnd.CountriesAirlines.domain.AirlinesRepository;
import jakarta.transaction.Transactional;



@Controller
public class AirlinesController {

@Autowired
private AirlinesRepository airlineRep;

@RequestMapping(value = "/airlines", method=RequestMethod.GET)
public @ResponseBody String airlineList(Model model) {
    model.addAttribute("airlines", airlineRep.findAll());
    return "airlines";
}

@RequestMapping(value = "/addairlines", method = RequestMethod.GET)
public @ResponseBody String addAirlines(Model model) {
    model.addAttribute("airlines", new Airlines());
    return "addairlines";
}
	@RequestMapping(value = "/saveairlines", method = RequestMethod.POST)
    public @ResponseBody String saveAirlines(Airlines airlines){
        airlineRep.save(airlines);
        return "redirect:/airlines";
    } 
    @Transactional
    @GetMapping("/airlines/{id}")
    public @ResponseBody Airlines getAirlinesById(@PathVariable String airlineid) {
        List<Airlines> airlinesList = airlineRep.findByAirlineid(airlineid);
        return airlinesList.isEmpty() ? null : airlinesList.get(0);
}
}