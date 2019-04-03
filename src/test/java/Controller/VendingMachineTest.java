package Controller;

import Enums.Coin;
import Enums.Product;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineTest {

    private VendingMachine vendingMachine;

    @BeforeEach
    void setUp() {
        vendingMachine = new VendingMachine();
    }

    @Test
    void testProductsListContainsCorrectNumberOfElements() {
        List<Product> actual = vendingMachine.createProductsList();

        assertEquals(3, actual.size());
    }

    @Test
    void testCoinsListContainsCorrectNumberOfElements() {
        List<Coin> actual = vendingMachine.createCoinsList();

        assertEquals(13, actual.size());
    }

    @Test
    void testPriceProductMapContainsCorrectNumberOfElements() {
        Map<Product, Double> actual = vendingMachine.createPriceProductMap();

        assertEquals(3, actual.size());
    }

    @Test
    void testMakeChangeReturnsZeroElementsWhenInsertedZeroCoins() {
        Map<Coin, Integer> actual = vendingMachine.makeChange(0.00);

        assertEquals(0, actual.size());
        assertNotNull(actual);
    }

    @Test
    void testIsDoubleReturnTrueIfGiveCorrectString() {
        assertTrue(vendingMachine.isDouble("3.40"));
    }

    @Test
    void testIsDoubleReturnFalseIfGiveIncorrectString() {
        assertFalse(vendingMachine.isDouble("xxx"));
    }
}