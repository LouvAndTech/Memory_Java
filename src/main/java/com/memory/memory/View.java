package com.memory.memory;

import com.memory.pages.*;;
import javafx.stage.Stage;

/**
 * The type View.
 */
public class View {
    /**
     * The Is created.
     */
    static boolean isCreated = false;
    private int HEIGHT = 1000;
    private int WIDTH = 1000;
    private Stage stage;
    private Presenter presenter;
    private Board board;
    private Win win;
    private Page activePage;


    /**
     * Instantiates a new View.
     *
     * @param presenter the presenter
     * @param stage     the stage
     * @param height    the height of the window
     * @param width     the width of the window
     * @throws Exception the exception if the view is already created
     */
    public View(Presenter presenter, Stage stage, int height, int width) throws Exception {
        if (isCreated) {
            throw new IllegalStateException("View already created");
        }
        this.HEIGHT = height;
        this.WIDTH = width;
        this.stage = stage;
        this.presenter = presenter;
        isCreated = true;
    }

    /**
     * Init the view
     */
    public void init() {
        board = new Board(this);
        activePage = board;
    }

    /**
     * Set the scene active and show it on the stage.
     */
    public void show() {
        stage.setScene(activePage.getScene());
        stage.show();
    }

    public void showWin(){
        win = new Win(this);
        activePage = win;
        this.show();
    }

    /**
     * Flip card when asked by the presenter.
     *
     * @param index the index of the card to flip
     */
    public void flipCard(int index) {
        board.flipAcard(index);
    }

    /**
     * When a card is selected ask the presenter to process the card.
     *
     * @param index the index of the card
     */
    public void cardSelected(int index) {
        presenter.cardSelected(index);
    }


    /**
     * Ask the presenter for the card image path.
     *
     * @param index the index
     * @return the card path
     */
    public String getCardPath(int index) {
        return presenter.retrieveCardPath(index);
    }

    /**
     * Gets height.
     *
     * @return the height
     */
    public int getHEIGHT() {
        return HEIGHT;
    }

    /**
     * Gets width.
     *
     * @return the width
     */
    public int getWIDTH() {
        return WIDTH;
    }

}
