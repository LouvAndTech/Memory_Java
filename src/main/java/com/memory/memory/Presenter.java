package com.memory.memory;

/**
 * The type Presenter.
 */
public class Presenter {
    /**
     * The Is created.
     */
    static boolean isCreated = false;
    private Model model;
    private View view;

    private int found = 0;

    /**
     * Instantiates a new Presenter.
     *
     * @throws Exception the exception
     */
    public Presenter() throws Exception {
        if (isCreated) {
            throw new IllegalStateException("Presenter already created");
        }
        isCreated = true;
    }

    /**
     * Init the presenter.
     *
     * @param model the model
     * @param view  the view
     */
    public void init(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Start the model and view init.
     */
    public void start(){
        this.model.init();
        this.view.init();
        this.view.show();
    }

    /**
     * Retrieve card image path.
     *
     * @param index the index of the card
     * @return the string with the path
     */
    public String retrieveCardPath (int index) {
        return model.getCard(index);
    }

    /**
     * Ask when a card has been clicked.
     * It will flip the card and check if it matches with the previously selected card.
     * Or if it is the first card selected.
     *
     * @param index the index of the card on the board
     */
    public void cardSelected(int index) {
        //If the card is already flipped, do nothing
        if (model.cardIsHidden(index)) {
            //If it is the first card selected, flip it and save the index and return
            if (!model.asSelected()){
                model.flipACard(index);
                view.flipCard(index);
            }
            //If it is the second card selected flip it
            else {
                model.flipACard(index);
                view.flipCard(index);
                view.show();
                //if it is the same card
                if(model.checkMatch(index)){
                    //Just forgot the selected card and leave them face up
                    model.resetSelected();
                    this.found++;
                }else {
                    //if it is not the same card, flip the two cards back
                    model.flipACard(index);
                    model.flipACard(model.getIndexSelected());
                    view.flipCard(index);
                    view.flipCard(model.getIndexSelected());
                    //Then forgot the last selected card
                    model.resetSelected();
                }
            }
            view.show();
            if (this.found == 3) {
                view.showWin();
            }
        }
    }

}
