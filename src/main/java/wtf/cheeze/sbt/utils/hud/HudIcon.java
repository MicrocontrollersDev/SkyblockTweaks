package wtf.cheeze.sbt.utils.hud;

import net.minecraft.client.gui.DrawContext;
//? if >=1.21.3
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class HudIcon {
    @Nullable private Identifier iconTexture;
    @Nullable private ItemStack iconStack;
    private Mode mode;

    public HudIcon(Identifier iconTexture) {
        this.iconTexture = iconTexture;
        this.mode = Mode.TEXTURE;
    }

    public HudIcon(ItemStack iconStack) {
        this.iconStack = iconStack;
        this.mode = Mode.ITEM;
    }

    public void render(DrawContext context, int x, int y) {
        switch (mode) {
            case TEXTURE -> context.drawTexture(/*? if >=1.21.3 {*/ RenderLayer::getGuiTextured, /*?}*/ iconTexture, x, y, 0, 0, 8, 8, 8, 8);
            case ITEM -> context.drawItem(iconStack, x, y);
        }
    }
    private static enum Mode {
        TEXTURE,
        ITEM
    }
}
