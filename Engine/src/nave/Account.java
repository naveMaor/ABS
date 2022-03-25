package nave;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCurrBalance() {
        return currBalance;
    }

    public void setCurrBalance(int currBalance) {
        this.currBalance = currBalance;
    }

    public List<String> getArgsList() {
        return argsList;
    }

    public void setArgsList(List<String> argsList) {
        this.argsList = argsList;
    }

    private int currBalance;
    private List<String> argsList = new ArrayList<>();
}
