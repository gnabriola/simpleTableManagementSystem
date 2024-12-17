package org.gnabriola.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML
    private Button addButton, editButton, seeButton, deleteButton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToEditScene(ActionEvent event) throws Exception {
        // mainClass.SwitchScene("EditScene");
        root = FXMLLoader.load(getClass().getResource("EditScene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToAddScene(ActionEvent event) throws Exception {
        // mainClass.SwitchScene("AddScene");
        root = FXMLLoader.load(getClass().getResource("AddScene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToSeeAllScene(ActionEvent event) throws Exception {
        // mainClass.SwitchScene("SeeAllScene");
        root = FXMLLoader.load(getClass().getResource("SeeAllScene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToDeleteScene(ActionEvent event) throws Exception {
        // mainClass.SwitchScene("DeleteScene");
        root = FXMLLoader.load(getClass().getResource("DeleteScene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
