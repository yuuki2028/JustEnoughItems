package mezz.jei.gui.ingredients;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class ItemStackRenderer implements IIngredientRenderer<ItemStack> {
	@Override
	public void draw(@Nonnull Minecraft minecraft, int xPosition, int yPosition, @Nullable ItemStack itemStack) {
		if (itemStack == null) {
			return;
		}

		FontRenderer font = getFontRenderer(minecraft, itemStack);

		minecraft.getRenderItem().renderItemAndEffectIntoGUI(itemStack, xPosition, yPosition);
		minecraft.getRenderItem().renderItemOverlayIntoGUI(font, itemStack, xPosition, yPosition, null);
		GlStateManager.disableBlend();
	}

	@SuppressWarnings("unchecked")
	@Nonnull
	@Override
	public List<String> getTooltip(@Nonnull Minecraft minecraft, @Nonnull ItemStack itemStack) {
		List<String> list = itemStack.getTooltip(minecraft.thePlayer, minecraft.gameSettings.advancedItemTooltips);
		for (int k = 0; k < list.size(); ++k) {
			if (k == 0) {
				list.set(k, itemStack.getRarity().rarityColor + list.get(k));
			} else {
				list.set(k, EnumChatFormatting.GRAY + list.get(k));
			}
		}

		return list;
	}

	@Override
	public FontRenderer getFontRenderer(@Nonnull Minecraft minecraft, @Nonnull ItemStack itemStack) {
		FontRenderer fontRenderer = itemStack.getItem().getFontRenderer(itemStack);
		if (fontRenderer == null) {
			fontRenderer = minecraft.fontRendererObj;
		}
		return fontRenderer;
	}
}
