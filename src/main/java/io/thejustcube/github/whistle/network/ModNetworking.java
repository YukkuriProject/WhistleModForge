package io.thejustcube.github.whistle.network;

import io.thejustcube.github.whistle.main.WhistleMod;
import io.thejustcube.github.whistle.network.packet.WhistlingPacket;
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
                .clientAcceptedVersions((s, v) -> true)
                .serverAcceptedVersions((s, v) -> true)
                .simpleChannel();

        MOD_INSTANCE.messageBuilder(WhistlingPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(WhistlingPacket::new)
                .encoder(WhistlingPacket::toBytes)
                .consumerMainThread(WhistlingPacket::handle)
                .add();
    }

    public static <MSG> void sendToServer(MSG message) {
        MOD_INSTANCE.send(message, PacketDistributor.SERVER.noArg());
    }
}
