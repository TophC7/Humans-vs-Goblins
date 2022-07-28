package com.hvg.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {
	final HVG game;
	final HVGEntity player = new Player();
	final Array<HVGEntity> enemies = new Array<>();
	TiledMap tiledMap;
	TiledMapRenderer tiledMapRenderer;
	OrthographicCamera camera;


	public GameScreen(final HVG game) {
		this.game = game;

		//creates camera for the game
		camera = new OrthographicCamera();
		camera.setToOrtho(false, HVG.w, HVG.h);

		//Initializes tiled map from file and its renderer
		tiledMap = new TmxMapLoader().load("simpleRoom.tmx");
		tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);

		//test goblin
		enemies.add(new Goblin());
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

		game.draw(player);
		enemies.forEach(game::draw);

		game.batch.end();

		// process user input
		if (Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			player.setCoordinates(touchPos.x - 16 / 2, touchPos.y - 16 / 2);
		}

		//checks if entity is out of bounds and fix their position
		player.checkOutOfBounds();
		enemies.forEach(HVGEntity::checkOutOfBounds);

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
		player.dispose();
		enemies.forEach(HVGEntity::dispose);
		tiledMap.dispose();

	}

}
