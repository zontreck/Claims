package dev.zontreck.claims.savedata;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.Tag;

public enum ChunkFlags {
    Empty(0), // uninitialized flags
    isWilderness(1), // unclaimed land. This is the default everywhere area
    allowsMobSpawns(2),   // claim flag
    allowsBlockPlace(4),  // party flag
    allowsBlockDestroy(8),  // party flag
    allowExplosion(16),  // claim flag
    isOwned(32),   // claim flag
    allowMobGrief(64);   // claim flag. separate from explode. Entities like enderman

    private int flag;
    public int value(){
        return flag;
    }
    private ChunkFlags(int val){
        flag=val;
    }

    public Tag serialize()
    {
        CompoundTag tag = new CompoundTag();
        tag.putInt("flags", flag);

        return tag.get("flags");
    }
    
    public static ChunkFlags deserialize(IntTag tag){
        int val = tag.getAsInt();
        ChunkFlags vFlags = ChunkFlags.Empty;
        while(val >0){
            for (ChunkFlags flags : ChunkFlags.values()) {
                if((val&flags.value())==flags.value())
                {
                    vFlags.flag+=flags.value();
                    val-=flags.value();
                }
            }
        }

        return vFlags;
    }
}
