package customes;

public class Lenders {

    private String fullName;
    private int deposit;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getDeposit() {
        return deposit;
    }

    public Lenders(String fullName, int deposit) {
        this.fullName = fullName;
        this.deposit = deposit;
    }

    public void setDeposit(int deposit) {
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

