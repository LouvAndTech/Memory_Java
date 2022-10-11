package com.memory.pages;

import com.memory.memory.View;
import javafx.scene.Scene;

public class Page {
    protected Scene scene;
    protected String name;
    protected View view;

    public Page(View view, String name) {
        this.view = view;
        this.name = name;
    }

    public Scene getScene() {
        return scene;
    }
}
