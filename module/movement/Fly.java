package schwitzen.module.movement;

import org.lwjgl.input.Keyboard;



import schwitzen.events.Event;
import schwitzen.events.listeners.EventUpdate;
import schwitzen.module.Module;

public class Fly extends Module {

	public Fly() {
		super("Fly", Keyboard.KEY_F, Category.MOVEMENT);
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			
			if(e.isPre()) {
				//mc.thePlayer.capabilities.isFlying = true;
				//mc.thePlayer.moveFlying(100, 150L, 0);
				
				 mc.thePlayer.setVelocity(0, 0, 0);
		            mc.thePlayer.jumpMovementFactor = 1.51f;
		            if (mc.gameSettings.keyBindJump.isKeyDown()) {
		                mc.thePlayer.motionY += 0.5f;
		            }
		            if (mc.gameSettings.keyBindSneak.isKeyDown()) {
		                mc.thePlayer.motionY -= 0.5f;
		            }
		            mc.thePlayer.setSprinting(false);
		            float forward = 0;
		            float strafe = 0;
		            if (mc.gameSettings.keyBindForward.isKeyDown()) {
		                forward++;
		            }
		            if (mc.gameSettings.keyBindBack.isKeyDown()) {
		                forward--;
		            }
		            if (mc.gameSettings.keyBindLeft.isKeyDown()) {
		                strafe++;
		            }
		            if (mc.gameSettings.keyBindRight.isKeyDown()) {
		                strafe--;
		            }
		            mc.thePlayer.setAIMoveSpeed(0.1f);
		         
		        }
		    }
				
			}
			
		
		
	
	
	public void onEnable() {
		
		
		
		
	}
	
	public void onDisable() {
		
		mc.thePlayer.capabilities.isFlying = false;
		mc.thePlayer.capabilities.allowFlying = false;
	}

}
