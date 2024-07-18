package io.thejustcube.github.whistle.register;

import io.thejustcube.github.whistle.block.BlockWhistle;
import io.thejustcube.github.whistle.main.WhistleMod;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WhistleModBlocks {
    public static final DeferredRegister<Block> MOD_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, WhistleMod.MOD_ID);

    public static final RegistryObject<Block> WHISTLE_BLOCK = MOD_BLOCKS.register("whistle_block", BlockWhistle::new);
}
