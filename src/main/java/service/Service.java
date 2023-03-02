package service;

import dao.UserDAO;
import domains.additional.Language;
import domains.additional.UpdateType;
import login.Login;
import lombok.SneakyThrows;
import console.Console;
import service.serviceAdditional.ServiceInterface;
import temporarily.data.Data;

import java.util.Scanner;

public class Service implements ServiceInterface {


    public static final String INSERT_INTO_QUERY = "insert into users(username,password,language,role) values ( %s , %s , %s,%s)";


    private static Service service = new Service();
    private Data data = Data.getInstance();
    private UserDAO userDAO = UserDAO.getInstance();

    public static Service getInstance() {
        return service;
    }

    public Login login = Login.getInstance();


    public void mainService(int id) {
        Console.println(" <1> quiz");
        Console.println(" <2> statistics");
        Console.println(" <3> settings");
        Console.println(" <4> log out");
        Console.print("Enter option: ");
        switch (new Scanner(System.in).nextInt()) {
            case 1 -> quiz();
            case 2 -> statistics(id);
            case 3 -> settings(id);
            case 4 -> login.login();
        }
    }

    @SneakyThrows
    private void settings(int id) {
        Console.println(" <1> change username");
        Console.println(" <2> change password");
        Console.println(" <3> change language");
        switch (new Scanner(System.in).nextInt()) {
            case 1 -> changeUsername();
            case 2 -> changePassword();
            case 3 -> changeLanguage();
            default -> {
                Console.printErr("entered option not found");
                Thread.sleep(3000);
                mainService(id);
            }
        }
    }

    private void statistics(int id) {

    }

    private void quiz() {

    }

    @Override
    public boolean changeUsername() {
        Console.print("Enter new name: ");
        String updateUsername = new Scanner(System.in).nextLine();
        if (updateUsername.isBlank()) {
            userDAO.update(updateUsername, UpdateType.USERNAME);
        }
        return true;
    }


    @Override
    public boolean changePassword() {
        Console.print("Enter new name: ");
        String updatePassword = new Scanner(System.in).nextLine();
        if (updatePassword.isBlank()) {
            userDAO.update(updatePassword, UpdateType.PASSWORD);
        }
        return true;
    }

    @Override
    public boolean changeLanguage() {
        Language language = null;
        Console.println(" <1> " + Language.ENG);
        Console.println(" <2> " + Language.RU);
        Console.println(" <3> " + Language.UZ);
        Console.print("Enter option: ");
        switch (new Scanner(System.in).nextInt()) {
            case 1 -> language = Language.ENG;
            case 2 -> language = Language.RU;
            case 3 -> language = Language.UZ;
            default -> {
            }
        }
        userDAO.update(language.toString(), UpdateType.LANGUAGE);
        return false;
    }
}
