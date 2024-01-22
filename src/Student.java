public class Student {
    private String firstName;
    private String lastName;
    private String city;
    private int age;

    public Student(String firstName, String lastName, int age, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.age = age;
    }

    public String getCity() {
        return this.city;
    }

    public String getInfo() {
        return String.format("%s %s is %d years old.", this.firstName, this.lastName, this.age);
    }
}
