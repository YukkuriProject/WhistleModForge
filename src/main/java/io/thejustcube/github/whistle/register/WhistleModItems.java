package io.thejustcube.github.whistle.register;

import io.thejustcube.github.whistle.block.item.BlockItemWhistle;
import io.thejustcube.github.whistle.item.ItemWhistle;
import io.thejustcube.github.whistle.main.WhistleMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WhistleModItems {

    public static final DeferredRegister<Item> MOD_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WhistleMod.MOD_ID);
    public static final RegistryObject<Item> WHISTLE = MOD_ITEMS.register("whistle", ItemWhistle::new);
    public static final RegistryObject<BlockItem> WHISTLE_BLOCK = MOD_ITEMS.register("whistle_block", () -> new BlockItemWhistle(WhistleModBlocks.WHISTLE_BLOCK.get()));
}
