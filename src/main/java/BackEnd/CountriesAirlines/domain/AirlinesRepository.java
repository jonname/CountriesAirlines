package BackEnd.CountriesAirlines.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AirlinesRepository extends CrudRepository<Airlines, Long> {

List<Airlines> findByAirlineName(String airlineName);
List<Airlines> findByAirlineid(String airlineid);



}
