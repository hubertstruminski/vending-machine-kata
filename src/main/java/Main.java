import Controller.MainController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MainController mainController = new MainController();
        Scanner scanner = new Scanner(System.in);
        mainController.selectProduct(scanner);
    }
}
