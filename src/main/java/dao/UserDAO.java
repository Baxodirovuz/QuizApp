package dao;

import domains.User;
import domains.additional.UpdateType;
import dto.UserCreateDTO;
import lombok.NonNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    private static String SAVE_USER_QUERY = "insert into users(uuid, username, password, language, role) values (?,?,?,?,?);";
    private static String SELECT_ALL = "SELECT * FROM users;";

    public boolean save(@NonNull UserCreateDTO dto) {
        User user = User.builder()
                .UUID(dto.uuid())
                .username(dto.username())
                .password(dto.password())
                .language(dto.language())
                .role(dto.role())
                .build();
        Connection connection = DAO.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SAVE_USER_QUERY)) {
            preparedStatement.setString(1, user.getUUID());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getLanguage().toString());
            preparedStatement.setString(5, user.getRole().toString());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User get(int userId) {
        return null;
    }

    public List<User> findAll() {
        Connection connection = getConnection();
        List<User> userArrayList = new ArrayList<>();
        try (var pr = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String uuid = resultSet.getString("uuid");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userArrayList;
    }

    public boolean delete(Integer integer) {
        return false;
    }

    public boolean update(String value, UpdateType type) {

        return false;
    }
}

