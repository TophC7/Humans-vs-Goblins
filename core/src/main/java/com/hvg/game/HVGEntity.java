package com.hvg.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public abstract class HVGEntity{

    final Texture texture;
    final Sprite sprite;

    Rectangle hitBox = new Rectangle(HVG.w / 2 - 16 / 2, HVG.h - 16, 16, 16);

    HVGEntity(Texture texture){
        this.texture = texture;
        this.sprite = new Sprite(this.texture);
    }

    public void checkOutOfBounds(){
        if (hitBox.x < 16)
            hitBox.x = 16;
        if (hitBox.x > HVG.w - 16  * 2)
            hitBox.x = HVG.w - 16  * 2;
        if (hitBox.y < 16)
            hitBox.y = 16;
        if (hitBox.y > HVG.h - 16 * 2)
            hitBox.y = HVG.h - 16 * 2;
    }

    public void setCoordinates(float x, float y){
        hitBox.x = x;
        hitBox.y = y;
    }

    public float getX(){
        return hitBox.x;
    }
    public float getY(){
        return hitBox.y;
    }
    public float getWidth(){
        return hitBox.width;
    }
    public float getHeight(){
        return hitBox.height;
    }
    public void setX(float x){
        hitBox.x = x;
    }
    public void setY(float y){
        hitBox.y = y;
    }
    public void setWidth(float width){
        hitBox.width = width;
    }
    public void setHeight(float height){
        hitBox.height = height;
    }
    public void dispose(){
        texture.dispose();
    }
}
