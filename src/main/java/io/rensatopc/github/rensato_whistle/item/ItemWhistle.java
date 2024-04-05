package io.rensatopc.github.rensato_whistle.item;

import io.rensatopc.github.rensato_whistle.util.Whistle;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

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

        if (!world.isClientSide()) {
            Whistle.use(world, player, this);
        }

        return InteractionResultHolder.consume(stack);
    }
}
