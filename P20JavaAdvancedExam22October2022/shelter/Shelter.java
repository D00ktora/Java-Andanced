/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 1.4.2023 г.
 * Time: 18:11
 */
package P20JavaAdvancedExam22October2022.shelter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Shelter {
    private List<Animal> data;
    private int capacity;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (capacity > 0) {
            data.add(animal);
        }
    }

    public boolean remove(String name) {
        for (Animal datum : data) {
            if (datum.getName().equals(name)) {
                data.remove(datum);
                return true;
            }
        }
        return false;
    }

    public Animal getAnimal(String name, String caretaker) {
        for (Animal datum : data) {
            if (datum.getName().equals(name) && datum.getCaretaker().equals(caretaker)) {
                return datum;
            }
        }
        return null;
    }

    public Animal getOldestAnimal() {
        Animal animal = null;
        List<Animal> collect = this.data.stream().sorted(Comparator.comparing(Animal::getAge)).collect(Collectors.toList());
        return collect.get(collect.size() - 1);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append("The shelter has the following animals:");
        builder.append(System.lineSeparator());
        for (Animal animal : data) {
            builder.append(String.format("%s %s%n",animal.getName(), animal.getCaretaker()));
        }
        return builder.toString().trim();
    }
}
