package edu.GaryMooradian.advancedjava;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TelevisionTest {
	private RemoteControl rem;
	
	@Before
	public void setup() {
		//establish max volume for this remote control (our dependency object), and mute availability
		this.rem = new SamsungRemote(50, true);
	}
	
	
	
	@Test
	public void testSetVolumePositive() {
		int vol = 30;
		/*
		 * Create the television object, passing it the dependency object
		 * (i.e. the remote control object), established in the setup.
		 */
		Television tv = new Television(rem);
		
		/*
		 * pass the volume to the method we are testing
		 */
		tv.setVolume(vol);
		
		/*
		 * Verify that this volume setting was established in the class variable
		 * (i.e. established for this Television object)
		 */
		assertEquals("The volume setting is valid", tv.getVolume(), vol);
	}
	
	@Test
	public void testSetVolumeNegative1() {
		int vol = 0;
		Television tv = new Television(rem);
		
		/*
		 * Verify the proper message is returned
		 */
		assertEquals("Invalid volume setting", "invalid volume setting", tv.setVolume(vol));
	}
	
	@Test
	public void testSetVolumeNegative2() {
		int vol = 70;
		Television tv = new Television(rem);
		
		/*
		 * Verify the proper message is returned
		 */
		assertEquals("Unavailable volume setting", "This volume setting is not available", tv.setVolume(vol));
		
		/*
		 * Also verify that the object's volume was not set with this unavailable volume
		 */
		assertNotEquals(tv.getVolume(), vol);
	}
	
	@Test
	public void testSetMutePositive1() {
		Television tv = new Television(rem);
		tv.setMute(Button.ON);
		assertTrue(tv.getMute().equals("on"));
	}
	
	@Test
	public void testSetMutePositive2() {
		Television tv = new Television(rem);
		tv.setMute(Button.OFF);
		assertTrue(tv.getMute().equals("off"));
	}
	
	@Test
	public void testSetMuteNegative1() {
		this.rem = new SamsungRemote(50, false);
		Television tv = new Television(rem);
		tv.setMute(Button.ON);
		assertTrue(tv.getMute().equals("off"));
	}
	
	@Test
	public void testSetMuteNegative2() {
		this.rem = new SamsungRemote(50, false);
		Television tv = new Television(rem);
		tv.setMute(Button.OFF);
		assertTrue(tv.getMute().equals("off"));
	}
	

}
