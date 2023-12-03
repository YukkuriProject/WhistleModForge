package io.ren778.github.registers;

import io.ren778.github.item.ItemWhistle;
import io.ren778.github.main.WhistleMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WhistleModItems {

    public static final DeferredRegister<Item> MOD_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WhistleMod.MOD_ID);
    public static final RegistryObject<Item> WHISTLE = MOD_ITEMS.register("whistle", ItemWhistle::new);
}
