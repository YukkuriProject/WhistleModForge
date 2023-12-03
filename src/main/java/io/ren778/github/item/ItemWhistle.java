package io.ren778.github.item;

import io.ren778.github.registers.WhistleModSounds;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.event.sound.SoundEvent;

public class ItemWhistle extends Item {
    public ItemWhistle() {
        super(new Properties()
                .rarity(Rarity.COMMON)
                .stacksTo(1)
        );
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        for (Player target:world.players()) {
            if (!(target.getUUID() == player.getUUID())) {
                target.teleportTo(player.position().x, player.position().y, player.position().z);
            }
        }

        world.playSound(null, player.position().x, player.position().y, player.position().z, WhistleModSounds.WHISTLE_CLICK.get(), SoundSource.MASTER, 1, 1);

        return InteractionResultHolder.consume(stack);
    }
}
