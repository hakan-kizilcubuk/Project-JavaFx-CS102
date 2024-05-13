package org.example.projectjavafx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class UserProfileController implements Initializable {

    private User user;

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

    }

    @FXML
    public void changeUsernameButtonOnAction(ActionEvent event) {

    }

    @FXML
    public void deleteButtonOnAction(ActionEvent event) {

    }

    @FXML
    public void logOutButtonOnAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    public void savedButtonOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUsernameLabel();
        setCoinLabel();
        setPasswordLabel();
        setCurrentUsernameLabel();
    }
}
