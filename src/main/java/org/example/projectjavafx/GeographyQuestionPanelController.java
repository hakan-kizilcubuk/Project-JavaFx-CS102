package org.example.projectjavafx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.Random;
import java.util.ResourceBundle;

public class GeographyQuestionPanelController implements Initializable {

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

    public void initialize(URL location, ResourceBundle resources) {
        setCoinView();
        setUsernameView();

        int noOfQuestions = findNoOfQuestionsFromGeography();
        Random rand = new Random();

        int randomNoInRange = 1 + rand.nextInt(noOfQuestions);
        try {
            chooseQuestionsFromGeography(randomNoInRange);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
    void wrongAnswer1ButtonOnAction(ActionEvent event) {

    }

    @FXML
    void wrongAnswer2ButtonOnAction(ActionEvent event) {

    }

    @FXML
    void wrongAnswer3ButtonOnAction(ActionEvent event) {

    }

    public int findNoOfQuestionsFromGeography()
    {
        DatabaseConnection connectDatabaseNow = new DatabaseConnection();
        Connection connectDatabase = connectDatabaseNow.getConnection();

        String query = "SELECT COUNT(*) AS row_count FROM geographyquestions";
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

    public void chooseQuestionsFromGeography(int indexOfQuestion) throws SQLException {
        DatabaseConnection connectDatabaseNow = new DatabaseConnection();
        String query = "SELECT username, wronganswer1, wronganswer2, wronganswer3, correctanswer, question FROM geographyquestions WHERE idgeographyquestions = ?";

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

}

