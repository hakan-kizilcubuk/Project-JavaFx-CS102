package org.example.mainmenuquizhub;

import javafx.application.Application;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextArea;

import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;

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

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }

    DatabaseConnection connectDatabaseNow = new DatabaseConnection();
    Connection connectDatabase = connectDatabaseNow.getConnection();

    public void setData( Post post) {

        post.setProfilePicSrc( "");
        post.setUsername( "");
        post.setMediaSrc( "");
        post.setBranch( "");
        post.setQuestion( "");
        post.setAnswers( 0);
        post.setChallenging( 0);

    }
}
