package medium;

import java.util.HashMap;
import java.util.Map;
class UserData {
    private int id;
    private String name;
    private String email;
    public UserData(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
interface UserDataCloudDataSource {
    UserData fetchUserData(int userId);
}
class UserRepository {
    private UserDataCloudDataSource cloudDataSource;
    private Map<Integer, UserData> cache = new HashMap<>();
    public UserRepository(UserDataCloudDataSource cloudDataSource) {
        this.cloudDataSource = cloudDataSource;
    }
    public UserData getUserData(int userId) {
        if (cache.containsKey(userId)) {
            return cache.get(userId);
        } else {
            UserData userData = cloudDataSource.fetchUserData(userId);
            cache.put(userId, userData);
            return userData;
        }
    }
}
class MockUserDataCloudDataSource implements UserDataCloudDataSource {
    @Override
    public UserData fetchUserData(int userId) {
        return new UserData(userId, "User" + userId, "user" + userId + "@example.com");
    }
}
public class Main {
    public static void main(String[] args) {
        UserDataCloudDataSource cloudDataSource = new MockUserDataCloudDataSource();
        UserRepository userRepository = new UserRepository(cloudDataSource);
        UserData user1 = userRepository.getUserData(1);
        System.out.println(user1);
        UserData user2 = userRepository.getUserData(2);
        System.out.println(user2);
        UserData cachedUser1 = userRepository.getUserData(1);
        System.out.println(cachedUser1);
    }
}