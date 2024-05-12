package org.example.projectjavafx;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginPageController {

    protected static User user = new User("","","","",0);

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

    @FXML
    private TextField passwordTextFieldSignup;

    @FXML
    private Button loginButton;
    @FXML
    private Button signupButton;

    @FXML
    private Label invalidValidLabel;

    @FXML
    private Label signUpLabel;

    @FXML
    private Label signUpPasswordLabel;

    public void loginButtonOnAction(ActionEvent event) {
        if (!emailusernameTextField.getText().isBlank() && !passwordTextFieldLogin.getText().isBlank()) {
            invalidValidLabel.setText("Trying to login");
            validateLogin();
        } else {
            invalidValidLabel.setText("Please enter a valid username and password");
        }
    }


    public void validateLogin() {
        DatabaseConnection connectDatabaseNow = new DatabaseConnection();
        Connection connectDatabase = connectDatabaseNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM userinfo WHERE userName = '" + emailusernameTextField.getText() + "' AND password = '" + passwordTextFieldLogin.getText() + "'";

        try {
            Statement statement = connectDatabase.createStatement();
            ResultSet resultSet = statement.executeQuery(verifyLogin);

            while (resultSet.next()) {
                if (resultSet.getInt(1) == 1) {
                    invalidValidLabel.setText("Valid login!");
                    String idOfUser = "SELECT iduserAccounts FROM userinfo WHERE userName = '" + emailusernameTextField.getText() + "'";
                    String emailOfUser = "SELECT email FROM userinfo WHERE userName = '" + emailusernameTextField.getText() + "'";
                    user.setUserEmail(emailOfUser);
                    user.setUserName(emailusernameTextField.getText());
                    user.setUserPassword(passwordTextFieldLogin.getText());
                    user.setUserId(idOfUser);
                    mainMenuOpen();
                } else {
                    invalidValidLabel.setText("Invalid login! Try again");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void signUpButtonOnAction(ActionEvent event) {
        if (passwordTextFieldSignup.getText().equals(confirmPasswordTextField.getText())) {
            signupUser();
            signUpPasswordLabel.setText("Password matches!");
            signUpLabel.setText("User registered succesfully!!");
        } else {
            signUpPasswordLabel.setText("Password do not matches!");
        }
    }

    public void signupUser() {
        DatabaseConnection connectDatabaseNow = new DatabaseConnection();
        Connection connectDatabase = connectDatabaseNow.getConnection();

        String name = nameTextField.getText();
        String username = usernameTextField.getText();
        String email = emailTextField.getText();
        String password = passwordTextFieldSignup.getText();

        String insertFields = "INSERT INTO userinfo (name, username, email, coin, password) VALUES ('";
        String insertValues = name + "','" + username + "','" + email + "','" + 0 + "','" + password + "')";
        String insertToRegister = insertFields + insertValues;

        try {
            Statement statement = connectDatabase.createStatement();
            statement.executeUpdate(insertToRegister);
            // to add the new registered user into arraylist of whole users.
            WholeUsers users = new WholeUsers();
            users.addUser( user);
            signUpPasswordLabel.setText("User has been registered succesfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mainMenuOpen()
    {
        try {
            Parent root = FXMLLoader.load((getClass().getResource("MainMenu.fxml")));
            Stage mainMenuStage = new Stage();
            mainMenuStage.setScene(new Scene(root, 720, 512));
            mainMenuStage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}