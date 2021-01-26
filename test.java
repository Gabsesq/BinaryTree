import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class test {
    public static void main(String [] args) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader("C:\\Users\\dell\\Downloads\\Game Leader Board\\players.csv"));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            for (int i=0;i<3;i++)
            {
                System.out.print(data[i]);
            }
            System.out.println();
        }
        csvReader.close();
    }
}
