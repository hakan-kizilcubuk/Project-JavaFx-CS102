package org.example.projectjavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.awt.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddQuestionController implements Initializable {

    @FXML
    private ChoiceBox<String> branchChoiceBox;

    @FXML
    private TextField choice1TextField;

    @FXML
    private TextField choice2TextField;

    @FXML
    private TextField choice3TextField;

    @FXML
    private Button addingQuestionButton;

    @FXML
    private TextField choice4TextField;

    @FXML
    private Button goBackButton;

    @FXML
    private TextField questionTextField;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label questionAddedLabel;

    private String[] branch = {"History", "General Knowledge", "Geography", "Sports", "Science"};

    public void setUsernameLabel()
    {
        usernameLabel.setText(MainMenuController.newUser.getUserName());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUsernameLabel();
        branchChoiceBox.getItems().addAll(branch);
    }




    @FXML
    public void goBackButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) goBackButton.getScene().getWindow();
        stage.close();
    }

    public void addQuestionToBranch(){
        DatabaseConnection connectDatabaseNow = new DatabaseConnection();
        Connection connectDatabase = connectDatabaseNow.getConnection();

        String question = questionTextField.getText();
        String branch = branchChoiceBox.getValue();
        String correctAnswer = choice1TextField.getText();
        String wrongAnswer1 = choice2TextField.getText();
        String wrongAnswer2 = choice3TextField.getText();
        String wrongAnswer3 = choice4TextField.getText();
        String authorOfQuestion = usernameLabel.getText();

        String insertFields = "INSERT INTO question (username, wronganswer1, wronganswer2, wronganswer3, correctanswer, branch, question, noOfAnswers) VALUES ('";
        String insertValues = authorOfQuestion + "','" + wrongAnswer1 + "','" + wrongAnswer2 + "','" + wrongAnswer3 + "','" + correctAnswer + "','" + branch + "','" + question + "', '0')";
        String insertToRegister = insertFields + insertValues;

        try {
            Statement statement = connectDatabase.createStatement();
            statement.executeUpdate(insertToRegister);
            questionAddedLabel.setText("Question Added to " + branchChoiceBox.getValue());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addingQuestionOnAction(ActionEvent actionEvent) {
        if (!questionTextField.getText().isBlank() && !choice1TextField.getText().isBlank() && !choice2TextField.getText().isBlank() && !choice3TextField.getText().isBlank() && !choice4TextField.getText().isBlank() && !branchChoiceBox.getValue().isEmpty()) {
            addQuestionToBranch();
        }

        else{
            questionAddedLabel.setText("Some parts are missing! Fill all fields");
        }
    }
}
