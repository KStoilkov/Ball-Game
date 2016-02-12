package com.kstoilkov.spaceball.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.kstoilkov.spaceball.Config;
import com.kstoilkov.spaceball.SpaceBall;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = (int)Config.V_WIDTH;
		config.height = (int)Config.V_HEIGHT;
		new LwjglApplication(new SpaceBall(), config);
	}
}
