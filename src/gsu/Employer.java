package gsu;

public class Employer{

    private static int DAILY_ALLOWANCE = 69;
    private String account;
    private int transport_cost;
    private int number_of_days;

    public Employer(String account, int transport_cost, int number_of_days) {
        this.account = account;
        this.transport_cost = transport_cost;
        this.number_of_days = number_of_days;
    }

    public Employer() {
        this.account = "Name";
        this.transport_cost = 0;
        this.number_of_days = 1;
    }

    public String get_account() {
        return account;
    }

    public void set_account(String account) {
        this.account = account;
    }

    public int get_transport_cost() {
        return transport_cost;
    }

    public void set_transport_cost(int transport_cost) {
        this.transport_cost = transport_cost;
    }

    public int get_number_of_days() {
        return number_of_days;
    }

    public void set_number_of_days(int number_of_days) {
        this.number_of_days = number_of_days;
    }

    public float get_total(){
        if (number_of_days==1){
            return transport_cost;
        } else {
            return DAILY_ALLOWANCE * number_of_days + transport_cost;
        }
    }

    public void show(){
        System.out.println(" - - - - - - - ");
        System.out.println("ставка = " + DAILY_ALLOWANCE);
        System.out.println("счет = " + account);
        System.out.println("транспорт = " + transport_cost);
        System.out.println("дней = " + number_of_days);
        System.out.println("итого = " + get_total());
    }

    public String to_string(){
        return DAILY_ALLOWANCE +";"+ account+";"+transport_cost+";"+number_of_days+";"+get_total();
    }
}

