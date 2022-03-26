package nave;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int ID;
    private double currBalance;
    private List<Tnua> tnuaList = new ArrayList<>();
    //TODO:: CHANGE CURRBALNCE TO DOUBLE



    //getters and setters:
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public double getCurrBalance() {
        return currBalance;
    }
    public void setCurrBalance(double currBalance) {
        this.currBalance = currBalance;
    }
    public List<Tnua> getTnuaList() {
        return tnuaList;
    }
/*    public void setTnuaList(List<Tnua> argsList) {
        this.tnuaList = argsList;
    }*/


}
