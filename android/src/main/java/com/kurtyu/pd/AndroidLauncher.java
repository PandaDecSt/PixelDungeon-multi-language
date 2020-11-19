package com.kurtyu.pd;

import android.os.Bundle;
import android.util.Log;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.graphics.g2d.freetype.FreeType;
import com.badlogic.gdx.utils.GdxNativesLoader;
import com.watabou.pixeldungeon.PixelDungeon;
import com.watabou.utils.PDPlatformSupport;

public class AndroidLauncher extends AndroidApplication
{
    AndroidApplicationConfiguration config;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        Log.d("DEBUG", "AndroidLauncher::onCreate");
        GdxNativesLoader.load();
        FreeType.initFreeType();

        config = new AndroidApplicationConfiguration();
        config.useWakelock = true;
        launch(config);
    }
    
    private void launch(AndroidApplicationConfiguration config)
    {
        initialize(new PixelDungeon(new PDPlatformSupport<>("1.0.3", "Documents/pixeldungeon.tc/saves/", new AndroidInputProcessor(this))), config);
    }
    
}
