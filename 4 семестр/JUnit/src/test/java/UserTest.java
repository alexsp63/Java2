import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserTest extends TestCase {

    @Test
    public void testGetUserHashMap() {
        User user = new User("Евгений", "Male", 35);
        User user1 = new User("Марина", "Female", 41);
        User user2 = new User("Алина", "Female", 12);

        List<User> expected = User.getUserHashMap();
        System.out.println();

        List<User> actual = new ArrayList<User>();
        actual.add(user);
        actual.add(user1);
        actual.add(user2);

        Assert.assertEquals(expected, actual);
    }

    public void testTestGetUserHashMap() {
    }

    public void testGetCount() {
    }

    public void testTestGetCount() {
    }
}