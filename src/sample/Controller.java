package sample;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;


public class Controller {
    private Model model = new Model();
    private Timeline timeline = new Timeline();
    private int result;
    private int progress;

    @FXML
    private Label numbers;

    @FXML
    private Button startButton;

    @FXML
    private Button stopButton;

    @FXML
    private ListView resultLists;

    @FXML
    public void initialize() {
        numbers.setText("0");
    }

    @FXML
    private void start(ActionEvent event) {

        result = model.getRandomNumber();
        numbers.setText(String.valueOf(result));
        resultLists.getItems().add(progress++,result);

        timeline = new Timeline(new KeyFrame(Duration.seconds(0.05), evt -> numbers.setVisible(false)),
                                new KeyFrame(Duration.seconds( 0.1), evt -> numbers.setVisible(true)),
                                new KeyFrame(Duration.seconds(3), ev -> {

            result = model.getRandomNumber();
            numbers.setText(String.valueOf(result));
            resultLists.getItems().add(result);

        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();


    }

    @FXML
    private void stop(ActionEvent event) {
        timeline.stop();
        numbers.setText("0");
        resultLists.getItems().clear();
    }





}
