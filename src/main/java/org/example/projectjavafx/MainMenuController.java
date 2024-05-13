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
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    protected static User newUser = LoginPageController.user;

    @FXML
    private Button generalKnowledgeQuestionsButton;

    @FXML
    private Button geographyQuestionsButton;

    @FXML
    private Button historyQuestionButton;

    @FXML
    private Button scienceQuestionsButton;

    @FXML
    private Button sportsQuestionsButton;

    @FXML
    public void generalKnowledgeQuestionsOnAction(ActionEvent event) {

    }

    @FXML
    public void geographyQuestionsOnAction(ActionEvent event) {

    }

    @FXML
    public void historyQuestionsButtonOnAction(ActionEvent event) {

    }

    @FXML
    public void scienceQuestionsButtonOnAction(ActionEvent event) {

    }

    @FXML
    public void sportsQuestionsOnAction(ActionEvent event) {

    }

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



    public void setUserNameLabel ()
    {
        userNameLabel.setText(MainMenuController.newUser.getUserName());
    }

    public void setCoinLabel()
    {
        coinLabel.setText(MainMenuController.newUser.getUserCoin() + "");
    }

    private ArrayList<String> profileImages = new ArrayList<>();

    public void setProfileImages( ArrayList<String> profileImages) {
        profileImages.add("src/main/resources/org/example/projectjavafx/avatar (3).png");
        profileImages.add("src/main/resources/org/example/projectjavafx/avatar (4).png");
        profileImages.add("src/main/resources/org/example/projectjavafx/avatar (5).png");
        profileImages.add("src/main/resources/org/example/projectjavafx/avatar (6).png");
        profileImages.add("src/main/resources/org/example/projectjavafx/avatar (7).png");
        profileImages.add("src/main/resources/org/example/projectjavafx/avatar (8).png");
        profileImages.add("src/main/resources/org/example/projectjavafx/pp.png");
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        setProfileImages(profileImages);
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

        int questionNo = findNoOfQuestions();
        List<Post> posts = new ArrayList<>();

            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();
            String query = "SELECT username, branch, question, noOfAnswers FROM question";

            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    Post post = new Post();

                    String username = resultSet.getString("username");
                    String branch = resultSet.getString("branch");
                    String question = resultSet.getString("question");
                    int answerCount = resultSet.getInt("noOfAnswers");

                    post.setProfilePicSrc( "");
                    post.setUsername(username);
                    post.setMediaSrc( "");
                    post.setBranch(branch);
                    post.setQuestion(question);
                    post.setAnswers(answerCount);
                    post.setChallenging( 0);

                    posts.add(post);
                }
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        return posts;
    }


    public int findNoOfQuestions()
    {
        DatabaseConnection connectDatabaseNow = new DatabaseConnection();
        Connection connectDatabase = connectDatabaseNow.getConnection();

        String noOfQuestions = "SELECT COUNT(*) AS row_count FROM question";

        try{
            Statement statement = connectDatabase.createStatement();
            ResultSet resultSet = statement.executeQuery(noOfQuestions);
            resultSet.next();
            int rowCount = resultSet.getInt("row_count");

            return rowCount;
        }catch(Exception e){
            e.printStackTrace();
            return -1;
        }

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