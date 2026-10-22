package com.example.schematicmod;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import java.util.HashMap;
import java.util.Map;

public class SchematicHandler {
    private static final Map<String, BlockState[][][]> schematics = new HashMap<>();

    public static void saveSchematic(String name, BlockState[][][] blocks) {
        schematics.put(name, blocks);
    }

    public static BlockState[][][] loadSchematic(String name) {
        return schematics.get(name);
    }

    public static void placeSchematic(Level level, BlockPos pos, BlockState[][][] blocks) {
        for (int x = 0; x < blocks.length; x++) {
            for (int y = 0; y < blocks[x].length; y++) {
                for (int z = 0; z < blocks[x][y].length; z++) {
                    level.setBlock(pos.offset(x, y, z), blocks[x][y][z], 3);
                }
            }
        }
    }
}