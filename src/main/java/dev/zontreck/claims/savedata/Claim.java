package dev.zontreck.claims.savedata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import dev.zontreck.libzontreck.vectors.ChunkPos;
import dev.zontreck.libzontreck.vectors.Vector3;
import dev.zontreck.libzontreck.vectors.WorldPosition;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;

public class Claim {
    public String ClaimName;
    public UUID ClaimOwner;
    public List<ClaimedChunk> chunks = new ArrayList<ClaimedChunk>();
    public ChunkFlags ClaimFlags;

    public UUID ClaimID;



/*
    public static ClaimedChunk get(Player owner)
    {
        WorldPosition wp = new WorldPosition(new Vector3(owner.position()), (ServerLevel)owner.level);
        ChunkPos pos = wp.getChunkPos();

        
    }
*/
    Claim()
    {

    }

    public static Claim fetch(WorldPosition wp)
    {
        Iterator<Claim> iter = ClaimsData.claims.iterator();
        while(iter.hasNext())
        {
            Claim x = iter.next();
            if(x.find(wp))
            {

            }
        }
    }

    public boolean find(WorldPosition wp)
    {
        for (ClaimedChunk claimedChunk : chunks) {
            if(claimedChunk.ChunkPosition.isWithin(wp)) return true;
        }
        return false;
    }

    public void claim(ChunkPos pos)
    {
        chunks.add(new ClaimedChunk(this, pos));
    }

    public void unclaim(ClaimedChunk chunk)
    {
        chunks.remove(chunk);
        chunk.parent=null;
    }

    public void unclaim(Vector3 pos){
        Iterator<ClaimedChunk> iterator = chunks.iterator();
        while(iterator.hasNext())
        {
            ClaimedChunk claimedChunk = iterator.next();
            if(claimedChunk==null)return;


            if(claimedChunk.ChunkPosition.isWithin(pos))
            {
                iterator.remove();
            }
        }
    }

    public CompoundTag serialize()
    {
        CompoundTag tag = new CompoundTag();
        tag.putString("name", ClaimName);
        tag.putUUID("owner", ClaimOwner);
        ListTag lst = new ListTag();
        for (ClaimedChunk claimedChunk : chunks) {
            lst.add(claimedChunk.serialize());
        }
        tag.put("chunks", lst);
        tag.putUUID("id", ClaimID);
        tag.put("flags", ClaimFlags.serialize());

        return tag;
    }

    public Claim(CompoundTag tag)
    {
        ClaimName = tag.getString("name");
        ClaimOwner = tag.getUUID("owner");
        ListTag lst = tag.getList("chunks", Tag.TAG_COMPOUND);
        chunks = new ArrayList<>();
        for (Tag tag2 : lst) {
            ClaimedChunk cChunk = new ClaimedChunk(((CompoundTag)tag2));
            cChunk.parent=this;
            chunks.add(cChunk);
        }
        ClaimID = tag.getUUID("id");
        ClaimFlags = ChunkFlags.deserialize((IntTag)tag.get("flags"));
    }
}
