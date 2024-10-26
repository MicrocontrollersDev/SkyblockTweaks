package wtf.cheeze.sbt.mixin;

//? if >=1.21.3 {
import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import wtf.cheeze.sbt.SkyblockTweaks;
import wtf.cheeze.sbt.config.SBTConfig;

@Mixin(RecipeBookWidget.class)
public class RecipeBookWidgetMixin {
    @WrapWithCondition(method = "toggleOpen", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/recipebook/RecipeBookWidget;setOpen(Z)V"))
    private boolean sbt$onPressRBook(RecipeBookWidget instance, boolean opened) {
        if (SBTConfig.get().inventory.redirectRecipeBook && SkyblockTweaks.DATA.inSB) {
            MinecraftClient.getInstance().getNetworkHandler().sendChatCommand("recipebook");
            return false;
        }
        return true;
    }
}
//?}
