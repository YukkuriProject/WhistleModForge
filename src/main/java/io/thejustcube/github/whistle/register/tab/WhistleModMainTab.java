package io.thejustcube.github.whistle.register.tab;

import io.thejustcube.github.whistle.register.WhistleModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class WhistleModMainTab {
    public static ItemStack[] items = ((Supplier<ItemStack[]>) () -> {
        return new ItemStack[] {
                WhistleModItems.WHISTLE.get().getDefaultInstance(),
                WhistleModItems.WHISTLE_BLOCK.get().getDefaultInstance()
        };
    }).get();

    public static CreativeModeTab get() {
        CreativeModeTab.Builder builder = CreativeModeTab.builder();
        builder.icon(() -> WhistleModItems.WHISTLE.get().getDefaultInstance());
        builder.title(Component.translatable("itemGroup.whistle_main"));
        builder.displayItems((param, output) -> {
            for (ItemStack itemStack:WhistleModMainTab.items) {
                output.accept(itemStack);
            }
        });

        return builder.build();
    }
}
