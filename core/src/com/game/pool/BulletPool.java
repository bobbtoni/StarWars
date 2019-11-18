package com.game.pool;

import com.game.base.SpritesPool;
import com.game.sprite.Bullet;

public class BulletPool extends SpritesPool<Bullet> {
    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}
