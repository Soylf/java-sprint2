import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Считываем данные за месяц/несколько месяцев
public class MonthlyReport {
    FileReader fileReader = new FileReader();
    public String montNam;
    public List<List<SaverMonthly>> monthlyReports = new ArrayList<>();

    public void monthLoader(String fileName, String monthName, List<SaverMonthly> reports) {
        // принмает на вход файл и лист,
        // возвращает лист наполненный
        // экземпляярами класса SaverMonthly
        ArrayList<String> monthReports = fileReader.readFileContents(fileName);
        for (int i = 1; i < monthReports.size(); i++) {
            String[] partsOfContent = monthReports.get(i).split(","); // item_name,is_expense,quantity,unit_price
            String itemName = partsOfContent[0];
            boolean isExpense = Boolean.parseBoolean(partsOfContent[1]);
            int quantity = Integer.parseInt(partsOfContent[2]);
            int unitPrice = Integer.parseInt(partsOfContent[3]);
            // стоимость одной единицы товара
            SaverMonthly saverMonthly = new SaverMonthly(itemName, isExpense, quantity, unitPrice, monthName);
            reports.add(saverMonthly);
        }
    }

    public void readAndSaveReports() { // ложит месячнные отчеты в лист, содержащщий
                                       // листы с экземплярами класса SaverMonthly
        if (monthlyReports.isEmpty()) {
            String monthName;
            String fileName;
            for (int i = 1; i < 4; i++) {
                fileName = "m.20210" + i + ".csv";
                if (i == 1) {
                    monthName = "январь";

                    List<SaverMonthly> month = new ArrayList<>();
                    monthlyReports.add(month);
                    monthLoader(fileName, monthName, month);
                    System.out.println("За " + monthName + " считанно");
                } else if (i == 2) {
                    monthName = "февраль";

                    List<SaverMonthly> month = new ArrayList<>();
                    monthLoader(fileName, monthName, month);
                    monthlyReports.add(month);
                    System.out.println("За " + monthName + " считанно");
                } else {
                    monthName = "март";

                    List<SaverMonthly> month = new ArrayList<>();
                    monthLoader(fileName, monthName, month);
                    monthlyReports.add(month);
                    System.out.println("За " + monthName + " считанно");
                }
            }
        } else {
            System.out.println("Месячные отчеты уже были считаны!");
        }
    }
}