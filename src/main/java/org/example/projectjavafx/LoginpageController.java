package org.example.projectjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class LoginpageController {
    @FXML
    private Label welcomeText;

    @FXML
    ImageView logo;
    Image myLogo = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/logo.png")));

    @FXML
    private TextField emailusernameTextField;
    private TextField passwordTextFieldLogin;
    private TextField confirmPasswordTextField;
    private TextField nameTextField;
    private TextField usernameTextField;
    private TextField emailTextField;
    private TextField passwordTextFieldSignup;

    @FXML
    private Button loginButton;
    private Button signupButton;



}