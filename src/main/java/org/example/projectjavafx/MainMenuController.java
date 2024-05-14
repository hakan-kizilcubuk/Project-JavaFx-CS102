package org.example.projectjavafx;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
        try {
            Parent rootAnother = FXMLLoader.load((getClass().getResource("GeneralKnowledgePanel.fxml")));
            Stage generalKnowledgePageStage = new Stage();
            generalKnowledgePageStage.setScene(new Scene(rootAnother, 720, 512));
            generalKnowledgePageStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void geographyQuestionsButtonOnAction(ActionEvent event) {
        try {
            Parent rootAnother = FXMLLoader.load((getClass().getResource("GeographyQuestionPanel.fxml")));
            Stage geographyPageStage = new Stage();
            geographyPageStage.setScene(new Scene(rootAnother, 720, 512));
            geographyPageStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void historyQuestionsButtonOnAction(ActionEvent event) {
        try {
            Parent rootAnother = FXMLLoader.load((getClass().getResource("HistoryQuestionPanel.fxml")));
            Stage historyPageStage = new Stage();
            historyPageStage.setScene(new Scene(rootAnother, 720, 512));
            historyPageStage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void scienceQuestionsButtonOnAction(ActionEvent event) {
        try {
            Parent rootAnother = FXMLLoader.load((getClass().getResource("ScienceQuestionPanel.fxml")));
            Stage historyPageStage = new Stage();
            historyPageStage.setScene(new Scene(rootAnother, 720, 512));
            historyPageStage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void sportsQuestionsOnAction(ActionEvent event) {
        try {
            Parent rootAnother = FXMLLoader.load((getClass().getResource("SportQuestionPanel.fxml")));
            Stage geographyPageStage = new Stage();
            geographyPageStage.setScene(new Scene(rootAnother, 720, 512));
            geographyPageStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
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


    public void setUserNameLabel() {
        userNameLabel.setText(MainMenuController.newUser.getUserName());
    }

    public void setCoinLabel() {
        coinLabel.setText(MainMenuController.newUser.getUserCoin() + "");
    }

    private ArrayList<String> profileImages = new ArrayList<>();

    public void setProfileImages(ArrayList<String> profileImages) {
        profileImages.add("src/main/resources/org/example/projectjavafx/avatar (3).png");
        profileImages.add("src/main/resources/org/example/projectjavafx/avatar (4).png");
        profileImages.add("src/main/resources/org/example/projectjavafx/avatar (5).png");
        profileImages.add("src/main/resources/org/example/projectjavafx/avatar (6).png");
        profileImages.add("src/main/resources/org/example/projectjavafx/avatar (7).png");
        profileImages.add("src/main/resources/org/example/projectjavafx/avatar (8).png");
        profileImages.add("src/main/resources/org/example/projectjavafx/pp.png");
    }

    private void orderUsersBasedOnCoins()
    {
        ArrayList<String> usernamesByOrder = new ArrayList<>();
        ArrayList<String> coinsByOrder = new ArrayList<>();

        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();
        String sql = "SELECT username, coin, RANK() OVER (ORDER BY coin DESC) FROM userinfo";
        try( Statement statement = connection.createStatement() )
        {
            ResultSet resultSet = statement.executeQuery(sql);

            for ( int i = 0; i < 10; i++)
            {
                String username = resultSet.getString("username");
                int coin = resultSet.getInt("coin");
                usernamesByOrder.add(username);
                coinsByOrder.add(String.valueOf(coin));
            }

            firstRankingUserName.setText(usernamesByOrder.get(0));
            firstRankingCoinNumber.setText(coinsByOrder.get(0));

            secondRankingUserName.setText(usernamesByOrder.get(1));
            secondRankingCoinNumber.setText(coinsByOrder.get(1));

            thirdRankingUsername.setText(usernamesByOrder.get(2));
            thirdRankingCoinNumber.setText(coinsByOrder.get(2));

            fourthRankingUsername.setText(usernamesByOrder.get(3));
            fourthRankingCoinNumber.setText(coinsByOrder.get(3));

            fifthRankingUserName.setText(usernamesByOrder.get(4));
            fifthRankingCoinNumber.setText(coinsByOrder.get(4));

            sixthRankingUsername.setText(usernamesByOrder.get(5));
            sixthRankingCoinNumber.setText(coinsByOrder.get(5));

            seventhRankingUsername.setText(usernamesByOrder.get(6));
            seventhRankingCoinNumber.setText(coinsByOrder.get(6));

            eightRankingUsername.setText(usernamesByOrder.get(7));
            eightRankingCoinNumber.setText(coinsByOrder.get(7));

            ninthRankingUsername.setText(usernamesByOrder.get(8));
            ninthRankingCoinNumber.setText(coinsByOrder.get(8));

            tenthRankingUsername.setText(usernamesByOrder.get(9));
            tenthRankingCoinNumber.setText(coinsByOrder.get(9));

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        setProfileImages(profileImages);
        setUserNameLabel();
        setCoinLabel();
        orderUsersBasedOnCoins();
        newUser.setUserEmail(LoginPageController.user.getUserEmail());
        newUser.setUserName(LoginPageController.user.getUserName());
        newUser.setUserCoin(LoginPageController.user.getUserCoin());
        newUser.setUserId(LoginPageController.user.getUserId());

        posts = new ArrayList<>(posts());

        int columns = 0;
        int rows = 1;


        try {
            for (int i = 0; i < posts.size(); i++) {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("post.fxml"));
                VBox box = fxmlloader.load();
                PostController postController = fxmlloader.getController();
                postController.setData(posts.get(i));

                if (columns == 1) {
                    columns = 0;
                    ++rows;
                }

                postGrid.add(box, columns++, rows);
                GridPane.setMargin(box, new Insets(10));
            }
        } catch (IOException e) {
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

                post.setProfilePicSrc("");
                post.setUsername(username);
                post.setMediaSrc("");
                post.setBranch(branch);
                post.setQuestion(question);
                post.setAnswers(answerCount);
                post.setChallenging(0);

                posts.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return posts;
    }

    public int findNoOfQuestions() {
        DatabaseConnection connectDatabaseNow = new DatabaseConnection();
        Connection connectDatabase = connectDatabaseNow.getConnection();

        String noOfQuestions = "SELECT COUNT(*) AS row_count FROM question";

        try {
            Statement statement = connectDatabase.createStatement();
            ResultSet resultSet = statement.executeQuery(noOfQuestions);
            resultSet.next();
            int rowCount = resultSet.getInt("row_count");

            return rowCount;
        } catch (Exception e) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void userProfileButtonOnAction(ActionEvent actionEvent) {
        try {
            Parent rootAnother = FXMLLoader.load((getClass().getResource("UserProfile.fxml")));
            Stage profilePageStage = new Stage();
            profilePageStage.setScene(new Scene(rootAnother, 720, 512));
            profilePageStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}