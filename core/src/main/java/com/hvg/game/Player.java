package com.hvg.game;

import com.badlogic.gdx.graphics.Texture;

public class Player extends HVGEntity {

    private final static int playerMaxHP = 100;
    private final static int playerAttack = 10;

    Player() {
        super(new Texture("Tiles/tile_0096.png"), playerMaxHP, playerAttack);
    }

}
