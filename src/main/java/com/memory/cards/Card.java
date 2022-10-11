package com.memory.cards;

public class Card {
    protected String name;
    protected String path;
    protected String backPath;
    protected boolean isHidden;
    protected boolean isMatched;

    public Card(String name, String path) {
        //editable
        this.name = name;
        this.path = path;
        //non editable
        isHidden = true;
        isMatched = false;
        backPath = "img/img0.png";
    }

    public String getUsedPath() {
        if (isHidden) {
            return backPath;
        } else {
            return path;
        }
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void flip() {
        isHidden = !isHidden;
    }

    public String getName() {
        return name;
    }

}
