package Controller;

import Enums.Coin;
import Enums.Product;

import java.util.*;

public class VendingMachine {

    public List<Coin> createCoinsList() {
        List<Coin> coinsList = new ArrayList<>();

        for (Coin coin : Coin.values()) {
            coinsList.add(coin);
        }
        return coinsList;
    }

    public List<Product> createProductsList() {
        List<Product> productsList = new ArrayList<>();

        for (Product product : Product.values()) {
            productsList.add(product);
        }
        return productsList;
    }

    public Map<Product, Double> createPriceProductMap() {
        Map<Product, Double> priceMap = new TreeMap<>();

        Product cola = Product.COLA;
        Product chips = Product.CHIPS;
        Product candy = Product.CANDY;

        priceMap.put(cola, 1.80);
        priceMap.put(chips, 3.40);
        priceMap.put(candy, 6.40);

        return priceMap;
    }

    public Map<Coin, Integer> makeChange(double totalPrice) {
        List<Coin> coinsList = createCoinsList();
        Map<Coin, Integer> result = new TreeMap<>();

        double sumPrice = 0.00;
        while (sumPrice != totalPrice) {
            for (Coin coin : coinsList) {
                double coinValue = Double.parseDouble(coin.getName());

                if (sumPrice == totalPrice) {
                    return result;
                }

                double differenceNumber = totalPrice - sumPrice;

                differenceNumber = differenceNumber * 100;
                differenceNumber = Math.round(differenceNumber);
                differenceNumber = differenceNumber / 100;

                if (coinValue > differenceNumber) {
                    continue;
                } else {
                    Iterator it = result.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        Coin coinMap = (Coin) entry.getKey();

                        if (coinMap.getName().equals(coinValue)) {
                            result.put(coin, result.get(coin) + 1);
                        } else if (it.hasNext() == false) {
                            result.put(coin, 1);
                        }
                    }
                    if (result.size() == 0) {
                        result.put(coin, 1);
                    }
                    sumPrice += coinValue;
                }
            }
        }
        return Collections.emptyMap();
    }


    public void showReturnedCoins(Map<Coin, Integer> returnedCoins) {
        for (Map.Entry<Coin, Integer> entry : returnedCoins.entrySet()) {
            Coin coin = entry.getKey();
            int amount = entry.getValue();

            System.out.println(amount + ": " + coin.getName() + " zl");
        }
    }

    public double insertCoins(Scanner scanner, double price) {
        double totalPrice = 0.00;
        double insertedCoins = 0.00;

        while (totalPrice < price) {
            System.out.print("INSERT IN COINS: ");

            String input = scanner.nextLine();
            if(!isDouble(input)) {
                System.out.println("ERROR - INVALID COIN!");
                continue;
            } else {
                insertedCoins = Double.parseDouble(input);
            }

            totalPrice += insertedCoins;
            System.out.println("Sum of inserted coins: " + totalPrice);
        }
        totalPrice = totalPrice - price;

        totalPrice = totalPrice * 100;
        totalPrice = Math.round(totalPrice);
        totalPrice = totalPrice / 100;

        return totalPrice;
    }

    public double getValueHashMap(String key) {
        Map<Product, Double> priceMap = createPriceProductMap();

        for (Map.Entry<Product, Double> entry : priceMap.entrySet()) {
            Product product = entry.getKey();

            if (product.getName().equals(key)) {
                return entry.getValue();
            }
        }
        return 0.00;
    }

    public boolean isDouble(String inputString) {
        try {
            Double.parseDouble(inputString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
