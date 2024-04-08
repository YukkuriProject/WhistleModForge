package io.rensatopc.github.rensato_whistle.network.packet;

import io.rensatopc.github.rensato_whistle.item.ItemWhistle;
import io.rensatopc.github.rensato_whistle.network.ModNetworking;
import io.rensatopc.github.rensato_whistle.register.WhistleModItems;
import io.rensatopc.github.rensato_whistle.util.Whistle;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.network.NetworkEvent;

import java.util.Set;
import java.util.function.Supplier;

public class WhistleC2SPacket {
    public WhistleC2SPacket() {

    }

    public WhistleC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            ServerLevel level = player.serverLevel();

            ItemWhistle whistle = (ItemWhistle) WhistleModItems.WHISTLE.get();

            Inventory inventory = Minecraft.getInstance().player.getInventory();
            if (inventory.hasAnyOf(Set.of(WhistleModItems.WHISTLE.get()))) {
                if (!player.getCooldowns().isOnCooldown(whistle)) {
                    Whistle.use(level, player, whistle);
                }
            }
        });
        return true;
    }
}
