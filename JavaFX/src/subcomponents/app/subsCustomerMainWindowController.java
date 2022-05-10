package subcomponents.app;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class subsCustomerMainWindowController {

    @FXML private BorderPane subsCustomerMainWindow;

    @FXML private AnchorPane CustomerHeader;
    @FXML private subcomponents.header.Customer.CustomerHeaderController CustomerHeaderController;

    @FXML private ScrollPane CustomerInformationBody;
    @FXML private subcomponents.body.Customer.Information.CustomerInformationBodyController CustomerInformationBodyController;

    @FXML private ScrollPane CustomerIpaymentBody;
    @FXML private subcomponents.body.Customer.Payment.CustomerIpaymentBodyController CustomerIpaymentBodyController;

    @FXML public void initialize() {

        subsCustomerMainWindow.setBottom(null);
        subsCustomerMainWindow.setCenter(null);
        //root.setBottom(null);
        if (CustomerHeaderController != null && CustomerInformationBodyController != null) {
            CustomerHeaderController.setMainController(this);
            CustomerInformationBodyController.setMainController(this);
        }
        if(CustomerIpaymentBodyController!=null){
            CustomerIpaymentBodyController.setCustomerMainWindowController(this);
        }


    }
}
