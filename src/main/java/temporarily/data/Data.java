package temporarily.data;

import obj.User;

import java.util.ArrayList;

public class Data {
    private static Data data = new Data();

    public static Data getInstance() {
        return data;
    }


    public ArrayList<User> usersList = new ArrayList<>();

}
