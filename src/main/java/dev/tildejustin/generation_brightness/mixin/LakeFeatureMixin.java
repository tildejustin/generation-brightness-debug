package dev.tildejustin.generation_brightness.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;
import net.minecraft.world.gen.feature.LakeFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LakeFeature.class)
public abstract class LakeFeatureMixin {
    @WrapOperation(method = "generate(Lnet/minecraft/world/ServerWorldAccess;Lnet/minecraft/world/gen/StructureAccessor;Lnet/minecraft/world/gen/chunk/ChunkGenerator;Ljava/util/Random;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/world/gen/feature/SingleStateFeatureConfig;)Z", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/ServerWorldAccess;getLightLevel(Lnet/minecraft/world/LightType;Lnet/minecraft/util/math/BlockPos;)I"))
    private int printLakeLight(ServerWorldAccess instance, LightType lightType, BlockPos blockPos, Operation<Integer> original) {
        int brightness = original.call(instance, lightType, blockPos);
        System.out.println("lake: pos: " + blockPos + ", level: " + brightness + ", chunk: " + instance.getChunk(blockPos).getStatus().getId() + ", correct: " + instance.getChunk(blockPos).isLightOn());
        return brightness;
    }
}
