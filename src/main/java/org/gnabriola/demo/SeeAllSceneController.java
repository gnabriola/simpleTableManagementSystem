package org.gnabriola.demo;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SeeAllSceneController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button backButton, refreshButton;
    @FXML
    private Label selectedItemLabel;
    @FXML
    private ListView<String> membersListView;

    private SQLController sqlController;

    ObservableList<String> members;

    String currentMember;

    public SeeAllSceneController() throws SQLException {
    }

    public void backToMainScene(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("Scene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setSqlController() throws SQLException {
        sqlController = new SQLController();
        members = FXCollections.observableArrayList(sqlController.getMembersAsList());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            setSqlController();
        } catch (SQLException e) {
            System.out.println("lalka");
        }

        membersListView.getItems().addAll(members);
        membersListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){

            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                currentMember = membersListView.getSelectionModel().getSelectedItem();
                selectedItemLabel.setText(currentMember);
            }
        });

    }
}
