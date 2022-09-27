package net.Davidak.phenomena.structures;

import com.mojang.serialization.Codec;
import net.Davidak.phenomena.structures.simple.*;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.structure.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import static net.minecraft.core.Registry.STRUCTURE_TYPES;

public class StructuresPH {
public static final DeferredRegister<StructureType<?>> DEFERRED_REGISTRY_STRUCTURE = DeferredRegister.create(Registry.STRUCTURE_TYPE_REGISTRY, "phenomena");

    public static final RegistryObject<StructureType<WitchHut>> WITCH_HUT = DEFERRED_REGISTRY_STRUCTURE.register("witch_hut_structures", () -> () -> WitchHut.CODEC);
    public static final RegistryObject<StructureType<MedievalBoat>> MEDIEVAL_BOAT = DEFERRED_REGISTRY_STRUCTURE.register("medieval_boat_structures", () -> () -> MedievalBoat.CODEC);
    public static final RegistryObject<StructureType<Wall>> WALL = DEFERRED_REGISTRY_STRUCTURE.register("wall_structures", () -> () -> Wall.CODEC);
    public static final RegistryObject<StructureType<EndHouse>> END_HOUSE = DEFERRED_REGISTRY_STRUCTURE.register("end_house_structures", () -> () -> EndHouse.CODEC);
}
