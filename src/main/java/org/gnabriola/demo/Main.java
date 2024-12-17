package org.gnabriola.demo;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    private Stage primaryStage;
    private Scene addScene, editScene, seeAllScene, deleteScene, scene;

    @Override
    public void start(Stage primaryStage) throws Exception{

        this.primaryStage = primaryStage;

        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("Scene.fxml"));
        FXMLLoader addLoader = new FXMLLoader(getClass().getResource("AddScene.fxml"));
        FXMLLoader editLoader = new FXMLLoader(getClass().getResource("EditScene.fxml"));
        FXMLLoader seeAllLoader = new FXMLLoader(getClass().getResource("SeeAllScene.fxml"));
        FXMLLoader deleteLoader = new FXMLLoader(getClass().getResource("DeleteScene.fxml"));

        Parent mainPane = mainLoader.load();
        Parent addPane = addLoader.load();
        Parent editPane = editLoader.load();
        Parent seeAllPane = seeAllLoader.load();
        Parent deletePane = deleteLoader.load();

        MainController mainController = mainLoader.getController();
        mainController.getMain(this);

        AddSceneController addSceneController = addLoader.getController();
        addSceneController.getMain(this);

        EditSceneController editSceneController = editLoader.getController();
        editSceneController.getMain(this);

        SeeAllSceneController seeAllSceneController = seeAllLoader.getController();
        seeAllSceneController.getMain(this);

        DeleteSceneController deleteSceneController = deleteLoader.getController();
        deleteSceneController.getMain(this);

        scene = new Scene(mainPane);
        primaryStage.setTitle("Main Scene");
        primaryStage.setScene(scene);
        primaryStage.show();

        addScene = new Scene(addPane);
        editScene = new Scene(editPane);
        seeAllScene = new Scene(seeAllPane);
        deleteScene = new Scene(deletePane);

    }

    public static void main(String[] args) {
        launch(args);
    }

    public void SwitchScene(String fxml) throws Exception {
        // Parent pane = FXMLLoader.load(getClass().getResource(fxml + ".fxml"));
        switch(fxml) {
            case "Scene":
                primaryStage.setTitle(fxml);
                primaryStage.setScene(scene);
                break;
            case "AddScene":
                primaryStage.setTitle(fxml);
                primaryStage.setScene(addScene);
                break;
            case "EditScene":
                primaryStage.setTitle(fxml);
                primaryStage.setScene(editScene);
                break;
            case "SeeAllScene":
                primaryStage.setTitle(fxml);
                primaryStage.setScene(seeAllScene);
                break;
            case "DeleteScene":
                primaryStage.setTitle(fxml);
                primaryStage.setScene(deleteScene);
                break;
        }

    }

}
