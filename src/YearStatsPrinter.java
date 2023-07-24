import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

/*
При вызове этой функции программа должна выводить такие данные:
рассматриваемый год;
прибыль по каждому месяцу;
средний расход за все имеющиеся операции в году;
средний доход за все имеющиеся операции в году.

true = трата
false = доход
*/
public class YearStatsPrinter { // month,amount,is_expense
    public String year;
    public int profitYear;

    void averageIncome(List<SaverYear> saver) { // доход
        HashMap<Integer, Integer> asMemory = new HashMap<>();
        int monthName;
        int maxExp = 0;
        for (SaverYear saverYear : saver) {
            if (!saverYear.isExpense) {
                monthName = saverYear.month;
                asMemory.put(monthName, saverYear.amount);
            }
        }
        for (int num : asMemory.values()) {
            if (maxExp < num) {
                maxExp += num;

            }
        }
        System.out.println("Средний доход за все имеющиеся операции в 2021 году: " + (maxExp / 2));

    }

    void averageConsumption(List<SaverYear> saver) { // трата
        HashMap<Integer, Integer> asMemory = new HashMap<>();
        int monthName;
        int maxExp = 0;
        for (SaverYear saverYear : saver) {
            if (saverYear.isExpense) {
                monthName = saverYear.month;
                asMemory.put(monthName, saverYear.amount);
            }
        }
        for (int num : asMemory.values()) {
            if (maxExp < num) {
                maxExp += num;

            }
        }
        System.out.println("Средняя трата за все имеющиеся операции в 2021 году: " + (maxExp / 2));

    }

    void profitYear(List<SaverYear> saver) {
        List<Integer> month = new ArrayList<>();
        HashMap<Integer, Integer> asMemory = new HashMap<>(); // январь, февраль и март
        int monthName;
        for (SaverYear saverYear : saver) {
            if (!saverYear.isExpense) {
                monthName = saverYear.month;
                month.add(saverYear.month);
                asMemory.put(monthName, saverYear.amount);
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("За " + month.get(i) + " месяц, доход состовляет " + asMemory.get(month.get(i)));
        }
    }

}
