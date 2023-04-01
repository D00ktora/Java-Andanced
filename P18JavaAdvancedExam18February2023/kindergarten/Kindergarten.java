/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 31.3.2023 г.
 * Time: 18:14
 */
package P18JavaAdvancedExam18February2023.kindergarten;

import P18JavaAdvancedExam18February2023.kindergarten.Child;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }
    public List<Child> getRegistry() {
        return registry;
    }
    public boolean addChild(Child child) {
        if (this.getChildrenCount() == this.capacity) {
            return false;
        }
        this.registry.add(child);
        return true;
    }

    public boolean removeChild(String firstName) {
        for (int i = 0; i < registry.size(); i++) {
            if (this.registry.get(i).getFirstName().equals(firstName)) {
                this.registry.remove(i);
                return true;
            }
        }
        return false;
    }

    public int getChildrenCount() {
        return this.registry.size();
    }

    public Child getChild(String firstName) {
        return registry.stream().filter(e -> e.getFirstName().equals(firstName)).findFirst().orElse(null);
    }

    public String registryReport() {
        List<Child> sortedChildren = this.registry.stream()
                .sorted(Comparator.comparing(Child::getAge).thenComparing(Child::getFirstName).thenComparing(Child::getLastName))
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        sb.append("Registered children in ").append(this.name).append(":");

        for (Child child : sortedChildren) {
            sb.append(System.lineSeparator()).append("--").append(System.lineSeparator());
            sb.append(child.toString());
        }

        return sb.toString().trim();
    }
}
