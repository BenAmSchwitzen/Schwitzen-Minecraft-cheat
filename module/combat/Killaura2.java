package src.schwitzen.module.combat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.management.relation.InvalidRelationTypeException;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;


import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityLookHelper;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.util.MathHelper;
import schwitzen.Client;
import schwitzen.events.Event;
import schwitzen.events.EventMotion;
import schwitzen.module.Module;
import schwitzen.util.Timer;

public class Killaura2 extends Module {
	
   
	private Timer timer = new Timer();
	
	
	
	
	
	
	private int range;
	
	

	public Killaura2() {
		super("Killaura2",Keyboard.KEY_M,Category.COMBAT);
		
		
		
		
		this.range = 4;
		
	}
	

	@Override
	public void onEvent(Event e) {
		
if(e instanceof EventMotion) {
			
			if(e.isPre()) {
				
				EventMotion ev = (EventMotion)e;
		
		if(mc.thePlayer.isDead || mc.thePlayer.getHealth() <=0) {
			this.toggled = false;
		}
		
		double playerX = mc.thePlayer.posX;
		double playerY = mc.thePlayer.posY;
		double playerZ= mc.thePlayer.posZ;
		double distance = 0;
		
		double targetX;
		double targetY;
		double targetZ;
		
		 ArrayList<Entity> targets  = new ArrayList<>();
		
		
		for(Entity entity : mc.theWorld.loadedEntityList) {
			if (entity instanceof EntityAnimal || entity instanceof EntityPlayer && entity !=mc.thePlayer) {
			if(entity == null) {
			continue;
			}
			targetX = entity.posX;
			targetY = entity.posY;
			targetZ = entity.posZ;
			
			double x = targetX-playerX;
			double y = targetY-playerY;
			double z= targetZ-playerZ;
			
			double distanceBetweenEntities = Math.sqrt((x*x)+(y*y)+(z*z));
		      
			if(distanceBetweenEntities <= range) {
				

				
				
				
				
				targets.add(entity);
				
				Entity target = getClosestEnemy(targets,ev);
				double deltaX = targetX - playerX;
				 double deltaZ =targetZ - playerZ;
				 double angle = Math.atan2(deltaZ, deltaX);
				 double degrees = Math.toDegrees(angle);
				  ev.setYaw(getRotation(target)[0]);
				  mc.thePlayer.renderYawOffset = (float) degrees-100;
					mc.thePlayer.setSprinting(false);
					ev.setPitch(getRotation(target)[1]);
					faceEntity((EntityLivingBase)target);

					

					 EntityLookHelper lookHelper = new EntityLookHelper(null);
						lookHelper.setLookPosition(0, getKey(), getKey(), getKey(), getKey());
				
				 
				
				
				//mc.playerController.interactWithEntitySendPacket(mc.thePlayer, target);
				if(timer.hasTimeElapsed(500, 100, true)) {
					//mc.thePlayer.renderYawOffset = (float) degrees-100;
					mc.thePlayer.swingItem();
				mc.playerController.interactWithEntitySendPacket(mc.thePlayer, target);
				mc.playerController.attackEntity(mc.thePlayer, target);
				
				}}
			}
			
			
			
		
		
		
		
		
		
		
		
		
		}}super.onEvent(e);}}
	
	
	private Entity getClosestEnemy(ArrayList<Entity> entities,Event ev) {
		
		double playerX = mc.thePlayer.posX;
		double playerY = mc.thePlayer.posY;
		double playerZ= mc.thePlayer.posZ;
		Entity closestEntity = entities.get(0);
		double targetX;
		double targetY;
		double targetZ;
		double closestDistance = 0;
		double distanceBetweenEntities;
		
		for(Entity entity : entities) {
			
			
			
			targetX = entity.posX;
			targetY = entity.posY;
			targetZ = entity.posZ;
			

			double x = targetX-playerX;
			double y = targetY-playerY;
			double z= targetZ-playerZ;
			
			 distanceBetweenEntities = Math.sqrt((x*x)+(y*y)+(z*z));
			
			 if(distanceBetweenEntities<closestDistance) {
				 
				 if(entity.isEntityAlive()) {
					 
					 
				 
				  closestEntity = entity;
				 closestDistance = distanceBetweenEntities;
				 
				 ((EventMotion) ev).setYaw(getRotation(closestEntity)[0]);
					
					mc.thePlayer.setSprinting(false);
					((EventMotion) ev).setPitch(getRotation(closestEntity)[1]);
					faceEntity((EntityLivingBase)closestEntity);
					
					double deltaX = targetX - playerX;
					 double deltaZ =targetZ - playerZ;
					 double angle = Math.atan2(deltaZ, deltaX);
					 double degrees = Math.toDegrees(angle);
					 mc.thePlayer.renderYawOffset = (float) degrees-100;
				
			 }else {
				 
				 break;
				 
				 }
			 }
			
		
		}
		
		 return closestEntity;
		 
	}
	
	
	public  synchronized void faceEntity(EntityLivingBase entity) {
		final float[] rotations = getRotationsNeeded(entity);

		if (rotations != null) {
			mc.thePlayer.rotationYawHead = rotations[0];
		//mc.thePlayer.rotationPitch = rotations[1] + 1.0F;// 14
		}
	}

