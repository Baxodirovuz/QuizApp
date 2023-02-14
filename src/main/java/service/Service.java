package service;

import login.Login;
import lombok.SneakyThrows;
import serv.Console;
import service.serviceAdditional.ServiceInterface;

import java.util.Scanner;

public class Service implements ServiceInterface {
    private static Service service = new Service();

    public static Service getInstance() {
        return service;
    }

    public Login login = Login.getInstance();


    public void mainService(String username) {
        Console.println(" <1> quiz");
        Console.println(" <2> statistics");
        Console.println(" <3> settings");
        Console.println(" <4> log out");
        Console.print("Enter option: ");
        switch (new Scanner(System.in).nextInt()) {
            case 1 -> quiz();
            case 2 -> statistics(username);
            case 3 -> settings(username);
            case 4 -> login.login();
        }
    }

    @SneakyThrows
    private void settings(String username) {
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
                mainService(username);
            }
        }
    }

    private void statistics(String username) {

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
