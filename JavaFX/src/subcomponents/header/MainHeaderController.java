package subcomponents.header;

import MainWindow.mainWindowController;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainHeaderController {

    private mainWindowController mainController;

    @FXML
    private Label NameCurrentYaz;

    @FXML
    private Label NameFilePath;

    @FXML
    private ComboBox<String> ViewByComboBox;

    @FXML
    void ViewByComboBoxListener(ActionEvent event) {
        String selectedBomboBox = ViewByComboBox.getSelectionModel().getSelectedItem().toString();
        if (selectedBomboBox.equals("Admin")){
            mainController.ChangeToAdminCompenent();

        }
        if (selectedBomboBox.equals("Customer")){
            mainController.ChangeToCustomerCompenent();

        }
    }

    @FXML
    void openFileButtonListener(ActionEvent event) {
        mainController.openFileButtonAction();
    }

    public void setMainController(mainWindowController mainController) {
        this.mainController = mainController;
    }


    public void initializeComboBox() {
        ViewByComboBox.setItems((FXCollections.observableArrayList("Admin","Customer")));
    }

    public void bindProperties(SimpleBooleanProperty isFileSelected, SimpleStringProperty selectedFileProperty, SimpleIntegerProperty currentYazProperty){
        NameFilePath.textProperty().bind(selectedFileProperty);
        NameCurrentYaz.textProperty().bind(Bindings.concat("Current Yaz: ", currentYazProperty));
        //todo add isFileSelected bolean!!
    }




}

