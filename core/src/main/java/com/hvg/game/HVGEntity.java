package com.hvg.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public abstract class HVGEntity {

    public final int MAX_HP;
    public final Sprite SPRITE;
    public final Rectangle RECT = new Rectangle(HVG.w / 2 - 16 / 2, HVG.h - 16, 16, 16);
    private final Texture texture;
    private final int attack;
    private int health;

    HVGEntity(Texture texture, int maxHealth, int attack) {
        this.texture = texture;
        this.SPRITE = new Sprite(this.texture);

        this.MAX_HP = maxHealth;
        this.health = MAX_HP;
        this.attack = attack;
    }

    public void checkOutOfBounds() {
        if (RECT.x < 16)
            RECT.x = 16;
        if (RECT.x > HVG.w - 16 * 2)
            RECT.x = HVG.w - 16 * 2;
        if (RECT.y < 16)
            RECT.y = 16;
        if (RECT.y > HVG.h - 16 * 2)
            RECT.y = HVG.h - 16 * 2;
    }

    public void setCoordinates(float x, float y) {
        RECT.x = x;
        RECT.y = y;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void attack(HVGEntity entity) {
        entity.health -= this.attack;
    }

    public float getX() {
        return RECT.x;
    }

    public void setX(float x) {
        RECT.x = x;
    }

    public float getY() {
        return RECT.y;
    }

    public void setY(float y) {
        RECT.y = y;
    }

    public float getWidth() {
        return RECT.width;
    }

    public void setWidth(float width) {
        RECT.width = width;
    }

    public float getHeight() {
        return RECT.height;
    }

    public void setHeight(float height) {
        RECT.height = height;
    }

    public void dispose() {
        texture.dispose();
    }

    public void moveUp(){
        RECT.y += 0.5;
    }
    public void moveDown(){
        RECT.y -= 0.5;
    }
    public void moveRight(){
        RECT.x += 0.5;
    }
    public void moveLeft(){
        RECT.x -= 0.5;
    }
}
