package schwitzen.module.render;

import java.security.PublicKey;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.ARBTextureRGB10_A2UI;
import org.lwjgl.util.vector.Matrix;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import schwitzen.Client;
import schwitzen.module.Module;

public class PlayerESP extends Module {

	public PlayerESP() {
		super("PlayerESP", Keyboard.KEY_Z, Category.RENDER);
	}
	
	public void onRender() {
		
		
       
		
			
			
			for(Entity entity : mc.theWorld.loadedEntityList) {
				
				if (entity instanceof EntityPlayer) {
			        EntityPlayer player = (EntityPlayer) entity;
			        double x = player.posX;
			        double y = player.posY;
			        double z = player.posZ;

			        // Koordinaten des Punktes berechnen
			        int pointSize = 50; // Größe des Punktes
			        int pointColor = 0xFFFFFFFF; // Farbe des Punktes (hier: Weiß)
			        int pointX = (int) (x - pointSize / 2);
			        int pointY = (int) y;
			        int pointZ = (int) (z - pointSize / 2);

			        
			        
			        
			        // Punkt zeichnen
			        Gui.drawRect(pointX, pointY, pointX + pointSize, pointY + pointSize, 0xFF0000FF);
				    
			    }
		

		
			
		
	

}
		
			
		
			
			
			
}
	

  









}