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
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class UserProfileController implements Initializable {

    private User user;

    @FXML
    private TextField searchFriendBar;

    @FXML
    private Label statusOfAddFriend;

    @FXML
    private ListView<String> addFriendList;

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
    private Text eMailText;

    @FXML
    private Button logOutButton;

    @FXML
    private ImageView logoImage;

    @FXML
    private Text myAccountLabel;

    @FXML
    private Button savedButton;

    @FXML
    private Text userNameText;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField usernameTextField;

    public void setPasswordLabel() {
        currentEmailLabel.setText("Current password: " + LoginPageController.user.getUserPassword());
    }

    public void setCurrentUsernameLabel() {
        currentUsernameLabel.setText("Current username: " + LoginPageController.user.getUserName());
    }

    public void setUsernameLabel() {
        usernameLabel.setText(LoginPageController.user.getUserName());
    }

    public void setCoinLabel() {
        coinLabel.setText(LoginPageController.user.getUserCoin() + "");
    }

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

    private String prevUsername;


    @FXML
    public void addFriendButtonOnAction(ActionEvent event) {
        addFriends(searchFriendBar.getText());
    }


    @FXML
    void removeFriendButtonOnAction(ActionEvent event) {
        removeFriends(searchFriendBar.getText());
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadFriends()
    {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();
        try(Statement statement = connection.createStatement())
        {
            ResultSet resultSet = statement.executeQuery("SELECT name FROM friends");
            while(resultSet.next())
            {
                addFriendList.getItems().add(resultSet.getString("name"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void addFriends( String name)
    {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();
        if (isExistInDataBase(name))
        {
            if (!name.equals(LoginPageController.user.getUserName()))
            {
                try ( PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO friends (name) VALUES (?)"))
                {
                    preparedStatement.setString(1, name);
                    preparedStatement.executeUpdate();
                    addFriendList.getItems().add(name);
                    statusOfAddFriend.setText( name + " is added.");
                }
                catch ( Exception e)
                {
                    e.printStackTrace();
                }
            }

        }
        else if ( name.equals(LoginPageController.user.getUserName()))
        {
            statusOfAddFriend.setText("you cannot add yourself");
        }
        else
        {
            statusOfAddFriend.setText("no such user has found.");
        }

    }

    private void removeFriends( String name)
    {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();
        if ( isExistListView( name))
        {
            try ( PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM friends WHERE name = ?"))
            {
                preparedStatement.setString(1, name);
                preparedStatement.executeUpdate();
                addFriendList.getItems().remove(name);
                statusOfAddFriend.setText( name + " is removed.");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            statusOfAddFriend.setText( name + " is not your friend");
        }

    }

    private boolean isExistInDataBase( String name)
    {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();
        String sql = "SELECT username FROM userinfo WHERE username = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql))
        {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if ( resultSet.next())
            {
                return true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    private boolean isExistListView( String name)
    {
        for ( String existName : addFriendList.getItems())
        {
            if ( existName.equals(name))
            {
                return true;
            }
        }
        return false;
    }

    public void changePassword() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connectDatabase = databaseConnection.getConnection();

        String newPassword = emailTextField.getText();
        String oldPassword = currentEmailLabel.getText();
        String username = usernameLabel.getText();

        String query = "UPDATE userinfo SET password = ? WHERE username = ?";

        try {
            PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();

            currentEmailLabel.setText("Current Password: " + emailTextField.getText());
            succesfullyChangedLabelPassword.setText("Succesfully Changed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeUsername() {
        DatabaseConnection updateDatabase = new DatabaseConnection();
        Connection updateDatabaseConnection = updateDatabase.getConnection();

        String newUsername = usernameTextField.getText();
        String oldUsername = usernameLabel.getText();
        prevUsername = oldUsername;
        String mySQL = "UPDATE userinfo SET username = ? WHERE username = ?";

        try {
            PreparedStatement updateUsername = updateDatabaseConnection.prepareStatement(mySQL);
            updateUsername.setString(1, newUsername);
            updateUsername.setString(2, oldUsername);
            updateUsername.executeUpdate();

            currentUsernameLabel.setText("Current Username: " + usernameTextField.getText());
            usernameLabel.setText(usernameTextField.getText());
            succesfullyChangedLabelUsername.setText("Succesfully Changed!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void changeUsernameInQuestionTable() {
        DatabaseConnection database = new DatabaseConnection();
        Connection connectDatabase = database.getConnection();

        String newUsername = usernameTextField.getText();
        String oldUsername = prevUsername;

        String query = "UPDATE question SET username = ? WHERE username = ?";

        try {
            PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
            preparedStatement.setString(1, newUsername);
            preparedStatement.setString(2, oldUsername);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount() {
        DatabaseConnection database = new DatabaseConnection();
        Connection connectDatabase = database.getConnection();

        String username = usernameLabel.getText();
        String query = "DELETE FROM userinfo WHERE username = ?";

        try {
            PreparedStatement preparedStatement = connectDatabase.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUsernameLabel();
        setCoinLabel();
        setPasswordLabel();
        setCurrentUsernameLabel();
        loadFriends();
    }
}
