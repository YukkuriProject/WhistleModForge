package io.rensatopc.github.rensato_whistle.main;

import io.rensatopc.github.rensato_whistle.registers.WhistleModBlocks;
import io.rensatopc.github.rensato_whistle.registers.WhistleModItems;
import io.rensatopc.github.rensato_whistle.registers.WhistleModSounds;
import io.rensatopc.github.rensato_whistle.registers.tab.WhistleModTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(WhistleMod.MOD_ID)
public class WhistleMod {
    public static final String MOD_ID = "rensato_whistle";

    public WhistleMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        WhistleModItems.MOD_ITEMS.register(bus);
        WhistleModTabs.MOD_TABS.register(bus);
        WhistleModSounds.MOD_SOUNDEVENTS.register(bus);
        WhistleModBlocks.MOD_BLOCKS.register(bus);
    }
}
