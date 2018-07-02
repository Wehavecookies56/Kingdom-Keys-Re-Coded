package uk.co.wehavecookies56.kk.common.lib;

import java.util.ArrayList;

import net.minecraft.util.ResourceLocation;
import uk.co.wehavecookies56.kk.common.item.ModItems;

public class Tutorials {
	private static int index = 0;
	public static final int TUTORIAL_KEYBLADE_1 = index++;
	public static final int TUTORIAL_KEYBLADE_2 = index++;
	public static final int TUTORIAL_MAGIC_1 = index++;
	public static final int TUTORIAL_MAGIC_2 = index++;
	public static final int TUTORIAL_DRIVE_1 = index++;
	public static final int TUTORIAL_DRIVE_2 = index++;
	public static final int TUTORIAL_DRIVE_3 = index++;
	public static final int TUTORIAL_SOA_1 = index++;
	public static final int TUTORIAL_SWORD_1 = index++;
	public static final int TUTORIAL_STAFF_1 = index++;
	public static final int TUTORIAL_SHIELD_1 = index++;
//	public static final int TUTORIAL_ABILITIES_1 = index++;

	public static Tutorial[] tutorials = {
		new Tutorial(TUTORIAL_KEYBLADE_1,"Keyblade"),
		new Tutorial(TUTORIAL_KEYBLADE_2, "Keyblade 2"),
		new Tutorial(TUTORIAL_MAGIC_1, "Magic"),
		new Tutorial(TUTORIAL_MAGIC_2, "Magic 2"), 
		new Tutorial(TUTORIAL_DRIVE_1, "Drive"), 
		new Tutorial(TUTORIAL_DRIVE_2, "Drive 2"), 
		new Tutorial(TUTORIAL_DRIVE_3, "Drive 3"), 
		new Tutorial(TUTORIAL_SOA_1, "Station of Awakening"),
		new Tutorial(TUTORIAL_SWORD_1, "Station of Awakening Sword"),
		new Tutorial(TUTORIAL_STAFF_1, "Station of Awakening Staff"),
		new Tutorial(TUTORIAL_SHIELD_1, "Station of Awakening Shield"),

		//new Tutorial(TUTORIAL_ABILITIES_1,"Abilities")
	};
	
	public static void initTutorials() {
		tutorials[TUTORIAL_KEYBLADE_1].addNextTutorial(tutorials[TUTORIAL_KEYBLADE_2]);
		tutorials[TUTORIAL_MAGIC_1].addNextTutorial(tutorials[TUTORIAL_MAGIC_2]);
		tutorials[TUTORIAL_DRIVE_1].addNextTutorial(tutorials[TUTORIAL_DRIVE_2]);
		tutorials[TUTORIAL_DRIVE_2].addNextTutorial(tutorials[TUTORIAL_DRIVE_3]);
		/*tutorials[TUTORIAL_SOA_1].addNextTutorial(tutorials[TUTORIAL_SOA_2]);
		tutorials[TUTORIAL_SOA_2].addNextTutorial(tutorials[TUTORIAL_SOA_3]);
		tutorials[TUTORIAL_SOA_3].addNextTutorial(tutorials[TUTORIAL_SOA_4]);*/
	}

	public static Tutorial getTutorialById(int id) {
		for (Tutorial t : tutorials) {
			if (t.id == id) {
				return t;
			}
		}
		return null;
	}

	public static Tutorial getRoot(int id) {
		Tutorial tuto = getTutorialById(id);
		while (tuto.prevTutorial != null) {
			tuto = tuto.prevTutorial;
		}
		return tuto;
	}

	public static String getTutorialName(int id) {
		return getTutorialById(id).getTutorialName();
	}

	public static String[][] getLines(int num) {
		String[][] lines = new String[2][4];
		String prefix = "tutorial.";
		if(num == TUTORIAL_KEYBLADE_1) {
			prefix += "keyblade1";
		
		} else if (num == TUTORIAL_KEYBLADE_2) {
			prefix +="keyblade2";
			
		} else if (num == TUTORIAL_MAGIC_1) {
			prefix +="magic1";

		} else if (num == TUTORIAL_MAGIC_2) {
			prefix +="magic2";

		} else if (num == TUTORIAL_DRIVE_1) {
			prefix +="drive1";

		} else if (num == TUTORIAL_DRIVE_2) {
			prefix +="drive2";

		} else if (num == TUTORIAL_DRIVE_3) {
			prefix +="drive3";

		} else if (num == TUTORIAL_SOA_1) {
			prefix +="soa1";
			
		} else if (num == TUTORIAL_SWORD_1) {
			prefix +="soa2";

		} else if (num == TUTORIAL_STAFF_1) {
			prefix +="soa3";
			
		} else if (num == TUTORIAL_SHIELD_1) {
			prefix +="soa4";
		}	
		/* else if (num == TUTORIAL_ABILITIES_1) {
			prefix +="abilities1";
		}*/
		
		
		for (int i = 0; i < lines.length; i++) {
			for (int j = 0; j < lines[0].length; j++) {
				lines[i][j] = prefix + "." + i + "." + j;
			}
		}

		return lines;
	}

	public static ArrayList<ResourceLocation> getImages(int num) {
		ArrayList<ResourceLocation> images = new ArrayList<ResourceLocation>();

		if (num == TUTORIAL_KEYBLADE_1) {
			images.add(new ResourceLocation(Reference.MODID, "textures/gui/tutorials/keyblade.png"));
			images.add(new ResourceLocation(Reference.MODID, "textures/blocks/synthesistable.png"));

		} else if (num == TUTORIAL_MAGIC_1) {
			images.add(new ResourceLocation(Reference.MODID, "textures/items/levelupmagicfire.png"));
			images.add(new ResourceLocation(Reference.MODID, "textures/gui/tutorials/magics.png"));

		} else if (num == TUTORIAL_MAGIC_2) {
			images.add(new ResourceLocation(Reference.MODID, "textures/gui/tutorials/mpbar.png"));
			images.add(new ResourceLocation(Reference.MODID, "textures/gui/tutorials/mpbarr.png"));

		} else if (num == TUTORIAL_DRIVE_1) {
			images.add(new ResourceLocation(Reference.MODID, "textures/items/levelupdrivevalor.png"));
			images.add(new ResourceLocation(Reference.MODID, "textures/gui/tutorials/forms.png"));
			
		} else if (num == TUTORIAL_DRIVE_2) {
			images.add(new ResourceLocation(Reference.MODID, "textures/gui/tutorials/drivebar.png"));
			images.add(new ResourceLocation(Reference.MODID, "textures/gui/tutorials/drivebarf.png"));
			
		} else if (num == TUTORIAL_DRIVE_3) {
			images.add(new ResourceLocation(Reference.MODID, "textures/gui/tutorials/keychains.png"));
			images.add(new ResourceLocation(Reference.MODID, "textures/gui/tutorials/formbar.png"));

		} else if (num == TUTORIAL_SOA_1) {
			images.add(new ResourceLocation(Reference.MODID, "textures/gui/tutorials/soa.png"));
			images.add(new ResourceLocation(Reference.MODID, "textures/items/keyblades/dreamsword.png"));
		}

		return images;
	}
}
