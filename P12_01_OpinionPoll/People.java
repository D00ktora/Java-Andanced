/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 19.3.2023 г.
 * Time: 18:18
 */
package P12_01_OpinionPoll;

import java.util.ArrayList;
import java.util.List;

public class People {
    private String name = "";
    private Company company = null;
    private List<Pokemon> pokemons = new ArrayList<>();
    private List<Parent> parents = new ArrayList<>();
    private List<Children> childrens = new ArrayList<>();
    private Car car = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<Children> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Children> childrens) {
        this.childrens = childrens;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
