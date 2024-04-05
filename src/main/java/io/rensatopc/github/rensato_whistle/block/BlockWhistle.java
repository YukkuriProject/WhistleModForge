package io.rensatopc.github.rensato_whistle.block;

import io.rensatopc.github.rensato_whistle.item.ItemWhistle;
import io.rensatopc.github.rensato_whistle.register.WhistleModItems;
import io.rensatopc.github.rensato_whistle.util.Whistle;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class BlockWhistle extends Block {
    public BlockWhistle() {
        super(Properties.of()
                .strength(Integer.MAX_VALUE)
        );
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemWhistle whistle = (ItemWhistle) WhistleModItems.WHISTLE.get();

        if (player.getInventory().contains(whistle.getDefaultInstance())) {
            if (!player.getCooldowns().isOnCooldown(whistle)) {
                Whistle.use(level, player, whistle);
            }
        }


        return InteractionResult.SUCCESS;
    }
}
