package login;

import lombok.SneakyThrows;
import obj.User;
import obj.additional.Language;
import obj.additional.Role;
import serv.Console;
import service.Service;
import temporarily.data.Data;

import java.util.Scanner;
import java.util.UUID;

import static java.lang.System.*;

public class Login {

    private Data data = Data.getInstance();
    private Service service = Service.getInstance();
    private static Login login = new Login();

    public static Login getInstance() {
        return login;
    }

    @SneakyThrows
    public void login() {
        Console.println(" <1> Sign in");
        Console.println(" <2> Sign up");
        Console.print("Enter option: ");
        switch (new Scanner(in).nextInt()) {
            case 1 -> signIn();
            case 2 -> signUp();
            default -> {
                Console.printErr("Entered option not found");
                Thread.sleep(3000);
                login();
            }
        }
    }

    @SneakyThrows
    private void signIn() {
        Console.print("Enter username: ");
        String username = new Scanner(in).nextLine();
        Console.print("Enter password: ");
        String password = new Scanner(in).nextLine();
        for (User user : data.usersList) {
            if (user.getUsername().equalsIgnoreCase(username) &&
                    user.getPassword().equals(password))
                service.mainService(data.getId(username));
            else
                Console.printErr("Entered valid invalid");
            Thread.sleep(3000);
            login();
        }
    }

    @SneakyThrows
    private void signUp() {
        Console.print("Enter username: ");
        String username = new Scanner(System.in).nextLine();
        Console.print("Enter password: ");
        String password = new Scanner(System.in).nextLine();
        Console.println("<1> " + Language.ENG.toString());
        Console.println("<2> " + Language.RU.toString());
        Console.println("<3> " + Language.UZ.toString());
        Language language = null;
        Console.print("Enter language: ");
        switch (new Scanner(System.in).nextInt()) {
            case 1 -> language = Language.ENG;
            case 2 -> language = Language.RU;
            case 3 -> language = Language.UZ;
            default -> {
                Console.printErr("Entered valid invalid!");
                Thread.sleep(3000);
                login();
            }
        }
        User user = User.builder()
                .id(nextId())
                .UUID(UUID.randomUUID().toString())
                .username(username)
                .password(password)
                .language(language)
                .role(Role.USER)
                .build();
        data.usersList.add(user);
    }

    private int nextId() {
        return data.usersList.size() + 1;
    }

}
