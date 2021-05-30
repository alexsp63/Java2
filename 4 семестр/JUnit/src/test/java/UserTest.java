import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserTest extends TestCase {

    private User user;
    private User user1;
    private User user2;

    @Before
    public void setUp() throws Exception {
        user = new User("Евгений", "Male", 35);
        user1 = new User("Марина", "Female", 41);
        user2 = new User("Алина", "Female", 12);
    }

    @Test
    public void testGetUserHashMap() {

        List<User> expected = User.getUserHashMap();
        System.out.println();

        List<User> actual = new ArrayList<User>();
        actual.add(user);
        actual.add(user1);
        actual.add(user2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetUserHashMapNotNull() {
        List<User> expected = User.getUserHashMap();
        Assert.assertNotNull(expected);
    }

    @Test
    public void testGetUserHashMapMale() {

        List<User> expected = User.getUserHashMap("Male");

        List<User> actual = new ArrayList<>();
        actual.add(user);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetUserHashMapFemale() {

        List<User> expected = User.getUserHashMap("Female");

        List<User> actual = new ArrayList<>();
        actual.add(user1);
        actual.add(user2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCount() {

        int expected = User.getCount();
        int actual = 3;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCountMale() {

        int expected = User.getCount("Male");
        int actual = 1;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCountFemale() {

        int expected = User.getCount("Female");
        int actual = 2;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsEqual() {

        boolean expected = user.isEqual(user1);
        boolean actual = false;

        Assert.assertEquals(expected, actual);
    }
}