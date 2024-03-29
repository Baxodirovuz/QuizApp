package login;

import dao.UserDAO;
import lombok.SneakyThrows;
import domains.User;
import domains.additional.Language;
import domains.additional.Role;
import console.Console;
import service.Service;
import temporarily.data.Data;

import java.util.Scanner;
import java.util.UUID;

import static java.lang.System.*;

public class Login {

    private Data data = Data.getInstance();
    private Service service = Service.getInstance();
    private static Login login = new Login();
    private UserDAO userDAO = UserDAO.getInstance();

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
        for (User user : userDAO.findAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                service.mainService(user.getId());
            } else {
                Console.printErr("Entered valid invalid");
                Thread.sleep(3000);
                login();
            }
        }
    }

    @SneakyThrows
    private void signUp() {
        Console.print("Enter username: ");
        String username = new Scanner(System.in).nextLine();
        Console.print("Enter password: ");
        String password = new Scanner(System.in).nextLine();
        Console.println("<1> " + Language.ENG);
        Console.println("<2> " + Language.RU);
        Console.println("<3> " + Language.UZ);
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
