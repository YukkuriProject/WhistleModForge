package io.thejustcube.github.whistle.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinds {
    public static final String MOD_KEY_CATEGORY = "key.category.whistle.main";
    public static final String WHISTLING_KEY_ID = "key.whistle.whistling";

    public static final KeyMapping WHISTLING_KEY = new KeyMapping(WHISTLING_KEY_ID, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_Y, MOD_KEY_CATEGORY);
}
