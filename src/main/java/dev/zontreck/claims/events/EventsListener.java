package dev.zontreck.claims.events;

import dev.zontreck.claims.ClaimsMod;
import dev.zontreck.claims.savedata.Claim;
import dev.zontreck.claims.savedata.ClaimsData;
import dev.zontreck.libzontreck.events.PlayerChangedPositionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = ClaimsMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventsListener {
    
    @SubscribeEvent
    public void onPlayerPositionChange(PlayerChangedPositionEvent ev)
    {
        Claim c = Claim.fetch(ev.position);
    }
}
