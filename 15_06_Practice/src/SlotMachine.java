import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;

public class SlotMachine extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Slot Machine");
        Border border =new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT));

        // slot label を作成
        ArrayList<MyLabel> label_array = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            label_array.add(new MyLabel());
        }

        for (MyLabel la:label_array){
            la.setBorder(border);
        }

        try {
            // 1~9を表示するHBoxを作成
            HBox numberBox = new HBox(20d);
            numberBox.setPadding(new Insets(10, 10, 10, 10));
            numberBox.setAlignment(Pos.CENTER);

            // HBoxにlabelを配置
            numberBox.getChildren().addAll(label_array);

            // Start,Stopを設定するボタンを作成
            Button startButton = new Button("Start");
            Button stopButton = new Button("Stop");

            // slot number
            String[] number_array = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

            // Startを設定するActionを設定
            Timeline timer = new Timeline();
            startButton.setOnAction(event -> {
                timer.getKeyFrames().add(new KeyFrame(Duration.millis(100), (e -> {
                    for (MyLabel la : label_array) {
                        Random rand = new Random();
                        int randomNumber = rand.nextInt(number_array.length);
                        la.setText(number_array[randomNumber]);
                    }
                })));
                timer.setCycleCount(Timeline.INDEFINITE);
                timer.play();
            });

            // Stopを設定するActionを設定
            stopButton.setOnAction(event -> {
                timer.stop();
                for (MyLabel la : label_array) {
                    la.setNumber(la.toString());
                }

//                for(MyLabel la:label_array){
//                    la.setText("7");
//                    la.setNumber("7");
//                }
                String la0 = label_array.get(0).getNumber();
                if (la0 == label_array.get(1).getNumber() && la0 == label_array.get(2).getNumber()) {
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
            BorderPane.setAlignment(borderPane,Pos.CENTER);
            borderPane.setTop(numberBox);
            borderPane.setBottom(setBox);

            Scene scene = new Scene(borderPane, 400, 120);
            stage.setScene(scene);
            stage.show();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } finally {
            Logger logger = Logger.getLogger("Finish");
        }
    }
}
