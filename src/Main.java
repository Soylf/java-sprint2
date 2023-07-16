
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileReader fileReader = new FileReader();
        Working_months_years working = new Working_months_years(fileName);
        ArrayList<String> lines = fileReader.readFileContents(fileName);
        String[] lineContents = lines.split(",");

        System.out.println("Впишите название месяце или года, в таком ввиде (m.202101.csv)/(y.2021.csv)");
        String fileName = scanner.next();

        while (true) {
            printMein();
            System.out.println("Выберите из перечня");
            int command = scanner.nextInt();
            if (command == 1) {

            } else if (command == 2) {

            } else if (command == 3) {

            } else if (command == 4) {

            } else if (command == 5) {

            } else if (command == 6) {// переделать на что-то типо формулы
                System.out.println("Сайонара, путник");
                break;
            } else {
                System.out.println("А, что. Такой команды нету");
            }
        }

    }

    static void printMein() {
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию обо всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("6 - Выход");
        System.out.println();
    }
}

// за январь, февраль и март 2021 года

/*
 * 1 Консольный интерфейс для управления программой.
 * 2 Считывание месячных и годового отчётов бухгалтерии из файлов и их перевод в
 * объекты приложения.
 * 3 Сверка данных по месячным и годовому отчётам.
 * 4 Вывод информации о месячных и годовом отчётах.
 */

/*
 * Сверка данных
 * 1 Проверить, что месячные и годовой отчёты были считаны из файлов. В случае
 * если этого не было сделано, нужно предложить сначала считать данные.
 * 2 Подсчитать суммы доходов и расходов по каждому из месяцев.
 * 3 Сверить полученные суммы с суммой доходов и расходов в отчёте по году.
 * 4 При обнаружении несоответствия программа должна вывести месяц, где оно
 * обнаружено.
 * 5 Если несоответствий не обнаружено, приложение должно вывести только
 * информацию об успешном завершении операции.
 */
