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
import javafx.scene.media.AudioClip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Logger;

public class SlotMachine extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Slot Machine");
        Border border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT));

        // slot label を作成
//        ArrayList<MyLabel> label_array = new ArrayList<>();
//        for (int i = 0; i < 3; i++) {
//            label_array.add(new MyLabel());
//        }

        ArrayList<MyLabel> label_array = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            label_array.add(new MyLabel());
        }

        for (MyLabel la : label_array) {
            la.setBorder(border);
            la.setAlignment(Pos.CENTER);
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
//            Button stopButton = new Button("Stop");

            // slot number
            String[] number_array = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

            // 各slotが停止しているかのフラグ0:stop,1:stat
            int[] SLOT_STOP_FLAG = new int[5];
            for (int i = 0; i < SLOT_STOP_FLAG.length; i++) {
                SLOT_STOP_FLAG[i] = 0;
            }

            // Startを設定するActionを設定
            Timeline[] timer = new Timeline[5];
            for (int i = 0; i < timer.length; i++) {
                timer[i] = new Timeline();
            }
            startButton.setOnAction(event -> {
                for (int i = 0; i < timer.length; i++) {
                    int[] j = {i};
                    SLOT_STOP_FLAG[i] = 1;
                    timer[i].getKeyFrames().add(new KeyFrame(Duration.millis(100), (e -> {
                        Random rand = new Random();
                        int randomNumber = rand.nextInt(number_array.length);
                        label_array.get(j[0]).setText(number_array[randomNumber]);
                    })));
                    timer[i].setCycleCount(Timeline.INDEFINITE);
                    timer[i].play();
                }
            });


            // Stopを設定するActionを設定
            label_array.get(0).setOnMouseClicked(event -> {
                timer[0].stop();
                SLOT_STOP_FLAG[0] = 0;
                label_array.get(0).setNumber(label_array.get(0).toString());

//                label_array.get(0).setNumber("7");
//                label_array.get(0).setText("7");

                String[] la = new String[5];
                for (int i = 0; i < label_array.size(); i++) {
                    la[i] = label_array.get(i).getNumber();
                }
                if (!Arrays.asList(SLOT_STOP_FLAG).contains(1) && (la[0] == la[1] && la[0] == la[2] && la[0] == la[3] && la[0] == la[4])) {
                    Stage newStage = new Stage();
                    newStage.initModality(Modality.APPLICATION_MODAL);
                    newStage.initOwner(stage);
                    HBox hbox = new HBox();
                    Label label = new Label("Congratulations!");
                    hbox.getChildren().add(label);
                    newStage.setScene(new Scene(hbox));
                    newStage.show();
                    AudioClip sound = new AudioClip("http://www.hmix.net/music/n/n12.mp3");
                    sound.play();
                }
            });

            label_array.get(1).setOnMouseClicked(event -> {
                timer[1].stop();
                SLOT_STOP_FLAG[1] = 0;
                label_array.get(1).setNumber(label_array.get(1).toString());

//                label_array.get(1).setNumber("7");
//                label_array.get(1).setText("7");

                String[] la = new String[5];
                for (int i = 0; i < label_array.size(); i++) {
                    la[i] = label_array.get(i).getNumber();
                }
                if (!Arrays.asList(SLOT_STOP_FLAG).contains(1) && (la[0] == la[1] && la[0] == la[2] && la[0] == la[3] && la[0] == la[4])) {
                    Stage newStage = new Stage();
                    newStage.initModality(Modality.APPLICATION_MODAL);
                    newStage.initOwner(stage);
                    HBox hbox = new HBox();
                    Label label = new Label("Congratulations!");
                    hbox.getChildren().add(label);
                    newStage.setScene(new Scene(hbox));
                    newStage.show();
                    AudioClip sound = new AudioClip("http://www.hmix.net/music/n/n12.mp3");
                    sound.play();
                }
            });

            label_array.get(2).setOnMouseClicked(event -> {
                timer[2].stop();
                SLOT_STOP_FLAG[2] = 0;
                label_array.get(2).setNumber(label_array.get(2).toString());

//                label_array.get(2).setNumber("7");
//                label_array.get(2).setText("7");

                String[] la = new String[5];
                for (int i = 0; i < label_array.size(); i++) {
                    la[i] = label_array.get(i).getNumber();
                }
                if (!Arrays.asList(SLOT_STOP_FLAG).contains(1) && (la[0] == la[1] && la[0] == la[2] && la[0] == la[3] && la[0] == la[4])) {
                    Stage newStage = new Stage();
                    newStage.initModality(Modality.APPLICATION_MODAL);
                    newStage.initOwner(stage);
                    HBox hbox = new HBox();
                    Label label = new Label("Congratulations!");
                    hbox.getChildren().add(label);
                    newStage.setScene(new Scene(hbox));
                    newStage.show();
                    AudioClip sound = new AudioClip("http://www.hmix.net/music/n/n12.mp3");
                    sound.play();
                }
            });

            label_array.get(3).setOnMouseClicked(event -> {
                timer[3].stop();
                SLOT_STOP_FLAG[3] = 0;
                label_array.get(3).setNumber(label_array.get(3).toString());

//                label_array.get(3).setNumber("7");
//                label_array.get(3).setText("7");

                String[] la = new String[5];
                for (int i = 0; i < label_array.size(); i++) {
                    la[i] = label_array.get(i).getNumber();
                }
                if (!Arrays.asList(SLOT_STOP_FLAG).contains(1) && (la[0] == la[1] && la[0] == la[2] && la[0] == la[3] && la[0] == la[4])) {
                    Stage newStage = new Stage();
                    newStage.initModality(Modality.APPLICATION_MODAL);
                    newStage.initOwner(stage);
                    HBox hbox = new HBox();
                    Label label = new Label("Congratulations!");
                    hbox.getChildren().add(label);
                    newStage.setScene(new Scene(hbox));
                    newStage.show();
                    AudioClip sound = new AudioClip("http://www.hmix.net/music/n/n12.mp3");
                    sound.play();
                }
            });

            label_array.get(4).setOnMouseClicked(event -> {
                timer[4].stop();
                SLOT_STOP_FLAG[4] = 0;
                label_array.get(4).setNumber(label_array.get(4).toString());

//                label_array.get(4).setNumber("7");
//                label_array.get(4).setText("7");

                String[] la = new String[5];
                for (int i = 0; i < label_array.size(); i++) {
                    la[i] = label_array.get(i).getNumber();
                }

                if (!(Arrays.asList(SLOT_STOP_FLAG).contains(1)) && (la[0] == la[1] && la[0] == la[2] && la[0] == la[3] && la[0] == la[4])) {
                    Stage newStage = new Stage();
                    newStage.initModality(Modality.APPLICATION_MODAL);
                    newStage.initOwner(stage);
                    HBox hbox = new HBox();
                    Label label = new Label("Congratulations!");
                    hbox.getChildren().add(label);
                    newStage.setScene(new Scene(hbox));
                    newStage.show();
                    AudioClip sound = new AudioClip("http://www.hmix.net/music/n/n12.mp3");
                    sound.play();
                }
            });

//            stopButton.setOnAction(event -> {
//                timer.stop();
//                for (MyLabel la : label_array) {
//                    la.setNumber(la.toString());
//                }
//
//                String la0 = label_array.get(0).getNumber();
//                if (la0 == label_array.get(1).getNumber() && la0 == label_array.get(2).getNumber()) {
//                    Stage newStage = new Stage();
//                    newStage.initModality(Modality.APPLICATION_MODAL);
//                    newStage.initOwner(stage);
//                    HBox hbox = new HBox();
//                    Label label = new Label("Congratulations!");
//                    hbox.getChildren().add(label);
//                    newStage.setScene(new Scene(hbox));
//                    newStage.show();
//                }
//            });

            // ボタンをまとめるHBoxを作成
            HBox setBox = new HBox(20d);
            setBox.setPadding(new Insets(10, 10, 10, 10));
            setBox.setAlignment(Pos.CENTER);
            setBox.getChildren().add(startButton);
//            setBox.getChildren().add(stopButton);

            BorderPane borderPane = new BorderPane();
            borderPane.setPadding(new Insets(10, 10, 10, 10));
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
