package io.thejustcube.github.whistle.network;

import io.thejustcube.github.whistle.main.WhistleMod;
import io.thejustcube.github.whistle.network.packet.WhistleC2SPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.*;

import static net.minecraftforge.network.ChannelBuilder.named;

public class ModNetworking {
    private static SimpleChannel MOD_INSTANCE;

    private static int packetId = 0;
    private static int id() {
        return packetId += 1;
    }

    public static void register() {
        MOD_INSTANCE = ChannelBuilder.named(new ResourceLocation(WhistleMod.MOD_ID, "networking"))
                .networkProtocolVersion(1)
                .clientAcceptedVersions((s, i) -> true)
                .serverAcceptedVersions((s, i) -> true)
                .simpleChannel();

        MOD_INSTANCE.messageBuilder(WhistleC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(WhistleC2SPacket::new)
                .encoder(WhistleC2SPacket::toBytes)
                .consumerMainThread(WhistleC2SPacket::handle)
                .add();
    }

    public static <MSG> void sendToServer(MSG message) {
        MOD_INSTANCE.send(message, PacketDistributor.SERVER.noArg());
    }
}
