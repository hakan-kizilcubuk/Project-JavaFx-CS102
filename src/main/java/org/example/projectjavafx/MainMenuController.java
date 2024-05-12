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

import javax.swing.text.html.ImageView;
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

    //branch question number label variables

    @FXML
    private Label branch1Number;

    @FXML
    private Label branch2Number;

    @FXML
    private Label branch3Number;

    @FXML
    private Label branch4Number;

    @FXML
    private Label branch5Number;

    @FXML
    private Label branch6Number;

    @FXML
    private Label branch7Number;

    @FXML
    private Label branch8Number;

    @FXML
    private Label branch9Number;

    // rankingtable variables

    @FXML
    private ImageView FirstRankingImage;

    @FXML
    private ImageView SecondRankingImage;
    @FXML
    private Label eightRankingCoinNumber;

    @FXML
    private ImageView eightRankingImage;

    @FXML
    private Label eightRankingUsername;

    @FXML
    private Label fifthRankingCoinNumber;

    @FXML
    private ImageView fifthRankingImage;

    @FXML
    private Label fifthRankingUserName;

    @FXML
    private Label firstRankingCoinNumber;

    @FXML
    private Label firstRankingUserName;

    @FXML
    private Label fourthRankingCoinNumber;

    @FXML
    private ImageView fourthRankingImage;

    @FXML
    private Label fourthRankingUsername;

    @FXML
    private Label ninthRankingCoinNumber;

    @FXML
    private ImageView ninthRankingImage;

    @FXML
    private Label ninthRankingUsername;
    @FXML
    private Label secondRankingCoinNumber;

    @FXML
    private Label secondRankingUserName;

    @FXML
    private Label seventhRankingCoinNumber;

    @FXML
    private ImageView seventhRankingImage;

    @FXML
    private Label seventhRankingUsername;

    @FXML
    private Label sixthRankingCoinNumber;

    @FXML
    private ImageView sixthRankingImage;

    @FXML
    private Label sixthRankingUsername;

    @FXML
    private Label tenthRankingCoinNumber;

    @FXML
    private ImageView tenthRankingImage;

    @FXML
    private Label tenthRankingUsername;

    @FXML
    private Label thirdRankingCoinNumber;

    @FXML
    private ImageView thirdRankingImage;

    @FXML
    private Label thirdRankingUsername;



    @FXML
    private Label branch10Number;

    private List<Post> posts;

    private WholeUsers users = new WholeUsers();

    public void setUserNameLabel ()
    {
        userNameLabel.setText(MainMenuController.newUser.getUserName());
    }

    public void setCoinLabel()
    {
        coinLabel.setText(MainMenuController.newUser.getUserCoin() + "");
    }

    private ArrayList<User> firstTen = new ArrayList<User>();

    public void findFirstTen()
    {
        for ( int i = 0; i <= users.getUsers().size() - 1; i++)
        {
            for ( int j = 0; j < users.getUsers().size() - i - 1; j++)
            {
                if ( users.getUsers().get(j).getUserCoin() > users.getUsers().get(j+1).getUserCoin())
                {
                    int temp = users.getUsers().get(j).getUserCoin();
                    users.getUsers().get(j).setUserCoin(users.getUsers().get(j+1).getUserCoin());
                    users.getUsers().get(j+1).setUserCoin(temp);
                }
            }
        }

        for ( int i = 0; i < 10; i++)
        {
            firstTen.add(users.getUsers().get(i));
        }
    }

    public void initilizeRankingTable( ArrayList<User> firstTen )
    {
        firstRankingUserName.setText(firstTen.get(0).getUserName());
        firstRankingCoinNumber.setText(firstTen.get(0).getUserCoin() + "");

        secondRankingUserName.setText(firstTen.get(1).getUserName());
        secondRankingCoinNumber.setText(firstTen.get(1).getUserCoin() + "");

        thirdRankingUsername.setText(firstTen.get(2).getUserName());
        thirdRankingCoinNumber.setText(firstTen.get(2).getUserCoin() + "");

        fourthRankingUsername.setText(firstTen.get(3).getUserName());
        fourthRankingCoinNumber.setText(firstTen.get(3).getUserCoin() + "");

        fifthRankingUserName.setText(firstTen.get(4).getUserName());
        fifthRankingCoinNumber.setText(firstTen.get(4).getUserCoin() + "");

        sixthRankingUsername.setText(firstTen.get(5).getUserName());
        sixthRankingCoinNumber.setText(firstTen.get(5).getUserCoin() + "");

        seventhRankingUsername.setText(firstTen.get(6).getUserName());
        seventhRankingCoinNumber.setText(firstTen.get(6).getUserCoin() + "");

        eightRankingUsername.setText(firstTen.get(7).getUserName());
        eightRankingCoinNumber.setText(firstTen.get(7).getUserCoin() + "");

        ninthRankingUsername.setText(firstTen.get(8).getUserName());
        ninthRankingCoinNumber.setText(firstTen.get(8).getUserCoin() + "");

        tenthRankingUsername.setText(firstTen.get(9).getUserName());
        tenthRankingCoinNumber.setText(firstTen.get(9).getUserCoin() + "");
    }


    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUserNameLabel();
        setCoinLabel();
        newUser.setUserEmail(LoginPageController.user.getUserEmail());
        newUser.setUserName(LoginPageController.user.getUserName());
        newUser.setUserCoin(LoginPageController.user.getUserCoin());
        newUser.setUserId(LoginPageController.user.getUserId());
        initilizeRankingTable( firstTen);
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