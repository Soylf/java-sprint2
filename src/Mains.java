import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/*
 * 1 Считать все месячные отчёты — прочитать данные из файлов месячных отчётов, сохранить их в память программы.
 * 
 * 2 Считать годовой отчёт — прочитать данные из файла годового отчёта, сохранить их в память программы.
 * 
 * 3 Сверить отчёты — по сохранённым данным проверить, сходятся ли отчёты за месяцы и за год.
 * 
 * 4 Вывести информацию обо всех месячных отчётах — по сохранённым данным вывести в консоль имеющуюся информацию.
 * 
 * 5 Вывести информацию о годовом отчёте — по сохранённым данным вывести в консоль имеющуюся информацию.
 */

public class Mains {
    public static Map<Integer, Integer> monthlyIncome = new HashMap<>();
    public static Map<Integer, Integer> monthlyExpense = new HashMap<>();
    public static Map<Integer, Integer> yearlyIncome = new HashMap<>();
    public static Map<Integer, Integer> yearlyExpense = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MonthlyReport monthlyReport = new MonthlyReport();
        YearReport yearReport = new YearReport();
        MonthlyStatsPrinter monthlyStatsPrinter = new MonthlyStatsPrinter();
        YearStatsPrinter yearStatsPrinter = new YearStatsPrinter();

        while (true) {
            printMenu();
            int comm = scanner.nextInt();
            if (comm == 1) {

                monthlyReport.readAndSaveReports();

            } else if (comm == 2) {

                yearReport.readAndSaveReports();
            } else if (comm == 3) {
                if (!yearReport.yearReports.isEmpty() && !monthlyReport.monthlyReports.isEmpty()) {
                    monthReportToHashMapSaver(monthlyReport.monthlyReports.get(0));
                    monthReportToHashMapSaver(monthlyReport.monthlyReports.get(1));
                    monthReportToHashMapSaver(monthlyReport.monthlyReports.get(2));
                    yearReportToHashMapSaver(yearReport.yearReports.get(0));

                    if (compareReports()) {
                        System.out.println("Отчеты точны, можете отдыхать");
                    } else {
                        System.out.println("Отчеты не точные, переделать!");
                    }

                } else {
                    System.out.println("Пирожок, сначало надо 1 и 2 команду :3");
                }

            } else if (comm == 4) {
                if (!monthlyReport.monthlyReports.isEmpty()) {
                    System.out.println("Выберите месяц от 1 до - " + monthlyReport.monthlyReports.size());
                    int num = scanner.nextInt();
                    System.out.println("Вот что тебе нужно зайка:");
                    monthlyStatsPrinter.searchTopAndPrint(monthlyReport.monthlyReports.get(num - 1));
                    monthlyStatsPrinter.searchWorstAndPrint(monthlyReport.monthlyReports.get(num - 1));
                } else {
                    System.out.println("Пирожок, сначало надо 1 команду :3");
                }
            } else if (comm == 5) {
                if (!yearReport.yearReports.isEmpty()) {
                    yearStatsPrinter.averageConsumption(yearReport.yearReports.get(0));
                    yearStatsPrinter.averageIncome(yearReport.yearReports.get(0));
                } else {
                    System.out.println("Пирожок, сначало надо 2 команду :3");

                }
            } else {
                break;
            }
        }

    }

    public static void printMenu() {
        System.out.println();
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию обо всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println();
    }

    public static void monthReportToHashMapSaver(List<SaverMonthly> saver) { // сохраняет в хешмапу по ключам месяцы
        // и по значениям общую сумму доходов/расходов
        for (SaverMonthly save : saver) {
            if (!save.isExpense) {
                int monthNumber = 1;
                int sumOfIncome = 0;
                int profitOfIncome = save.quantity * save.unitPrice;
                sumOfIncome += profitOfIncome;
                monthlyIncome.put(monthNumber, monthlyIncome.getOrDefault(monthNumber, 0) + sumOfIncome);

            }
        }
        for (SaverMonthly save : saver) {
            if (save.isExpense) {
                int monthNumber = 1;
                int sumOfIncome = 0;
                int profitOfIncome = save.quantity * save.unitPrice;
                sumOfIncome += profitOfIncome;
                monthlyExpense.put(monthNumber, monthlyExpense.getOrDefault(monthNumber, 0) + sumOfIncome);

            }

        }
    }

    public static void yearReportToHashMapSaver(List<SaverYear> saver) { // сохраняет в хешмапу по ключам месяцы
        // и по значениям доход/расход
        for (SaverYear save : saver) {
            if (!save.isExpense) {
                yearlyIncome.put(save.month, yearlyIncome.getOrDefault(save.month, 0) + save.amount);
            }
        }
        for (SaverYear save : saver) {
            if (save.isExpense) {
                yearlyExpense.put(save.month, yearlyExpense.getOrDefault(save.month, 0) + save.amount);

            }
        }
    }

    public static boolean compareReports() { // сверяет отчёты за месяцы и за год
        int totalIncomeMonth = 0;
        int totalExpenseMonth = 0;// 454 000
        int totalIncomeYear = 0; //
        int totalExpenseYear = 0;
        for (int i = 1; i <= monthlyIncome.size(); i++) {
            totalIncomeMonth += monthlyIncome.getOrDefault(i, 0);
            totalExpenseMonth += monthlyExpense.getOrDefault(i, 0);
        }
        for (int i = 1; i <= yearlyIncome.size(); i++) {
            totalIncomeYear += yearlyIncome.getOrDefault(i, 0);
            totalExpenseYear += yearlyExpense.getOrDefault(i, 0);
        }
        return totalIncomeMonth == totalIncomeYear && totalExpenseMonth == totalExpenseYear;
    }

}
