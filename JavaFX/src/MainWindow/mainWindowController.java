
package MainWindow;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import subcomponents.body.Admin.AdminMainBodyController;
import subcomponents.header.MainHeaderController;

public class mainWindowController {

    @FXML private BorderPane mainHeader;

    @FXML private MainHeaderController mainHeaderController;

    @FXML private ScrollPane adminMainBody;

    @FXML private AdminMainBodyController adminMainBodyController;




    @FXML public void initialize() {
        if (mainHeaderController != null && adminMainBodyController != null) {
            mainHeaderController.setMainController(this);
            adminMainBodyController.setMainController(this);
        }

        mainHeaderController.initializeComboBox();
    }

    public void setHeaderComponentController(MainHeaderController headerComponentController) {
        this.mainHeaderController = headerComponentController;
        headerComponentController.setMainController(this);
    }

    public void setBodyComponentController(AdminMainBodyController bodyComponentController) {
        this.adminMainBodyController = bodyComponentController;
        bodyComponentController.setMainController(this);
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label NameCurrentYaz;

    @FXML
    private Label NameFilePath;

    @FXML
    void CustomersInformationButtonListener(ActionEvent event) {

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

    @FXML
    void ViewByComboBoxListener(ActionEvent event) {

    }

/*    @FXML
    void initialize() {
        assert NameCurrentYaz != null : "fx:id=\"NameCurrentYaz\" was not injected: check your FXML file 'mainWindowFXML.fxml'.";
        assert NameFilePath != null : "fx:id=\"NameFilePath\" was not injected: check your FXML file 'mainWindowFXML.fxml'.";

    }*/

}

