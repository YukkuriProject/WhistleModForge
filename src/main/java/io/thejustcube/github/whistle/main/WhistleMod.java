package io.thejustcube.github.whistle.main;

import io.thejustcube.github.whistle.network.ModNetworking;
import io.thejustcube.github.whistle.register.WhistleModBlocks;
import io.thejustcube.github.whistle.register.WhistleModItems;
import io.thejustcube.github.whistle.register.WhistleModSounds;
import io.thejustcube.github.whistle.register.tab.WhistleModTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(WhistleMod.MOD_ID)
public class WhistleMod {
    public static final String MOD_ID = "whistle";

    public WhistleMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        WhistleModItems.MOD_ITEMS.register(bus);
        WhistleModTabs.MOD_TABS.register(bus);
        WhistleModSounds.MOD_SOUNDEVENTS.register(bus);
        WhistleModBlocks.MOD_BLOCKS.register(bus);
        ModNetworking.register();
    }
}
