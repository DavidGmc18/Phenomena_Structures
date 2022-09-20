package net.Davidak.phenomena.structures;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.Davidak.phenomena.HeightmapCustom;
import net.Davidak.phenomena.StructuresRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

import java.util.Optional;

public class LushTrap extends Structure {

    public static final Codec<LushTrap> CODEC = RecordCodecBuilder.<LushTrap>mapCodec(instance ->
            instance.group(LushTrap.settingsCodec(instance),
                    StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter(structure -> structure.startPool),
                    ResourceLocation.CODEC.optionalFieldOf("start_jigsaw_name").forGetter(structure -> structure.startJigsawName),
                    Codec.intRange(0, 30).fieldOf("size").forGetter(structure -> structure.size),
                    HeightProvider.CODEC.fieldOf("start_height").forGetter(structure -> structure.startHeight),
                    Heightmap.Types.CODEC.optionalFieldOf("project_start_to_heightmap").forGetter(structure -> structure.projectStartToHeightmap),
                    Codec.intRange(1, 128).fieldOf("max_distance_from_center").forGetter(structure -> structure.maxDistanceFromCenter)
            ).apply(instance, LushTrap::new)).codec();

    private final Holder<StructureTemplatePool> startPool;
    private final Optional<ResourceLocation> startJigsawName;
    private final int size;
    private final HeightProvider startHeight;
    private final Optional<Heightmap.Types> projectStartToHeightmap;
    private final int maxDistanceFromCenter;

    public LushTrap(StructureSettings config,
                    Holder<StructureTemplatePool> startPool,
                    Optional<ResourceLocation> startJigsawName,
                    int size,
                    HeightProvider startHeight,
                    Optional<Heightmap.Types> projectStartToHeightmap,
                    int maxDistanceFromCenter)
    {
        super(config);
        this.startPool = startPool;
        this.startJigsawName = startJigsawName;
        this.size = size;
        this.startHeight = startHeight;
        this.projectStartToHeightmap = projectStartToHeightmap;
        this.maxDistanceFromCenter = maxDistanceFromCenter;
    }

    private static boolean extraSpawningChecks(Structure.GenerationContext context) {
        ChunkPos chunkpos = context.chunkPos();

       return context.chunkGenerator().getFirstOccupiedHeight(
                chunkpos.getMinBlockX(),
                chunkpos.getMinBlockZ(),
                Heightmap.Types.OCEAN_FLOOR_WG,
                context.heightAccessor(),
                context.randomState()) < 64;
    }
    //TODO loot tables
    @Override
    public Optional<GenerationStub> findGenerationPoint(GenerationContext context) {

       if (!LushTrap.extraSpawningChecks(context)) {
            return Optional.empty();
        }

       int startY = this.startHeight.sample(context.random(), new WorldGenerationContext(context.chunkGenerator(), context.heightAccessor()));

        ChunkPos chunkPos = context.chunkPos();
        BlockPos blockPos = new BlockPos(chunkPos.getMinBlockX(), startY, chunkPos.getMinBlockZ());

        Optional<GenerationStub> structurePiecesGenerator =
                JigsawPlacement.addPieces(
                        context,
                        this.startPool,
                        this.startJigsawName,
                        this.size,
                        blockPos,
                        false,
                        this.projectStartToHeightmap,
                        this.maxDistanceFromCenter);

        return structurePiecesGenerator;
    }

    @Override
    public StructureType<?> type() {return StructuresRegister.LUSH_TRAP.get();}
}
