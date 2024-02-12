package dev.tildejustin.generation_brightness.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(MushroomPlantBlock.class)
public abstract class MushroomPlantBlockMixin {
    @ModifyExpressionValue(method = "canPlaceAt", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/WorldView;getBaseLightLevel(Lnet/minecraft/util/math/BlockPos;I)I"))
    private int printMushroomBrightness(int original, BlockState state, WorldView world, BlockPos pos) {
        System.out.println("mushroom: pos: " + pos + ", level: " + original + ", chunk: " + world.getChunk(pos).getStatus().getId());
        return original;
    }
}
