import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class App3 extends Application {

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // make MyLabel
        ArrayList<MyLabel> label_array=new ArrayList<>();
        for(int i=0;i<5;i++){
            label_array.add(new MyLabel());
        }

//        for(MyLabel arr:label_array){
//            arr.setBatsu();
//        }

        // o,xを表示するHBoxを作成
        HBox maruBox=new HBox(20d);
        maruBox.setPadding(new Insets(10,10,10,10));
        maruBox.setAlignment(Pos.CENTER);

        HBox batsuBox=new HBox(20d);
        batsuBox.setPadding(new Insets(10,10,10,10));
        batsuBox.setAlignment(Pos.CENTER);

        maruBox.getChildren().addAll(label_array);

        // o,xを設定するボタンを作成
        Button maruButton=new Button("Set Maru");
        Button batsuButton=new Button("Set Batsu");

        // oを設定するActionを設定
        maruButton.setOnAction(event -> {
            for(int i=0;i<label_array.size();i++){
                label_array.get(i).setMaru();
            }
        });

        // xを設定するActionを設定
        batsuButton.setOnAction(event -> {
            for(int i=0;i<label_array.size();i++){
                label_array.get(i).setBatsu();
            }
        });

        // setMaru・setBatsuボタンをまとめるHBoxを作成
        HBox setBox=new HBox(20d);
        setBox.setPadding(new Insets(10,10,10,10));
        setBox.setAlignment(Pos.CENTER);
        setBox.getChildren().add(maruButton);
        setBox.getChildren().add(batsuButton);

        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10, 10, 10, 10));
        borderPane.setTop(maruBox);
        borderPane.setBottom(setBox);

        Scene scene = new Scene(borderPane, 400, 120);
        stage.setScene(scene);
        stage.show();
    }
}
