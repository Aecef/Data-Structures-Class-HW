package RequestInheritance;

public class Payment {
    private String nameF, nameS;
    private int randInt;
    Payment(String nameF, int randInt, String nameS){
       this.nameF = nameF;
       this.nameS = nameS;
       this.randInt = randInt;
    }

    public int getPaymentTotal() {
        return randInt;
    }

    public String getNameF() {
        return nameF;
    }

    public String getNameS() {
        return nameS;
    }
}
