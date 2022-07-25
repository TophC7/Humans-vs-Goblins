package com.hvg.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {
	final HVG game;

	Texture playerTexture;
	Sprite playerSprite;
	TiledMap tiledMap;
	TiledMapRenderer tiledMapRenderer;
	OrthographicCamera camera;
	Rectangle player;
	Array<Rectangle> enemies;

	public GameScreen(final HVG game) {
		this.game = game;

		//creates camera for the game
		camera = new OrthographicCamera();
		camera.setToOrtho(false, HVG.w, HVG.h);

		//Initializes tiled map from file and its renderer
		tiledMap = new TmxMapLoader().load("simpleRoom.tmx");
		tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);

		//gets players texture from file and applies it to player sprite
		playerTexture = new Texture(Gdx.files.internal("Tiles/tile_0096.png"));
		playerSprite = new Sprite(playerTexture);

		//sets hit box for player basically
		player = new Rectangle();
		player.x = HVG.w / 2 - 16 / 2;
		player.y = HVG.h - 16;
		player.width = 16;
		player.height = 16;

	}

	@Override
	public void render(float delta) {

		//sets screen background
		ScreenUtils.clear(0, 0, 0, 1);

		// tell the camera to update its matrices.
		camera.update();

		// tell the SpriteBatch to render in the
		// coordinate system specified by the camera.
		//this is confusing but basically makes the map and the sprites have the same size and hence coordinates
		game.batch.setProjectionMatrix(camera.combined);

		tiledMapRenderer.setView(camera);
		tiledMapRenderer.render();

		//batch rendering
		game.batch.begin();

		game.batch.draw(playerSprite, player.x, player.y, player.width, player.height);

		game.batch.end();

		// process user input
		if (Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			player.x = touchPos.x - 16 / 2;
			player.y = touchPos.y - 16 / 2;
		}

		//checks if player is out of bounds and fixed their position
		if (player.x < 16)
			player.x = 16;
		if (player.x > HVG.w - 16  * 2)
			player.x = HVG.w - 16  * 2;
		if (player.y < 16)
			player.y = 16;
		if (player.y > HVG.h - 16 * 2)
			player.y = HVG.h - 16 * 2;

	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		// start the playback of the background music
		// when the screen is shown
//		rainMusic.play();
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		playerTexture.dispose();
		tiledMap.dispose();

	}

}
