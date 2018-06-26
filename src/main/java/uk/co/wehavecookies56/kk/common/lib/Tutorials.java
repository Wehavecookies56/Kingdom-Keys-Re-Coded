package uk.co.wehavecookies56.kk.common.lib;

import java.util.ArrayList;

import net.minecraft.util.ResourceLocation;

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

	// All the tutorials
	public static Tutorial tutorialKeyblade1 = new Tutorial(TUTORIAL_KEYBLADE_1);
	public static Tutorial tutorialKeyblade2 = new Tutorial(TUTORIAL_KEYBLADE_2);
	public static Tutorial tutorialMagic1 = new Tutorial(TUTORIAL_MAGIC_1);
	public static Tutorial tutorialMagic2 = new Tutorial(TUTORIAL_MAGIC_2);
	public static Tutorial tutorialDrive1 = new Tutorial(TUTORIAL_DRIVE_1);
	public static Tutorial tutorialDrive2 = new Tutorial(TUTORIAL_DRIVE_2);
	public static Tutorial tutorialDrive3 = new Tutorial(TUTORIAL_DRIVE_3);
	public static Tutorial tutorialSOA1 = new Tutorial(TUTORIAL_SOA_1);

	public static Tutorial[] tutorials = {
		tutorialKeyblade1,tutorialMagic1,tutorialMagic2,tutorialDrive1,tutorialDrive2,tutorialDrive3,tutorialSOA1
	};

	public static void initTutorials() {
		tutorialKeyblade1.addNextTutorial(tutorialKeyblade2);
		tutorialMagic1.addNextTutorial(tutorialMagic2);
		tutorialDrive1.addNextTutorial(tutorialDrive2);
		tutorialDrive2.addNextTutorial(tutorialDrive3);
	}

	public static Tutorial getTutorialById(int id) {
		for (Tutorial t : tutorials) {
			if (t.id == id) {
				return t;
			}
		}
		return null;
	}

	public static String[][] getLines(int num) {
		String[][] lines = new String[2][4];

		if (num == TUTORIAL_KEYBLADE_1) {
			lines[0][0] = "The keyblades are the main weapons in the mod";
			lines[0][1] = "It's a weapon which can defeat heartless and collect hearts";
			lines[0][2] = ":)";

			lines[1][0] = "They can be obtained through the synthesis table";
			lines[1][1] = "Or through being Roxas as a member of the Organization XIII";
			lines[1][2] = "Or through being Roxas as a member of the Organization XIII 2";

		} else if (num == TUTORIAL_KEYBLADE_2) {
			lines[0][0] = "To equip it you must do things";
			lines[1][1] = "To equip it you must do things2";

		} else if (num == TUTORIAL_MAGIC_1) {
			lines[0][0] = "Magic 1";
			lines[0][1] = "Magic 2";
			lines[0][2] = "Magic 3";

		} else if (num == TUTORIAL_MAGIC_2) {
			lines[0][0] = "Magic2 1";
			lines[0][1] = "Magic2 2";

		} else if (num == TUTORIAL_DRIVE_1) {
			lines[0][0] = "Drive 1";

		} else if (num == TUTORIAL_DRIVE_2) {
			lines[0][0] = "Drive2 1";

		} else if (num == TUTORIAL_DRIVE_3) {
			lines[0][0] = "Drive3 1";
			lines[0][1] = "Drive3 2";

		} else if (num == TUTORIAL_SOA_1) {
			lines[0][0] = "Welcome to Kingdom Keys!";
			lines[0][1] = "You are right now in the Station of Awakening";

		}

		return lines;
	}

	public static ArrayList<ResourceLocation> getImages(int num) {
		ArrayList<ResourceLocation> images = new ArrayList<ResourceLocation>();

		if (num == TUTORIAL_KEYBLADE_1) {
			images.add(new ResourceLocation(Reference.MODID, "textures/gui/tutorials/keyblade/keyblade.png"));
			images.add(new ResourceLocation(Reference.MODID, "textures/gui/tutorials/keyblade/synthesistable.png"));

		} else if (num == TUTORIAL_SOA_1) {
			images.add(new ResourceLocation(Reference.MODID, "textures/gui/tutorials/soa/soa.png"));
		} 

		return images;
	}
}
