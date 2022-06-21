package Languages.Controller;

import Languages.Controller.Test.Test;
import Languages.Controller.Test.TestUser;
import Service.Result;
import lombok.SneakyThrows;

import java.util.List;
import java.util.Scanner;

public class UserController extends MainController implements Test {
    private static UserController userController = new UserController();
    public static UserController getUserController(){
        return userController;
    }
    public TestUser testUser = new TestUser();

    @SneakyThrows
    public void uzbekQuestion() {
        println(" <1> Test yechish");
        println(" <2> Yechilgan testlarni ko`rish");
        println(" <3> Orqaga");
        println(" <4> Chiqish");
        print("Tanlang: ");
        switch (new Scanner(System.in).nextInt()) {
            case 1 -> uzbekTest();
            case 2 -> uzbekShowTaskList();
            case 3 -> uzbekLogin();
            case 4 -> println("");
            default -> {
                println("Siz noto`g`ri kiritdingiz! ");
                Thread.sleep(3000);
                uzbekQuestion();
            }
        }
    }

    @SneakyThrows
    @Override
    public void uzbekTest() {
        println(" <1> IT");
        println(" <2> Tarix");
        println(" <3> Orqaga");
        println(" <4> Chiqish");
        print(" Test yo`nalishini tanlang: ");
        switch (new Scanner(System.in).nextInt()) {
            case 1 -> testUser.uzbekIT();
            case 2 -> testUser.uzbekHistory();
            case 3 -> uzbekQuestion();
            case 4 -> println("");
            default -> {
                println("Siz noto`g`ri kiritdingi!");
                Thread.sleep(3000);
                uzbekTest();
            }
        }
    }

    private void uzbekShowTaskList() {
        Result result = new Result();
        println("Ismingiz: " + result.getUsername());
        println("Sanasi: " + result.getTime());
        println("Savollar soni: " + result.getIsRight() + result.getWrong());
        println("To`gri javoblar: " + result.getIsRight());
        println("Noto`g`ri javoblar: " + result.getWrong());
        uzbekQuestion();
    }


    @SneakyThrows
    public void englishQuestion() {
        println(" <1> Test solution");
        println(" <2> View solved tests");
        println(" <3> Back");
        println(" <4> Exit");
        print("Enter option: ");
        switch (new Scanner(System.in).nextInt()) {
            case 1 -> englishTest();
            case 2 -> enlishShowTaskList();
            case 3 -> login();
            case 4 -> println("");
            default -> {
                println("Entered option not found!");
                Thread.sleep(3000);
                englishQuestion();
            }
        }
    }

    private void enlishShowTaskList() {
        Result result = new Result();
        println("Username: " + result.getUsername());
        println("Time: " + result.getTime());
        println("Question count: " + result.getIsRight() + result.getWrong());
        println("Right: " + result.getIsRight());
        println("Wrong: " + result.getWrong());
        englishQuestion();
    }

    @SneakyThrows
    @Override
    public void englishTest() {
        println(" <1> IT");
        println(" <2> History");
        println(" <3> Back");
        println(" <4> Exit");
        print("Enter option: ");
        switch (new Scanner(System.in).nextInt()) {
            case 1 -> testUser.enIT();
            case 2 -> testUser.enHistory();
            case 3 -> englishQuestion();
            case 4 -> println("");
            default -> {
                println("Entered option not found!");
                Thread.sleep(3000);
                englishTest();
            }
        }
    }


    @SneakyThrows
    public void russianQuestion() {
        println(" <1> тестовое решение");
        println(" <2> посмотреть решенные тесты");
        println(" <3> назад");
        println(" <4> выход");
        print("Выбрать: ");
        switch (new Scanner(System.in).nextInt()) {
            case 1 -> russianTest();
            case 2 -> russianShowTasks();
            case 3 -> russianLogin();
            case 4 -> println("");
            default -> {
                println("вы ввели неправильно!");
                Thread.sleep(3000);
                russianQuestion();
            }
        }
    }

    private void russianShowTasks() {
        Result result = new Result();
        println("ваше имя: " + result.getUsername());
        println("время: " + result.getTime());
        println("количество вопросов: " + result.getIsRight() + result.getWrong());
        println("правильные вопросы: " + result.getIsRight());
        println("неправильные вопросы: " + result.getWrong());
        russianQuestion();
    }

    @SneakyThrows
    @Override
    public void russianTest() {
        println(" <1> IT");
        println(" <2> история");
        println(" <3> назад");
        println(" <4> выход");
        print("Выбрать: ");
        switch (new Scanner(System.in).nextInt()) {
            case 1 -> testUser.ruIT();
            case 2 -> testUser.ruHistory();
            case 3 -> russianQuestion();
            case 4 -> println("");
            default -> {
                println("вы ввели неправильно!");
                Thread.sleep(3000);
                russianTest();
            }
        }
    }


}
