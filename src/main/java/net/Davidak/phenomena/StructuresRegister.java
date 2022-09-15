package net.Davidak.phenomena;

import net.Davidak.phenomena.structures.MedievalBoat;
import net.Davidak.phenomena.structures.WitchHut;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class StructuresRegister {

    public static final DeferredRegister<StructureType<?>> DEFERRED_REGISTRY_STRUCTURE = DeferredRegister.create(Registry.STRUCTURE_TYPE_REGISTRY, Phenomena.MODID);

    public static final RegistryObject<StructureType<WitchHut>> WITCH_HUT = DEFERRED_REGISTRY_STRUCTURE.register("witch_hut", () -> () -> WitchHut.CODEC);
    public static final RegistryObject<StructureType<MedievalBoat>> MEDIEVAL_BOAT = DEFERRED_REGISTRY_STRUCTURE.register("medieval_boat", () -> () -> MedievalBoat.CODEC);
}
