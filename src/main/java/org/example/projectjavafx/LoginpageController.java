package org.example.projectjavafx;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginpageController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    ImageView logo;
    Image myLogo = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/logo.png")));

    @FXML
    private TextField emailusernameTextField;
    private PasswordField passwordTextFieldLogin;
    private PasswordField confirmPasswordTextField;
    private TextField nameTextField;
    private TextField usernameTextField;
    private TextField emailTextField;
    private PasswordField passwordTextFieldSignup;

    @FXML
    private Button loginButton;
    private Button signupButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        signupButton.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) {

            }
        });
    }
}