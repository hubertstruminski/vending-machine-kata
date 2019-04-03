package Controller;

import Enums.Coin;
import Enums.Product;

import java.util.Map;
import java.util.Scanner;

public class MainController {

    private VendingMachine vendingMachine;

    public MainController() {
        vendingMachine = new VendingMachine();
    }

    public void selectProduct(Scanner scanner) {
        showMenuPrice();

        System.out.print("\n" + "Select product: ");
        String choose = scanner.next();

        double price = 0;
        switch(choose) {
            case "1":
                price = showPriceCola(price);
                break;
            case "2":
                price = showPriceChips(price);
                break;
            case "3":
                price = showPriceCandy(price);
                break;
        }

        Scanner scanner1 = new Scanner(System.in);

        double totalPrice = vendingMachine.insertCoins(scanner1, price);

        Map<Coin, Integer> returnedCoins = vendingMachine.makeChange(totalPrice);

        vendingMachine.showReturnedCoins(returnedCoins);
    }

    private void showMenuPrice() {
        System.out.println("PRICE" + ": 0.00zl" + "\n" + "---------------------" + "\n");
        Map<Product, Double> priceMap = vendingMachine.createPriceProductMap();

        int count = 0;
        for (Map.Entry<Product, Double> entry : priceMap.entrySet()) {
            Product product = entry.getKey();
            double price = entry.getValue();

            System.out.println(++count + ". " + product.getName() + " : " + price + " zl");
        }
    }

    private double showPriceCandy(double price) {
        Product candy = Product.CANDY;
        price = vendingMachine.getValueHashMap(candy.getName());

        System.out.println("\nTOTAL PRICE: " + price);
        System.out.print("INSERT IN COINS: ");

        return price;
    }

    private double showPriceCola(double price) {
        Product cola = Product.COLA;
        price = vendingMachine.getValueHashMap(cola.getName());

        System.out.println("\nTOTAL PRICE: " + price);
        System.out.print("INSERT IN COINS: ");

        return price;
    }

    private double showPriceChips(double price) {
        Product chips = Product.CHIPS;
        price = vendingMachine.getValueHashMap(chips.getName());

        System.out.println("\nTOTAL PRICE: " + price);
        System.out.print("INSERT IN COINS: ");

        return price;
    }
}
