package nave;

public class Lenders {
    private String first_name;
    private String last_name;
    private int deposit;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    @Override
    public String toString() {
        return "Lenders{" +
                "first name :" + first_name + '\'' +
                ", last name :" + last_name + '\'' +
                ", deposit :" + deposit +
                '}';
    }
}
