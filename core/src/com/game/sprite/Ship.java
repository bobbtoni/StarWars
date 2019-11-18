package com.game.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.game.base.Sprite;
import com.game.math.Rect;
import com.game.pool.BulletPool;

public class Ship extends Sprite {

    private final Vector2 v = new Vector2(0, -0.1f);

    private Rect worldBounds;
    private BulletPool bulletPool;
    private TextureRegion bulletRegion;
    private Vector2 bulletV = new Vector2(0, -0.3f);

    private final float reloadInterval = 0.7f;
    private float reloadTimer = 0f;

    public Ship(TextureAtlas atlas) {
        super(atlas.findRegion("enemy0"), 1, 2, 2);
        bulletRegion = atlas.findRegion("bulletEnemy");
        setHeightProportion(0.1f);
    }

    public void set(
            BulletPool bulletPool,
            Vector2 pos,
            Vector2 v,
            int damage){
        this.bulletPool = bulletPool;
        this.pos.set(pos);
        this.v.set(v);
        setHeightProportion(0.1f);
    }

    public void setWorldBounds(Rect worldBounds) {
        this.worldBounds = worldBounds;
    }

    @Override
    public void update(float delta) {
        reloadTimer += delta;
        if (reloadTimer > reloadInterval) {
            reloadTimer = 0f;
            shoot();
        }
        pos.mulAdd(v, delta);
        if (isOutside(worldBounds)) {
            destroy();
        }
    }

    private void stop() {
        v.setZero();
    }

    private void shoot() {
        Bullet bullet = bulletPool.obtain();
        bullet.set(this, bulletRegion, pos, bulletV, 0.01f, worldBounds, 1);
    }
}
