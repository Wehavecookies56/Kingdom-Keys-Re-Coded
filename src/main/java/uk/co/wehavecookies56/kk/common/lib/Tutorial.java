package uk.co.wehavecookies56.kk.common.lib;

import java.util.ArrayList;

import net.minecraft.util.ResourceLocation;

public class Tutorial {
	int id;
	String name;
	Tutorial nextTutorial;
	Tutorial prevTutorial;

	public Tutorial(int idTutorial, String name) {
		this.id = idTutorial;
		this.name = name;
		this.nextTutorial = null;
		this.prevTutorial = null;
	}
	
	public int getTutorialID() {
		return id;
	}
	
	public String getTutorialName() {
		return name;
	}

	public String[][] getTutorialText() {
		return Tutorials.getLines(id);
	}
	
	public ArrayList<ResourceLocation> getTutorialImages() {
		return Tutorials.getImages(id);
	}
	
	public boolean hasPrev() {
		return prevTutorial != null;
	}
	
	public Tutorial getPrev() {
		return prevTutorial;
	}
	
	public void addPrevTutorial(Tutorial tutorial) {
		this.prevTutorial = tutorial;
	}
	
	public boolean hasNext() {
		return nextTutorial != null;
	}
	
	public Tutorial getNext() {
		return nextTutorial;
	}
	
	public void addNextTutorial(Tutorial tutorial) {
		this.nextTutorial = tutorial;
		this.nextTutorial.addPrevTutorial(this);
	}

	public Tutorial getRoot() {
		Tutorial tuto = this;
		while(tuto.prevTutorial != null) {
			tuto = tuto.prevTutorial;
		}
		return tuto;
	}
}
