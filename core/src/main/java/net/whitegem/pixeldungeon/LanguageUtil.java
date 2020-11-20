package net.whitegem.pixeldungeon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.watabou.noosa.BitmapText;
import com.watabou.pixeldungeon.scenes.PixelScene;
import com.watabou.utils.BitmapCache;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import com.watabou.pixeldungeon.PixelDungeon;

/**
 * Created by Carl-Station on 01/22/15.
 */
public class LanguageUtil {
    private static String code = "en";
    public static String lang[] = {"en", "ru", "fr", "pl", "es", "ko", "pt_BR", "it", "de", "zh", "ja", "tr", "uk","ms"/*"hu"*/};
    public static String langtext[] = {"English", "Русский", "Français", "Polski", "Español", "한국말", "Português brasileiro", "Italiano", "Deutsch", "简体中文", "日本語", "Türkçe", "Украї́нська","Bahasa Melayu"/*"Magyar Nyelv"*/};
    private static class FontSettings {
        protected float baseline = -1;
        protected int scale = -1;

        public float getBaseline(float def) {
            return baseline == -1 ? def : baseline;
        }
    }
    
    private static void getCode() {
        boolean e = false;
        code = "zh";
        for (int i = 0; i < lang.length; i++) {
            if (PixelDungeon.language() != lang[i]) {
                e = true;          
            }
            if (!e) {
                code = PixelDungeon.language();
            }
        }
        Gdx.app.log("langsetting", PixelDungeon.language());
    }
    
    public static void setLanguage() {
        getCode();
        LanguageFactory.INSTANCE.setLanguage(code);

        if (!code.equals("en")) {

        }
    }
}
