package schwitzen.module.combat;

import org.lwjgl.input.Keyboard;

import schwitzen.events.listeners.EventUpdate;

public class NoSlowDown extends schwitzen.module.Module {

	public NoSlowDown() {
		super("NoslowDown", Keyboard.KEY_L, Category.COMBAT);
		
	}
	
	@Override
	public void onEnable() {
		
		super.onEnable();
	}
	
	
	public void onUpdate(EventUpdate event) {
		
		//if(mc.thePlayer.onGround && mc.thePlayer.moveForward!=0 && mc.thePlayer.isBlocking()&& !mc.thePlayer.isUsingItem() ) {
			//mc.thePlayer.motionX *= 1.4D;
			//mc.thePlayer.motionY = 0.2D;
			//mc.thePlayer.motionZ  *= 1.4D;
		}
		
		//if(mc.thePlayer.onGround && mc.thePlayer.isBlocking() && !mc.thePlayer.isUsingItem() && mc.thePlayer.moveForward !=0) {
			//mc.thePlayer.motionY = -1F;
		//}
		
	//}
	
	
	@Override
	public void onDisable() {
		
		super.onDisable();
	}

}
