package schwitzen.module.movement;

import java.util.Random;

import javax.sound.midi.Soundbank;

import org.lwjgl.input.Keyboard;

import com.mojang.realmsclient.dto.RealmsServer.McoServerComparator;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.MathHelper;
import schwitzen.Client;
import schwitzen.events.Event;
import schwitzen.module.Module;
import schwitzen.module.combat.Killaura;
import schwitzen.util.Timer;

public class TargetStrafe extends Module {

	EntityLivingBase targetEntity  = null;
	Timer timer = new Timer();
	EntityPlayerSP player = mc.thePlayer;
	double angle = 0;
	
	
	public TargetStrafe() {
		super("TargetStrafe", Keyboard.KEY_J, Category.MOVEMENT);
		
	}
	
	@Override
	public void onEvent(Event e) {
		
		if(Killaura.target != null && Client.moduleManager.getModuleByName("Killaura").toggled && Killaura.target instanceof Entity ) {
			EntityLivingBase targetEntity = (EntityLivingBase)Killaura.target;
			
			
			toTarget(targetEntity);
		
			
			
			
		}
		
		
		super.onEvent(e);
	}
	
	public double getPlayerPositionX(EntityLivingBase entity) {
		
		double playerX = entity.posX;
		return playerX;
	}
	
public double getPlayerPositionZ(EntityLivingBase entity) {
		
		double playerY = entity.posZ;
		return playerY;
	}

public double mcThePlayerX() {
	
	return mc.thePlayer.posX;
	
}

public double mcThePlayerZ() {
	
return mc.thePlayer.posZ;
	
	
}


   
	
	
	public void toTarget(EntityLivingBase entity) {

		
	
		
		
    
		
		double playerX = mcThePlayerX();
		double playerZ= mcThePlayerZ();
		
		double targetX = getPlayerPositionX(entity);
		double targetZ = getPlayerPositionZ(entity);
		
		double targetDirectionX = targetX-playerX;
		double targetDirectionZ = targetZ-playerZ;
		
		double targetDirectionLength = Math.sqrt(targetDirectionX*targetDirectionX+targetDirectionZ*targetDirectionZ)-80;
			
			
		
		targetDirectionX/=targetDirectionLength;
		targetDirectionZ /= targetDirectionLength;
		
		double strafeX = -targetDirectionZ;
		double strafeZ = targetDirectionX;
		
		
		if( entity.isEntityAlive() && mc.thePlayer.canEntityBeSeen(entity) && targetDirectionX < 1&& targetDirectionZ <1) {
			
			if(mc.thePlayer.onGround) {
				
				mc.thePlayer.jump();
			}
			  
		
			 double deltaX = targetX - playerX;
			 double deltaZ = targetZ - playerZ;
			 double angle = Math.atan2(deltaZ, deltaX);
			 double degrees = Math.toDegrees(angle);

			
			 mc.thePlayer.renderYawOffset = (float) degrees-100;}
			 
			 float maxSpeed = 0.2f; // Maximale normale Geschwindigkeit
			 float thresholdSpeed = 0.3f; // Schwellenwert für die zu schnelle Geschwindigkeit

			 if (mc.thePlayer.motionX > thresholdSpeed || mc.thePlayer.motionZ > thresholdSpeed) {
			     // Der Spieler ist zu schnell, Geschwindigkeit anpassen
			     double currentSpeed = Math.sqrt(mc.thePlayer.motionX * mc.thePlayer.motionX + mc.thePlayer.motionZ * mc.thePlayer.motionZ);
			     if (currentSpeed > maxSpeed) {
			         double factor = maxSpeed / currentSpeed;
			         mc.thePlayer.motionX /= factor;
			         mc.thePlayer.motionZ /= factor;
			    
			 
			 
			     }}
		
			
				 
		
			
			 if( entity.isEntityAlive() && mc.thePlayer.canEntityBeSeen(entity) && targetDirectionX < 2 && targetDirectionZ <2) {
				 mc.thePlayer.moveEntity(strafeX*5.5,0,strafeZ);}
    
	}
	
	float maxSpeed = 0.1f; // Maximale normale Geschwindigkeit
	float thresholdSpeed = 0.3f; {
			 
			

		
			
		
			
	}
	
	private void toTarget2(EntityLivingBase entity) {
		Random random = new Random();
		
		if(entity !=null) {
		
	    
	      
	     double angleIncrement = 2*Math.PI/36;
	    // double angle = random.nextDouble(360)+0;
	     double playerPosX = mc.thePlayer.posX;  // x = horizontal
	     double playerPosZ = mc.thePlayer.posZ;	 // z = vertikal
	     double playerPosY = mc.thePlayer.posY;	 
	   
	     double targetPosX = entity.posX;
	     double targetPosZ = entity.posZ;
	     double radius =3;
	     int x = (int)targetPosX + (int) (radius*Math.cos(angle));
 	     int z = (int)targetPosZ + (int) (radius*Math.sin(angle));
 	     
 	    double deltaX = targetPosX - playerPosX;
		 double deltaZ = targetPosZ - playerPosZ;
		  angle =+15;
          
 	     
	     if(mc.thePlayer.getDistanceToEntity(entity) < 4) {
	    	 
	    	 
	    
	    	 
	    	
	    	 if(timer.hasTimeElapsed(500, 50, true))
			
	 	     mc.thePlayer.setPosition(x, playerPosY, z);
		    //mc.thePlayer.moveEntity(x,0, z);
	    	
	     
	     
		
	}}}
	}
	




