package com.game.sprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import com.badlogic.gdx.math.Vector2;
import com.game.base.Sprite;
import com.game.math.Rect;

public class Logo extends Sprite {

    private Vector2 vectorMove;
    private Vector2 vectorBuffer;

    public Logo(TextureRegion region) {
        super(region);
        vectorMove = new Vector2(pos);
        vectorBuffer = new Vector2();
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        return super.touchUp(touch, pointer);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        super.touchDown(touch, pointer);
        vectorMove.set(touch);
        return false;
    }

    @Override
    public void draw(SpriteBatch batch) {
        vectorBuffer.set(vectorMove);
        pos.add(vectorBuffer.sub(pos).limit(0.03f));
        super.draw(batch);
    }

}
