import java.util.ArrayList;

public class Working_months_years {
    String fileName;

    ArrayList<String> lines = fileReader.readFileContents(fileName);
    String[] lineContents = line.split(",");

    Working_months_years(String filename) {
        filename = fileName;
    }

    // Считать все месячные отчёты
    void monthlyData() {
        System.out.println(fileName);
    }

}