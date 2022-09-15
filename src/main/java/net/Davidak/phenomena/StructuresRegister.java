package net.Davidak.phenomena;

import net.Davidak.phenomena.structures.Wall;
import net.Davidak.phenomena.structures.MedievalBoat;
import net.Davidak.phenomena.structures.WildWheat;
import net.Davidak.phenomena.structures.WitchHut;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.WildcardType;

public class StructuresRegister {

    public static final DeferredRegister<StructureType<?>> DEFERRED_REGISTRY_STRUCTURE = DeferredRegister.create(Registry.STRUCTURE_TYPE_REGISTRY, Phenomena.MODID);

    public static final RegistryObject<StructureType<WitchHut>> WITCH_HUT = DEFERRED_REGISTRY_STRUCTURE.register("witch_hut_structures", () -> () -> WitchHut.CODEC);
    public static final RegistryObject<StructureType<MedievalBoat>> MEDIEVAL_BOAT = DEFERRED_REGISTRY_STRUCTURE.register("medieval_boat_structures", () -> () -> MedievalBoat.CODEC);
    public static final RegistryObject<StructureType<Wall>> WALL = DEFERRED_REGISTRY_STRUCTURE.register("wall_structures", () -> () -> Wall.CODEC);
    public static final RegistryObject<StructureType<WildWheat>> WILD_WHEAT = DEFERRED_REGISTRY_STRUCTURE.register("wild_wheat_structures", () -> () -> WildWheat.CODEC);
}
