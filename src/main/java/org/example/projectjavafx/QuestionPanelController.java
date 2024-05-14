package org.example.projectjavafx;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class QuestionPanelController {

    @FXML
    private Label timerLabel;

    @FXML
    private Pane stage;

    private int timeSeconds = 20;
    private Timeline timeLine;

    private void updateTime()
    {
        timeSeconds--;
        timerLabel.setText("time: " + timeSeconds);

        if ( timeSeconds <= 0 )
        {
            timeLine.stop();
            Stage stage = (Stage) this.stage.getScene().getWindow();
            stage.close();
        }
    }

    public void initialize()
    {
        timerLabel.setText("time: " + timeSeconds);

        timeLine = new Timeline( new KeyFrame(Duration.seconds(1), e -> updateTime()));
        timeLine.setCycleCount(Timeline.INDEFINITE);
        timeLine.play();
    }

}
