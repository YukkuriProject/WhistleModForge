package io.rensatopc.github.rensato_whistle.block;

import io.rensatopc.github.rensato_whistle.registers.WhistleModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class BlockWhistle extends Block {
    public BlockWhistle() {
        super(Properties.of()
                .strength(100)
        );
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);

        if (level.players().size() > 1) {
            for (Player target:level.players()) {
                if (!(target.getUUID() == player.getUUID())) {
                    target.teleportTo(player.position().x, player.position().y, player.position().z);
                }
            }

            level.playSound(null, pos.getX(), pos.getY(), pos.getZ(), WhistleModSounds.WHISTLE_CLICK.get(), SoundSource.MASTER, 1, 1);
        } else {
            player.displayClientMessage(Component.literal(Component.translatable("string.whistle_cannotuse").getString()), true);
        }

        return InteractionResult.SUCCESS;
    }
}
