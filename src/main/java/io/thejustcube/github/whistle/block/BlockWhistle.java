package io.thejustcube.github.whistle.block;

import io.thejustcube.github.whistle.item.ItemWhistle;
import io.thejustcube.github.whistle.register.WhistleModItems;
import io.thejustcube.github.whistle.util.Whistle;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Set;

public class BlockWhistle extends Block {
    public BlockWhistle() {
        super(Properties.of()
                .strength(Integer.MAX_VALUE)
        );
    }

    @Override
    public InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        ItemWhistle whistle = (ItemWhistle) WhistleModItems.WHISTLE.get();

        if (player.getInventory().hasAnyOf(Set.of(whistle))) {
            if (!player.getCooldowns().isOnCooldown(whistle)) {
                Whistle.use(level, player, whistle);
            }
        }


        return InteractionResult.SUCCESS;
    }
}
