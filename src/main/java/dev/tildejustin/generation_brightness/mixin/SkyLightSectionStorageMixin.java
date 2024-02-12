package dev.tildejustin.generation_brightness.mixin;

import net.minecraft.world.chunk.light.SkyLightStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(SkyLightStorage.class)
public abstract class SkyLightSectionStorageMixin {
    // @ModifyConstant(method = "getLight", constant = @Constant(intValue = 15, ordinal = 1))
    // private int noBrightnessOnFailure(int constant) {
    //     return 0;
    // }
}
