package uk.co.wehavecookies56.kk.api.menu;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import java.util.HashMap;

public class ItemCategoryRegistry {

    public static HashMap<String, ItemCategory> categories = new HashMap<>();

    static {
        registerItem(Items.WOODEN_SWORD, ItemCategory.TOOL);
        registerItem(Items.WOODEN_AXE, ItemCategory.TOOL);
        registerItem(Items.WOODEN_HOE, ItemCategory.TOOL);
        registerItem(Items.WOODEN_PICKAXE, ItemCategory.TOOL);
        registerItem(Items.WOODEN_SHOVEL, ItemCategory.TOOL);

        registerItem(Items.STONE_SWORD, ItemCategory.TOOL);
        registerItem(Items.STONE_AXE, ItemCategory.TOOL);
        registerItem(Items.STONE_HOE, ItemCategory.TOOL);
        registerItem(Items.STONE_PICKAXE, ItemCategory.TOOL);
        registerItem(Items.STONE_SHOVEL, ItemCategory.TOOL);

        registerItem(Items.IRON_SWORD, ItemCategory.TOOL);
        registerItem(Items.IRON_AXE, ItemCategory.TOOL);
        registerItem(Items.IRON_HOE, ItemCategory.TOOL);
        registerItem(Items.IRON_PICKAXE, ItemCategory.TOOL);
        registerItem(Items.IRON_SHOVEL, ItemCategory.TOOL);

        registerItem(Items.GOLDEN_SWORD, ItemCategory.TOOL);
        registerItem(Items.GOLDEN_AXE, ItemCategory.TOOL);
        registerItem(Items.GOLDEN_HOE, ItemCategory.TOOL);
        registerItem(Items.GOLDEN_PICKAXE, ItemCategory.TOOL);
        registerItem(Items.GOLDEN_SHOVEL, ItemCategory.TOOL);

        registerItem(Items.DIAMOND_SWORD, ItemCategory.TOOL);
        registerItem(Items.DIAMOND_AXE, ItemCategory.TOOL);
        registerItem(Items.DIAMOND_HOE, ItemCategory.TOOL);
        registerItem(Items.DIAMOND_PICKAXE, ItemCategory.TOOL);
        registerItem(Items.DIAMOND_SHOVEL, ItemCategory.TOOL);

        registerItem(Items.FLINT_AND_STEEL, ItemCategory.TOOL);
        registerItem(Items.SHEARS, ItemCategory.TOOL);
        registerItem(Items.COMPASS, ItemCategory.TOOL);
        registerItem(Items.CLOCK, ItemCategory.TOOL);
        registerItem(Items.FISHING_ROD, ItemCategory.TOOL);
        registerItem(Items.LEAD, ItemCategory.TOOL);
        registerItem(Items.MAP, ItemCategory.TOOL);
        registerItem(Items.FILLED_MAP, ItemCategory.TOOL);
        registerItem(Item.getItemFromBlock(Blocks.TNT), ItemCategory.TOOL);
        registerItem(Item.getItemFromBlock(Blocks.TORCH), ItemCategory.TOOL);
        registerItem(Items.BUCKET, ItemCategory.TOOL);
        registerItem(Items.WATER_BUCKET, ItemCategory.TOOL);
        registerItem(Items.LAVA_BUCKET, ItemCategory.TOOL);

        registerItem(Items.LEATHER_HELMET, ItemCategory.EQUIPMENT);
        registerItem(Items.LEATHER_CHESTPLATE, ItemCategory.EQUIPMENT);
        registerItem(Items.LEATHER_LEGGINGS, ItemCategory.EQUIPMENT);
        registerItem(Items.LEATHER_BOOTS, ItemCategory.EQUIPMENT);

        registerItem(Items.IRON_HELMET, ItemCategory.EQUIPMENT);
        registerItem(Items.IRON_CHESTPLATE, ItemCategory.EQUIPMENT);
        registerItem(Items.IRON_LEGGINGS, ItemCategory.EQUIPMENT);
        registerItem(Items.IRON_BOOTS, ItemCategory.EQUIPMENT);

        registerItem(Items.GOLDEN_HELMET, ItemCategory.EQUIPMENT);
        registerItem(Items.GOLDEN_CHESTPLATE, ItemCategory.EQUIPMENT);
        registerItem(Items.GOLDEN_LEGGINGS, ItemCategory.EQUIPMENT);
        registerItem(Items.GOLDEN_BOOTS, ItemCategory.EQUIPMENT);

        registerItem(Items.DIAMOND_HELMET, ItemCategory.EQUIPMENT);
        registerItem(Items.DIAMOND_CHESTPLATE, ItemCategory.EQUIPMENT);
        registerItem(Items.DIAMOND_LEGGINGS, ItemCategory.EQUIPMENT);
        registerItem(Items.DIAMOND_BOOTS, ItemCategory.EQUIPMENT);

        registerItem(Items.ELYTRA, ItemCategory.EQUIPMENT);

        registerItem(Items.CARROT, ItemCategory.CONSUMABLE);
        registerItem(Items.BREAD, ItemCategory.CONSUMABLE);
        registerItem(Items.APPLE, ItemCategory.CONSUMABLE);
        registerItem(Items.GOLDEN_APPLE, ItemCategory.CONSUMABLE);
        registerItem(Items.GOLDEN_CARROT, ItemCategory.CONSUMABLE);
        registerItem(Items.BEETROOT, ItemCategory.CONSUMABLE);
        registerItem(Items.BEETROOT_SOUP, ItemCategory.CONSUMABLE);
        registerItem(Items.ROTTEN_FLESH, ItemCategory.CONSUMABLE);
        registerItem(Items.SPIDER_EYE, ItemCategory.CONSUMABLE);
        registerItem(Items.MUSHROOM_STEW, ItemCategory.CONSUMABLE);
        registerItem(Items.MILK_BUCKET, ItemCategory.CONSUMABLE);
        registerItem(Items.BEEF, ItemCategory.CONSUMABLE);
        registerItem(Items.COOKED_BEEF, ItemCategory.CONSUMABLE);
        registerItem(Items.PORKCHOP, ItemCategory.CONSUMABLE);
        registerItem(Items.COOKED_PORKCHOP, ItemCategory.CONSUMABLE);
        registerItem(Items.RABBIT, ItemCategory.CONSUMABLE);
        registerItem(Items.COOKED_RABBIT, ItemCategory.CONSUMABLE);
        registerItem(Items.CHICKEN, ItemCategory.CONSUMABLE);
        registerItem(Items.COOKED_CHICKEN, ItemCategory.CONSUMABLE);
        registerItem(Items.MUTTON, ItemCategory.CONSUMABLE);
        registerItem(Items.COOKED_MUTTON, ItemCategory.CONSUMABLE);
        registerItem(Items.FISH, ItemCategory.CONSUMABLE);
        registerItem(Items.COOKED_FISH, ItemCategory.CONSUMABLE);
        registerItem(Items.COOKIE, ItemCategory.CONSUMABLE);
        registerItem(Items.POTATO, ItemCategory.CONSUMABLE);
        registerItem(Items.BAKED_POTATO, ItemCategory.CONSUMABLE);
        registerItem(Items.POISONOUS_POTATO, ItemCategory.CONSUMABLE);
        registerItem(Items.CAKE, ItemCategory.CONSUMABLE);
        registerItem(Items.CHORUS_FRUIT, ItemCategory.CONSUMABLE);
        registerItem(Items.MELON, ItemCategory.CONSUMABLE);
        registerItem(Items.SPECKLED_MELON, ItemCategory.CONSUMABLE);
        registerItem(Items.RABBIT_STEW, ItemCategory.CONSUMABLE);
        registerItem(Items.POTIONITEM, ItemCategory.CONSUMABLE);

        registerItem(Item.getItemFromBlock(Blocks.DIRT), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.GRASS), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.GRASS_PATH), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.STONE), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.COBBLESTONE), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.SAND), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.SANDSTONE), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.BRICK_BLOCK), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.NETHERRACK), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.OBSIDIAN), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.PLANKS), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.LOG), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.LOG2), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.WOOL), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.DIAMOND_BLOCK), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.IRON_BLOCK), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.GOLD_BLOCK), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.COAL_BLOCK), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.CRAFTING_TABLE), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.FURNACE), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.CHEST), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.CONCRETE), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.CONCRETE_POWDER), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.GLASS), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.GLASS_PANE), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.STAINED_GLASS), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.STAINED_GLASS_PANE), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.CLAY), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.HARDENED_CLAY), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.STAINED_HARDENED_CLAY), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.OAK_DOOR), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.ACACIA_DOOR), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.SPRUCE_DOOR), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.BIRCH_DOOR), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.JUNGLE_DOOR), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.TRAPDOOR), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.STONEBRICK), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.SPONGE), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.SOUL_SAND), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.GLOWSTONE), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.SNOW), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.IRON_BARS), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.IRON_DOOR), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.IRON_TRAPDOOR), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.WOODEN_PRESSURE_PLATE), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.STONE_PRESSURE_PLATE), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.REDSTONE_BLOCK), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.REDSTONE_LAMP), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.SLIME_BLOCK), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.PISTON), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.STICKY_PISTON), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.RAIL), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.ACTIVATOR_RAIL), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.DETECTOR_RAIL), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.GOLDEN_RAIL), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.STONE_SLAB), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.STONE_SLAB2), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.WOODEN_SLAB), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.MAGMA), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.SEA_LANTERN), ItemCategory.BUILDING);
        registerItem(Items.SIGN, ItemCategory.BUILDING);
        registerItem(Items.BED, ItemCategory.BUILDING);
        registerItem(Items.ITEM_FRAME, ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.ANVIL), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.ENCHANTING_TABLE), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.END_STONE), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.ENDER_CHEST), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.TRAPPED_CHEST), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.BOOKSHELF), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.BONE_BLOCK), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.END_BRICKS), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.END_PORTAL_FRAME), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.WEB), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.MOB_SPAWNER), ItemCategory.BUILDING);
        registerItem(Item.getItemFromBlock(Blocks.WATERLILY), ItemCategory.BUILDING);

        registerItem(Item.getItemFromBlock(Blocks.AIR), ItemCategory.MISC);

    }

    public static void registerItem(Item item, ItemCategory category) {
        categories.put(item.getRegistryName().toString(), category);
    }

    public static boolean hasCategory(Item item) {
        return categories.containsKey(item.getRegistryName().toString());
    }

    public static ItemCategory getCategory(Item item) {
        return categories.get(item.getRegistryName().toString());
    }

}
