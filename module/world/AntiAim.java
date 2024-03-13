package schwitzen.module.world;

import java.util.Random;

import org.lwjgl.input.Keyboard;


import schwitzen.events.Event;
import schwitzen.module.Module;
import schwitzen.util.Timer;

public class AntiAim extends Module {
	
	Timer timer = new Timer();
	Random random = new Random();

	public AntiAim() {
		super("AntiAim",Keyboard.KEY_B,Category.World);
		
	}
	
	@Override
	public void onEvent(Event e) {
		
		if(timer.hasTimeElapsed(5000/100, 100, false)) {
			
			mc.thePlayer.rotationPitch = random.nextFloat(10)+1;
			
			
			
		}
		
		
		super.onEvent(e);
	}

}
