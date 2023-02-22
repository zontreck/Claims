package dev.zontreck.claims.events;

import dev.zontreck.claims.savedata.Claim;
import dev.zontreck.libzontreck.vectors.Vector3;
import dev.zontreck.libzontreck.vectors.WorldPosition;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.eventbus.api.Event;

public class PlayerChangedClaimEvent extends Event
{
    public ServerPlayer player;
    public Claim claim;
    public WorldPosition position;

    public PlayerChangedClaimEvent(ServerPlayer player, Claim claim){
        this.player=player;
        this.claim=claim;
        position = new WorldPosition(new Vector3(player.position()), (ServerLevel)player.getLevel());
    }
}
