package subcomponents.body.Admin;

import MainWindow.mainWindowController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AdminMainBodyController {

    private mainWindowController mainController;


    @FXML
    void CustomersInformationButtonListener(ActionEvent event) {
        mainController.ChangeToCustomerCompenent();
    }

    @FXML
    void IncreaseYazButtonListener(ActionEvent event) {

    }

    @FXML
    void LoadFileButtonListener(ActionEvent event) {

    }

    @FXML
    void LoansButtonListener(ActionEvent event) {

    }

    public void setMainController(mainWindowController mainController) {
        this.mainController = mainController;
    }

}