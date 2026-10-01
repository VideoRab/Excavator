package me.videorab.algos;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class BlockClusterFinder {
    protected static final int c_DefaultClusterSize = 64;

    protected final int c_MaxClusterSize;

    public BlockClusterFinder(int maxClusterSize) {
        this.c_MaxClusterSize = maxClusterSize;
    }

    public static BlockClusterFinder getInstance(int maxClusterSize) {
        return new BlockClusterFinder(maxClusterSize);
    }

    public static BlockClusterFinder getInstance() {
        return BlockClusterFinder.getInstance(c_DefaultClusterSize);
    }

    public Set<BlockPos> getCluster(Level level, BlockPos pos) {
        var result = new HashSet<BlockPos>();
        result.add(pos);

        var targetBlockState = level.getBlockState(pos);
        var nextPositions = new Stack<BlockPos>();
        nextPositions.push(pos);
        while (result.size() < this.c_MaxClusterSize && !nextPositions.isEmpty()) {
            var currentPos = nextPositions.pop();
            for (var direction : Direction.values()) {
                var newPos = currentPos.relative(direction);
                if (!targetBlockState.getBlock().equals(level.getBlockState(newPos).getBlock())) {
                    continue;
                }

                if (!result.contains(newPos)) {
                    nextPositions.add(newPos);
                    result.add(newPos);
                }

                if (result.size() >= this.c_MaxClusterSize) {
                    break;
                }
            }
        }

        return result;
    }
}
