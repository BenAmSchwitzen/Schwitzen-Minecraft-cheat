package schwitzen.module.player;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.C03PacketPlayer;
import schwitzen.events.Event;
import schwitzen.events.listeners.EventUpdate;
import schwitzen.module.Module;

public class NoFall extends Module {

	public NoFall() {
		super("NoFall", Keyboard.KEY_O, Category.PLAYER);
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			
			if(e.isPre()) {
				if(mc.thePlayer.fallDistance>2) {
					mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(true));
					
				}
				
				
				
			}
			
		}
		
	}
	
	public void onEnable() {
		
	
		
		
	}
	
	public void onDisable() {
		
		
		
	}

}
