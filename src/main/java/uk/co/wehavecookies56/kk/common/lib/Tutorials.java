package uk.co.wehavecookies56.kk.common.lib;

import java.util.ArrayList;

import net.minecraft.util.ResourceLocation;

public class Tutorials {
	private static int index = 0;
	public static final int TUTORIAL_KEYBLADE = index++;
	public static final int TUTORIAL_KEYBLADE_2 = index++;
	public static final int TUTORIAL_MAGIC = index++;
	public static final int TUTORIAL_MAGIC_2 = index++;
	public static final int TUTORIAL_DRIVE = index++;
	public static final int TUTORIAL_DRIVE_2 = index++;
	public static final int TUTORIAL_DRIVE_3 = index++;
	
	//All the tutorials
	public static Tutorial 
		tutorialKeyblade = new Tutorial(TUTORIAL_KEYBLADE),
		tutorialKeyblade_2 = new Tutorial(TUTORIAL_KEYBLADE_2),
		tutorialMagic = new Tutorial(TUTORIAL_MAGIC),
		tutorialMagic2 = new Tutorial(TUTORIAL_MAGIC_2),
		tutorialDrive = new Tutorial(TUTORIAL_DRIVE),
		tutorialDrive2 = new Tutorial(TUTORIAL_DRIVE_2),
		tutorialDrive3 = new Tutorial(TUTORIAL_DRIVE_3);
	
	public static Tutorial[] tutorials = {
		tutorialKeyblade,tutorialMagic,tutorialMagic2,tutorialDrive,tutorialDrive2,tutorialDrive3
	};
	
	public static void initTutorials() {
		tutorialKeyblade.addNextTutorial(tutorialKeyblade_2);
		tutorialMagic.addNextTutorial(tutorialMagic2);
		tutorialDrive.addNextTutorial(tutorialDrive2);
		tutorialDrive2.addNextTutorial(tutorialDrive3);
	}
	
	public static Tutorial getTutorialById(int id) {
		for(Tutorial t : tutorials) {
			if(t.id == id) {
				return t;
			}
		}
		return null;
	}
	
	public static String[][] getLines(int num) {
		String[][] lines = new String[2][4];

		if(num == TUTORIAL_KEYBLADE) {
			lines[0][0]="The keyblades are the main weapons in the mod";
			lines[0][1]="It's a weapon which can defeat heartless and collect hearts";
			lines[0][2] = ":)";

			lines[1][0]="They can be obtained through the synthesis table";
			lines[1][1]="Or through being Roxas as a member of the Organization XIII";
			lines[1][2]="Or through being Roxas as a member of the Organization XIII 2";
			
		} else if(num == TUTORIAL_KEYBLADE_2) {
			lines[0][0] = "To equip it you must do things";
			lines[1][1] = "To equip it you must do things2";
		} /*else if(num == TUTORIAL_MAGIC) {
			lines.add("Magic 1");
			lines.add("Magic 2");
			lines.add("Magic 3");
			
		} else if(num == TUTORIAL_MAGIC_2) {
			lines.add("Magic2 1");
			lines.add("Magic2 2");

		} else if(num == TUTORIAL_DRIVE) {
			lines.add("Drive 1");

		} else if(num == TUTORIAL_DRIVE_2) {
			lines.add("Drive2 1");

		} else if(num == TUTORIAL_DRIVE_3) {
			lines.add("Drive3 1");
			lines.add("Drive3 2");

		}*/
			
		return lines;
	}
	
	public static ArrayList<ResourceLocation> getImages(int num) {
		ArrayList<ResourceLocation> images = new ArrayList<ResourceLocation>();

		if(num == TUTORIAL_KEYBLADE) {
			images.add(new ResourceLocation(Reference.MODID, "textures/gui/tutorials/keyblade/keyblade.png"));
			images.add(new ResourceLocation(Reference.MODID, "textures/gui/tutorials/keyblade/synthesistable.png"));
			
		}/* else if(num == TUTORIAL_KEYBLADE_2) {
			images.add("The keyblades are the main weapons in the mod");
			
		} else if(num == TUTORIAL_MAGIC) {
			images.add("Magic 1");
			images.add("Magic 2");
			images.add("Magic 3");
		} else if(num == TUTORIAL_MAGIC_2) {
			images.add("Magic2 1");
			images.add("Magic2 2");

		} else if(num == TUTORIAL_DRIVE) {
			images.add("Drive 1");

		} else if(num == TUTORIAL_DRIVE_2) {
			images.add("Drive2 1");

		} else if(num == TUTORIAL_DRIVE_3) {
			images.add("Drive3 1");
			images.add("Drive3 2");

		}*/
			
		return images;
	}
}
