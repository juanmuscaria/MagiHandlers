package net.heyzeer0.mgh.mixins.am2;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Created by Frani on 04/07/2017.
 */

@Pseudo
@Mixin(targets = "am2/spell/components/BanishRain", remap = false)
public abstract class MixinBanishRain {

    @Inject(method = "applyEffectBlock", at = @At("HEAD"), cancellable = true)
    private void injectApplyEffectBlock(ItemStack stack, World world, int blockx, int blocky, int blockz, int blockFace, double impactX, double impactY, double impactZ, EntityLivingBase caster, CallbackInfoReturnable cir) {
        cir.setReturnValue(false);
    }

    @Inject(method = "applyEffectEntity", at = @At("HEAD"), cancellable = true)
    private void injectApplyEffectEntity(ItemStack stack, World world, EntityLivingBase caster, Entity target, CallbackInfoReturnable cir) {
        cir.setReturnValue(false);
    }

}
