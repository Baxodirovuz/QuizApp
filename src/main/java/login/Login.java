package login;

import serv.Console;

import java.util.Scanner;

public class Login {
    public void login() throws Exception{
        Console.println(" <1> Sign in");
        Console.println(" <2> Sign up");
        Console.print("Enter option: ");
        switch (new Scanner(System.in).nextInt()) {
            case 1 -> signIn();
            case 2 -> signUp();
            default -> {
                Console.printErr("Entered option not found");
                Thread.sleep(3000);
                login();
            }
        }
    }

    private void signUp() {

    }

    private void signIn() {
        Console.print("Enter username: ");
        String username = new Scanner(System.in).nextLine();
        Console.print("Enter password: ");
        String password = new Scanner(System.in).nextLine();
        if (username.equals(password)){

        }
    }
}
