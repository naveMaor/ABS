package subcomponents.header;

import MainWindow.mainWindowController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

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

    }

    public void setMainController(mainWindowController mainController) {
        this.mainController = mainController;
    }


    public void initializeComboBox() {
        ViewByComboBox.setItems((FXCollections.observableArrayList("Admin","Customer")));
    }




}

