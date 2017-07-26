package uk.co.wehavecookies56.kk.common.crafting;

/**
 * Created by Toby on 14/04/2016.
 */
/*
public class ShapelessNBTRecipe implements IRecipe {

    private ItemStack output;
    private ArrayList<Object> input = new ArrayList<>();

    public ShapelessNBTRecipe(Block result, Object... recipe) {
        this(new ItemStack(result), recipe);
    }

    public ShapelessNBTRecipe(Item result, Object... recipe) {
        this(new ItemStack(result), recipe);
    }

    public ShapelessNBTRecipe(ItemStack result, Object... recipe) {
        output = result.copy();
        for (Object in : recipe) {
            if (in instanceof ItemStack) {
                input.add(((ItemStack)in).copy());
            } else if (in instanceof Item) {
                input.add(new ItemStack((Item)in));
            } else if (in instanceof Block) {
                input.add(new ItemStack((Block)in));
            } else if (in instanceof String) {
                input.add(OreDictionary.getOres((String)in));
            } else {
                String ret = "Invalid NBT shapeless ore recipe: ";
                for (Object tmp : recipe) {
                    ret += tmp + ", ";
                }
                ret += output;
                throw new RuntimeException(ret);
            }
        }
    }

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        ArrayList<Object> required = new ArrayList<>(input);
        for(int s = 0; s < inv.getSizeInventory(); s++){
            ItemStack slot = inv.getStackInSlot(s);
            if(slot != ItemStack.EMPTY){
                boolean inRecipe = false;
                Iterator<Object> req = required.iterator();
                while (req.hasNext()){
                    boolean match = false;
                    Object next = req.next();
                    if (next instanceof ItemStack){
                        if(slot.hasTagCompound() && slot.getTagCompound().hasKey("material") && ((ItemStack) next).hasTagCompound() && ((ItemStack) next).getTagCompound().hasKey("material")){
                            if(slot.getTagCompound().getString("material").equals(((ItemStack)next).getTagCompound().getString("material"))){
                                match = true;
                            }
                        }else{
                            if(slot.getItem() == ((ItemStack) next).getItem()){
                                match = true;
                            }
                        }
                    }
                    else if (next instanceof List) {
                        Iterator<ItemStack> itr = ((List<ItemStack>)next).iterator();
                        while (itr.hasNext() && !match) {
                            match = OreDictionary.itemMatches(itr.next(), slot, false);
                        }
                    }
                    if(match){
                        inRecipe = true;
                        required.remove(next);
                        break;
                    }
                }
                if (!inRecipe){
                    return false;
                }
            }
        }
        return required.isEmpty();
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        return this.output.copy();
    }

    @Override
    public int getRecipeSize() {
        return this.input.size();
    }

    @Override
    public ItemStack getRecipeOutput() {
        return this.output;
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(InventoryCrafting inv) {
        NonNullList<ItemStack> stack = NonNullList.withSize(inv.getSizeInventory(), ItemStack.EMPTY);

        for (int i = 0; i < stack.size(); i++) {
            ItemStack itemStack = inv.getStackInSlot(i);
            stack.set(i,ForgeHooks.getContainerItem(itemStack));
        }

        return stack;
    }

}
*/
