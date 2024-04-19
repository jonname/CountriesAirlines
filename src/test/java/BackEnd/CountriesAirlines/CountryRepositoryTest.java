package BackEnd.CountriesAirlines;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import BackEnd.CountriesAirlines.domain.Airlines;
import BackEnd.CountriesAirlines.domain.AirlinesRepository;
import BackEnd.CountriesAirlines.domain.Country;
import BackEnd.CountriesAirlines.domain.CountryRepository;

@DataJpaTest
public class CountryRepositoryTest {
@Autowired
private CountryRepository countryRep;
@Autowired
private AirlinesRepository airlinesRep;

@Test
public void findByCountryShouldReturnCountry() {
    List<Country> countries =  countryRep.findByCountry("Iceland");
    assertThat(countries).hasSize(1);

}
@Test
public void createNewCountry() {
    Country country = new Country("Finland", "Finland", 0, "Finland", 0, (List<Airlines>) airlinesRep.findByAirlineName("Finnair"));
    countryRep.save(country);
assertThat(country.getId()).isNotNull();


}

}
