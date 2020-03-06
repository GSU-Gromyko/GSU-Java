package rocks;

public class SemipreciousStone extends Stone {
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

    public double getParamSP1() {
        return paramSP1;
    }

    public void setParamSP1(double paramSP1) {
        this.paramSP1 = paramSP1;
    }

    public double getParamSP2() {
        return paramSP2;
    }

    public void setParamSP2(double paramSP2) {
        this.paramSP2 = paramSP2;
    }

    public void showInfo(){
        System.out.println("Weight: "+getWeight()+" Transparency: "+getTransparency()+" Price: "+getPrice()+ " SP1: "
                +paramSP1+" SP2: "+paramSP2);
    }
}
