import javafx.scene.control.Label;

public class MyLabel extends Label {
    public MyLabel() {
        super();
        this.setText("x");
        this.setPrefSize(50, 50);
    }

    public void setMaru() {
        this.setText("o");
    }

    public void setBatsu() {
        this.setText("x");
    }
}
