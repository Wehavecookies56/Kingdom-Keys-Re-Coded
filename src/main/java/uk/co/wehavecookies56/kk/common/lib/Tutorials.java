package uk.co.wehavecookies56.kk.common.lib;

import java.util.ArrayList;

public class Tutorials {
	static final int TUTORIAL_KEYBLADE = 0;
	static final int TUTORIAL_MAGIC = 1;
	static final int TUTORIAL_MAGIC_2 = 2;
	static final int TUTORIAL_DRIVE = 3;
	static final int TUTORIAL_DRIVE_2 = 4;
	static final int TUTORIAL_DRIVE_3 = 5;
	
	//All the tutorials
	public static Tutorial 
		tutorialKeyblade = new Tutorial(TUTORIAL_KEYBLADE),
		tutorialMagic = new Tutorial(TUTORIAL_MAGIC),
		tutorialMagic2 = new Tutorial(TUTORIAL_MAGIC_2),
		tutorialDrive = new Tutorial(TUTORIAL_DRIVE),
		tutorialDrive2 = new Tutorial(TUTORIAL_DRIVE_2),
		tutorialDrive3 = new Tutorial(TUTORIAL_DRIVE_3);
	
	public static Tutorial[] tutorials = {
		tutorialKeyblade,tutorialMagic,tutorialMagic2,tutorialDrive,tutorialDrive2,tutorialDrive3		
	};
	
	public static void initTutorials() {
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
	
	public static ArrayList<String> getLines(int num) {
		ArrayList<String> lines = new ArrayList<String>();

		switch(num) {
		case TUTORIAL_KEYBLADE:
			lines.add("Keyblade 1");
			lines.add("Keyblade 2");
			break;
		case TUTORIAL_MAGIC:
			lines.add("Magic 1");
			lines.add("Magic 2");
			lines.add("Magic 3");
			
			break;
		case TUTORIAL_MAGIC_2:
			lines.add("Magic2 1");
			lines.add("Magic2 2");
			break;
		case TUTORIAL_DRIVE:
			lines.add("Drive 1");

			break;
		case TUTORIAL_DRIVE_2:
			lines.add("Drive2 1");

			break;
		case TUTORIAL_DRIVE_3:
			lines.add("Drive3 1");
			lines.add("Drive3 2");
			break;
		}
		
		return lines;
	}
}
