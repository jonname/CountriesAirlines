package BackEnd.CountriesAirlines.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {
    List<Country> findByCountry(String country);

}
