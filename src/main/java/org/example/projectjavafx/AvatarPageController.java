package org.example.projectjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AvatarPageController {

        @FXML
        private ImageView profileImage;
        @FXML
        private ToggleGroup imageToggleGroup;

        @FXML
        private RadioButton radio1, radio2, radio3, radio4, radio5, radio6;

    @FXML
    private Label username;

        @FXML
        public void initialize() {
            radio1.setUserData("avatar (8).png");
            radio2.setUserData("avatar (7).png");
            radio3.setUserData("avatar (6).png");
            radio4.setUserData("avatar (5).png");
            radio5.setUserData("avatar (4).png");
            radio6.setUserData("avatar (3).png");

            imageToggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null)
                {
                    String imagePath = newValue.getUserData().toString();
                    updateUserProfile( username.getText(), imagePath);
                }
            });
        }

    private void updateUserProfile(String username, String imagePath) {

        DatabaseConnection database = new DatabaseConnection();
        Connection connectDatabase = database.getConnection();

        String sql = "UPDATE users SET userProfilePicture = ? WHERE username = ?";

        try (PreparedStatement preparedStatement = connectDatabase.prepareStatement(sql)) {
            preparedStatement.setString(1, imagePath);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

