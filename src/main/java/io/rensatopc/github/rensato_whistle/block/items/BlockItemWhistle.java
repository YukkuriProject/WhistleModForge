package io.rensatopc.github.rensato_whistle.block.items;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class BlockItemWhistle extends BlockItem {

    public BlockItemWhistle(Block block) {
        super(block, new Properties().fireResistant());
    }
}
