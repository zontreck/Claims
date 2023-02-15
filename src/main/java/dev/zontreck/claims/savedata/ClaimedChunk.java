package dev.zontreck.claims.savedata;

import java.util.UUID;

import dev.zontreck.libzontreck.vectors.ChunkPos;
import dev.zontreck.libzontreck.vectors.Vector2;
import dev.zontreck.libzontreck.vectors.Vector3;
import dev.zontreck.libzontreck.vectors.WorldPosition;
import net.minecraft.core.BlockPos;
import net.minecraft.server.commands.TitleCommand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;

public class ClaimedChunk {
    public ChunkPos ChunkPosition;
    public UUID Owner;
    public ChunkFlags Flags;

    public ClaimedChunk(Player owner, ChunkPos chunkPos)
    {
        this(owner.getUUID(), chunkPos);
    }

    public ClaimedChunk(UUID ID, ChunkPos chunk){
        Owner=ID;
        ChunkPosition=chunk;
        Flags=ChunkFlags.Empty;
    }

    public static ClaimedChunk get(Player owner)
    {
        WorldPosition wp = new WorldPosition(new Vector3(owner.position()), (ServerLevel)owner.level);
        ChunkPos pos = wp.getChunkPos();

        
    }
}
