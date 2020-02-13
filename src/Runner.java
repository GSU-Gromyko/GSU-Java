import by.gsu.pms.Employer;

public class Runner {
    public static void main(String[] args) {

        Employer[] slaves = new Employer[7];

        slaves[0] = new Employer("Name1", 10, 4);
        slaves[1] = new Employer("Name2", 24, 9);
        slaves[3] = new Employer("Name4", 50, 6);
        slaves[4] = new Employer("Name5", 42, 8);
        slaves[5] = new Employer("Name6", 70, 3);
        slaves[6] = new Employer();

        for (int i = 0; i < slaves.length; i++) {
            if (slaves[i] != null){
                slaves[i].show();
            }
        }

// Runner 1, 2

    }
}
