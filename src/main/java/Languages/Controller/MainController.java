package Languages.Controller;

import Languages.MainLanguages;
import Service.Additional.Language;
import Service.Additional.Role;
import Service.User;
import lombok.SneakyThrows;

import java.util.Scanner;
import java.util.UUID;

public class MainController extends MainLanguages {

    private static MainController mainController = new MainController();
    public static MainController getMainController(){
        return mainController;
    }

    public UserController userController = UserController.getUserController();
    public AdminController adminController = AdminController.getAdminController();



    @SneakyThrows
    public void uzbekLogin() {
        println(" <1> Kirish");
        println(" <2> Ro`yxatdan o`tish");
        println(" <9> Orqaga");
        println(" <0> Chiqish");
        print("Tanlang: ");
        switch (new Scanner(System.in).nextInt()){
            case 1 -> uzbekSignIn();
            case 2 -> uzbekSignUp();
            case 9 -> chooseLang();
            case 0 -> println("");
            default -> {
                println("Siz noto`gri kiritdingiz!");
                Thread.sleep(3000);
                uzbekLogin();
            }
        }
    }
    private void uzbekSignUp() {
        print("Ism kiriting: ");
        user.setUsername(new Scanner(System.in).nextLine());
        print("Parol kiring: ");
        user.setPassword(new Scanner(System.in).nextLine());
        user.setId(UUID.randomUUID().toString());
        user.setRole(Role.USER);
        if (i == 1) {
            user.setLanguage(Language.EN);
        } else if (i == 2) {
            user.setLanguage(Language.RU);
        } else if (i == 3) {
            user.setLanguage(Language.UZ);
        } else user.setLanguage(null);
        uzbekLogin();
    }
    private void uzbekSignIn() {
        print("Ism kiriting: ");
        String username = new Scanner(System.in).nextLine();
        print("Parol kiriting: ");
        String password = new Scanner(System.in).nextLine();
        for (User findUser : usersList) {
            if (findUser.getUsername().equals(username) && findUser.getPassword().equals(password)) {
                if (findUser.getRole().equals("ADMIN")) {
                    if (findUser.getLanguage().equals("UZ")) adminController.uzbekQuestion();
                    if (findUser.getLanguage().equals("EN")) adminController.englishQuestion();
                    if (findUser.getLanguage().equals("RU")) adminController.russianQuestion();
                } else if (findUser.getRole().equals("USER")) {
                    if (findUser.getLanguage().equals("UZ")) userController.uzbekQuestion();
                    if (findUser.getLanguage().equals("EN")) userController.englishQuestion();
                    if (findUser.getLanguage().equals("RU")) userController.russianQuestion();
                }
            }
        }
    }

    @SneakyThrows
    public void russianLogin() {
        println(" <1> Введение");
        println(" <2> Регистрация");
        println(" <9> назад");
        println(" <0> выход");
        print("Выбрать: ");
        switch (new Scanner(System.in).nextInt()){
            case 1 -> russSignIn();
            case 2 -> russSignUp();
            case 9 -> chooseLang();
            case 0 -> println("");
            default -> {
                println("Bы ввели неправильно!");
                Thread.sleep(3000);
                russianLogin();
            }
        }
    }
    private void russSignUp() {
        print("Введите имя: ");
        user.setUsername(new Scanner(System.in).nextLine());
        print("Введите пароль: ");
        user.setPassword(new Scanner(System.in).nextLine());
        user.setId(UUID.randomUUID().toString());
        user.setRole(Role.USER);
        if (i == 1) {
            user.setLanguage(Language.EN);
        } else if (i == 2) {
            user.setLanguage(Language.RU);
        } else if (i == 3) {
            user.setLanguage(Language.UZ);
        } else user.setLanguage(null);
        russianLogin();
    }
    private void russSignIn() {
        print("Введите имя: ");
        String username = new Scanner(System.in).nextLine();
        print("Введите пароль: ");
        String password = new Scanner(System.in).nextLine();
        for (User findUser : usersList) {
            if (findUser.getUsername().equals(username) && findUser.getPassword().equals(password)) {
                if (findUser.getRole().equals("ADMIN")) {
                    if (findUser.getLanguage().equals("UZ")) adminController.uzbekQuestion();
                    if (findUser.getLanguage().equals("EN")) adminController.englishQuestion();
                    if (findUser.getLanguage().equals("RU")) adminController.russianQuestion();
                } else if (findUser.getRole().equals("USER")) {
                    if (findUser.getLanguage().equals("UZ")) userController.uzbekQuestion();
                    if (findUser.getLanguage().equals("EN")) userController.englishQuestion();
                    if (findUser.getLanguage().equals("RU")) userController.russianQuestion();
                }
            }
        }
    }

    @SneakyThrows
    public void login() {
        println(" <1> Sign in");
        println(" <2> Sign up");
        println(" <9> Log out");
        println(" <0> Exit");
        print("Enter option: ");
        switch (new Scanner(System.in).nextInt()) {
            case 1 -> signIn();
            case 2 -> signUp();
            case 9 -> chooseLang();
            case 0 -> println("");
            default -> {
                println("Entered option not found!");
                Thread.sleep(3000);
            }
        }
    }
    private void signUp() {
        print("Enter username: ");
        user.setUsername(new Scanner(System.in).nextLine());
        print("Enter password: ");
        user.setPassword(new Scanner(System.in).nextLine());
        user.setId(UUID.randomUUID().toString());
        user.setRole(Role.USER);
        if (i == 1) {
            user.setLanguage(Language.EN);
        } else if (i == 2) {
            user.setLanguage(Language.RU);
        } else if (i == 3) {
            user.setLanguage(Language.UZ);
        } else user.setLanguage(null);
        login();
    }
    private void signIn() {
        print("Enter username: ");
        String username = new Scanner(System.in).nextLine();
        print("Enter password: ");
        String password = new Scanner(System.in).nextLine();
        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).getUsername().equals(username) && usersList.get(i).getPassword().equals(password)) {
                if (usersList.get(i).getRole().equals("ADMIN")) {
                    if (usersList.get(i).getLanguage().equals("UZ")) adminController.uzbekQuestion();
                    if (usersList.get(i).getLanguage().equals("EN")) adminController.englishQuestion();
                    if (usersList.get(i).getLanguage().equals("RU")) adminController.russianQuestion();
                } else if (usersList.get(i).getRole().equals("USER")) {
                    if (usersList.get(i).getLanguage().equals("UZ")) userController.uzbekQuestion();
                    if (usersList.get(i).getLanguage().equals("EN")) userController.englishQuestion();
                    if (usersList.get(i).getLanguage().equals("RU")) userController.russianQuestion();
                }
            }
        }
    }
}
