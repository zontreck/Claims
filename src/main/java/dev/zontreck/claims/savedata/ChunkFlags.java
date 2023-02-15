package dev.zontreck.claims.savedata;

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
}
