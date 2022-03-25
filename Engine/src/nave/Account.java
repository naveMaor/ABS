package nave;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int ID;
    private int currBalance;
    private List<Tnua> tnuaList = new ArrayList<>();




    //getters and setters:
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
    public List<Tnua> getTnuaList() {
        return tnuaList;
    }
    public void setTnuaList(List<Tnua> argsList) {
        this.tnuaList = argsList;
    }


}
