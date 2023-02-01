package login;

import serv.Console;

import java.util.Scanner;

public class Service {
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
            case 4 ->
        }
    }

    private void settings(String username) {

    }

    private void statistics(String username) {

    }

    private void quiz() {

    }
}
