package org.example.projectjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AvatarPageController {
    @FXML
    private Label welcomeText;
    @FXML
    private RadioButton avatar1;
    private RadioButton avatar2;
    private RadioButton avatar3;
    private RadioButton avatar4;
    private RadioButton avatar5;
    private RadioButton avatar6;

    ToggleGroup avatar;

    @FXML
    ImageView firstAvatar;
    Image firstavatar = new Image(getClass().getResourceAsStream("/images/avatar (8).png"));


    public void initialize() {
        avatar = new ToggleGroup();
        avatar1.setToggleGroup(avatar);
        avatar2.setToggleGroup(avatar);
        avatar3.setToggleGroup(avatar);
        avatar4.setToggleGroup(avatar);
        avatar5.setToggleGroup(avatar);
        avatar6.setToggleGroup(avatar);


    }


}