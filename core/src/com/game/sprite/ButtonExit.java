package com.game.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import com.game.base.ScaledTouchUpButton;
import com.game.math.Rect;

public class ButtonExit extends ScaledTouchUpButton {

    public ButtonExit(TextureAtlas atlas) {
        super(atlas.findRegion("btExit"));
    }

    @Override
    public void action() {
        Gdx.app.exit();
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.15f);
        setRight(worldBounds.getRight() - 0.05f);
        setBottom(worldBounds.getBottom() + 0.05f);
    }
}
