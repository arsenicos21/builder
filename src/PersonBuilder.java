import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private String address;
    private OptionalInt age = OptionalInt.empty();

    public PersonBuilder() {
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Введен недопустимый возраст!");
        } else {
            this.age = OptionalInt.of(age);
            return this;
        }
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalStateException {
        if (name == null || name.isBlank() && surname == null || surname.isBlank()) {
            throw new IllegalStateException("Недопустимый вариант! Поле имени и фамилии не заполнено!");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalStateException("Недопустимый вариант! Поле имени не заполнено!");
        }
        if (surname == null || surname.isBlank()) {
            throw new IllegalStateException("Недопустимый вариант! Поле фамилии не заполнено!");
        }
        Person person = new Person(name, surname, age, address);
        return person;
    }
}
