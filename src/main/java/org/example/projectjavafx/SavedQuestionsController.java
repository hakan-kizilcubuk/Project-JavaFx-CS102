package org.example.projectjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SavedQuestionsController implements Initializable {

    @FXML
    private GridPane savedQuestionGrid;
    private List<Post> savedPosts;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label coinNumberLabel;

    @FXML
    private Button goBackButton;

    int columns = 0;
    int rows = 1;

    public void setCoinView()
    {
        coinNumberLabel.setText(LoginPageController.user.getUserCoin() + "");
    }

    public void setUsernameLabel()
    {
        usernameLabel.setText(LoginPageController.user.getUserName());
    }

    public void initialize(URL location, ResourceBundle resources) {

        int columns = 0;
        int rows = 1;

        setCoinView();
        setUsernameLabel();
        savedPosts = new ArrayList<>(savedPosts());
        try
        {
            for ( int i = 0; i < savedPosts.size(); i++ )
            {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Post.fxml"));
                VBox box = fxmlLoader.load();
                PostController postController = fxmlLoader.getController();
                postController.setData(savedPosts.get(i));

                if ( columns == 1)
                {
                    columns = 0;
                    ++rows;
                }

                savedQuestionGrid.add(box, columns++,rows);
                GridPane.setMargin(box, new Insets(10));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private List<Post> savedPosts()
    {
        List<Post> savedPosts = new ArrayList<>();
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();
        String query = "SELECT username, branch, question, noOfAnswers FROM savedquestions";

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

                savedPosts.add(post);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }


        return savedPosts;

        
    }

    public void goBackButtonOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) goBackButton.getScene().getWindow();
        stage.close();
    }
}
