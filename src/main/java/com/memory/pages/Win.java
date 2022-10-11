package com.memory.pages;

import com.memory.memory.View;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.File;

public class Win extends Page {
    public Win(View view) {
        super(view, "win");
        this.createWin();
    }
    private void createWin(){
        GridPane grid = new GridPane();
        grid.setBackground(new Background(new BackgroundFill(Color.DARKGREEN, CornerRadii.EMPTY, Insets.EMPTY)));

        File file = new File("img/win.png");
        Image image = new Image(file.toURI().toString(),(int)(view.getHEIGHT())*0.9,(int)(view.getHEIGHT())*0.9,true,false);
        ImageView imageView = new ImageView(image);
        FlowPane flowPane = new FlowPane(imageView);
        flowPane.setAlignment(Pos.CENTER);
        grid.add(flowPane,0,0);
        super.scene = new Scene(grid, view.getHEIGHT(), view.getHEIGHT());
    }
}
