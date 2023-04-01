/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 19.3.2023 г.
 * Time: 17:20
 */
package P12_06PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Trainer> trainers = new ArrayList<>();
        String command = scanner.nextLine();

        while (!command.contains("Tournament")) {

        String trainerName = command.split("\\s+")[0];
        String pokemonName = command.split("\\s+")[1];
        String pokemonElement = command.split("\\s+")[2];
        int pokemonHealth = Integer.parseInt(command.split("\\s+")[3]);
        Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
        Trainer trainer = null;
            for (Trainer tempTrainer : trainers) {
                if (tempTrainer.getName().equals(trainerName)) {
                    trainer = tempTrainer;
                    break;
                }
            }
            //може да се чупи тук!!!!
            if (trainer == null) {
                trainer = new Trainer(trainerName);
                List<Pokemon> pokemons = trainer.getPokemons();
                pokemons.add(pokemon);
                trainer.setPokemons(pokemons);
                trainers.add(trainer);
            } else {
                List<Pokemon> pokemons = trainer.getPokemons();
                pokemons.add(pokemon);
                trainer.setPokemons(pokemons);
            }

            command = scanner.nextLine();
        }

        command = scanner.nextLine();

        while (!command.contains("End")) {

            for (Trainer trainer : trainers) {
                List<Pokemon> temp = trainer.getPokemons();
                boolean isFound = false;
                for (Pokemon pokemon : temp) {
                    if (pokemon.getElement().equals(command)) {
                        trainer.setBadges();
                        isFound = true;
                        break;
                    }
                }

                if (!isFound) {
                    for (Pokemon pokemon : temp) {
                        if (pokemon.getHealth() - 10 <= 0) {
                            pokemon.setHealth(-999);
                        } else {
                            pokemon.setHealth(pokemon.getHealth() - 10);
                        }
                    }
                }

                temp.removeIf(x-> x.getHealth() < 0);
                trainer.setPokemons(temp);
            }

            command = scanner.nextLine();
        }


        List<Trainer> sorted = trainers.stream().sorted(Comparator.comparing(Trainer::getBadges).reversed()).collect(Collectors.toList());
        for (Trainer trainer : sorted) {
            System.out.println(trainer.toString());
        }
    }
}
