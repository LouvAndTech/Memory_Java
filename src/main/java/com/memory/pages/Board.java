package com.memory.pages;

import com.memory.memory.View;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Board.
 */
public class Board extends Page {

    private List<ImageView> listImageView = new ArrayList<>();

    /**
     * Instantiates a new Board.
     *
     * @param view the view
     */
    public Board(View view) {
        super(view, "Board");
        this.createBoard();
    }

    private void createBoard() {
        //Create the grid
        GridPane grid = new GridPane();
        //grid.setHgap(10);
        //grid.setVgap(10);
        grid.setGridLinesVisible(true);
        grid.setBackground(new Background(new BackgroundFill(Color.DARKGREEN, CornerRadii.EMPTY, Insets.EMPTY)));

        //Row and column constraints
        for (int i = 0; i < 3; i++) {
            //Column constraints
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(33);
            grid.getColumnConstraints().add(column);
        }
        for (int i = 0; i < 2; i++) {
            //Row constraints
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(50);
            grid.getRowConstraints().add(row);
        }

        //Add the images
        for (int i = 0; i < 6; i++) {
            File file = new File(this.view.getCardPath(i));
            Image image = new Image(file.toURI().toString(),(int)(view.getHEIGHT()/2)*0.8,(int)(view.getWIDTH()/3)*0.8,true,false);
            ImageView imageView = new ImageView(image);
            FlowPane imagePane = new FlowPane(imageView);
            imagePane.setAlignment(Pos.CENTER);
            grid.add(imagePane,i%3,i/3);

            listImageView.add(imageView);
            imageView.setOnMouseClicked(e -> {
                view.cardSelected(listImageView.indexOf(imageView));
            });
        }

        super.scene = new Scene(grid, view.getWIDTH(), view.getHEIGHT());
    }

    /**
     * Flip acard.
     *
     * @param index the index
     */
    public void flipAcard(int index) {
        File file = new File(this.view.getCardPath(index));
        Image image = new Image(file.toURI().toString(),(int)(view.getHEIGHT()/2)*0.8,(int)(view.getWIDTH()/3)*0.8,true,false);
        this.listImageView.get(index).setImage(image);
    }

}
