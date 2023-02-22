package dev.zontreck.claims.savedata;

import dev.zontreck.libzontreck.vectors.ChunkPos;
import net.minecraft.nbt.CompoundTag;

public class ClaimedChunk {
    public ChunkPos ChunkPosition;
    public Claim parent; // Necessary to quickly access the claim itself

    public ClaimedChunk(Claim main, ChunkPos chunkPos)
    {
        parent=main;
        ChunkPosition=chunkPos;
    }


    public CompoundTag serialize()
    {
        CompoundTag tag = new CompoundTag();
        tag.put("pos", ChunkPosition.serialize());

        return tag;
    }

    public ClaimedChunk(CompoundTag tag)
    {
        ChunkPosition = new ChunkPos(tag.getCompound("pos"));
    }
}
