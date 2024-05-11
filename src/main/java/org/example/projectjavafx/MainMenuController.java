package org.example.projectjavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

public class MainMenuController implements Initializable {

    protected static User newUser = LoginPageController.user;

    @FXML
    private Button userProfileButton;

    @FXML
    private Label coinLabel;

    private User user;

    @FXML
    private Label userNameLabel;

    @FXML
    private GridPane postGrid;

    @FXML
    private Button addQuestionButton;


    private List<Post> posts;

    public void setUserNameLabel ()
    {
        userNameLabel.setText(MainMenuController.newUser.getUserName());
    }

    public void setCoinLabel()
    {
        coinLabel.setText(MainMenuController.newUser.getUserCoin() + "");
    }


    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUserNameLabel();
        setCoinLabel();
        newUser.setUserEmail(LoginPageController.user.getUserEmail());
        newUser.setUserName(LoginPageController.user.getUserName());
        newUser.setUserCoin(LoginPageController.user.getUserCoin());
        newUser.setUserId(LoginPageController.user.getUserId());
        posts = new ArrayList<>(posts());

        int columns = 0;
        int rows = 1;


        try {
            for ( int i = 0; i < posts.size(); i++ ) {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("post.fxml"));
                VBox box = fxmlloader.load();
                PostController postController = fxmlloader.getController();
                postController.setData(posts.get(i));
                if (columns == 1)
                {
                    columns = 0;
                    ++rows;
                }

                postGrid.add(box, columns++,rows);
                GridPane.setMargin(box,new Insets(10));
            }
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    private List<Post> posts() {

        List<Post> posts = new ArrayList<>();

        for( int i = 1; i < 10; i++ )
        {
            Post post = new Post();

            post.setProfilePicSrc( "");
            post.setUsername( "");
            post.setMediaSrc( "");
            post.setBranch( "");
            post.setQuestion( "");
            post.setAnswers( 0);
            post.setChallenging( 0);

            posts.add(post);
        }

        return posts;
    }

    public void addQuestionButtonOnAction(ActionEvent actionEvent) {
        try {
            Parent newRoot = FXMLLoader.load((getClass().getResource("AddQuestion.fxml")));
            Stage addQuestionStage = new Stage();
            addQuestionStage.setScene(new Scene(newRoot, 720, 512));
            addQuestionStage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void userProfileButtonOnAction(ActionEvent actionEvent) {
        try {
            Parent rootAnother = FXMLLoader.load((getClass().getResource("UserProfile.fxml")));
            Stage profilePageStage = new Stage();
            profilePageStage.setScene(new Scene(rootAnother, 720, 512));
            profilePageStage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}