package com.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.game.base.BaseScreen;
import com.game.math.Rect;
import com.game.sprite.Background;
import com.game.sprite.Logo;

public class MenuScreen extends BaseScreen {
    private Texture img;
    private Texture bg;
    private Logo logo;
    private Background background;


    @Override
    public void show() {
        super.show();
        img = new Texture("FlyUnit.png");
        bg = new Texture("StarsImg.jpg");
        logo = new Logo(new TextureRegion(img));
        logo.setHeightProportion(0.2f);
        background = new Background(new TextureRegion(bg));
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        logo.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        img.dispose();
        bg.dispose();
        super.dispose();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        logo.touchDown(touch, pointer);
        return false;
    }

}
