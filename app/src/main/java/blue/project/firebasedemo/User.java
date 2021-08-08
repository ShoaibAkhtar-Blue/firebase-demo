package blue.project.firebasedemo;

public class User {
    private String firstNamr;
    private String lastName;
    private String fullName;

    public User(String firstNamr, String lastName) {
        this.firstNamr = firstNamr;
        this.lastName = lastName;
    }

    public String getFirstNamr() {
        return firstNamr;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstNamr + " " + lastName;
    }
}
