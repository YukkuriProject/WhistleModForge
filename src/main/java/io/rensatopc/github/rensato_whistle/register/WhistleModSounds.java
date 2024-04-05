package io.rensatopc.github.rensato_whistle.register;

import io.rensatopc.github.rensato_whistle.main.WhistleMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WhistleModSounds {
    public static final DeferredRegister<SoundEvent> MOD_SOUNDEVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, WhistleMod.MOD_ID);

    public static final RegistryObject<SoundEvent> WHISTLE_CLICK = registerSoundEvent("whistle_click");

    public static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return MOD_SOUNDEVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(WhistleMod.MOD_ID, name)));
    }
}
