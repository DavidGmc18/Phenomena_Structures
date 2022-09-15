package net.Davidak.phenomena;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Phenomena.MODID)
public class Phenomena {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "phenomena";

    public Phenomena() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        StructuresRegister.DEFERRED_REGISTRY_STRUCTURE.register(modEventBus);
    }
}
