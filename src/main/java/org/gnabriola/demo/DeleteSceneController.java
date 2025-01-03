package org.gnabriola.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class DeleteSceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button backButton, deleteButton;
    @FXML
    private TextField deleteField;
    @FXML
    private Label messageLabel;

    private SQLController sqlController = new SQLController();

    private int id;

    public void backToMainScene(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("Scene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void deleteMember(ActionEvent event) throws SQLException {
        id = Integer.parseInt(deleteField.getText());
        sqlController.deleteMember(id);
        messageLabel.setText("Deleted member of id " + id);
    }
}
