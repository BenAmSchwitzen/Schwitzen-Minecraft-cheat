package schwitzen.module.combat;

import org.lwjgl.input.Keyboard;

import io.netty.util.internal.chmv8.ConcurrentHashMapV8.ObjectByObjectToDouble;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import schwitzen.events.Event;
import schwitzen.events.listeners.EventUpdate;

public class Antibot extends schwitzen.module.Module {

	public Antibot() {
		super("Antibot",Keyboard.KEY_L,Category.COMBAT);
		
	}
	
	public void onevent(Event e) {
		
		mc.thePlayer.jump();
		
		for(Object entity : mc.theWorld.loadedEntityList) {
			
			if(((Entity)entity).isInvisible() &&entity!=mc.thePlayer) {
				mc.theWorld.removeEntity((Entity)entity);
			}
		}
		
		
		for(Object entity : mc.theWorld.loadedEntityList) {
			if(((Entity)entity).isInvisible() && ((Entity) entity) != mc.thePlayer && !((Entity)entity).onGround) {
				mc.theWorld.removeEntity(((Entity)entity));
			}
			if(((Entity)entity) instanceof EntityPlayer && ((Entity)entity) != mc.thePlayer) {
				EntityPlayer entity1 = (EntityPlayer) entity;
				if(Float.isNaN(entity1.getHealth())) {
					mc.theWorld.removeEntity(entity1);
				}
			} else {
				
			}
			if(mc.thePlayer == null || mc.theWorld == null) {
				return;
			}
		}
	}
		
	
	
	public void onUpdate(EventUpdate event) {
		
		mc.thePlayer.jump();
		
		for(Object entity : mc.theWorld.loadedEntityList) {
			if(((Entity)entity).isInvisible() && ((Entity) entity) != mc.thePlayer && !((Entity)entity).onGround) {
				mc.theWorld.removeEntity(((Entity)entity));
			}
			if(((Entity)entity) instanceof EntityPlayer && ((Entity)entity) != mc.thePlayer) {
				EntityPlayer entity1 = (EntityPlayer) entity;
				if(Float.isNaN(entity1.getHealth())) {
					mc.theWorld.removeEntity(entity1);
				}
			} else {
				
			}
			if(mc.thePlayer == null || mc.theWorld == null) {
				return;
			}
		}
	}
	
	@Override
	public void onEnable() {
		
		
		for(Object entity : mc.theWorld.loadedEntityList) {
			if(((Entity)entity).isInvisible() && ((Entity) entity) != mc.thePlayer && !((Entity)entity).onGround) {
				mc.theWorld.removeEntity(((Entity)entity));
			}
			if(((Entity)entity) instanceof EntityPlayer && ((Entity)entity) != mc.thePlayer) {
				EntityPlayer entity1 = (EntityPlayer) entity;
				if(Float.isNaN(entity1.getHealth())) {
					mc.theWorld.removeEntity(entity1);
				}
			} else {
				
			}
			if(mc.thePlayer == null || mc.theWorld == null) {
				return;
			}
		}
	
		super.onEnable();
	}
	

	public static boolean isInTablist(Entity player) {
		if (Minecraft.getMinecraft().isSingleplayer()) {
			return true;
		}
		for (NetworkPlayerInfo o : Minecraft.getMinecraft().getNetHandler().getPlayerInfoMap()) {
			NetworkPlayerInfo playerInfo = o;
			if (!playerInfo.getGameProfile().getName().equalsIgnoreCase(player.getName()))
				continue;
			return true;
		}
		return false;
	}
		
	}


