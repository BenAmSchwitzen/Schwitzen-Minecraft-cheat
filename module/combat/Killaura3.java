package schwitzen.module.combat;

import java.awt.TextArea;

import org.lwjgl.input.Keyboard;


import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.client.C02PacketUseEntity;
import schwitzen.events.Event;
import schwitzen.events.EventMotion;
import schwitzen.events.listeners.EventUpdate;
import schwitzen.module.Module;
import schwitzen.util.Timer;

public class Killaura3 extends Module {
	
	Minecraft mc = Minecraft.getMinecraft();
	EntityLivingBase target;
	Timer timer = new Timer();

	public Killaura3() {
		super("Killraura3",Keyboard.KEY_N,Category.COMBAT);
		
	}
	
	
	
		public void onEvent(Event e) {
		
	
	          
		 target = getTarget();
			
		 
		 if(timer.hasTimeElapsed(10200/100,100,true)&&  target != null) {
			 mc.thePlayer.swingItem();
			 attack(target);
			 timer.reset();
			 
		 
		
		
		 }else {
			 return;
		 }
		
		
		
		
		
	}
	
	
	public EntityLivingBase getTarget() {
		
		EntityLivingBase entityLivingBase = null;
		
		
		
		for(Entity entity : mc.theWorld.loadedEntityList) {
			
			
			if(mc.thePlayer.getDistanceToEntity(entity)<4 && shouldAttack((EntityLivingBase)entity)) {
				
				
				
				entityLivingBase = (EntityLivingBase) entity;
				
			}
			
			
		}
		
		
		
		return (EntityLivingBase)entityLivingBase;
	}
	
	
	public boolean shouldAttack(EntityLivingBase entity) {
		
		if(entity != mc.thePlayer && mc.thePlayer.canEntityBeSeen(entity)  ) {
			
			return true;
			
		}else {
		   return false;
		}
		
		
		
	}
	
	public void attack(EntityLivingBase entity) {
		
		
		mc.thePlayer.sendQueue.addToSendQueue(new C02PacketUseEntity(target, net.minecraft.network.play.client.C02PacketUseEntity.Action.ATTACK));
		
		
	}
	
	@Override
	public void onEnable() {
		target = null;
		super.onEnable();
	}
	
	

}
