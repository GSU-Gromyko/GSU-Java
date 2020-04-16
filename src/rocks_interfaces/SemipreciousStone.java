package rocks_interfaces;

public class SemipreciousStone extends Stone implements Info {
    private double paramSP1;
    private double paramSP2;

    public SemipreciousStone(double weight, double transparency, double price, double paramSP1, double paramSP2) {
        super(weight, transparency, price);
        this.paramSP1 = paramSP1;
        this.paramSP2 = paramSP2;
    }

    public SemipreciousStone() {
        super(1, 0.75, 0);
        this.paramSP1 = 0.7;
        this.paramSP2 = 0.8;
    }

    public SemipreciousStone(double weight, double price, double paramSP1) {
        super(weight, price);
        this.setTransparency(0.75);
        this.paramSP1 = paramSP1;
        this.paramSP2 = 0.8;
    }

    public void showInfo(){
        System.out.println("Weight: "+getWeight()+" Transparency: "+getTransparency()+" Price: "+getPrice()+ " SP1: "
                +paramSP1+" SP2: "+paramSP2);
    }
}
