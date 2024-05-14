package org.example.projectjavafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextArea;

import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PostController extends Application {

    @FXML
    private Label answers;

    @FXML
    private Label branch;

    @FXML
    private ButtonBar challenging;

    @FXML
    private ImageView profile;

    @FXML
    private ImageView media;

    @FXML
    private TextArea question;

    @FXML
    private ButtonBar save;

    @FXML
    private Label username;

    @FXML
    private Button savedButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }

    DatabaseConnection connectDatabaseNow = new DatabaseConnection();
    Connection connectDatabase = connectDatabaseNow.getConnection();

    public void setData(Post post) {

        username.setText(post.getUsername());
        question.setText(post.getQuestion());
        branch.setText(post.getBranch());
        answers.setText(post.getAnswers() + "");
    }

    @FXML
    public void savedButtonOnAction(ActionEvent event) {
        saveQuestion();
    }

    public void saveQuestion() {
        DatabaseConnection connectDatabaseNow = new DatabaseConnection();
        Connection connectDatabase = connectDatabaseNow.getConnection();

        String contentOfQuestion = question.getText();
        String branchOfQuestion = branch.getText();
        String authorOfQuestion = username.getText();
        int noOfAnswers = Integer.parseInt(answers.getText());

        String insertFields = "INSERT INTO savedquestions (username, branch, question, noOfAnswers) VALUES ('";
        String insertValues = authorOfQuestion + "','" + branchOfQuestion + "','" + contentOfQuestion + "','" + noOfAnswers + "')";
        String insertToRegister = insertFields + insertValues;

        try {
            Statement statement = connectDatabase.createStatement();
            statement.executeUpdate(insertToRegister);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
