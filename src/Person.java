import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this(name, surname);
        this.age = OptionalInt.of(age);
    }

    public boolean hasAge() {
        return age != null;

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

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAge(int age) {
        this.age = OptionalInt.of(age);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (age.isPresent()) {
            int happyBirthday = age.getAsInt();
            happyBirthday++;
            this.age = OptionalInt.of(happyBirthday);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("имя: " + name)
                .append("\n" + "фамилия: " + surname);
        if (this.hasAge()) {
            sb.append("\n" + "возраст: " + this.age.getAsInt());
        }
        if (this.hasAddress()) {
            sb.append("\n" + "город: " + address);
        }
        String person = sb.toString();
        return person;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return age == person.age &&
                name.equals(person.name) &&
                surname.equals(person.surname) &&
                address.equals(person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(getSurname()).setAddress(getAddress());

    }
}

