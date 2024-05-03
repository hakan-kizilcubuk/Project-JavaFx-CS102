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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginPageController{

    @FXML
    private Label welcomeText;
    /*ImageView logo;
    Image myLogo = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/logo.png")));*/

    @FXML
    private TextField emailusernameTextField;
    @FXML
    private TextField passwordTextFieldLogin;
    @FXML
    private TextField confirmPasswordTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField emailTextField;
    private TextField passwordTextFieldSignup;

    @FXML
    private Button loginButton;
    @FXML
    private Button signupButton;

    @FXML
    private Label invalidValidLabel;

    public void loginButtonOnAction(ActionEvent event) {
        if (!emailusernameTextField.getText().isBlank() && !passwordTextFieldLogin.getText().isBlank()) {
            invalidValidLabel.setText("Trying to login");
            validateLogin();
        }
        else
        {
            invalidValidLabel.setText("Please enter a valid username and password");
        }
    }


    public void validateLogin() {
        Database connectDatabaseNow = new Database();
        Connection connectDatabase = connectDatabaseNow.getConnection();

        String verifyLogin = "'SELECT count(1) FROM userinfo WHERE userName = '" + emailusernameTextField.getText() + "' AND password = '" + passwordTextFieldLogin.getText() + " ";

        try {
            Statement statement = connectDatabase.createStatement();
            ResultSet resultSet = statement.executeQuery(verifyLogin);

            while (resultSet.next()) {
                if (resultSet.getInt(1) == 1) {
                    emailusernameTextField.setText("Valid login!");
                }
                else {
                    emailusernameTextField.setText("Invalid login! Try again");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}