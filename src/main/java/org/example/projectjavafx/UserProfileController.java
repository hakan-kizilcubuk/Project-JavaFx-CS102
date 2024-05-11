package org.example.projectjavafx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

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

    public void setEmail(){
        emailTextField.setText(LoginPageController.user.g);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
