/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 19.3.2023 г.
 * Time: 18:10
 */
package P12_01_OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<People> people = new ArrayList<>();
        String line = scanner.nextLine();

        while (!line.contains("End")) {
            People person = new People();

            if (personExist(line.split("\\s+")[0], people)){
                person = getPerson(people, line.split("\\s+")[0]);
                String command = line.split("\\s+")[1];
                switch (command) {
                    case "company":
                        Company company = new Company(line.split("\\s+")[2], line.split("\\s+")[3], Double.parseDouble(line.split("\\s+")[4]));
                        person.setCompany(company);
                        break;
                    case "pokemon":
                        if (hasPokemons(person, line.split("\\s+")[2])) {
                            Pokemon pokemon = getPokemonList(person, line.split("\\s+")[2]);
                            pokemon.setName(line.split("\\s+")[2]);
                            pokemon.setType(line.split("\\s+")[3]);
                            person.setPokemons(updatePokemon(person, line.split("\\s+")[2], pokemon));
                        } else {
                            Pokemon pokemon = new Pokemon(line.split("\\s+")[2], line.split("\\s+")[3]);
                            List<Pokemon> pokemonList = person.getPokemons();
                            pokemonList.add(pokemon);
                            person.setPokemons(pokemonList);
                        }
                        break;
                    case "parents":
                        if (hasParents(person, line.split("\\s+")[2])) {
                            List<Parent> parentList = person.getParents();
                            Parent tempParent = new Parent(line.split("\\s+")[2], line.split("\\s+")[3]);
                            parentList.add(tempParent);
                            person.setParents(parentList);
                        } else {
                            List<Parent> parentList = person.getParents();
                            Parent parent = new Parent(line.split("\\s+")[2], line.split("\\s+")[3]);
                            parentList.add(parent);
                            person.setParents(parentList);
                        }
                        break;
                    case "children":
                        if (hasChildrenList(person, line.split("\\s+")[2])) {
                            List<Children> childrenList = person.getChildrens();
                            Children children = getChildrenTemp(childrenList, line.split("\\s+")[2]);
                            children.setBirthday(line.split("\\s+")[3]);
                            person.setChildrens(childrenList);
                        } else {
                            List<Children> childrenList = person.getChildrens();
                            Children children = new Children(line.split("\\s+")[2], line.split("\\s+")[3]);
                            childrenList.add(children);
                            person.setChildrens(childrenList);
                        }
                        break;
                    case "car":
                        Car car = new Car(line.split("\\s+")[2], Integer.parseInt(line.split("\\s+")[3]));
                        person.setCar(car);
                        break;
                }
            } else {
                String name = line.split("\\s+")[0];
                String command = line.split("\\s+")[1];
                switch (command) {
                    case "company":
                        String companyName = line.split("\\s+")[2];
                        String comapanyDepartment = line.split("\\s+")[3];
                        double companySalary = Double.parseDouble(line.split("\\s+")[4]);
                        Company company = new Company(companyName, comapanyDepartment, companySalary);
                        person.setCompany(company);
                        person.setName(name);
                        people.add(person);
                        break;
                    case "pokemon":
                        String pokemonName = line.split("\\s+")[2];
                        String pokemonType = line.split("\\s+")[3];
                        List<Pokemon> pokemonList = new ArrayList<>();
                        Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                        pokemonList.add(pokemon);
                        person.setPokemons(pokemonList);
                        person.setName(name);
                        people.add(person);
                        break;
                    case "parents":
                        String parentName = line.split("\\s+")[2];
                        String parentBirthday = line.split("\\s+")[3];
                        List<Parent> parentList = new ArrayList<>();
                        Parent parent = new Parent(parentName, parentBirthday);
                        parentList.add(parent);
                        person.setParents(parentList);
                        person.setName(name);
                        people.add(person);
                        break;
                    case "children":
                        String childrenName = line.split("\\s+")[2];
                        String childrenBirthday = line.split("\\s+")[3];
                        List<Children> childrenList = new ArrayList<>();
                        Children children = new Children(childrenName, childrenBirthday);
                        childrenList.add(children);
                        person.setChildrens(childrenList);
                        person.setName(name);
                        people.add(person);
                        break;
                    case "car":
                        String carModel = line.split("\\s+")[2];
                        int carSpeed = Integer.parseInt(line.split("\\s+")[3]);
                        Car car = new Car(carModel, carSpeed);
                        person.setCar(car);
                        person.setName(name);
                        people.add(person);
                }
            }
            line = scanner.nextLine();
        }

        line = scanner.nextLine();

        for (People person : people) {
            if (person.getName().equals(line)) {
                String name = person.getName();
                String companyName = "";
                String car = "";
                System.out.println(person.getName());
                System.out.println("Company:");
                if (person.getCompany() != null) {
                    System.out.println(person.getCompany().toString());
                }
                System.out.println("Car:");
                if (person.getCar() != null) {
                    System.out.println(person.getCar().toString());
                }
                System.out.println("Pokemon:");
                if (person.getPokemons().size() > 0) {
                    List<Pokemon> pokemonList = person.getPokemons();
                    for (Pokemon pokemon : pokemonList) {
                        System.out.println(pokemon.toString());
                    }
                }
                System.out.println("Parents:");
                if (person.getParents().size() > 0) {
                    List<Parent> parentList = person.getParents();
                    for (Parent parent : parentList) {
                        System.out.println(parent.toString());
                    }
                }
                System.out.println("Children:");
                if (person.getChildrens().size() > 0) {
                    List<Children> childrenList = person.getChildrens();
                    for (Children children : childrenList) {
                        System.out.println(children.toString());
                    }
                }
            }
        }
    }

    private static Children getChildrenTemp(List<Children> childrenList, String name) {
        for (Children children : childrenList) {
            if (children.getName().equals(name)) {
                return children;
            }
        }
        return null;
    }

    private static boolean hasChildrenList(People person, String name) {
        List<Children> childrenList = person.getChildrens();
        for (Children children : childrenList) {
            if (children.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private static Parent getParentTemp(List<Parent> parentList, String name) {
        for (Parent parent : parentList) {
            if (parent.getName().equals(name)) {
                return parent;
            }
        }
        return null;
    }

    private static boolean hasParents(People person, String name) {
        List<Parent> personList = person.getParents();
        for (Parent parent : personList) {
            if (parent.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private static List<Pokemon> updatePokemon(People person, String pokemonName, Pokemon pokemon) {
        List<Pokemon> temp = person.getPokemons();
        for (Pokemon pokemon1 : temp) {
            if (pokemon1.getName().equals(pokemonName)) {
                pokemon1 = pokemon;
                return temp;
            }
        }
        return null;
    }

    private static Pokemon getPokemonList(People person, String pokemonName) {
        List<Pokemon> temp = person.getPokemons();
        for (Pokemon pokemon : temp) {
            if (pokemon.getName().equals(pokemonName)) {
                return pokemon;
            }
        }
        return null;
    }

    private static boolean hasPokemons(People person, String pokemonName) {
        List<Pokemon> temp = person.getPokemons();
        for (Pokemon pokemon : temp) {
            if (pokemon.getName().equals(pokemonName)) {
                return true;
            }
        }
        return false;
    }

    private static People getPerson(List<People> people, String name) {
        for (People person : people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    private static boolean personExist(String s, List<People> people) {
        for (People person : people) {
            if (person.getName().equals(s)) {
                return true;
            }
        }
        return false;
    }
}
