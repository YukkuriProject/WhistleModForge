package io.rensatopc.github.rensato_whistle.event;

import io.rensatopc.github.rensato_whistle.client.KeyBinds;
import io.rensatopc.github.rensato_whistle.main.WhistleMod;
import io.rensatopc.github.rensato_whistle.network.ModNetworking;
import io.rensatopc.github.rensato_whistle.network.packet.WhistleC2SPacket;
import io.rensatopc.github.rensato_whistle.register.WhistleModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Inventory;
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
                    Inventory inventory = Minecraft.getInstance().player.getInventory();
                    if (inventory.contains(WhistleModItems.WHISTLE.get().getDefaultInstance())) {
                        ModNetworking.sendToServer(new WhistleC2SPacket());
                    }
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
