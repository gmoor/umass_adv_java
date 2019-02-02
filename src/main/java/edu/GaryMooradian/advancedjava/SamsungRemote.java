package edu.GaryMooradian.advancedjava;

public class SamsungRemote implements RemoteControl{
	int maxVol;
	boolean muteAvailable;
	
	/*
	 * CONSTRUCTOR
	 * Parameters set the maximum volume, and whether mute option exists
	 * This object is a dependency for the Television object, and will be passed (injected)
	 * to the Television class's constructor when instantiating the Television class
	 */
	public SamsungRemote(int maxVol, boolean muteAvailable) {
		this.maxVol = maxVol;
		this.muteAvailable = muteAvailable;
	}

	/*
	 * returns the maximum volume
	 */
	public int getMaxVolume() {
		return maxVol;
	}
	
	/*
	 * returns the mute availability; true or false
	 */
	public boolean getMuteAvailable() {
		return muteAvailable;
	}

}
