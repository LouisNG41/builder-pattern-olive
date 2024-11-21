package info.dmerej.builder;

import info.dmerej.Address;
import info.dmerej.User;

public class UserBuilder {
    private String name;
    private String email;
    private int age;
    private boolean verified;
    private Address address;

    public UserBuilder ageMinor() {
        this.age = 16;
        return this;
    }

    public UserBuilder notVerified() {
        this.verified = false;
        return this;
    }

    public UserBuilder foreignAddress() {
        this.address = new Address(
                "33 quai d'Orsay",
                "",
                "Paris",
                "75007",
                "France"
        );
        return this;
    }

    public User build() {
        return new User(name, email, age, verified, address);
    }

    public UserBuilder defaultValues(){
        Address fsfAddress = new Address(
                "51 Franklin Street",
                "Fifth Floor",
                "Boston",
                "02110",
                "USA"
        );
        this.name = "Bob";
        this.email = "bob@domain.tld";
        this.age = 25;
        this.verified = true;
        this.address = fsfAddress;
        return this;
    }
}
