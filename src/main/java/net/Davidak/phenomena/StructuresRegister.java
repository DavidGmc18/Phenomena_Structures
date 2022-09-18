package net.Davidak.phenomena;

import net.Davidak.phenomena.structures.EndHouse;
import net.Davidak.phenomena.structures.Wall;
import net.Davidak.phenomena.structures.MedievalBoat;
import net.Davidak.phenomena.structures.WitchHut;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class StructuresRegister {

    public static final DeferredRegister<StructureType<?>> DEFERRED_REGISTRY_STRUCTURE = DeferredRegister.create(Registry.STRUCTURE_TYPE_REGISTRY, "phenomena");

    public static final RegistryObject<StructureType<WitchHut>> WITCH_HUT = DEFERRED_REGISTRY_STRUCTURE.register("witch_hut_structures", () -> () -> WitchHut.CODEC);
    public static final RegistryObject<StructureType<MedievalBoat>> MEDIEVAL_BOAT = DEFERRED_REGISTRY_STRUCTURE.register("medieval_boat_structures", () -> () -> MedievalBoat.CODEC);
    public static final RegistryObject<StructureType<Wall>> WALL = DEFERRED_REGISTRY_STRUCTURE.register("wall_structures", () -> () -> Wall.CODEC);
    public static final RegistryObject<StructureType<EndHouse>> END_HOUSE = DEFERRED_REGISTRY_STRUCTURE.register("end_house_structures", () -> () -> EndHouse.CODEC);

}
