package am2;

import java.util.HashMap;

import net.minecraft.item.ItemStack;

public class EnervatorRecipeHelper {

    private HashMap<ItemStack, ItemStack> recipes;

    public static final EnervatorRecipeHelper instance = new EnervatorRecipeHelper();

    private EnervatorRecipeHelper() {
        recipes = new HashMap<ItemStack, ItemStack>();
    }

    public void registerRecipe(ItemStack from, ItemStack to) {
        recipes.put(from.copy(), to);
    }

    public HashMap getRecipes() {
        return recipes;
    }

    public ItemStack getRecipe(ItemStack stack) {
        if (stack == null) return null;

        ItemStack toReturn = null;

        for (ItemStack possibleComponent : recipes.keySet()) {
            if (stack.getItem() == possibleComponent.getItem() && (possibleComponent.getItemDamage() == Short.MAX_VALUE
                || possibleComponent.getItemDamage() == stack.getItemDamage()))
                toReturn = recipes.get(possibleComponent);
        }

        if (toReturn == null) {
            if (stack.isItemStackDamageable()) {
                ItemStack newStack = stack.copy();
                newStack.setItemDamage(stack.getItemDamage() + 1);
                toReturn = newStack;
            }
        }

        if (toReturn != null) {
            toReturn.stackSize = 1;
        }
        return toReturn;
    }
}
