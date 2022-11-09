
public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 123) {
            throw new IllegalArgumentException("Некорректный возраст");
        } else {
            this.age = age;
            return this;
        }
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalStateException("Необходимо указать фамилию или имя");
        } else {
            Person person = new Person(this.name, this.surname);
            if (this.getAge() != 0) {
                person.setAge(this.age);
            }
            if (this.getAddress() != null) {
                person.setAddress(this.address);
            }
            return person;
        }
    }

}
