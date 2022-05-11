
package MainWindow;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import data.File.XmlFile;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import subcomponents.app.subsCustomerMainWindowController;
import subcomponents.body.Admin.AdminMainBodyController;
import subcomponents.body.Customer.Information.CustomerInformationBodyController;
import subcomponents.header.MainHeaderController;
import utills.BackgroundFunc;

public class mainWindowController {



    @FXML private BorderPane root;
    @FXML private BorderPane mainHeader;
    @FXML private MainHeaderController mainHeaderController;
    @FXML private ScrollPane adminMainBody;
    @FXML private AdminMainBodyController adminMainBodyController;
    @FXML private BorderPane subsCustomerMainWindow;
    @FXML private subsCustomerMainWindowController subsCustomerMainWindowController;

    private Stage primaryStage;
    private SimpleBooleanProperty isFileSelected;
    private SimpleStringProperty selectedFileProperty;
    private SimpleIntegerProperty currentYazProperty;

    public mainWindowController() {
        isFileSelected = new SimpleBooleanProperty(false);
        selectedFileProperty = new SimpleStringProperty();
        currentYazProperty = new SimpleIntegerProperty(0);
    }

    @FXML public void initialize() {
        root.setBottom(null);
        if (mainHeaderController != null && adminMainBodyController != null) {
            mainHeaderController.setMainController(this);
            adminMainBodyController.setMainController(this);
        }
        if(subsCustomerMainWindowController!=null){
            subsCustomerMainWindowController.setMainController(this);
        }
        mainHeaderController.initializeComboBox();
        mainHeaderController.bindProperties(isFileSelected,selectedFileProperty,currentYazProperty);
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
        root.setCenter(subsCustomerMainWindow);
    }

    public void ChangeToAdminCompenent(){
        root.setCenter(adminMainBody);
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void openFileButtonAction() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select words file");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("xml files", "*.xml"));
        File selectedFile = fileChooser.showOpenDialog(primaryStage);
        if (selectedFile == null) {
            return;
        }
        try {
            XmlFile.createInputObjectFromFile(selectedFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        BackgroundFunc.buildDataFromDescriptor();
        String absolutePath = selectedFile.getAbsolutePath();
        selectedFileProperty.set(absolutePath);
        isFileSelected.set(true);
    }

}

