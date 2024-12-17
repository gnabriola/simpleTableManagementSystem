package org.gnabriola.demo;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SeeAllSceneController implements Initializable {
    @FXML
    private Button backButton, refreshButton;
    @FXML
    private Label selectedItemLabel;
    @FXML
    private ListView<String> membersListView;

    URL url;
    ResourceBundle resourceBundle;

    private SQLController sqlController;

    ObservableList<String> members;

    String currentMember;

    private Main mainClass;

    public SeeAllSceneController() throws SQLException {
    }

    public void getMain(Main mainClass) {
        this.mainClass = mainClass;
    }

    public void backToMainScene() throws Exception {
        mainClass.SwitchScene("Scene");
    }

    public void setSqlController() throws SQLException {
        sqlController = new SQLController();
        members = FXCollections.observableArrayList(sqlController.getMembersAsList());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.url = url;
        this.resourceBundle = resourceBundle;

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

    public void refresh() {
        members.clear();
        //initialize(url, resourceBundle);
    }
}
