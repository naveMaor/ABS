
package MainWindow;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import subcomponents.body.Admin.AdminMainBodyController;
import subcomponents.body.Customer.Information.CustomerInformationBodyController;
import subcomponents.header.MainHeaderController;

public class mainWindowController {

    @FXML private BorderPane root;

    @FXML private BorderPane mainHeader;
    @FXML private MainHeaderController mainHeaderController;

    @FXML private ScrollPane adminMainBody;
    @FXML private AdminMainBodyController adminMainBodyController;



    @FXML private ScrollPane CustomerInformationBody;
    @FXML private CustomerInformationBodyController CustomerInformationBodyController;





    @FXML public void initialize() {

        root.setBottom(null);
            if (mainHeaderController != null && adminMainBodyController != null) {
            mainHeaderController.setMainController(this);
            adminMainBodyController.setMainController(this);
        }
        if(CustomerInformationBodyController!=null){
            CustomerInformationBodyController.setMainController(null);
        }


        mainHeaderController.initializeComboBox();
    }


    //todo:do we really need it?!?
    public void setHeaderComponentController(MainHeaderController headerComponentController) {
        this.mainHeaderController = headerComponentController;
        headerComponentController.setMainController(this);
    }
    public void setBodyComponentController(AdminMainBodyController bodyComponentController) {
        this.adminMainBodyController = bodyComponentController;
        bodyComponentController.setMainController(this);
    }



    public void ChangeToCustomerCompenent(){
        root.setCenter(CustomerInformationBody);
    }



}

