import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class App2 extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // make Label
        Label your_name = new Label("Your Name");
        Label my_name = new Label("Takayama");

        // make VBox
        VBox vBox = new VBox(20d);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().add(your_name);
        vBox.getChildren().add(my_name);


        // make HBox
        Button change_button = new Button("Change");
        change_button.setPrefSize(100, 50);
        Button roll_button = new Button("Roll");
        roll_button.setPrefSize(100, 50);
        Button check_button = new Button("Check");
        check_button.setPrefSize(100, 50);

        HBox hBox = new HBox(20d);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().add(change_button);
        hBox.getChildren().add(roll_button);
        hBox.getChildren().add(check_button);

        // event
        change_button.setOnAction(event -> {
            my_name.setText("kimura");
        });

        String[] name_array = {"morita", "Takayama", "Kimura", "Mogi"};
        roll_button.setOnAction(event -> {
            Timeline timer = new Timeline(new KeyFrame(Duration.millis(100), e-> {
                Random rand = new Random();
                int randomNumber = rand.nextInt(name_array.length);
                my_name.setText(name_array[randomNumber]);
            }));
            timer.setCycleCount(30);
            timer.play();
        });

        check_button.setOnAction(event -> {
            if (my_name.getText().equals("Mogi")) {
                Stage newStage = new Stage();

                newStage.initModality(Modality.APPLICATION_MODAL);

                newStage.initOwner(stage);

                HBox hbox = new HBox();
                Label label = new Label("Hellow!");
                hbox.getChildren().add(label);

                newStage.setScene(new Scene(hbox));

                newStage.show();
            }
        });

        // make BorderPane
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(30, 10, 10, 10));
        borderPane.setTop(vBox);
        borderPane.setCenter(hBox);

//        Scene scene = new Scene(hBox, 320, 240);
//        Scene scene = new Scene(vBox, 320, 240);
        Scene scene = new Scene(borderPane, 320, 240);
        stage.setScene(scene);

        stage.show();
    }
}
