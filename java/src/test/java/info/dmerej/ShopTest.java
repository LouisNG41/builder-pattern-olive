package info.dmerej;

import info.dmerej.builder.UserBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShopTest {

    private final Address fsfAddress = new Address(
        "51 Franklin Street",
        "Fifth Floor",
        "Boston",
        "02110",
        "USA"
    );

    private final Address parisAddress = new Address(
        "33 quai d'Orsay",
        "",
        "Paris",
        "75007",
        "France"
    );


    @Test
    public void happy_path() {
        final User user = new UserBuilder().withTestValues().build();
        //final User user = new User("Bob", "bob@domain.tld", 25, true, fsfAddress);

        assertTrue(Shop.canOrder(user));
        assertFalse(Shop.mustPayForeignFee(user));
    }

    @Test
    public void minors_cannot_order_from_shop() {
        final User user = new UserBuilder().withTestValues().withAge(16).build();
        //final User user = new User("Bob", "bob@domain.tld", 16, true, fsfAddress);

        assertFalse(Shop.canOrder(user));
    }

    @Test
    public void must_be_verified_to_order_from_shop() {
        final User user = new UserBuilder().withTestValues().withVerified(false).build();
        //final User user = new User("Bob", "bob@domain.tld", 20, false, fsfAddress);

        assertFalse(Shop.canOrder(user));
    }

    @Test
    public void foreigners_must_pay_foreign_fee() {
        final User user = new UserBuilder().withTestValues().withAddress(parisAddress).build();
        //final User user = new User("Bob", "bob@domain.tld", 25, false, parisAddress);

        assertTrue(Shop.mustPayForeignFee(user));
    }

}
