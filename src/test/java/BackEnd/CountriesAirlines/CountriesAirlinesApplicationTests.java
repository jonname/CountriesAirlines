package BackEnd.CountriesAirlines;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import BackEnd.CountriesAirlines.web.AirlinesController;
import BackEnd.CountriesAirlines.web.CountryController;
import BackEnd.CountriesAirlines.web.CountryRestController;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;


@SpringBootTest
class CountriesAirlinesApplicationTests {

	@Autowired
	private AirlinesController airlinesController;
	private CountryController countryController;
	private CountryRestController countryRestController;

	@Test
	void contextLoads() throws Exception {
		assertThat(airlinesController).isNotNull();
		assertThat(countryController).isNotNull();
		assertThat(countryRestController).isNotNull();
		} 

}
