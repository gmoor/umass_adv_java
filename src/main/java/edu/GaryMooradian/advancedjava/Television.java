package edu.GaryMooradian.advancedjava;

enum Button {
	ON,OFF
}
public class Television {
	
	private RemoteControl rem;
	private int vol;
	private String mute;
	
	/*
	 * The Television requires a remote control to operate, therefore it is a dependency
	 * for the Television. Here, we inject the RemoteControl object upon instantiation of
	 * our Television. A Television object will always include a RemoteControl object.
	 */
	public Television(RemoteControl rem) {
		this.rem = rem;		
	}

	/*
	 * The volume is set only if it's greater than 0 and less
	 * than or equal to what the remote control allows.
	 */
	public String setVolume(int vol) {
		String msg = "";
		if (vol == 0) {
			msg = "invalid volume setting";
		} else if (vol <= rem.getMaxVolume()) {
			this.vol = vol;
		} else {
			msg = "This volume setting is not available";
		}
		return msg;
	}
	
	/*
	 * Returns the volume setting
	 */
	public int getVolume() {
		return vol;
	}
	
	/*
	 * The mute can be turned on or off if the option is provided by
	 * the remote. If not, the mute is set to off (i.e. no muting)
	 */
	public void setMute(Button b) {
		if (rem.getMuteAvailable()) {
			if (b == b.ON) {
				this.mute = "on";
			} else {//because of the enum, only other choice is OFF
				this.mute = "off";
			}			
		} else {
			//NOTE: Would need to modify setup value in TelevisionTest to do a test case for this
			//else condition. Not doing it for this umass class assignment 1.
			this.mute = "off";
		}
	}
	
	/*
	 * Returns the mute setting
	 */
	public String getMute() {
		return mute;
	}
	
}
