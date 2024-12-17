package org.gnabriola.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class EditSceneController {
    @FXML
    private Button backButton;

    private Main mainClass;

    public void getMain(Main mainClass) {
        this.mainClass = mainClass;
    }

    public void backToMainScene() throws Exception {
        mainClass.SwitchScene("Scene");
    }
}
