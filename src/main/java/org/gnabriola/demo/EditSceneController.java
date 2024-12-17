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
import java.util.HashMap;
import java.util.Map;

public class EditSceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button backButton, searchButton, saveButton;
    @FXML
    private TextField getIdTF, idTextField, nameTextField, gradesTextField;
    @FXML
    private Label messageBoxLabel;

    int id;
    int memberId, memberGrades;
    String memberName;

    private SQLController sqlController;

    public void backToMainScene(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("Scene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void search() throws SQLException {
        id = Integer.parseInt(getIdTF.getText());
        sqlController = new SQLController();

        Map<Integer, Object> result = sqlController.searchMember(id);

        memberId = (int) result.get(1);
        memberName = (String) result.get(2);
        memberGrades = (int) result.get(3);

        idTextField.setText(Integer.toString(memberId));
        nameTextField.setText(memberName);
        gradesTextField.setText(Integer.toString(memberGrades));

        messageBoxLabel.setText("Member found");
    }

    public void save() throws SQLException {
        int mId = Integer.parseInt(idTextField.getText());
        String mName = nameTextField.getText();
        int mGrades = Integer.parseInt(gradesTextField.getText());
        sqlController.editMember(id, mId, mName, mGrades);
        messageBoxLabel.setText("Member edited");
    }
}
