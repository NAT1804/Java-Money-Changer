import java.util.Scanner;

public class MoneyChanger {
    // Ham doi tien
    public String changeMoney(int amountOfMoneyToChange, int[] arrOfDenominations, int length) {

        String result = "";

        // Kiem tra xem luong tien can doi voi cac menh gia voi so luong toi thieu la 1 co phu hop ?
        int totalAssumptions = 0;
        for (int i = 0; i < length; i++) {
            totalAssumptions += arrOfDenominations[i];
        }
        if (totalAssumptions > amountOfMoneyToChange) {
            result = "Không thể đổi được";
            return result;
        }

        int count = 0; // bien dem cac truong hop co the xay ra
        if (length == 1) {
            if (amountOfMoneyToChange % arrOfDenominations[0] != 0) {
                result = "Không thể đổi được";
            } else {
                count++;
                result = "Có thể đổi\n";
                result += "RESULT: " + amountOfMoneyToChange + " = " + amountOfMoneyToChange / arrOfDenominations[0] + "*" + arrOfDenominations[0];
            }
        }
        if (length == 2) {
            int limit1 = amountOfMoneyToChange / arrOfDenominations[0];
            int limit2 = amountOfMoneyToChange / arrOfDenominations[1];
            for (int i = 1; i <= limit1; i++) {
                for (int j = 1; j <= limit2; j++) {
                    int tmp = i * arrOfDenominations[0] + j * arrOfDenominations[1];
                    if (tmp == amountOfMoneyToChange) {
                        count++;
                        result = "Có thể đổi\n";
                        result += "RESULT: " + amountOfMoneyToChange + " = " + i + "*" + arrOfDenominations[0] + "+" + j + "*" + arrOfDenominations[1];
                    }
                }
            }
        }
        if (length == 3) {
            int limit1 = amountOfMoneyToChange / arrOfDenominations[0];
            int limit2 = amountOfMoneyToChange / arrOfDenominations[1];
            int limit3 = amountOfMoneyToChange / arrOfDenominations[2];
            for (int i = 1; i <= limit1; i++) {
                for (int j = 1; j <= limit2; j++) {
                    for (int k = 1; k <= limit3; k++) {
                        int tmp = i * arrOfDenominations[0] + j * arrOfDenominations[1] + k * arrOfDenominations[2];
                        if (tmp == amountOfMoneyToChange) {
                            count++;
                            result = "Có thể đổi\n";
                            result += "RESULT: " + amountOfMoneyToChange + " = " + i + "*" + arrOfDenominations[0] + "+" + j + "*" + arrOfDenominations[1] + "+" + k + "*" + arrOfDenominations[2];
                        }
                    }
                }
            }
        }
        if (count == 0) {
            result = "Không thể đổi được";
        }

        return result;
    }

    // Ham kiem tra string co la int
    public boolean isNumeric(String str) {
        // null or empty
        if (str == null || str.length() == 0) {
            return false;
        }

        return str.chars().allMatch(Character::isDigit);
    }

    // Ham may xu ly doi tien
    public String machineMoneyChange() {
        Scanner sc = new Scanner(System.in);

        System.out.println("--Denominations-----Selection--");
        System.out.println("-----50.000------|--------1----");
        System.out.println("----100.000------|--------2----");
        System.out.println("----200.000------|--------3----");
        System.out.println("----500.000------|--------4----");
        int amountOfMoneyToChange;
        int[] arrMoney = new int[]{0, 50000, 100000, 200000, 500000};
        while (true) {
            System.out.print("Select amount of money to change : ");
            String tmp = sc.nextLine();
            if (!isNumeric(tmp)) System.out.println("Invalid selection. Please choose again!");
            else {
                int temp = Integer.parseInt(tmp);
                if (temp < 1 || temp > 4) {
                    System.out.println("Invalid selection. Please choose again!");
                } else {
                    amountOfMoneyToChange = arrMoney[temp];
                    break;
                }
            }
        }

        int[] arr = new int[]{0, 1000, 2000, 5000, 10000, 20000, 50000};
        int[] arrSelected = new int[3];
        int count = 0;

        // Bảng mệnh giá
        System.out.println("-------------------------------");
        System.out.println("--Denominations-----Selection--");
        System.out.println("------1.000------|--------1----");
        System.out.println("------2.000------|--------2----");
        System.out.println("------5.000------|--------3----");
        System.out.println("-----10.000------|--------4----");
        System.out.println("-----20.000------|--------5----");
        System.out.println("-----50.000------|--------6----");
        System.out.println("-------------------------------");

        while (true) {

            System.out.print("Choose a denomination you want to exchange (Maximum is 3) (Enter 'x' to stop selecting): ");
            String tmp = sc.nextLine();

            if (tmp.equals("x") || tmp.equals("X")) break;

            if (!isNumeric(tmp)) {
                System.out.println("Invalid selection. Enter 'x' to stop selecting.");
            } else {
                int temp = Integer.parseInt(tmp);
                if (temp < 1 || temp > 6) {
                    System.out.println("Invalid selection. Enter 'x' to stop selecting.");
                } else {
                    if (arr[temp] == 0)
                        System.out.println("Selected earlier. Enter 'x' to stop selecting.");
                    else {
                        arrSelected[count] = arr[temp];
                        arr[temp] = 0;
                        count++;
                    }
                }
            }
            if (count == 3) break; //toi da 3 menh gia

            // Cap nhat bang menh gia
            System.out.println("-------------------------------");
            System.out.println("--Denominations-----Selection--");
            if (arr[1] != 0)
                System.out.println("------1.000------|--------1----");
            if (arr[2] != 0)
                System.out.println("------2.000------|--------2----");
            if (arr[3] != 0)
                System.out.println("------5.000------|--------3----");
            if (arr[4] != 0)
                System.out.println("-----10.000------|--------4----");
            if (arr[5] != 0)
                System.out.println("-----20.000------|--------5----");
            if (arr[6] != 0)
                System.out.println("-----50.000------|--------6----");
            System.out.println("-------------------------------");
        }


        return changeMoney(amountOfMoneyToChange, arrSelected, count);
    }

    public static void main(String[] args) {

        MoneyChanger moneyChanger = new MoneyChanger();
        Scanner scanner = new Scanner(System.in);
        String conti;
        while (true) {
            System.out.println(moneyChanger.machineMoneyChange());

            System.out.println("Do you want to continue?(y/n)");
            conti = scanner.nextLine();
            while (!conti.equals("y")) {
                if (conti.equals("n")) break;
                System.out.println("Invalid input.");
                conti = scanner.nextLine();
            }
            if (conti.equals("n")) {
                System.out.println("Goodbye! See you again!");
                break;
            }
        }

    }

}