	public  float[] getRotationsNeeded(Entity entity) {
		if (entity == null) {
			return null;
		}

		final double diffX = entity.posX - mc.thePlayer.posX;
		final double diffZ = entity.posZ - mc.thePlayer.posZ;
		double diffY;

		if (entity instanceof EntityLivingBase) {
			final EntityLivingBase entityLivingBase = (EntityLivingBase) entity;
			diffY = entityLivingBase.posY + entityLivingBase.getEyeHeight() - (mc.thePlayer.posY + mc.thePlayer.getEyeHeight());
		} else {
			diffY = (entity.boundingBox.minY + entity.boundingBox.maxY) / 2.0D - (mc.thePlayer.posY +mc.thePlayer.getEyeHeight());
		}

		final double dist = MathHelper.sqrt_double(diffX * diffX + diffZ * diffZ);
		final float yaw = (float) (Math.atan2(diffZ, diffX) * 180.0D / Math.PI) - 90.0F;
		final float pitch = (float) -(Math.atan2(diffY, dist) * 180.0D / Math.PI);
		return new float[] { mc.thePlayer.rotationYaw + MathHelper.wrapAngleTo180_float(yaw - mc.thePlayer.rotationYaw),mc.thePlayer.rotationPitch + MathHelper.wrapAngleTo180_float(pitch -mc.thePlayer.rotationPitch) };
	}
	
	public boolean newWayToReturnAValue() {
		
		int zahl = 3;
		
		return zahl<1;
		
	}
	
	public float[] getRotation(Entity e) {
		
		double deltaX = e.posX + (e.posX-e.lastTickPosX) -mc.thePlayer.posX;
		double deltaY = e.posY-3.5+e.getEyeHeight()-mc.thePlayer.posY+mc.thePlayer.getEyeHeight();
		double deltaZ = e.posZ + (e.posZ-e.lastTickPosZ)-mc.thePlayer.posZ;
		double distance = Math.sqrt(Math.pow(deltaX,2)+ Math.pow(deltaZ, 2));
		float yaw = (float) Math.toDegrees(-Math.atan(deltaX/deltaZ));
		float pitch = (float) -Math.toDegrees(Math.atan(deltaY/distance));
		
		if(deltaX<0 && deltaZ < 0) {
			yaw = (float) (90 + Math.toDegrees(Math.atan(deltaZ-deltaX)));
			
		}else if(deltaX > 0 && deltaZ> 0) {
			yaw = (float) (-90 + Math.toDegrees(Math.atan(deltaZ-deltaX)));
			
			
		}
		
		return new float[] {yaw,pitch};
		
	}
}


	
	
	

	
	
	

  
  
