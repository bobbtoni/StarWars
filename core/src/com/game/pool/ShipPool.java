package com.game.pool;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.game.base.SpritesPool;
import com.game.math.Rect;
import com.game.sprite.Ship;

public class ShipPool extends SpritesPool<Ship> {
    private TextureAtlas textureAtlas;
    private Rect worldBounds;

    @Override
    protected Ship newObject() {
        return new Ship(textureAtlas);
    }

    public ShipPool(TextureAtlas textureAtlas) {
        super();
        this.textureAtlas = textureAtlas;
    }

    public void setWorldBounds(Rect worldBounds) {
        for(Ship ship : this.activeObjects){
            ship.setWorldBounds(worldBounds);
        }
    }
}
