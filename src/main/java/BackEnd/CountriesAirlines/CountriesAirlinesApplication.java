package BackEnd.CountriesAirlines;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import BackEnd.CountriesAirlines.domain.Airlines;
import BackEnd.CountriesAirlines.domain.AirlinesRepository;
import BackEnd.CountriesAirlines.domain.Country;
import BackEnd.CountriesAirlines.domain.CountryRepository;
import BackEnd.CountriesAirlines.domain.User;
import BackEnd.CountriesAirlines.domain.UserRepository;



@SpringBootApplication
public class CountriesAirlinesApplication {
	private static final Logger Log = LoggerFactory.getLogger(CountriesAirlinesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CountriesAirlinesApplication.class, args);
	}
	
@Bean
public CommandLineRunner demo(CountryRepository countryRep, AirlinesRepository airlineRep, UserRepository userRep) {
	return (args) -> {

		Airlines airline1 = new Airlines("FIN", "Finnair");
		Airlines airline2 = new Airlines("ICE", "Icelandair");
		Airlines airline3 = new Airlines("LH", "Lufthansa");
		Airlines airline4 = new Airlines("SAS", "SAS");
		Airlines airline5 = new Airlines("CA", "Air China");
		Airlines airline6 = new Airlines("BT", "Air Baltic");

		airlineRep.save(airline1);
		airlineRep.save(airline2);
		airlineRep.save(airline3);
		airlineRep.save(airline4);
		airlineRep.save(airline5);
		airlineRep.save(airline6);

		Country country1 = new Country("Iceland", "Direct flight from Helsinki to Reykjavik", 241.0, "Helsinki - Frankfurt - Reykjavik", 183.0, List.of(airline2));
		Country country2 = new Country("Slovenia", "Direct flight from Helsinki to Ljubljana", 243, "Helsinki - Riga - Ljubljana", 187, List.of(airline1, airline6));
		Country country3 = new Country("China", "Direct flight from Helsinki to Shanghai", 806, "Helsinki - Copenhagen - Beijing - Shanghai", 514, List.of(airline1, airline4, airline5));
		
		countryRep.save(country1);
		countryRep.save(country2);
		countryRep.save(country3);

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		User user1 = new User("user", passwordEncoder.encode("password"), "USER");
		User user2 = new User("admin", passwordEncoder.encode("adminpassword"), "ADMIN");
		userRep.save(user1);
		userRep.save(user2);

		Log.info("All countries and routes");
		for (Country country : countryRep.findAll()) {
			Log.info(country.toString());
		}

			Log.info("Airlines:");
            for (Airlines airlines : airlineRep.findAll()) {
                Log.info(airlines.toString());
		}
	};
};

}
