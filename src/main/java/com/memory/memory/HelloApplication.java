package com.memory.memory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private Presenter presenter;
    private View view;
    private Model model;

    @Override
    public void start(Stage stage) throws IOException {
        try {
            presenter = new Presenter();
            model = new Model(presenter);
            view = new View(presenter, stage, 600, 800);
        } catch (Exception e) {
            System.out.println("Problem while building the game");
            System.out.println(e.getMessage());
            System.exit(1);
        }
        presenter.init(model, view);
        presenter.start();
    }

    public static void main(String[] args) {
        launch();
    }
}