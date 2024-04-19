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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table (name = "Country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private String fastestRoute;
    private double priceForFastest;
    private String cheapestRoute;
    private double priceForCheapest;

    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE })
    @JoinTable(
        name = "country_airline", 
        joinColumns = {@JoinColumn(name = "country_id")}, inverseJoinColumns = { @JoinColumn(name = "airline_id") }
    )
    Set<Airlines> airlines = new HashSet<>();

    public Country(String country, String fastestRoute, double priceForFastest, String cheapestRoute, double priceForCheapest, Set<Airlines> airlines) {
        this.country = country;
        this.fastestRoute = fastestRoute;
        this.priceForFastest = priceForFastest;
        this.cheapestRoute = cheapestRoute;
        this.priceForCheapest = priceForCheapest;
        this.airlines = airlines;

    }

    public Country() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFastestRoute() {
        return fastestRoute;
    }

    public void setFastestRoute(String fastestRoute) {
        this.fastestRoute = fastestRoute;
    }

    public double getPriceForFastest() {
        return priceForFastest;
    }

    public void setPriceForFastest(double priceForFastest) {
        this.priceForFastest = priceForFastest;
    }

    public String getCheapestRoute() {
        return cheapestRoute;
    }

    public void setCheapestRoute(String cheapestRoute) {
        this.cheapestRoute = cheapestRoute;
    }

    public double getPriceForCheapest() {
        return priceForCheapest;
    }

    public void setPriceForCheapest(double priceForCheapest) {
        this.priceForCheapest = priceForCheapest;
    }

    public void addAirlines(Airlines airline) {
        airlines.add(airline);
    }

    @Override
    public String toString() {
        if (this.airlines != null)
        return "Country [country=" + country + ", fastestRoute=" + fastestRoute + ", priceForFastest=" + priceForFastest
                + ", cheapestRoute=" + cheapestRoute + ", priceForCheapest=" + priceForCheapest + ", airlines="
                + airlines + "]";
        else
        return "Country [country=" + country + ", fastestRoute=" + fastestRoute + ", priceForFastest=" + priceForFastest
        + ", cheapestRoute=" + cheapestRoute + ", priceForCheapest=" + priceForCheapest + "]";
    }

}