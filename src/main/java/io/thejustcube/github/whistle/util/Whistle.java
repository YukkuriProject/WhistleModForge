package io.thejustcube.github.whistle.util;

import io.thejustcube.github.whistle.item.ItemWhistle;
import io.thejustcube.github.whistle.register.WhistleModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class Whistle {
    public static void use(Level world, Player player, ItemWhistle whistle) {
        if (world.players().size() > 1) {
            player.getCooldowns().addCooldown(whistle, 80);

            for (Player target:world.players()) {
                if (!(target.getUUID() == player.getUUID())) {
                    target.teleportTo(player.position().x, player.position().y, player.position().z);
                }
            }

            world.playSound(null, player.position().x, player.position().y, player.position().z, WhistleModSounds.WHISTLE_CLICK.get(), SoundSource.MASTER, 1, 1);
        } else {
            player.displayClientMessage(Component.translatable("string.whistle.whistle_cannotuse"), true);
        }
    }
}
