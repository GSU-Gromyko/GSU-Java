import gsu.Employer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws FileNotFoundException {

        FileReader file = new FileReader("/home/vitya/IT/java/src/file.txt");
        Scanner scanner = new Scanner(file);

        double dailyRate = Double.parseDouble(scanner.nextLine().split("=")[1]);
        int[] indices = Arrays.stream(scanner.nextLine().split("=")[1].split(";")).mapToInt(Integer::parseInt).toArray();

        Employer[] employers = new Employer[indices.length];

        for (int i=0; i < indices.length; i++){
            String account = scanner.nextLine().split("=")[1];
            int transport = Integer.parseInt(scanner.nextLine().split("=")[1]);
            int days = Integer.parseInt(scanner.nextLine().split("=")[1]);

            employers[i] = new Employer(account, transport, days);
        }

        Arrays.sort(employers, Comparator.comparing(Employer::get_total).reversed());

        for(Employer employer: employers){
            employer.show();
        }



    }
}
