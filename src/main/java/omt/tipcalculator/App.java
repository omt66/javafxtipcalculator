package omt.tipcalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Parent parent = loadFXML("tipcalculator");
        // scene = new Scene(parent, 800, 600);
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Tip Calculator");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        String fullName = fxml + ".fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fullName));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}