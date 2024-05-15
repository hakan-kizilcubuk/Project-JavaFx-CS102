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

import java.net.URL;
import java.sql.*;
import java.util.Random;
import java.util.ResourceBundle;

public class HistoryQuestionPanelController implements Initializable {

    @FXML
    private Label warningCoinAi;

    @FXML
    private Label warningCoinFifty;

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
    private Button wrongAnswer1Button;

    @FXML
    private Button wrongAnswer2Button;

    @FXML
    private Button wrongAnswer3Button;

    @FXML
    private Label timerLabel;

    @FXML
    private Label answerStatus;

    @FXML
    private Pane stage;

    private int timeSeconds = 20;
    private Timeline timeLine;

    private void updateTime() {
        timeSeconds--;
        timerLabel.setText("time: " + timeSeconds);

        if (timeSeconds <= 0) {
            timeLine.stop();
            Stage stage = (Stage) this.stage.getScene().getWindow();
            stage.close();
        }
    }


    @FXML
    void correctAnswerButtonOnAction(ActionEvent event) {
        increaseNoOfCorrectQuestions();
        increaseCoinOfUser();
        Stage stage = (Stage) this.stage.getScene().getWindow();
        stage.close();
    }

    @FXML
    void aiJokerButtonOnAction(ActionEvent event) {
        if (LoginPageController.user.getUserCoin() < 10)
        {
            warningCoinAi.setText("Insufficient Coin");
        }

        else{
            decreaseCoinOfUser();
            warningCoinAi.setText("Joker Purchased");
            wrongAnswer1Button.setDisable(true);
            wrongAnswer2Button.setDisable(true);
            wrongAnswer3Button.setDisable(true);
            wrongAnswer1Button.setText("");
            wrongAnswer2Button.setText("");
            wrongAnswer3Button.setText("");
        }
    }

    @FXML
    void fiftyPercentButtonOnAction(ActionEvent event) {
        if (LoginPageController.user.getUserCoin() < 10)
        {
            warningCoinFifty.setText("Insufficient Coin");
        }

        else{
            decreaseCoinOfUser();
            warningCoinFifty.setText("Joker Purchased");
            wrongAnswer1Button.setDisable(true);
            wrongAnswer3Button.setDisable(true);
            wrongAnswer3Button.setText("");
            wrongAnswer1Button.setText("");
        }
    }

    @FXML
    void goBackButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) goBackButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void wrongAnswer1ButtonOnAction(ActionEvent event) {
        answerStatus.setText("WRONG ANSWER!");
        increaseNoOfWrongQuestions();
        Stage stage = (Stage) this.stage.getScene().getWindow();
        stage.close();
    }

    @FXML
    void wrongAnswer2ButtonOnAction(ActionEvent event) {
        answerStatus.setText("WRONG ANSWER!");
        increaseNoOfWrongQuestions();
        Stage stage = (Stage) this.stage.getScene().getWindow();
        stage.close();
    }

    @FXML
    void wrongAnswer3ButtonOnAction(ActionEvent event) {
        answerStatus.setText("WRONG ANSWER!");
        increaseNoOfWrongQuestions();
        Stage stage = (Stage) this.stage.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCoinView();
        setUsernameView();

        int noOfQuestions = findNoOfQuestionsFromHistory();
        Random rand = new Random();

        int randomNoInRange = 1 + rand.nextInt(noOfQuestions);
        try {
            chooseQuestionsFromHistory(randomNoInRange);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        timerLabel.setText("time: " + timeSeconds);
        timeLine = new Timeline(new KeyFrame(Duration.seconds(1), e -> updateTime()));
        timeLine.setCycleCount(Timeline.INDEFINITE);
        timeLine.play();
    }

    public void setCoinView() {
        coinNumberLabel.setText(LoginPageController.user.getUserCoin() + "");
    }

    public void setUsernameView() {
        usernameLabel.setText(LoginPageController.user.getUserName());
    }


    public int findNoOfQuestionsFromHistory() {
        DatabaseConnection connectDatabaseNow = new DatabaseConnection();
        Connection connectDatabase = connectDatabaseNow.getConnection();

        String query = "SELECT COUNT(*) AS row_count FROM historyquestions";
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

    public void chooseQuestionsFromHistory(int indexOfQuestion) throws SQLException {
        DatabaseConnection connectDatabaseNow = new DatabaseConnection();
        String query = "SELECT username, wronganswer1, wronganswer2, wronganswer3, correctanswer, question FROM historyquestions WHERE idhistoryquestions = ?";

        try (Connection connection = connectDatabaseNow.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, indexOfQuestion);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    username.setText(resultSet.getString("username"));
                    wrongAnswer2Button.setText(resultSet.getString("wronganswer2"));
                    wrongAnswer3Button.setText(resultSet.getString("wronganswer3"));
                    correctAnswerButton.setText(resultSet.getString("correctanswer"));
                    wrongAnswer1Button.setText(resultSet.getString("wronganswer1"));
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

    public void increaseNoOfWrongQuestions()
    {
        DatabaseConnection connectDatabaseNow = new DatabaseConnection();
        Connection connectDatabase = connectDatabaseNow.getConnection();

        String query = "UPDATE historyquestions SET noOfWrongAnswers = noOfWrongAnswers + 1 WHERE correctanswer = ?";
        String correctAnswer = correctAnswerButton.getText();

        try{
            PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
            preparedStatement.setString(1, correctAnswer);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void increaseNoOfCorrectQuestions()
    {
        DatabaseConnection connectDatabaseNow = new DatabaseConnection();
        Connection connectDatabase = connectDatabaseNow.getConnection();

        String query = "UPDATE historyquestions SET noOfCorrectAnswers = noOfCorrectAnswers + 1 WHERE correctanswer = ?";
        String correctAnswer = correctAnswerButton.getText();

        try{
            PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
            preparedStatement.setString(1, correctAnswer);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void increaseCoinOfUser()
    {
        DatabaseConnection connectDatabaseNow = new DatabaseConnection();
        Connection connectDatabase = connectDatabaseNow.getConnection();

        String query = "UPDATE userinfo SET coin = coin + 10 WHERE username = ?";
        String username = LoginPageController.user.getUserName();

        try{
            PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void decreaseCoinOfUser()
    {
        DatabaseConnection connectDatabaseNow = new DatabaseConnection();
        Connection connectDatabase = connectDatabaseNow.getConnection();

        String query = "UPDATE userinfo SET coin = coin - 10 WHERE username = ?";
        String username = LoginPageController.user.getUserName();

        try{
            PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}