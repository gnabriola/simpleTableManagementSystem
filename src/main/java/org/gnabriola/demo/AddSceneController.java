package org.gnabriola.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AddSceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button backButton, saveButton;
    @FXML
    private TextField idTextField, nameTextField, gradesTextField;

    String id, name, grades;

    public void backToMainScene(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("Scene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addMember() throws SQLException {
        id = idTextField.getText();
        name = nameTextField.getText();
        grades = gradesTextField.getText();
        SQLController sqlController = new SQLController();
        sqlController.save(id, name, grades);
    }

}
