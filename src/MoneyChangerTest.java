import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MoneyChangerTest {

    MoneyChanger moneyChanger;

    @BeforeAll
    void beforeAllTest() {
        System.out.println("Start testing...");
    }

    @BeforeEach
    void init() {
        moneyChanger = new MoneyChanger();
    }

    @AfterEach
    void clean() {
        System.out.println("Cleaning up...");
    }

    @Test
    @DisplayName("Test if input is a number")
    void testIsNumeric() {

        assertAll(
                () -> assertEquals(false, moneyChanger.isNumeric("1a"), "Should return input is not a number"),
                () -> assertEquals(true, moneyChanger.isNumeric("15"), "Should return input is a number"),
                () -> assertEquals(false, moneyChanger.isNumeric("1-2"), "Should return input is a number")
        );

    }

    @Nested
    @DisplayName("Test the money conversion function with marginal value")
    class GroupTest1 {
        @Test
        @DisplayName("Test with 1 input")
        void testChangeMoneyOneInput() {
            String expected = "CAN'T BE REDEEMED.";
            int []arrMoney = new int[]{50000, 100000, 200000, 500000};
            assertAll(
                    () -> assertEquals(expected, moneyChanger.changeMoney(arrMoney[0], new int[]{}, 0), "Should return CAN'T BE REDEEMED."),
                    () -> assertEquals(expected, moneyChanger.changeMoney(arrMoney[1], new int[]{}, 0), "Should return CAN'T BE REDEEMED."),
                    () -> assertEquals(expected, moneyChanger.changeMoney(arrMoney[2], new int[]{}, 0), "Should return CAN'T BE REDEEMED."),
                    () -> assertEquals(expected, moneyChanger.changeMoney(arrMoney[3], new int[]{}, 0), "Should return CAN'T BE REDEEMED.")
            );
            ;
        }

        @Test
        @DisplayName("Test with 2 inputs")
        void testChangeMoneyTwoInputs() {
            int []arrMoney = new int[]{50000, 100000, 200000, 500000};
            int[] arrDenominations = new int[]{1000, 2000, 5000, 10000, 20000, 50000};
            String expectedTrue = "CAN BE REDEEMED.";
            String expectedFalse = "CAN'T BE REDEEMED.";

            assertAll(
                    // Giu nguyen normal input1
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[1],
                            new int[]{arrDenominations[2]}, 1)),
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[1],
                            new int[]{arrDenominations[0]}, 1)),
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[1],
                            new int[]{arrDenominations[1]}, 1)),
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[1],
                            new int[]{arrDenominations[4]}, 1)),
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[1],
                            new int[]{arrDenominations[5]}, 1)),
                    // Giu nguyen normal input2
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[0],
                            new int[]{arrDenominations[2]}, 1)),
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[2],
                            new int[]{arrDenominations[2]}, 1)),
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[3],
                            new int[]{arrDenominations[2]}, 1))
            );

        }

        @Test
        @DisplayName("Test with 3 inputs")
        void testChangeMoneyThreeInputs() {
            int []arrMoney = new int[]{50000, 100000, 200000, 500000};
            int[] arrDenominations = new int[]{1000, 2000, 5000, 10000, 20000, 50000};
            String expectedTrue = "CAN BE REDEEMED.";
            String expectedFalse = "CAN'T BE REDEEMED.";

            assertAll(
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[1],
                            new int[]{arrDenominations[2], arrDenominations[3]}, 2)),

                    // Giu nguyen normal input1, input2
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[1],
                            new int[]{arrDenominations[2], arrDenominations[0]}, 2)),
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[1],
                            new int[]{arrDenominations[2], arrDenominations[1]}, 2)),
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[1],
                            new int[]{arrDenominations[2], arrDenominations[4]}, 2)),
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[1],
                            new int[]{arrDenominations[2], arrDenominations[5]}, 2)),

                    //Giu nguyen normal input2, input3
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[0],
                            new int[]{arrDenominations[2], arrDenominations[3]}, 2)),
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[2],
                            new int[]{arrDenominations[2], arrDenominations[3]}, 2)),
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[3],
                            new int[]{arrDenominations[2], arrDenominations[3]}, 2)),

                    //Giu nguyen normal input1, input3
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[1],
                            new int[]{arrDenominations[0], arrDenominations[3]}, 2)),
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[1],
                            new int[]{arrDenominations[1], arrDenominations[3]}, 2)),
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[1],
                            new int[]{arrDenominations[4], arrDenominations[3]}, 2)),
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[1],
                            new int[]{arrDenominations[5], arrDenominations[3]}, 2))

            );
        }

        @Test
        @DisplayName("Test with 4 inputs")
        void testChangeMoneyFourInputs() {
            int []arrMoney = new int[]{50000, 100000, 200000, 500000};
            int[] arrDenominations = new int[]{1000, 2000, 5000, 10000, 20000, 50000};
            String expectedTrue = "CAN BE REDEEMED.";
            String expectedFalse = "CAN'T BE REDEEMED.";

            assertAll(
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[1],
                            new int[]{arrDenominations[2], arrDenominations[3], arrDenominations[4]}, 3)),

                    // Giu nguyen normal input1, input2, input3
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[1],
                            new int[]{arrDenominations[2], arrDenominations[3], arrDenominations[0]}, 3)),
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[1],
                            new int[]{arrDenominations[2], arrDenominations[3],arrDenominations[1]}, 3)),
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[1],
                            new int[]{arrDenominations[2], arrDenominations[3], arrDenominations[5]}, 3)),

                    // Giu nguyen normal input1, input2, input4
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[1],
                            new int[]{arrDenominations[2], arrDenominations[0], arrDenominations[4]}, 3)),
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[1],
                            new int[]{arrDenominations[2], arrDenominations[1],arrDenominations[4]}, 3)),
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[1],
                            new int[]{arrDenominations[2], arrDenominations[5], arrDenominations[4]}, 3)),

                    // Giu nguyen normal input1, input3, input4
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[1],
                            new int[]{arrDenominations[0], arrDenominations[3], arrDenominations[4]}, 3)),
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[1],
                            new int[]{arrDenominations[1], arrDenominations[3],arrDenominations[4]}, 3)),
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[1],
                            new int[]{arrDenominations[5], arrDenominations[3], arrDenominations[4]}, 3)),

                    // Giu nguyen normal input2, input3, input4
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[0],
                            new int[]{arrDenominations[2], arrDenominations[3], arrDenominations[4]}, 3)),
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[2],
                            new int[]{arrDenominations[2], arrDenominations[3],arrDenominations[4]}, 3)),
                    () -> assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[3],
                            new int[]{arrDenominations[2], arrDenominations[3], arrDenominations[4]}, 3))
            );
        }

    }

    @Nested
    @DisplayName("Test the money conversion function with equivalent class")
    class GroupTest2 {
        @Test
        @DisplayName("Test with 1 input")
        void testChangeMoneyOneInput() {
            int []arrMoney = new int[]{50000, 100000, 200000, 500000};
            int[] arrDenominations = new int[]{1000, 2000, 5000, 10000, 20000, 50000};
            String expectedTrue = "CAN BE REDEEMED.";
            String expectedFalse = "CAN'T BE REDEEMED.";

            assertEquals(expectedFalse, moneyChanger.changeMoney(arrMoney[1], new int[]{}, 0));
        }

        @Test
        @DisplayName("Test with 2 input")
        void testChangeMoneyTwoInput() {
            int []arrMoney = new int[]{50000, 100000, 200000, 500000};
            int[] arrDenominations = new int[]{1000, 2000, 5000, 10000, 20000, 50000};
            String expectedTrue = "CAN BE REDEEMED.";
            String expectedFalse = "CAN'T BE REDEEMED.";

            assertEquals(expectedTrue, moneyChanger.changeMoney(arrMoney[1], new int[]{arrDenominations[4]}, 1));
        }

        @Test
        @DisplayName("Test with 3 input")
        void testChangeMoneyThreeInput() {
            int []arrMoney = new int[]{50000, 100000, 200000, 500000};
            int[] arrDenominations = new int[]{1000, 2000, 5000, 10000, 20000, 50000};
            String expectedTrue = "CAN BE REDEEMED.";
            String expectedFalse = "CAN'T BE REDEEMED.";

            assertEquals(expectedFalse, moneyChanger.changeMoney(arrMoney[1], new int[]{arrDenominations[4],
                    arrDenominations[5]}, 2));
        }

        @Test
        @DisplayName("Test with 4 input")
        void testChangeMoneyFourInput() {
            int []arrMoney = new int[]{50000, 100000, 200000, 500000};
            int[] arrDenominations = new int[]{1000, 2000, 5000, 10000, 20000, 50000};
            String expectedTrue = "CAN BE REDEEMED.";
            String expectedFalse = "CAN'T BE REDEEMED.";

            assertEquals(expectedFalse, moneyChanger.changeMoney(arrMoney[0], new int[]{arrDenominations[3],
                    arrDenominations[4], arrDenominations[5]}, 3));
        }

    }

    @AfterAll
    void afterAllTest() {
        System.out.println("Test done");
    }

}