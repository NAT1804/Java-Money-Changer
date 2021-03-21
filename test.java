public String changeMoney(int amountOfMoneyToChange, int[] arrOfDenominations, int length) {

        String result = "";

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
                result = "Có thể đổi\n" + amountOfMoneyToChange + " = " + amountOfMoneyToChange / arrOfDenominations[0] + "*" + arrOfDenominations[0];
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
                        result = "Có thể đổi\n" + amountOfMoneyToChange + " = " + i + "*" + arrOfDenominations[0] + "+" + j + "*" + arrOfDenominations[1];
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
                            result = "Có thể đổi\n" + amountOfMoneyToChange + " = " + i + "*" + arrOfDenominations[0] + "+" + j + "*" + arrOfDenominations[1] + "+" + k + "*" + arrOfDenominations[2];
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