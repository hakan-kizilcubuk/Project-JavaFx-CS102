package org.example.projectjavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SavedQuestionsController implements Initializable {

    @FXML
    private GridPane savedQuestionGrid;
    private List<Post> savedPosts;

    int columns = 0;
    int rows = 1;

    public void initialize(URL location, ResourceBundle resources) {

        int columns = 0;
        int rows = 1;

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

        for ( int i = 0; i < 100; i++) {
            Post savedPost = new Post();
            savedPost.setQuestion("");
            savedPost.setAnswers(0);
            savedPost.setBranch("");
            savedPost.setChallenging(0);
            savedPost.setUsername("");
            savedPost.setProfilePicSrc("");
            savedPosts.add(savedPost);
        }

        return savedPosts;
    }

}
