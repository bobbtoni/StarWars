package com.game.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.game.base.Sprite;
import com.game.math.Rect;

public class Ship extends Sprite {

    private Vector2 vectorMove;
    private Vector2 vectorBuffer;
    private TextureRegion normal_state, critical_state;

    public Ship(TextureAtlas atlas) {
        super(atlas.findRegion("main_ship"));
        normal_state = atlas.findRegion("main_ship");
        normal_state.setRegion( normal_state.getRegionX(),
                                normal_state.getRegionY(),
                         normal_state.getRegionWidth()/2,
                                normal_state.getRegionHeight());
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

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.15f);
        setRight(worldBounds.getRight() - 0.05f);
        setBottom(worldBounds.getBottom() + 0.05f);
    }

}
