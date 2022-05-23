import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected String name;
    protected String surname;
    protected OptionalInt age = OptionalInt.empty();
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, OptionalInt age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public Person(String name, String surname, OptionalInt age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge(OptionalInt age) {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday(OptionalInt age) {
        age = OptionalInt.of(age.getAsInt() + 1);
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder childBuilder = new PersonBuilder();
        childBuilder.setSurname(this.surname);
        return childBuilder;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Имя: " + name + ", Фамилия: " + surname);
        if (this.hasAge()) {
            str.append(", Возраст: " + age.getAsInt());
        }
        if (this.hasAddress()) {
            str.append(", Адрес: " + address);
        }
        return str.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}
