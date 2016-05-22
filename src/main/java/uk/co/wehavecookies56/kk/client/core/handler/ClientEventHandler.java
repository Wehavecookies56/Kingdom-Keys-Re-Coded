package uk.co.wehavecookies56.kk.client.core.handler;

import net.minecraft.client.audio.PositionedSound;
import net.minecraft.util.ResourceLocation;
import uk.co.wehavecookies56.kk.common.lib.Reference;

import java.util.Random;

public class ClientEventHandler {
	Random rand = new Random();
	PositionedSound posSound;
	PositionedSound vanillaSound;
	ResourceLocation resLoc = new ResourceLocation(Reference.MODID, "");
	boolean[] played = { false };
	boolean[] bossBattlePlayed = { false };
	boolean[] battlePlayed = { false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false };
	boolean[] menuPlayed = { false, false, false, false, false, false, false, false, false };

	int interval = 100;

	int clientTick = 0;
	float volume = 1.0f;

	/*
	PositionedSoundRecord currMusic = Music.sinisterSundown;

	@SubscribeEvent (priority = EventPriority.HIGHEST)
	public void clientTick (ClientTickEvent event) {

		if(ConfigHandler.EnableCustomMusic || ConfigHandler.ForceEnableCustomMusic) {

			if (event.phase == Phase.END) if (!(Minecraft.getMinecraft().currentScreen instanceof GuiMainMenu || Minecraft.getMinecraft().currentScreen instanceof GuiModList || Minecraft.getMinecraft().currentScreen instanceof GuiScreenServerList || Minecraft.getMinecraft().currentScreen instanceof GuiMultiplayer || Minecraft.getMinecraft().currentScreen instanceof GuiLanguage || Minecraft.getMinecraft().currentScreen instanceof GuiSelectWorld)) {
				SoundManager soundManager = ReflectionHelper.getPrivateValue(SoundHandler.class, Minecraft.getMinecraft().getSoundHandler(), "sndManager", "field_147694_f");
				Map playingSounds = ReflectionHelper.getPrivateValue(SoundManager.class, soundManager, "playingSounds", "field_148629_h");
				Iterator iter = playingSounds.keySet().iterator();
				while (iter.hasNext()) {
					Object o = iter.next();
					if (playingSounds.get(o) instanceof PositionedSound) {
						if (((PositionedSound) playingSounds.get(o)).getSoundLocation().getResourcePath().contains("music.game") && ((PositionedSound) playingSounds.get(o)).getSoundLocation().getResourceDomain() == "minecraft")
							Minecraft.getMinecraft().getSoundHandler().stopSound(((PositionedSound) playingSounds.get(o)));

						this.posSound = (PositionedSound) playingSounds.get(o);
						this.resLoc = ReflectionHelper.getPrivateValue(PositionedSound.class, this.posSound, "positionedSoundLocation", "field_147664_a");
					}
				}

				if ("music.game".equals(resLoc.getResourcePath()) || "music.game.creative".equals(resLoc.getResourcePath())) {
					Minecraft.getMinecraft().getSoundHandler().stopSound(this.posSound);
					this.resLoc = new ResourceLocation(Reference.MODID, "");
				}
				// TODO implement this boss thing into this hard file
				if (!EventHandler.isBoss) {
					// Minecraft.getMinecraft().getSoundHandler().stopSound(Music.sinisterSundown);
					// this.bossBattlePlayed[0] = false;
				}
				
				if (!EventHandler.isHostiles) {
					clientTick++;
					if (clientTick >= 20) {
						Minecraft.getMinecraft().getSoundHandler().stopSound(currMusic);
						clientTick = 0;
					}
				} else if (EventHandler.isHostiles) {
					if (!Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.aFightToTheDeath)
						&& !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.arabianDream)
						&& !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.beneathTheGround)
						&& !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.criticalDrive)
						&& !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.darkImpetus)
						&& !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.deepDrive)
						&& !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.deepDrop)
						&& !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.handInHand)
						&& !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.happyHolidays)
						&& !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.havingAWildTime)
						&& !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.lImpetoOscuro)
						&& !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.lOscuritaDellIgnoto)
						&& !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.monstrousMonstro)
						&& !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.nightOfFate)
						&& !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.nightOfTragedy)
						&& !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.rageAwakened)
						&& !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.riskyRomp)
						&& !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.savannahPride)
						&& !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.sinisterSundown)
						&& !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.spooksOfHalloweenTown)
						&& !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.tensionRising)
						&& !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.theDreadOfNight)
						&& !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.theRustlingForest)
						&& !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.toOurSurprise)
						&& !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.whatLiesBeneath)
						&& !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.workingTogether)
						&& !"music.game".equals(this.resLoc.getResourcePath()) && !"music.game.creative".equals(this.resLoc.getResourcePath())) { 
						int r = randomWithRange(0, 25);
						if (resLoc.getResourcePath().contains("music.game") || resLoc.getResourcePath().contains("music.game.creative")) Minecraft.getMinecraft().getSoundHandler().stopSound(this.posSound);
						Minecraft.getMinecraft().getSoundHandler().stopSound(this.posSound);
						if (r == 0 && !this.battlePlayed[0]) {
							if(!playingSounds.containsValue(Music.aFightToTheDeath)) {
								currMusic = Music.aFightToTheDeath;
								try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.aFightToTheDeath);}catch(Exception e){}
							}
							for (int i = 0; i < this.battlePlayed.length; i++)
								this.battlePlayed[i] = false;
							this.battlePlayed[0] = true;
							return;
						} else if (r == 1 && !this.battlePlayed[1]) {
							if(!playingSounds.containsValue(Music.arabianDream)) {
								currMusic = Music.arabianDream;
								try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.arabianDream);}catch(Exception e){}
							}
							for (int i = 0; i < this.battlePlayed.length; i++)
								this.battlePlayed[i] = false;
							this.battlePlayed[1] = true;
							return;
						} else if (r == 2 && !this.battlePlayed[2]) {
							if(!playingSounds.containsValue(Music.beneathTheGround)) {
								currMusic = Music.beneathTheGround;
								try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.beneathTheGround);}catch(Exception e){}
							}
							for (int i = 0; i < this.battlePlayed.length; i++)
								this.battlePlayed[i] = false;
							this.battlePlayed[2] = true;
							return;
						} else if (r == 3 && !this.battlePlayed[3]) {
							if(!playingSounds.containsValue(Music.criticalDrive)) {
								currMusic = Music.criticalDrive;
								try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.criticalDrive);}catch(Exception e){}
							}
							for (int i = 0; i < this.battlePlayed.length; i++)
								this.battlePlayed[i] = false;
							this.battlePlayed[3] = true;
							return;
						} else if (r == 4 && !this.battlePlayed[4]) {
							if(!playingSounds.containsValue(Music.darkImpetus)) {
								currMusic = Music.darkImpetus;
								try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.darkImpetus);}catch(Exception e){}
							}
							for (int i = 0; i < this.battlePlayed.length; i++)
								this.battlePlayed[i] = false;
							this.battlePlayed[4] = true;
							return;
						} else if (r == 5 && !this.battlePlayed[5]) {
							if(!playingSounds.containsValue(Music.deepDrive)) {
								currMusic = Music.deepDrive;
								try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.deepDrive);}catch(Exception e){}
							}
							for (int i = 0; i < this.battlePlayed.length; i++)
								this.battlePlayed[i] = false;
							this.battlePlayed[5] = true;
							return;
						} else if (r == 6 && !this.battlePlayed[6]) {
							if(!playingSounds.containsValue(Music.deepDrop)) {
								currMusic = Music.deepDrop;
								try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.deepDrop);}catch(Exception e){}
							}
							for (int i = 0; i < this.battlePlayed.length; i++)
								this.battlePlayed[i] = false;
							this.battlePlayed[6] = true;
							return;
						} else if (r == 7 && !this.battlePlayed[7]) {
							if(!playingSounds.containsValue(Music.handInHand)) {
								currMusic = Music.handInHand;
								try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.handInHand);}catch(Exception e){}
							}
							for (int i = 0; i < this.battlePlayed.length; i++)
								this.battlePlayed[i] = false;
							this.battlePlayed[7] = true;
							return;
						} else if (r == 8 && !this.battlePlayed[8]) {
							if(!playingSounds.containsValue(Music.happyHolidays)) {
								currMusic = Music.happyHolidays;
								try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.happyHolidays);}catch(Exception e){}
							}
							for (int i = 0; i < this.battlePlayed.length; i++)
								this.battlePlayed[i] = false;
							this.battlePlayed[8] = true;
							return;
						} else if (r == 9 && !this.battlePlayed[9]) {
							if(!playingSounds.containsValue(Music.havingAWildTime)) {
								currMusic = Music.havingAWildTime;
								try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.havingAWildTime);}catch(Exception e){}
							}
							for (int i = 0; i < this.battlePlayed.length; i++)
								this.battlePlayed[i] = false;
							this.battlePlayed[9] = true;
							return;
						}  else if (r == 10 && !this.battlePlayed[10]) {
							if(!playingSounds.containsValue(Music.lImpetoOscuro)) {
								currMusic = Music.lImpetoOscuro;
								try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.lImpetoOscuro);}catch(Exception e){}
							}
							for (int i = 0; i < this.battlePlayed.length; i++)
								this.battlePlayed[i] = false;
							this.battlePlayed[10] = true;
							return;
						} else if (r == 11 && !this.battlePlayed[11]) {
							if(!playingSounds.containsValue(Music.lOscuritaDellIgnoto)) {
								currMusic = Music.lOscuritaDellIgnoto;
								try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.happyHolidays);}catch(Exception e){}
							}
							for (int i = 0; i < this.battlePlayed.length; i++)
								this.battlePlayed[i] = false;
							this.battlePlayed[11] = true;
							return;
						} else if (r == 12 && !this.battlePlayed[12]) {
							if(!playingSounds.containsValue(Music.monstrousMonstro)) {
								currMusic = Music.monstrousMonstro;
								try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.monstrousMonstro);}catch(Exception e){}
							}
							for (int i = 0; i < this.battlePlayed.length; i++)
								this.battlePlayed[i] = false;
							this.battlePlayed[12] = true;
							return;
						} else if (r == 13 && !this.battlePlayed[13]) {
							if(!playingSounds.containsValue(Music.nightOfFate)) {
								currMusic = Music.nightOfFate;
								try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.nightOfFate);}catch(Exception e){}
							}
							for (int i = 0; i < this.battlePlayed.length; i++)
								this.battlePlayed[i] = false;
							this.battlePlayed[13] = true;
							return;
						} else if (r == 14 && !this.battlePlayed[14]) {
							if(!playingSounds.containsValue(Music.nightOfTragedy)) {
								currMusic = Music.nightOfTragedy;
								try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.nightOfTragedy);}catch(Exception e){}
							}
							for (int i = 0; i < this.battlePlayed.length; i++)
								this.battlePlayed[i] = false;
							this.battlePlayed[14] = true;
							return;
						} else if (r == 15 && !this.battlePlayed[15]) {
							if(!playingSounds.containsValue(Music.rageAwakened)) {
								currMusic = Music.rageAwakened;
								try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.rageAwakened);}catch(Exception e){}
							}
							for (int i = 0; i < this.battlePlayed.length; i++)
								this.battlePlayed[i] = false;
							this.battlePlayed[15] = true;
							return;
						} else if (r == 16 && !this.battlePlayed[16]) {
							if(!playingSounds.containsValue(Music.riskyRomp))
								currMusic = Music.riskyRomp;
								try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.riskyRomp);}catch(Exception e){}
							for (int i = 0; i < this.battlePlayed.length; i++)
								this.battlePlayed[i] = false;
							this.battlePlayed[16] = true;
							return;
						} else if (r == 17 && !this.battlePlayed[17]) {
							if(!playingSounds.containsValue(Music.savannahPride)) {
								currMusic = Music.savannahPride;
								try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.savannahPride);}catch(Exception e){}
							}
							for (int i = 0; i < this.battlePlayed.length; i++)
								this.battlePlayed[i] = false;
							this.battlePlayed[17] = true;
							return;
						} else if (r == 18 && !this.battlePlayed[18]) {
							if(!playingSounds.containsValue(Music.sinisterSundown)) {
								currMusic = Music.sinisterSundown;
								try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.sinisterSundown);}catch(Exception e){}
							}
							for (int i = 0; i < this.battlePlayed.length; i++)
								this.battlePlayed[i] = false;
							this.battlePlayed[18] = true;
							return;
						} else if (r == 19 && !this.battlePlayed[19]) {
							if(!playingSounds.containsValue(Music.spooksOfHalloweenTown)) {
								currMusic = Music.spooksOfHalloweenTown;
								try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.spooksOfHalloweenTown);}catch(Exception e){}
							}
							for (int i = 0; i < this.battlePlayed.length; i++)
								this.battlePlayed[i] = false;
							this.battlePlayed[19] = true;
							return;
						} else if (r == 20 && !this.battlePlayed[20]) {
							if(!playingSounds.containsValue(Music.tensionRising)) {
								currMusic = Music.tensionRising;
								try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.tensionRising);}catch(Exception e){}
							}
							for (int i = 0; i < this.battlePlayed.length; i++)
								this.battlePlayed[i] = false;
							this.battlePlayed[20] = true;
							return;
						} else if (r == 21 && !this.battlePlayed[21]) {
							if(!playingSounds.containsValue(Music.theDreadOfNight)) {
								currMusic = Music.theDreadOfNight;
								try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.theDreadOfNight);}catch(Exception e){}
							}
							for (int i = 0; i < this.battlePlayed.length; i++)
								this.battlePlayed[i] = false;
							this.battlePlayed[21] = true;
							return;
						} else if (r == 22 && !this.battlePlayed[22]) {
							if(!playingSounds.containsValue(Music.theRustlingForest)) {
								currMusic = Music.theRustlingForest;
								try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.theRustlingForest);}catch(Exception e){}
							}
							for (int i = 0; i < this.battlePlayed.length; i++)
								this.battlePlayed[i] = false;
							this.battlePlayed[22] = true;
							return;
						} else if (r == 23 && !this.battlePlayed[23]) {
							if(!playingSounds.containsValue(Music.toOurSurprise)) {
								currMusic = Music.toOurSurprise;
								try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.toOurSurprise);}catch(Exception e){}
							}
							for (int i = 0; i < this.battlePlayed.length; i++)
								this.battlePlayed[i] = false;
							this.battlePlayed[23] = true;
							return;
						} else if (r == 24 && !this.battlePlayed[24]) {
							if(!playingSounds.containsValue(Music.whatLiesBeneath)) {
								currMusic = Music.whatLiesBeneath;
								try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.whatLiesBeneath);}catch(Exception e){}
							}
							for (int i = 0; i < this.battlePlayed.length; i++)
								this.battlePlayed[i] = false;
							this.battlePlayed[24] = true;
							return;
						} else if (r == 25 && !this.battlePlayed[25]) {
							if(!playingSounds.containsValue(Music.workingTogether)) {
								currMusic = Music.workingTogether;
								try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.workingTogether);}catch(Exception e){}
							}
							for (int i = 0; i < this.battlePlayed.length; i++)
								this.battlePlayed[i] = false;
							this.battlePlayed[25] = true;
							return;
						}
					}
				}
			} else {
				SoundManager soundManager = ReflectionHelper.getPrivateValue(SoundHandler.class, Minecraft.getMinecraft().getSoundHandler(), "sndManager", "field_147694_f");
				Map playingSounds = ReflectionHelper.getPrivateValue(SoundManager.class, soundManager, "playingSounds", "field_148629_h");
				Iterator iter = playingSounds.keySet().iterator();

				while (iter.hasNext()) {
					Object o = iter.next();
					if (playingSounds.get(o) instanceof PositionedSound) {
						if (((PositionedSound) playingSounds.get(o)).getSoundLocation().getResourcePath().equals("music.menu")) Minecraft.getMinecraft().getSoundHandler().stopSound(((PositionedSound) playingSounds.get(o)));
						this.posSound = (PositionedSound) playingSounds.get(o);
						this.resLoc = ReflectionHelper.getPrivateValue(PositionedSound.class, this.posSound, "positionedSoundLocation", "field_147664_a");
					}
				}

				if ("music.menu".equals(resLoc.getResourcePath())) {
					Minecraft.getMinecraft().getSoundHandler().stopSound(this.posSound);
					this.resLoc = new ResourceLocation(Reference.MODID, "");
				}
				if (!Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.dearlyBelovedDDD) && !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.dearlyBelovedBBS) && !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.dearlyBelovedKH1) && !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.dearlyBelovedKH2) && !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.dearlyBelovedReCoM) && !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.dearlyBelovedCoM) && !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.dearlyBelovedCoded) && !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.dearlyBelovedDays) && !Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.dearlyBelovedChi) && !"music.menu".equals(this.resLoc.getResourcePath())) {

					int r = randomWithRange(0, 8);
					if (resLoc.getResourcePath().contains("music.menu")) Minecraft.getMinecraft().getSoundHandler().stopSound(this.posSound);
					Minecraft.getMinecraft().getSoundHandler().stopSound(this.posSound);
					if (r == 0 && !this.menuPlayed[0]) {
						if(!playingSounds.containsValue(Music.dearlyBelovedKH1))
							try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.dearlyBelovedKH1);}catch(Exception e){}
						for (int i = 0; i < this.menuPlayed.length; i++)
							this.menuPlayed[i] = false;
						this.menuPlayed[0] = true;
						return;
					} else if (r == 1 && !this.menuPlayed[1]) {
						if(!playingSounds.containsValue(Music.dearlyBelovedKH2))
							try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.dearlyBelovedKH2);}catch(Exception e){}
						for (int i = 0; i < this.menuPlayed.length; i++)
							this.menuPlayed[i] = false;
						this.menuPlayed[1] = true;
						return;
					} else if (r == 2 && !this.menuPlayed[2]) {
						if(!playingSounds.containsValue(Music.dearlyBelovedBBS))
							try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.dearlyBelovedBBS);}catch(Exception e){}
						for (int i = 0; i < this.menuPlayed.length; i++)
							this.menuPlayed[i] = false;
						this.menuPlayed[2] = true;
						return;
					} else if (r == 3 && !this.menuPlayed[3]) {
						if(!playingSounds.containsValue(Music.dearlyBelovedDDD))
							try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.dearlyBelovedDDD);}catch(Exception e){}
						for (int i = 0; i < this.menuPlayed.length; i++)
							this.menuPlayed[i] = false;
						this.menuPlayed[3] = true;
						return;
					} else if (r == 4 && !this.menuPlayed[4]) {
						if(!playingSounds.containsValue(Music.dearlyBelovedDays))
							try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.dearlyBelovedDays);}catch(Exception e){}
						for (int i = 0; i < this.menuPlayed.length; i++)
							this.menuPlayed[i] = false;
						this.menuPlayed[4] = true;
						return;
					} else if (r == 5 && !this.menuPlayed[5]) {
						if(!playingSounds.containsValue(Music.dearlyBelovedCoded))
							try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.dearlyBelovedCoded);}catch(Exception e){}
						for (int i = 0; i < this.menuPlayed.length; i++)
							this.menuPlayed[i] = false;
						this.menuPlayed[5] = true;
						return;
					} else if (r == 6 && !this.menuPlayed[6]) {
						if(!playingSounds.containsValue(Music.dearlyBelovedCoM))
							try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.dearlyBelovedCoM);}catch(Exception e){}
						for (int i = 0; i < this.menuPlayed.length; i++)
							this.menuPlayed[i] = false;
						this.menuPlayed[6] = true;
						return;
					} else if (r == 7 && !this.menuPlayed[7]) {
						if(!playingSounds.containsValue(Music.dearlyBelovedReCoM))
							try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.dearlyBelovedReCoM);}catch(Exception e){}
						for (int i = 0; i < this.menuPlayed.length; i++)
							this.menuPlayed[i] = false;
						this.menuPlayed[7] = true;
						return;
					} else if (r == 8 && !this.menuPlayed[8]) {
						if(!playingSounds.containsValue(Music.dearlyBelovedChi))
							try{Minecraft.getMinecraft().getSoundHandler().playSound(Music.dearlyBelovedChi);}catch(Exception e){}
						for (int i = 0; i < this.menuPlayed.length; i++)
							this.menuPlayed[i] = false;
						this.menuPlayed[8] = true;
						return;
					}
				}
			}
		}
	}
	*/

	public static int randomWithRange (int min, int max) {
		int range = Math.abs(max - min) + 1;
		return (int) (Math.random() * range) + (min <= max ? min : max);
	}
}