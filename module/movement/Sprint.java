package schwitzen.module.movement;

import org.lwjgl.input.Keyboard;



import schwitzen.events.Event;
import schwitzen.events.listeners.EventUpdate;
import schwitzen.module.Module;

public class Sprint extends Module {

	public Sprint() {
		super("Sprint", Keyboard.KEY_G, Category.MOVEMENT);
		this.toggled = true;
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			
			if(e.isPre()) {
				
				if(mc.thePlayer.moveForward>0 &&  !mc.thePlayer.isUsingItem()) {
					mc.thePlayer.setSprinting(true);
				}
				
			}
			
		}
		
	}
	
	public void onEnable() {
		
	
		
		
	}
	
	public void onDisable() {
		
		mc.thePlayer.setSprinting(mc.gameSettings.keyBindSprint.isPressed() && !mc.thePlayer.isSneaking() && !mc.thePlayer.isCollidedVertically);
		
	}

}
