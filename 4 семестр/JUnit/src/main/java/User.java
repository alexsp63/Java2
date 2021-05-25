import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class User {

    private int id;
    private String name;
    private String sex;
    private int age;

    private static int countId = 0;

    private static HashMap<Integer, User> userHashMap = new HashMap<Integer, User>();

    public User(String name, String sex, int age){
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        countId += 1;
        userHashMap.put(countId, this);
    }

    public static List<User> getUserHashMap() {
        List<User> userList = new ArrayList<User>();
        for (User user : userHashMap.values()){
            userList.add(user);
        }
        return userList;
    }

    public static List<User> getUserHashMap(String sex) {
        List<User> users = new ArrayList<User>();
        for (User user : userHashMap.values()){
            if (user.sex == sex){
                users.add(user);
            }
        }
        return users;
    }

    public int getCount() {
        return userHashMap.size();
    }

    public int getCount(String sex) {
        return getUserHashMap(sex).size();
    }

    public boolean isEqual(Object obj){
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return age == user.age && obj.equals(this.name) && sex == user.sex;

    }
}
