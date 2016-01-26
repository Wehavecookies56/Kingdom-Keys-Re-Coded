package wehavecookies56.kk.lib;

import java.util.HashMap;
import java.util.Map;

import wehavecookies56.kk.util.TextHelper;

public class Constants {

	public static final int
	//Input
	LEFT_MOUSE = 0,
	RIGHT_MOUSE = 1,
	MIDDLE_MOUSE = 2,
	WHEEL_UP = -1,
	WHEEL_DOWN = 1,

	//MC Gamesettings
	//Gui scale
	SCALE_AUTO = 0,
	SCALE_SMALL = 1,
	SCALE_NORMAL = 2,
	SCALE_LARGE = 3,

	//OTHER
	TICKS_PER_SECOND = 20
	;

	//MP Costs
	public static final int
	FIRE_COST = 20,
	BLIZZARD_COST = 15,
	THUNDER_COST = 30,
	GRAVITY_COST = 25,
	AERO_COST = 20,
	STOP_COST = 15
	;
	
	public static Map<String, Integer> costs;
	
	public static void registerCosts(){
		costs = new HashMap<String, Integer>();
		costs.put("gui.commandmenu.magic.fire", 20);
		costs.put("gui.commandmenu.magic.blizzard", 15);
		costs.put("gui.commandmenu.magic.thunder", 30);
		costs.put("gui.commandmenu.magic.gravity", 25);
		costs.put("gui.commandmenu.magic.aero", 20);
		costs.put("gui.commandmenu.magic.stop", 15);
		costs.put("gui.commandmenu.magic.cure", -1);
	}
	
	public static int getCost(String name){
		System.out.println(name);
		return costs.get(name);
	}

	//Drive abilities
	public static double
	VALOR_SPEED = 1.1,
	VALOR_JUMP_1 = 1.08,
	VALOR_JUMP_2 = 1.1,
	VALOR_JUMP_3 = 1.15, //has to check if is safe

	FINAL_SPEED = 1.23,
	FINAL_JUMP = 1.08,
	FINAL_GLIDE_1= 0.6;
	;

	public static final double
	PLAYER_WALKSPEED = 0.10000000149011612D,
	PLAYER_JUMP = 0.42D;
	;

}
