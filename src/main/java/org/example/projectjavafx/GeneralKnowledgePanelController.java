package org.example.projectjavafx;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.sql.*;
import java.util.Random;

import java.net.URL;
import java.util.ResourceBundle;

public class GeneralKnowledgePanelController implements Initializable {

    @FXML
    private Label answerStatus;

    @FXML
    private Button aiJokerButton;

    @FXML
    private Label coinNumberLabel;

    @FXML
    private Button correctAnswerButton;

    @FXML
    private Button fiftyPercentButton;

    @FXML
    private Button goBackButton;

    @FXML
    private TextArea question;

    @FXML
    private Label username;

    @FXML
    private Label usernameLabel;

    @FXML
    private Button wrongAnswer2Button;

    @FXML
    private Button wrongAnswer3Button;

    @FXML
    private Button wrongAnswerButton;

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


    public void initialize(URL location, ResourceBundle resources) {
        setCoinView();
        setUsernameView();

        int noOfQuestions = findNoOfQuestionsFromGeneralKnowledge();
        Random rand = new Random();

        int randomNoInRange = 1 + rand.nextInt(noOfQuestions);
        try {
            chooseQuestionFromGeneralKnowledge(randomNoInRange);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        timerLabel.setText("time: " + timeSeconds);
        timeLine = new Timeline( new KeyFrame(Duration.seconds(1), e -> updateTime()));
        timeLine.setCycleCount(Timeline.INDEFINITE);
        timeLine.play();
    }

    public void setCoinView() {
        coinNumberLabel.setText(LoginPageController.user.getUserCoin() + "");
    }

    public void setUsernameView() {
        usernameLabel.setText(LoginPageController.user.getUserName());
    }

    @FXML
    void aiJokerButtonOnAction(ActionEvent event) {

    }

    @FXML
    void correctAnswerButtonOnAction(ActionEvent event) {

    }

    @FXML
    void fiftyPercentButtonOnAction(ActionEvent event) {

    }

    @FXML
    void goBackButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) goBackButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void wrongAnswer2ButtonOnAction(ActionEvent event) {
        answerStatus.setText("WRONG ANSWER!");
        Stage stage = (Stage) wrongAnswer2Button.getScene().getWindow();
        stage.close();
    }

    @FXML
    void wrongAnswer3ButtonOnAction(ActionEvent event) {
        answerStatus.setText("WRONG ANSWER!");
        Stage stage = (Stage) wrongAnswer3Button.getScene().getWindow();
        stage.close();
    }

    @FXML
    void wrongAnswerButtonOnAction(ActionEvent event) {
        answerStatus.setText("WRONG ANSWER!");
        Stage stage = (Stage) wrongAnswerButton.getScene().getWindow();
        stage.close();
    }

    public int findNoOfQuestionsFromGeneralKnowledge() {
        DatabaseConnection connectDatabaseNow = new DatabaseConnection();
        Connection connectDatabase = connectDatabaseNow.getConnection();

        String query = "SELECT COUNT(*) AS row_count FROM generalknowledgequestions";
        try {
            Statement statement = connectDatabase.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count;
            } else {
                return 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void chooseQuestionFromGeneralKnowledge(int indexOfQuestion) throws SQLException {
        DatabaseConnection connectDatabaseNow = new DatabaseConnection();
        String query = "SELECT username, wronganswer1, wronganswer2, wronganswer3, correctanswer, question FROM generalknowledgequestions WHERE idgeneralknowledgequestions = ?";

        try (Connection connection = connectDatabaseNow.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, indexOfQuestion);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    username.setText(resultSet.getString("username"));
                    wrongAnswer2Button.setText(resultSet.getString("wronganswer2"));
                    wrongAnswer3Button.setText(resultSet.getString("wronganswer3"));
                    correctAnswerButton.setText(resultSet.getString("correctanswer"));
                    wrongAnswerButton.setText(resultSet.getString("wronganswer1"));
                    question.setText(resultSet.getString("question"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.printf("SQLException" + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
