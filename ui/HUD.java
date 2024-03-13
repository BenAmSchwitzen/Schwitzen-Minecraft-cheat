package schwitzen.ui;

import java.awt.Color;

import org.apache.commons.lang3.math.Fraction;

import com.ibm.icu.util.InitialTimeZoneRule;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.gen.FlatGeneratorInfo;
import schwitzen.Client;
import schwitzen.module.combat.Killaura;
import schwitzen.module.combat.Killaura2;
import schwitzen.ui.targetHUD.TargetHUD;

public class HUD {
	
	public Minecraft mc = Minecraft.getMinecraft();
	
	private TargetHUD targetHUD =  new TargetHUD();
	
	EntityLivingBase savedTarget;
	
	public void draw() {
		
		float playerHP = mc.thePlayer.getHealth();
		String playerHPText = Float.toString(playerHP);
		
		
		
		ScaledResolution sr = new ScaledResolution(mc);
		FontRenderer fr = mc.fontRendererObj;
		
		
		if(Killaura.target != null && Client.moduleManager.getModuleByName("Killaura").toggled && mc.thePlayer.getDistanceToEntity(Killaura.target)<4) {
		
	    targetHUD.renderTargetHUD();
		}
	    
	    drawEnemyStats(fr);
	    renderPlayer();
	    
	//if(Client.moduleManager.getModuleByName("Killaura").toggled ) {
			
		//	fr.drawString(mc.thePlayer.getName(),197, 43,100000);
		//	fr.drawString(playerHPText, 210, 52, -100000);
		//}
	
		
		GlStateManager.translate(4, 4, 0);
		GlStateManager.scale(2, 2, 1);
		GlStateManager.translate(-4,-4, 0);
		
		Gui.drawRect(9, 18, 58, 9, -15000);
		fr.drawString(Client.name + "  v" + Client.version,10, 10, -1);
		
	
		
		
		GlStateManager.translate(4, 4, 0);
		GlStateManager.scale(0.5, 0.5, 1);
		GlStateManager.translate(-4,-4, 0);
		
		
		
		
		
		int count = 0;
		
		for(schwitzen.module.Module m : Client.moduleManager.mods) {
			
			if(!m.toggled) 
	           continue;
			
			int offset = count*(fr.FONT_HEIGHT+6);
	
		//Strich	
			Gui.drawRect(sr.getScaledWidth()- fr.getStringWidth(m.name)-9,offset, sr.getScaledWidth()- fr.getStringWidth(m.name)-8, + fr.FONT_HEIGHT+offset,-100000);
	//Hintergrund		
			Gui.drawRect(sr.getScaledWidth()- fr.getStringWidth(m.name)-8,offset, sr.getScaledWidth(),6 + fr.FONT_HEIGHT+offset,-15000);
			//fr.drawString(m.name, sr.getScaledWidth() - fr.getStringWidth(m.name) -4,4+count*(fr.FONT_HEIGHT+4),-1);
		//Modules	
			fr.drawStringWithShadow(m.name, sr.getScaledWidth() - fr.getStringWidth(m.name) -4,4+offset,-7000);
			
			count++;
	}
		
		
		
	}
	
	public void drawEnemyStats(FontRenderer fr) {
		
		
   
			
			
		
		
		savedTarget = (EntityLivingBase)Killaura.target;
		
		if(Killaura.target != null && Client.moduleManager.getModuleByName("Killaura").toggled) {
		
		//float hp  =  mc.thePlayer.getDistanceToEntity((EntityLivingBase)Killaura.target);
		int hp = (int)savedTarget.getHealth();
		
		double percentageHP = (double)savedTarget.getHealth()/(double)savedTarget.getMaxHealth()*100;
	   
		
		String hpText = Integer.toString(hp);
		Math.round(percentageHP);
		String percentageHPtext =    String.format("%.2f", percentageHP);        //Double.toString(percentageHP);
		
		
		
		System.out.println(percentageHPtext);
		
		
		
	
		
		
		
		
		if(mc.thePlayer.getDistanceToEntity(Killaura.target)<4 && Killaura.target != null && Client.moduleManager.getModuleByName("Killaura").toggled) {
		fr.drawString(Killaura.target.getName(),198,42,-20);	
		fr.drawString(percentageHPtext + "%",238, 52, -50000);
		
			
		
		if(mc.thePlayer.getHealth()> savedTarget.getHealth()) {
			
			fr.drawString("Winning", 198, 52, -50000);
			
		}else if(mc.thePlayer.getHealth()< savedTarget.getHealth()){
			fr.drawString("Losing", 198, 52, -50000);
		}else {
			fr.drawString("Draw", 198, 52, -50000);
		
		}}}}
	

	public void renderPlayer() {
		
		GuiInventory.drawEntityOnScreen(600, 350, 25, 0, 20, mc.thePlayer);
		
	}
	
}
