package org.gnabriola.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class DeleteSceneController {
    @FXML
    private Button backButton, deleteButton;
    @FXML
    private TextField deleteField;
    @FXML
    private Label messageLabel;

    private SQLController sqlController = new SQLController();

    private int id;

    private Main mainClass;

    public void getMain(Main mainClass) {
        this.mainClass = mainClass;
    }

    public void backToMainScene() throws Exception {
        mainClass.SwitchScene("Scene");
    }

    public void deleteMember(ActionEvent event) throws SQLException {
        id = Integer.parseInt(deleteField.getText());
        sqlController.deleteMember(id);
        messageLabel.setText("Deleted member of id " + id);
    }
}
