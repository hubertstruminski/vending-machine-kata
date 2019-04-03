package Enums;

public enum Coin {

    ONE_HUNDRED("100"),
    FIFTY("50"),
    TWENTY("20"),
    TEEN("10"),
    FIVE("5"),
    TWO("2"),
    ONE("1"),
    HALF_ONE_FIFTY("0.50"),
    HALF_ONE_TWENTY("0.20"),
    HALF_ONE_TEEN("0.10"),
    HALF_ONE_FIVE("0.05"),
    HALF_ONE_TWO("0.02"),
    HALF_ONE_ONE("0.01");

    private String name;

    Coin(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
