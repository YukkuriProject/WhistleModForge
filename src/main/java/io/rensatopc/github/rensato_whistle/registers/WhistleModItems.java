package io.rensatopc.github.rensato_whistle.registers;

import io.rensatopc.github.rensato_whistle.item.ItemWhistle;
import io.rensatopc.github.rensato_whistle.main.WhistleMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WhistleModItems {

    public static final DeferredRegister<Item> MOD_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WhistleMod.MOD_ID);
    public static final RegistryObject<Item> WHISTLE = MOD_ITEMS.register("whistle", ItemWhistle::new);
}
