import java.util.ArrayList;
import java.util.List;

public class YearReport {
    FileReader fileReader = new FileReader();
    // значения
    public int amount = 0;
    public boolean isExpense = true;

    // листы
    public List<List<SaverYear>> yearReports = new ArrayList<>();;

    public void yearLoader(String fileName, List<SaverYear> reports) {
        ArrayList<String> yearReports = fileReader.readFileContents(fileName);
        for (int i = 1; i < yearReports.size(); i++) {
            String[] partsOfContent = yearReports.get(i).split(","); // month,amount,is_expense
            int month = Integer.parseInt(partsOfContent[0]);
            int amounts = Integer.parseInt(partsOfContent[1]);
            boolean isExpenses = Boolean.parseBoolean(partsOfContent[2]);

            SaverYear saverYear = new SaverYear(month, amounts, isExpenses);
            reports.add(saverYear);

        }
    }

    public void readAndSaveReports() {
        if (yearReports.isEmpty()) {
            String fileName = "y.2021.csv";
            List<SaverYear> Year = new ArrayList<>();
            yearLoader(fileName, Year);
            yearReports.add(Year);
            System.out.println("Данные за 2021 год были считанны");
        } else {
            System.out.println("Годовые отчеты уже были считаны!");
        }
    }
}
