package dev.zontreck.claims;

import net.minecraftforge.fml.common.Mod;

@Mod(ClaimsMod.MODID)
public class ClaimsMod {
    public static final String MODID="claims";

    public ClaimsMod()
    {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register the setup method for modloading
        bus.addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    }
}
