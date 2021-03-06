
package MainWindow;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;

public class mainWindowMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // load main fxml
        Parent load = FXMLLoader.load(getClass().getResource("mainWindowFXML.fxml"));
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "mainWindowFXML.fxml"
                )
        );

        ScrollPane root = loader.load();
        mainWindowController controller =loader.getController();
        controller.setPrimaryStage(primaryStage);

        //todo: connect engine instance to controller
        //todo: create Engine instance

        primaryStage.setTitle("ABS System");

        Scene scene = new Scene(load, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(mainWindowMain.class);
    }}

