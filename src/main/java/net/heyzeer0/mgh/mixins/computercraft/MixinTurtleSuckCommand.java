package net.heyzeer0.mgh.mixins.computercraft;

import dan200.computercraft.api.turtle.ITurtleAccess;
import dan200.computercraft.api.turtle.TurtleCommandResult;
import dan200.computercraft.shared.turtle.core.InteractDirection;
import dan200.computercraft.shared.turtle.core.TurtleSuckCommand;
import net.heyzeer0.mgh.hacks.cc.PermissionHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Created by Frani on 16/10/2017.
 */
@Pseudo
@Mixin(value = TurtleSuckCommand.class, remap = false)
public abstract class MixinTurtleSuckCommand {

    @Shadow @Final private InteractDirection m_direction;

    @Inject(method = "execute", at = @At("HEAD"), cancellable = true)
    private void onExecute(ITurtleAccess turtle, CallbackInfoReturnable<TurtleCommandResult> cir) {
        if (!PermissionHelper.canTurtleBreak(turtle, m_direction.toWorldDir(turtle))) {
            cir.setReturnValue(TurtleCommandResult.failure("Voce nao tem permissao para retirar itens daqui!"));
        }
    }

}
