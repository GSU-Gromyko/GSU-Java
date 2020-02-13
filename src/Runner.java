import by.gsu.pms.Employer;

public class Runner {
    public static void main(String[] args) {

        // 1
        Employer[] slaves = new Employer[7];

        slaves[0] = new Employer("Name1", 10, 4);
        slaves[1] = new Employer("Name2", 24, 9);
        slaves[3] = new Employer("Name4", 50, 7);
        slaves[4] = new Employer("Name5", 42, 8);
        slaves[5] = new Employer("Name4", 70, 3);
        slaves[6] = new Employer();

        // 2
        for (Employer employer : slaves) {
            if (employer != null) {
                employer.show();
            }
        }

        // 3
        slaves[slaves.length-1].set_transport_cost(53);

        // 4
        for (int worker_id = 0; worker_id < slaves.length; worker_id++) {
            int sum_of_durations = 0;
            if (slaves[worker_id] != null){
                sum_of_durations = slaves[worker_id].get_number_of_days();
            } else {
                continue;
            }
            for (int worker_2_id = 0; worker_2_id < slaves.length; worker_2_id++) {
                if (worker_id != worker_2_id && slaves[worker_2_id] != null
                        && slaves[worker_id].get_account().equals(slaves[worker_2_id].get_account())){

                    sum_of_durations += slaves[worker_2_id].get_number_of_days();
                }
            }
            System.out.println("Работник "+slaves[worker_id].get_account()+" пробыл в коммандировках "+sum_of_durations
                    + "дня(дней)");
        }

        // 5
        for (Employer slave : slaves) {
            if (slave != null) {
                System.out.println(slave.to_string());
            }
        }

        // 6
        int total_expenses = 0;
        for (Employer slave : slaves) {
            if (slave != null) {
                total_expenses += slave.get_total();
            }
        }
        System.out.println("Сумма общих расходов: " + total_expenses);

        // 7
        int worker_number = 0;
        float worker_total = 0;
        for (int i = 0; i < slaves.length; i++) {
            if (slaves[i] != null) {
                float total = slaves[i].get_total();
                if (total > worker_total){
                    worker_number = i;
                    worker_total = total;
                }
            }
        }
        System.out.println("Самый большой составляет: " + worker_total + "р. И принадлежит " +
                slaves[worker_number].get_account());


    }
}
