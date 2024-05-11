package org.example.projectjavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.awt.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddQuestionController implements Initializable {

    @FXML
    private Button addQuestionButton;

    @FXML
    private ChoiceBox<String> branchChoiceBox;

    @FXML
    private TextField choice1TextField;

    @FXML
    private TextField choice2TextField;

    @FXML
    private TextField choice3TextField;

    @FXML
    private TextField choice4TextField;

    @FXML
    private Button goBackButton;

    @FXML
    private TextField questionTextField;

    @FXML
    private Label usernameLabel;

    private String[] branch = {"History", "General Knowledge", "Geography", "Sports", "Science"};

    public void setUsernameLabel()
    {
        usernameLabel.setText(MainMenuController.newUser.getUserName());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUsernameLabel();
        branchChoiceBox.getItems().addAll(branch);
    }
}
