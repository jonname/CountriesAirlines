package BackEnd.CountriesAirlines.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "Airlines")
public class Airlines {


public Airlines() {
    
}

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String airlineid;
private String airlineName;

@ManyToMany(mappedBy = "airlines")
private Set<Country> countries = new HashSet<>();


public Airlines(String airlineid, String airlineName) {
    this.airlineid = airlineid;
    this.airlineName = airlineName;
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}


public String getAirlineid() {
    return airlineid;
}

public void setAirlineid(String airlineid) {
    this.airlineid = airlineid;
}

public String getAirlineName() {
    return airlineName;
}

public void setAirlineName(String airlineName) {
    this.airlineName = airlineName;
}


@Override
public String toString() {
    return "Airlines [airlineid=" + airlineid + ", airlineName=" + airlineName + "]";

}
}