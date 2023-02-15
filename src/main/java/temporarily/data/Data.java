package temporarily.data;

import domains.User;

import java.util.ArrayList;

public class Data {
    private static Data data = new Data();

    public static Data getInstance() {
        return data;
    }


    public ArrayList<User> usersList = new ArrayList<>();


    public int getId(String username) {
        for (User user : data.usersList) {
            if (user.getUsername().equals(username)) {
                return user.getId();
            }
        }
        return -1;
    }

}
