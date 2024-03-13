package schwitzen.module.movement;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.client.C02PacketUseEntity;
import schwitzen.Client;
import schwitzen.events.Event;
import schwitzen.events.EventMotion;
import schwitzen.events.listeners.EventUpdate;
import schwitzen.module.Module;
import schwitzen.module.ModuleManager;
import schwitzen.util.Timer;


public class Speed extends Module {
	
	Timer timer = new Timer();

	public Speed() {
		super("Speed", Keyboard.KEY_H, Category.MOVEMENT);
		
	}
	
	
			
			
			@Override
			public void onEvent(Event e) {
				
				
				
				
				if(mc.thePlayer.onGround) {
					mc.thePlayer.jump();
					mc.thePlayer.motionX*=1.2;
					mc.thePlayer.motionY*=0.2;
					mc.thePlayer.motionZ*=0.8;

				// die Geschwindigkeit berechnen (hier als Beispiel 1.0)
			

				
				super.onEvent(e);
			
	
	
	
	
		
	
		   
				        
	        
	
	
	


}

			}}