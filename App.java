import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        Spiel spiel = new Spiel();
        View view = new View(spiel);

        Scene scene = new Scene(view);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setTitle("Schiffe versenken");
        stage.setScene(scene);

        stage.show();
    }

}
