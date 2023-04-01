/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 31.3.2023 г.
 * Time: 18:11
 */
package P18JavaAdvancedExam18February2023.kindergarten;

public class Child {
    private String firstName;
    private String lastName;
    private int age;
    private String parentName;
    private String contactNumber;

    public Child(String firstName, String lastName, int age, String parentName, String contactNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.parentName = parentName;
        this.contactNumber = contactNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Child: " + this.firstName + " " + this.lastName);
        sb.append(", Age: " + this.age);
        sb.append(", Contact info: " + this.parentName + " - " + this.contactNumber + "\n");

        return sb.toString().trim();
    }
}
