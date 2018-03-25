import javafx.scene.control.Label;

public class MyLabel extends Label {
    private int number;


    public MyLabel() {
        super();
        this.setText("1");
        this.setPrefSize(50, 50);
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
