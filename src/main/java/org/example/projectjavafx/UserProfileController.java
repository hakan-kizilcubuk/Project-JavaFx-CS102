package org.example.projectjavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ResourceBundle;

public class UserProfileController implements Initializable {

    private User user;

    @FXML
    private Label succesfullyChangedLabelPassword;

    @FXML
    private Label succesfullyChangedLabelUsername;

    @FXML
    private Button addFriendButton;

    @FXML
    private Rectangle addFriendRectangle;

    @FXML
    private Button changeProfilePicButton;

    @FXML
    private Rectangle changeProfilePictureRect;

    @FXML
    private ImageView coinImage;

    @FXML
    private Text coinNumber;

    @FXML
    private Button deleteButton;

    @FXML
    private Rectangle deleteRect;

    @FXML
    private Text eMailText;

    @FXML
    private Text editProfileText;

    @FXML
    private Rectangle emailRect;

    @FXML
    private ScrollPane friendsScrollPane;

    @FXML
    private Button logOutButton;

    @FXML
    private Rectangle logOutRect;

    @FXML
    private ImageView logoImage;

    @FXML
    private Text myAccountLabel;

    @FXML
    private Button savedButton;

    @FXML
    private Rectangle savedRect;

    @FXML
    private Circle userAvatar;

    @FXML
    private Text userNameText;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField usernameTextField;

    public void setPasswordLabel(){
        currentEmailLabel.setText("Current password: " + LoginPageController.user.getUserPassword());
    }

    public void setCurrentUsernameLabel(){
        currentUsernameLabel.setText("Current username: " + LoginPageController.user.getUserName());
    }

    public void setUsernameLabel(){
        usernameLabel.setText(LoginPageController.user.getUserName());
    }

    public void setCoinLabel(){
        coinLabel.setText(LoginPageController.user.getUserCoin() + "");
    }

    @FXML
    private ListView<?> addFriendList;

    @FXML
    private Button changeEmailButton;

    @FXML
    private Button changeUsernameButton;

    @FXML
    private Label coinLabel;

    @FXML
    private Label currentEmailLabel;

    @FXML
    private Label currentUsernameLabel;

    @FXML
    private Label usernameLabel;


    @FXML
    public void addFriendButtonOnAction(ActionEvent event) {

    }

    @FXML
    public void changeEmailButtonOnAction(ActionEvent event) {
        changePassword();
    }

    @FXML
    public void changeUsernameButtonOnAction(ActionEvent event) {
        changeUsername();
        changeUsernameInQuestionTable();
    }

    @FXML
    public void deleteButtonOnAction(ActionEvent event) {
        deleteAccount();
    }

    @FXML
    public void logOutButtonOnAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    public void savedButtonOnAction(ActionEvent event) {
        try {
            Parent rootAnother = FXMLLoader.load((getClass().getResource("SavedQuestions.fxml")));
            Stage savedQuestionsStage = new Stage();
            savedQuestionsStage.setScene(new Scene(rootAnother, 720, 512));
            savedQuestionsStage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changePassword()
    {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connectDatabase = databaseConnection.getConnection();

        String newPassword = emailTextField.getText();
        String oldPassword = currentEmailLabel.getText();
        String username = usernameLabel.getText();

        String query = "UPDATE userinfo SET password = ? WHERE username = ?";

        try
        {
            PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();

            currentEmailLabel.setText("Current Password: " + emailTextField.getText());
            succesfullyChangedLabelPassword.setText("Succesfully Changed!");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void changeUsername()
    {
        DatabaseConnection database = new DatabaseConnection();
        Connection connectDatabase = database.getConnection();

        String newUsername = usernameTextField.getText();
        String username = usernameLabel.getText();

        String query = "UPDATE userinfo SET username = ? WHERE username = ?";

        try
        {
            PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
            preparedStatement.setString(1, newUsername);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();

            currentUsernameLabel.setText("Current Username: " + usernameTextField.getText());
            succesfullyChangedLabelUsername.setText("Succesfully Changed!");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void changeUsernameInQuestionTable()
    {
        DatabaseConnection database = new DatabaseConnection();
        Connection connectDatabase = database.getConnection();

        String newUsername = usernameTextField.getText();
        String username = currentUsernameLabel.getText();

        String query = "UPDATE question SET username = ? WHERE username = ?";

        try
        {
            PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
            preparedStatement.setString(1, newUsername);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void deleteAccount()
    {
        DatabaseConnection database = new DatabaseConnection();
        Connection connectDatabase = database.getConnection();

        String username = usernameLabel.getText();
        String query = "DELETE FROM userinfo WHERE username = ?";

        try{
            PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
            System.exit(0);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUsernameLabel();
        setCoinLabel();
        setPasswordLabel();
        setCurrentUsernameLabel();
    }
}
