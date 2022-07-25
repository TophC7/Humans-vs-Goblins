package com.hvg.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.security.PublicKey;

public class HVG extends Game {
    public static final short w = 160; // games width
    public static final short h = 160; //games height
    public SpriteBatch batch;
    public BitmapFont font;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        this.setScreen(new MainMenuScreen(this));

    }

    public void render(){
        super.render();
    }

    public void dispose(){

    }
}
