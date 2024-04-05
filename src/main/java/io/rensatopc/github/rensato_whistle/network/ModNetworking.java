package io.rensatopc.github.rensato_whistle.network;

import io.rensatopc.github.rensato_whistle.main.WhistleMod;
import io.rensatopc.github.rensato_whistle.network.packet.WhistleC2SPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModNetworking {
    private static SimpleChannel MOD_INSTANCE;

    private static int packetId = 0;
    private static int id() {
        return packetId += 1;
    }

    public static void register() {
        MOD_INSTANCE = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(WhistleMod.MOD_ID, "networking"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        MOD_INSTANCE.messageBuilder(WhistleC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(WhistleC2SPacket::new)
                .encoder(WhistleC2SPacket::toBytes)
                .consumerMainThread(WhistleC2SPacket::handle)
                .add();
    }

    public static <MSG> void sendToServer(MSG message) {
        MOD_INSTANCE.sendToServer(message);
    }
}
