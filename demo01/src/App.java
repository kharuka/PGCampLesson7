import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // make Label
        Label your_name = new Label("Your Name");
        Label my_name = new Label("Takayama");

        // make BorderPane
        BorderPane borderPane = new BorderPane();

        borderPane.setPadding(new Insets(30, 10, 10, 10));

        BorderPane.setAlignment(your_name, Pos.CENTER);

        borderPane.setTop(your_name);
        borderPane.setCenter(my_name);

        Scene scene = new Scene(borderPane, 320, 240);
        stage.setScene(scene);

        stage.show();
    }
}
