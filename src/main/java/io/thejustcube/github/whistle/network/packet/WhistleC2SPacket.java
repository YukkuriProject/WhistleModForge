package io.thejustcube.github.whistle.network.packet;

import io.thejustcube.github.whistle.item.ItemWhistle;
import io.thejustcube.github.whistle.register.WhistleModItems;
import io.thejustcube.github.whistle.util.Whistle;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.event.network.CustomPayloadEvent;

import java.util.Set;

public class WhistleC2SPacket {
    public WhistleC2SPacket() {

    }

    public WhistleC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public void handle(CustomPayloadEvent.Context context) {
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            ServerLevel level = player.serverLevel();

            ItemWhistle whistle = (ItemWhistle) WhistleModItems.WHISTLE.get();

            Inventory inventory = player.getInventory();
            if (inventory.hasAnyOf(Set.of(WhistleModItems.WHISTLE.get()))) {
                if (!player.getCooldowns().isOnCooldown(whistle)) {
                    Whistle.use(level, player, whistle);
                }
            }
        });
    }
}
