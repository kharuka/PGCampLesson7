import javafx.scene.control.Label;

public class MyLabel extends Label {
    private String number;

    public MyLabel() {
        this.setText("1");
        this.setPrefSize(50, 50);
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
