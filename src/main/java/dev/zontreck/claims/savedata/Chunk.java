package dev.zontreck.claims.savedata;

import dev.zontreck.libzontreck.vectors.ChunkPos;
import dev.zontreck.libzontreck.vectors.Vector2;
import net.minecraft.nbt.CompoundTag;

public class Chunk {
    public Vector2 pos;

    public Chunk(ChunkPos pos){
        this.pos = pos.centerPoints;
    }

    public Chunk(CompoundTag tag)
    {
        pos=new Vector2(tag);
    }

    public CompoundTag serialize()
    {
        CompoundTag tag = new CompoundTag();
        tag.put("pos", pos.serialize());

        return tag;
    }
}
