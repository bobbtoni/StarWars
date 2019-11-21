package com.game;

import com.badlogic.gdx.Game;
import com.game.screens.MenuScreen;

public class StarWars extends Game {
	@Override
	public void create () {
		setScreen(new MenuScreen(this));
	}
}
