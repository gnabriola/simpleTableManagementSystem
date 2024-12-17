package org.gnabriola.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {
    @FXML
    private Button addButton, editButton, seeButton, deleteButton;

    private Main mainClass;

    public void getMain(Main mainClass) {
        this.mainClass = mainClass;
    }

    public void switchToAddScene() throws Exception {
        mainClass.SwitchScene("AddScene");
    }
    public void switchToEditScene() throws Exception {
        mainClass.SwitchScene("EditScene");
    }
    public void switchToSeeAllScene() throws Exception {
        mainClass.SwitchScene("SeeAllScene");
    }
    public void switchToDeleteScene() throws Exception {
        mainClass.SwitchScene("DeleteScene");
    }
}
