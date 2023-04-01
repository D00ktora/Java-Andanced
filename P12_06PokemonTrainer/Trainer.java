/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 19.3.2023 г.
 * Time: 17:27
 */
package P12_06PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badges = 0;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public String getName() {
        return name;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges() {
        this.badges = this.badges + 1;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.badges, this.pokemons.size());
    }
}
