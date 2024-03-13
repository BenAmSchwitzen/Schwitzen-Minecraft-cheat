package schwitzen.module.combat;

import java.security.PublicKey;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.swing.text.html.HTML.Tag;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.mojang.realmsclient.dto.RealmsServer.McoServerComparator;
import com.mojang.realmsclient.gui.screens.RealmsLongRunningMcoTaskScreen;

import io.netty.util.internal.chmv8.ConcurrentHashMapV8.Action;
import net.minecraft.block.BlockStairs.EnumHalf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.main.Main;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityLookHelper;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemCloth;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.client.C0FPacketConfirmTransaction;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import schwitzen.Client;
import schwitzen.events.Event;
import schwitzen.events.EventMotion;
import schwitzen.events.listeners.EventUpdate;
import schwitzen.module.Module;
import schwitzen.util.ChatUtil;
import schwitzen.util.Timer;

public class Killaura extends Module {
	
	//Pontj131
	
	public Timer timer = new Timer();
	Random random  = new Random();
	public static Entity target;
	EntityLivingBase gegner;
	Minecraft mc  = Minecraft.getMinecraft();
	public Killaura() {
		super("Killaura", Keyboard.KEY_R, Category.COMBAT);
		
	}
	
	public Entity getTarget() {
		
		return target;
		
	}
	
	public void onUpdate() {
		
	
    }
		
	
	
	
	
	public void onEvent(Event event) {
		
		  if(mc.thePlayer.isDead || mc.thePlayer.getHealth() <=0) {
			
			this.toggled = false;
		}
		
		
		if(event instanceof EventMotion) {
			
			if(event.isPre()) {
				
				EventMotion e = (EventMotion)event;
				
				
         List<Entity> targets =  (List<Entity>)mc.theWorld.loadedEntityList.stream().filter(EntityLivingBase.class::isInstance).collect(Collectors.toList());
         
         for(Entity entity : targets) {
        	 
        	 
         	
         	if(entity.isInvisible() && Client.moduleManager.getModuleByName("Antibot").toggled && !mc.thePlayer.canEntityBeSeen(entity)&& !entity.isEntityAlive() && !mc.thePlayer.isDead && !Antibot.isInTablist(entity)) {
         		
         		
         		if(entity != mc.thePlayer) 
         		mc.theWorld.removeEntity(entity);
         		
         	}
         	
         }
         
       
           targets =  targets.stream().filter(entity -> entity.getDistanceToEntity(mc.thePlayer) <4 && entity != mc.thePlayer && !entity.isDead ).collect(Collectors.toList());
				

                   
            




                  targets.sort(Comparator.comparingDouble(entity -> ((EntityLivingBase)entity).getDistanceToEntity(mc.thePlayer)));

				if(!targets.isEmpty() ) {
					
					
					
					
					 target = targets.get(0);
					
					
					FontRenderer fr = mc.fontRendererObj;
					
					
				    if(Client.moduleManager.getModuleByName("Antibot").toggled && !target.isAirBorne && target.canBePushed() && !target.isInvisibleToPlayer(mc.thePlayer) && mc.thePlayer.canAttackPlayer((EntityPlayer)target) && mc.thePlayer.canEntityBeSeen(target)) {
					faceEntity((EntityLivingBase)target);
				    }
					e.setYaw(getRotation(target)[0]);
					e.setPitch(getRotation(target)[1]);
					
					
					 BlockPos blockPos = mc.objectMouseOver.getBlockPos();
			            EnumFacing facing = mc.objectMouseOver.sideHit;
			            ItemStack currentItem = mc.thePlayer.getHeldItem();
			            
			           
			            mc.thePlayer.setLastAttacker(target);
			            mc.thePlayer.setSprinting(false);
			       

						double deltaX = target.posX - mc.thePlayer.posX;
						 double deltaZ =target.posZ - mc.thePlayer.posZ;
						 double angle = Math.atan2(deltaZ, deltaX);
						 double degrees = Math.toDegrees(angle);

						
						 mc.thePlayer.renderYawOffset = (float) degrees-100;}
			            
				
				
					if(timer.hasTimeElapsed(5200/10,100,true) && !mc.thePlayer.isDead && !(mc.thePlayer.openContainer instanceof ContainerChest) && !mc.thePlayer.isInvisible() && mc.thePlayer.canEntityBeSeen(target) && Antibot.isInTablist(target) && !(mc.thePlayer.getHealth() <= 0) && playerExistsInTabList(target) && anzahlPlayerNameInTablist(target)<2 && target.canBePushed() && target instanceof EntityLivingBase) {
					
						
						
						
						
					
						
						
						
						

						// Rufen Sie das ItemStack-Objekt des Schwerts ab
						
						
						if(mc.thePlayer.getLastAttacker() == target)  {
							
						
							
						mc.thePlayer.swingItem();
						
						
						
					//mc.thePlayer.sendQueue.addToSendQueue(new C02PacketUseEntity(target, net.minecraft.network.play.client.C02PacketUseEntity.Action.ATTACK));
					
					e.setYaw(getRotation(target)[0]);
						
					mc.thePlayer.setSprinting(false);
					e.setPitch(getRotation(target)[1]);
					
					
					
					
					
					EntityLookHelper lookHelper = new EntityLookHelper(null);
					lookHelper.setLookPosition(0, getKey(), getKey(), getKey(), getKey());
				
					
					
					
					mc.playerController.interactWithEntitySendPacket(mc.thePlayer, target);
					mc.playerController.attackEntity(mc.thePlayer, target);
					}
				
					
					
						
					
						}}
			
			}
			}
			
			
		
		
		
		
	
	
	public static float getEntityHealth(EntityLivingBase player) {
		
		return player.getHealth();
		
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
	
	public void onEnable() {
		
		
		
		
	}
	
	public void onDisable() {
		
		mc.timer.timerSpeed = 1F;
		
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
	
	
	public boolean playerExistsInTabList(Entity entity) {
		if (Minecraft.getMinecraft().isSingleplayer()) {
			return true;
		}
		
		for(NetworkPlayerInfo o : Minecraft.getMinecraft().getNetHandler().getPlayerInfoMap()) {
			NetworkPlayerInfo playerInfo = o;
			if(playerInfo.getGameProfile().getName().equalsIgnoreCase(entity.getName())) {
				System.out.println("True");
				return true;
				
			
				
			}
			
		}
		return false;
		
	}
	
	public int anzahlPlayerNameInTablist(Entity player) {
		
		int anzahlPlayerName = 0;
	
		
		for(NetworkPlayerInfo o : Minecraft.getMinecraft().getNetHandler().getPlayerInfoMap()) {
			NetworkPlayerInfo playerInfo = o;
			if(playerInfo.getGameProfile().getName().equalsIgnoreCase(player.getName())) {
		
				anzahlPlayerName +=1;
				
	}

}
	return anzahlPlayerName;	
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
}












