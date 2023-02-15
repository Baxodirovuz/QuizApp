package dao;

import domains.User;
import domains.additional.UpdateType;

public class UserDAO extends DAO<User, Integer> {

    private static UserDAO instance;

    public static UserDAO getInstance() {
        if (instance == null) {
            synchronized (UserDAO.class) {
                if (instance == null) {
                    instance = new UserDAO();
                }
            }
        }
        return instance;
    }


    public void save(User user) {

    }

    public User get(int userId) {
        return null;
    }

    public boolean delete(Integer integer) {
        return false;
    }

    public boolean update(String value, UpdateType type) {

        return false;
    }
}
