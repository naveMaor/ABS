package customes;

public class Lenders {

    private String fullName;
    private double deposit;

    public String getFullName() {
        return fullName;
    }




    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getDeposit() {
        return deposit;
    }

    public Lenders(String fullName, double deposit) {
        this.fullName = fullName;
        this.deposit = deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    @Override
    public String toString() {
        return "Lenders{" +
                "fullName: " + fullName + '\'' +
                ", deposit: " + deposit +
                '}';
    }

}

