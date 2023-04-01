/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 19.3.2023 г.
 * Time: 17:27
 */
package P12_06PokemonTrainer;

public class Pokemon {
    private String name;
    private String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public String getElement() {
        return element;
    }
}
