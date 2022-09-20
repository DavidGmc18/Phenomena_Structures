package net.Davidak.phenomena;

import com.mojang.serialization.Codec;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Heightmap;

import java.util.function.Predicate;
//TODO made this works
public class HeightmapCustom extends Heightmap {

    static final Predicate<BlockState> LUSH = (blockState) -> {
        return (blockState.equals(Blocks.MOSS_BLOCK) || blockState.equals(Blocks.CLAY));
    };

    public HeightmapCustom(ChunkAccess chunkAccess, Heightmap.Types types) {
        super(chunkAccess, types);
    }

    public static enum Types implements StringRepresentable {
        UNDERGROUND_LUSH("UNDERGROUND_LUSH", Heightmap.Usage.WORLDGEN, LUSH);

        public static final Codec<Heightmap.Types> CODEC = StringRepresentable.fromEnum(Heightmap.Types::values);
        private final String serializationKey;
        private final Heightmap.Usage usage;
        private final Predicate<BlockState> isOpaque;

        private Types(String p_64284_, Heightmap.Usage p_64285_, Predicate<BlockState> p_64286_) {
            this.serializationKey = p_64284_;
            this.usage = p_64285_;
            this.isOpaque = p_64286_;
        }

        public Predicate<BlockState> isOpaque() {
            return this.isOpaque;
        }

        public String getSerializedName() {
            return this.serializationKey;
        }
    }
}
