package com.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.game.base.BaseScreen;

public class MenuScreen extends BaseScreen {
    private Texture unit;
    private Vector2 moveVector;
    private Vector2 unitCoord;
    private float unitSpeed;

    @Override
    public void show() {
        super.show();
        unitCoord = new Vector2(0, 0);
        moveVector = unitCoord.cpy();
        unitSpeed = 1.0f;
        unit = new Texture("FlyUnit.png");
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        unitCoord.add(moveVector.cpy().sub(unitCoord).limit(unitSpeed));
        batch.draw(unit, unitCoord.x - 64, Gdx.graphics.getHeight() - unitCoord.y - 64, 128, 128);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        super.dispose();
        unit.dispose();
    }

    @Override
    public boolean keyUp(int keycode) {
        System.out.println("" + keycode);
        switch (keycode){
            case 19: moveVector.set(moveVector.x, unitCoord.y); break;
            case 20: moveVector.set(moveVector.x, unitCoord.y); break;
            case 21: moveVector.set(unitCoord.x, moveVector.y); break;
            case 22: moveVector.set(unitCoord.x, moveVector.y); break;
            default: break;
        }

        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        System.out.println("" + keycode);
        switch (keycode){
            case 19: moveVector.set(moveVector.x, 0); break;
            case 20: moveVector.set(moveVector.x, Gdx.graphics.getHeight()); break;
            case 21: moveVector.set(0, moveVector.y); break;
            case 22: moveVector.set(Gdx.graphics.getWidth(), moveVector.y); break;
            default: break;
        }

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        moveVector.set(screenX, screenY);
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        // изменение скорости передвижения
        if (amount == -1 && unitSpeed > 1) {
            unitSpeed -= 1;
        }
        else if (amount == 1 && unitSpeed < 5){
            unitSpeed += 1;
        }
        return false;
    }
}
