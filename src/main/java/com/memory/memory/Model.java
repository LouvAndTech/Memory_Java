package com.memory.memory;

import com.memory.cards.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The type Model.
 */
public class Model {
    private static boolean isCreated = false;
    private final Presenter presenter;
    private List<Card> cards;

    private int indexSelected = -1;

    /**
     * Instantiates a new Model.
     *
     * @param presenter the presenter
     * @throws Exception if the model is already created
     */
    public Model(Presenter presenter) throws Exception {
        if (isCreated) {
            throw new IllegalStateException("Model already created");
        }
        this.presenter = presenter;
        this.isCreated = true;
    }

    /**
     * Init a list of card inside the model
     */
    public void init() {
        cards = new ArrayList<>();
        try {
            this.cards.add(new Pear());
            this.cards.add(new Pear());
            this.cards.add(new Strawberry());
            this.cards.add(new Strawberry());
            this.cards.add(new Lemon());
            this.cards.add(new Lemon());
        } catch (Exception e) {
            System.out.println("Problem while creating the cards");
            System.out.println(e.getMessage());
            System.exit(1);
        }
        Collections.shuffle(cards);
    }

    /**
     * Check if the card match with previously selected card.
     *
     * @param index the index
     * @return the result
     */
    public boolean checkMatch(int index) {
        return cards.get(index).getName().equals(cards.get(indexSelected).getName());
    }

    /**
     * Gets the index of the card that's already selected
     *
     * @return the index previously selected
     */
    public int getIndexSelected() {
        return indexSelected;
    }

    /**
     * Reset sleceted card when the player got a good match
     */
    public void resetSelected(){
        indexSelected = -1;
    }

    /**
     * Gets the image for a card.
     *
     * @param index the index in the list
     * @return the path to the image card
     */
    public String getCard(int index) {
        return cards.get(index).getUsedPath();
    }

    /**
     * Check if the card is hidden.
     *
     * @param index the index
     * @return true if hidden false otherwise.
     */
    public Boolean cardIsHidden(int index) {
        return cards.get(index).isHidden();
    }

    /**
     * Return if the player already as selected one card or if it's the first
     *
     * @return yes if the player already selected a card.
     */
    public boolean asSelected() {
        return indexSelected != -1;
    }

    /**
     * Flip a card.
     *
     * @param index the index of the card to flip
     */
    public void flipACard(int index) {
        //If there is no card selected save as selected
        indexSelected =(indexSelected == -1)?index:indexSelected;
        cards.get(index).flip();
    }
}
