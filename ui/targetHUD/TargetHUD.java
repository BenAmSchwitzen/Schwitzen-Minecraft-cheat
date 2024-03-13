package schwitzen.ui.targetHUD;

import java.awt.Color;
import java.awt.Font;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.stream.MetadataAchievement;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.player.EntityPlayer;
import schwitzen.Client;
import schwitzen.module.combat.Killaura;
import schwitzen.ui.HUD;
import tv.twitch.chat.ChatMessageTokenType;


public class TargetHUD {
	
	Minecraft mc = Minecraft.getMinecraft();
	FontRenderer fr  = mc.fontRendererObj;
	
	EntityLivingBase savedTarget;
	
	
			
	
	
	public TargetHUD() {
		
		
		
	}
	
	
	public void renderTargetHUD() {
		
		savedTarget = (EntityLivingBase)Killaura.target;
		
			
			if(Client.moduleManager.getModuleByName("Killaura").toggled && Killaura.target !=null) {
				int width = 1080;
				int height = 1080;
				int rectWidth = 200;
				int rectHeight = 100;

				int x = (width - rectWidth) / 2;
				int y = (height - rectHeight) / 2;

			   Gui.drawRect(190,40,280,50, -151200); // Rechteck in Rot
				
				Gui.drawRect(190,60, 280,50, -1);
				Gui.drawRect(190,60, 280,50, -10000);
				
				if(Killaura.target instanceof EntityPlayer) {
					drawPlayerHead(Killaura.target);
				}else {
				drawPlayerHead(mc.thePlayer);
				}
				
			   int hpColor = 0;
			   
			   if(savedTarget.getHealth() == savedTarget.getMaxHealth()) {
				   hpColor = -65000;
			   }else if(savedTarget.getHealth() < savedTarget.getMaxHealth()-5 && savedTarget.getHealth() > savedTarget.getMaxHealth()-20) {
				   hpColor = -100000;
			   }else {
				  hpColor =  new Color(213,45,65).getRGB();
			   }
 				
	 //Background   
				Gui.drawRect(180, 60,4*70, 65,-1);
	      //HP	
				Gui.drawRect(180,60, 70*(int)savedTarget.getHealth()/(int)savedTarget.getMaxHealth()+210, 65, hpColor);
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	
	
	
	
	public EntityLivingBase getTarget(double range)  {
		
		EntityLivingBase entityLivingBase = null;
		
		
		for(Entity entity : mc.theWorld.loadedEntityList) {
			
		
			
			if(mc.thePlayer.getDistanceToEntity(entity) < range ) {
				
				
					
				
				range = mc.thePlayer.getDistanceToEntity(entity);
				
				entityLivingBase = (EntityLivingBase) entity;
				
			}
			
			
		}
		
		
		
		return entityLivingBase;
		
		
		
	}
	
	
	public void drawPlayerHead(Entity player) {
		
		NetworkPlayerInfo playerInfo = mc.getNetHandler().getPlayerInfo(player.getUniqueID());
    	if (playerInfo != null){
            mc.getTextureManager().bindTexture(playerInfo.getLocationSkin());
            GL11.glColor4f(1F, 1F, 1F, 1F);

            Gui.drawScaledCustomSizeModalRect((int) 180- 5, (int) 45 - 5, 8F, 8F, 8, 8, 20, 20, 64F, 64F);
        }
	}
		
}


