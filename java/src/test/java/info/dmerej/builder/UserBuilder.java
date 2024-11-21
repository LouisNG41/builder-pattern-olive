package info.dmerej.builder;

import info.dmerej.Address;
import info.dmerej.User;

public class UserBuilder {
    private String name;
    private String email;
    private int age;
    private boolean verified;
    private Address address;

    public UserBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder withAge(int age) {
        this.age = age;
        return this;
    }

    public UserBuilder withVerified(boolean verified) {
        this.verified = verified;
        return this;
    }

    public UserBuilder withAddress(Address address) {
        this.address = address;
        return this;
    }

    public User build() {
        return new User(name, email, age, verified, address);
    }

    public UserBuilder withTestValues(){
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
