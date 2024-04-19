package BackEnd.CountriesAirlines;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import BackEnd.CountriesAirlines.domain.Airlines;
import BackEnd.CountriesAirlines.domain.AirlinesRepository;


@DataJpaTest
public class AirlinesRepositoryTest {
@Autowired
private AirlinesRepository airlineRep;

@Test
public void findByAirlineNameShouldReturnAirlineName() {
    List<Airlines> airlines =  airlineRep.findByAirlineName("Finnair");
    assertEquals(1, airlines.size());
}

}
