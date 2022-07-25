package com.hvg.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.hvg.game.HVG;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

		config.setTitle("Drop");
		config.setWindowedMode(800,800);
		config.setResizable(false);
		config.useVsync(true);
		config.setForegroundFPS(60);
		config.setTitle("Humans vs Goblins");
		config.setWindowIcon("axe.png");

		new Lwjgl3Application(new HVG(), config);
	}
}
