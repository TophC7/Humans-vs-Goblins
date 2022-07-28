package com.hvg.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;

public class Goblin extends HVGEntity {

    private final static int goblinMaxHP = 50;

    Goblin() {
        super(new Texture("Tiles/tile_0108.png"), goblinMaxHP, MathUtils.random(8,10));

        int x = MathUtils.random(1,8);
        int y = MathUtils.random(1,8);

        //if entrance cooridantes change move it
        if(y == 8){
            if(x == 3 || x == 4)
                x = 2;
            else if( x == 5 || x == 6)
                x = 7;
        }

        setCoordinates(x * 16, y * 16);

    }
}
