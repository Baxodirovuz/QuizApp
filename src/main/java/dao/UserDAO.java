package dao;

import obj.User;

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


    @Override
    protected User save(User user) {
        return null;
    }

    @Override
    protected User get(Integer integer) {
        return null;
    }

    @Override
    protected boolean update(User user) {
        return false;
    }

    @Override
    protected boolean delete(Integer integer) {
        return false;
    }
}
