package Languages;

import Data.Data;
import Languages.Controller.MainController;
import lombok.SneakyThrows;

import java.util.Scanner;

public class MainLanguages extends Data {

    public MainController controller = MainController.getMainController();

    public int i = 0;
    @SneakyThrows
    public void chooseLang() {
        println(" <1> English");
        println(" <2> Russian");
        println(" <3> Uzbek");
        println(" <0> Exit");
        print("Enter option: ");
        i = new Scanner(System.in).nextInt();
        switch (i) {
            case 1 -> controller.login();
            case 2 -> controller.russianLogin();
            case 3 -> controller.uzbekLogin();
            case 0 -> println("");
            default -> {
                println("Entered option not found!");
                Thread.sleep(3000);
            }
        }
    }
}
