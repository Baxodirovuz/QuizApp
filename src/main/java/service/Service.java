package service;

import login.Login;
import lombok.SneakyThrows;
import obj.User;
import serv.Console;
import service.serviceAdditional.ServiceInterface;
import temporarily.data.Data;
import java.util.Scanner;

public class Service implements ServiceInterface {


    public static final String INSERT_INTO_QUERY = "insert into users(username,password,language,role) values ( %s , %s , %s,%s)";


    private static Service service = new Service();
    private Data data = Data.getInstance();


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

        return false;
    }

    @Override
    public boolean changePassword() {
        return false;
    }

    @Override
    public boolean changeLanguage() {
        return false;
    }
}
