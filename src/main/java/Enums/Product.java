package Enums;

public enum Product {

    COLA("Cola"),
    CHIPS("Chips"),
    CANDY("Candy");

    private String name;

    Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
