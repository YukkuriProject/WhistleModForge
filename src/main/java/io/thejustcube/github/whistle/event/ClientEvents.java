package io.thejustcube.github.whistle.event;

import io.thejustcube.github.whistle.client.KeyBinds;
import io.thejustcube.github.whistle.main.WhistleMod;
import io.thejustcube.github.whistle.network.ModNetworking;
import io.thejustcube.github.whistle.network.packet.WhistlingPacket;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = WhistleMod.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if (KeyBinds.WHISTLING_KEY.consumeClick()) {
                if (Minecraft.getInstance().player != null) {
                    ModNetworking.sendToServer(new WhistlingPacket());
                }
            }
        }
    }

    @Mod.EventBusSubscriber(modid = WhistleMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinds.WHISTLING_KEY);
        }
    }
}
