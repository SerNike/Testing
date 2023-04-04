import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    public static final String LOGIN = "login";

    public static final String EMAIL = "Sega@mail.ru";
    public static final String INCORRECT_LOGIN = ".";
    public static final String INCORRECT_LOGIN1 = "@";
    public static final String INCORRECT_EMAIL = "Segamail.ru";
    User user1;
    User user2;

    User user3;


    @Before
    public void initTest() {
        user2 = new User(LOGIN, EMAIL);
        user1 = new User();
        user3 = new User(INCORRECT_LOGIN, EMAIL);
    }

    @After
    public void afterTest() {
        System.out.println("Testing is finished!");
    }


    @Test
    public void creatingUserObjectWithTwoParameters() {
        assertEquals(LOGIN, user2.getLogin());
        assertEquals(EMAIL, user2.getEmail());
    }


    @Test
    public void creatingCustomObjectWithoutParameters() {
        assertNull(user1.getLogin());
        assertNull(user1.getEmail());
    }

    @Test(expected = IllegalArgumentException.class)
    public void isTheCorrectEmailAddressSetInTheEmailField() {
        User user = new User(LOGIN, INCORRECT_EMAIL);
        assertFalse(user.getEmail().contains(INCORRECT_LOGIN1));
        assertFalse(user.getEmail().contains(INCORRECT_LOGIN));
    }

    @Test(expected = IllegalArgumentException.class)
    public void determinesWhetherTheUserLoginAndEmailAre() {
        User user = new User(LOGIN, LOGIN);
        assertFalse(user.getLogin().equals(user.getEmail()));

    }
}






