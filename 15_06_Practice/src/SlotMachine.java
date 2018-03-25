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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;

public class SlotMachine extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ArrayList<MyLabel> label_array = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            label_array.add(new MyLabel());
        }

        // 1~9を表示するHBoxを作成
        HBox numberBox = new HBox(20d);
        numberBox.setPadding(new Insets(10, 10, 10, 10));
        numberBox.setAlignment(Pos.CENTER);

        numberBox.getChildren().addAll(label_array);

        // Start,Stopを設定するボタンを作成
        Button startButton = new Button("Start");
        Button stopButton = new Button("Stop");

        // Startを設定するActionを設定
        int[] number_array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        Timeline timer = new Timeline();
        startButton.setOnAction(event -> {
            timer.getKeyFrames().add(new KeyFrame(Duration.millis(100), (e -> {
                for (int i = 0; i < 3; i++) {
                    Random rand = new Random();
                    int randomNumber = rand.nextInt(number_array.length);
                    label_array.get(i).setText(String.valueOf(number_array[randomNumber]));
                }
            })));
            timer.setCycleCount(Timeline.INDEFINITE);
            timer.play();
        });

        // Stopを設定するActionを設定
        stopButton.setOnAction(event -> {
            timer.stop();
            for(int i=0;i<label_array.size();i++){
                label_array.get(i).setNumber(Integer.parseInt(label_array.get(i).toString()));
//                label_array.get(i).setText(String.valueOf(7));
//                label_array.get(i).setNumber(7);
            }
            if (label_array.get(0).getNumber() == label_array.get(1).getNumber() && label_array.get(0).getNumber() == label_array.get(2).getNumber()) {
                Stage newStage = new Stage();
                newStage.initModality(Modality.APPLICATION_MODAL);
                newStage.initOwner(stage);
                HBox hbox = new HBox();
                Label label = new Label("Congratulations!");
                hbox.getChildren().add(label);
                newStage.setScene(new Scene(hbox));
                newStage.show();
            }
        });

        // ボタンをまとめるHBoxを作成
        HBox setBox = new HBox(20d);
        setBox.setPadding(new Insets(10, 10, 10, 10));
        setBox.setAlignment(Pos.CENTER);
        setBox.getChildren().add(startButton);
        setBox.getChildren().add(stopButton);

        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10, 10, 10, 10));
        borderPane.setTop(numberBox);
        borderPane.setBottom(setBox);

        Scene scene = new Scene(borderPane, 400, 120);
        stage.setScene(scene);
        stage.show();
    }
}
