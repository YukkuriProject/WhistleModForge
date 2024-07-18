package io.thejustcube.github.whistle.register.tab;

import io.thejustcube.github.whistle.main.WhistleMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class WhistleModTabs {
    public static final DeferredRegister<CreativeModeTab> MOD_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WhistleMod.MOD_ID);
    public static final RegistryObject<CreativeModeTab> MAIN_TAB = MOD_TABS.register("whistle_main", () -> WhistleModMainTab.get());
}
