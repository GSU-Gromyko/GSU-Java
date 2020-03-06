package rocks;

public class PreciousStone extends Stone {
    private double paramS1;
    private double paramS2;

    public PreciousStone(double weight, double transparency, double price, double paramS1, double paramS2) {
        super(weight, transparency, price);
        this.paramS1 = paramS1;
        this.paramS2 = paramS2;
    }

    public PreciousStone() {
        super(1, 0.25, 0);
        this.paramS1 = 0.2;
        this.paramS2 = 0.3;
    }

    public PreciousStone(double weight, double price, double paramS1) {
        super(weight, price);
        this.setTransparency(0.25);
        this.paramS1 = paramS1;
        this.paramS2 = 0.3;
    }

    public double getParamS1() {
        return paramS1;
    }

    public void setParamS1(double paramS1) {
        this.paramS1 = paramS1;
    }

    public double getParamS2() {
        return paramS2;
    }

    public void setParamS2(double paramS2) {
        this.paramS2 = paramS2;
    }

    public void showInfo(){
        System.out.println("Weight: "+getWeight()+" Transparency: "+getTransparency()+" Price: "+getPrice()+ " S1: "
                +paramS1+" S2: "+paramS2);
    }
}
