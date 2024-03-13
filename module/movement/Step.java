package schwitzen.module.movement;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.C03PacketPlayer;
import schwitzen.events.Event;
import schwitzen.events.EventMotion;
import schwitzen.events.listeners.EventUpdate;
import schwitzen.module.Module;

public class Step extends Module {

	public Step() {
		super("Step",Keyboard.KEY_V,Category.PLAYER);
		
	}
	
	

	
	
	@Override
	public void onDisable() {
		
		mc.thePlayer.stepHeight =  0;
		
		super.onDisable();
	}
	
	@Override
	public void onEnable() {
		
		mc.thePlayer.stepHeight =  1.5F;
		super.onEnable();
	}
	
	
}
