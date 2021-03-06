package mezz.jei.api.gui;

import javax.annotation.Nonnull;
import java.util.Collection;

/**
 * IGuiIngredientGroup displays recipe ingredients in a gui.
 *
 * If multiple ingredients are set for one index, they will be displayed in rotation.
 *
 * @see IGuiItemStackGroup and IGuiFluidStackGroup
 */
public interface IGuiIngredientGroup<T> {
	void set(int slotIndex, @Nonnull Collection<T> ingredients);

	void set(int slotIndex, @Nonnull T ingredient);

	void addTooltipCallback(@Nonnull ITooltipCallback<T> tooltipCallback);
}
