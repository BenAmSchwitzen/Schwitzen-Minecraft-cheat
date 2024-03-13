package schwitzen.module.movement;

import org.lwjgl.input.Keyboard;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import schwitzen.Client;
import schwitzen.events.Event;
import schwitzen.module.Module;
import schwitzen.util.Timer;

public class Tower extends Module {
	
	public Timer timer = new Timer();
	public BlockPos lastPos;
	

	public Tower() {
		super("Tower",Keyboard.KEY_Y,Category.MOVEMENT);
		
	}
	
	@Override
	public void onEnable() {
		
		
			
	     
		
		mc.thePlayer.rotationPitch = 95F;
	
	    Client.moduleManager.getModuleByName("Sprint").toggled = false;
		super.onEnable();
	}
	
	public void onUpdate() {
	
    

		 ItemStack itemStack = mc.thePlayer.inventory.getCurrentItem();
		    if (itemStack != null && itemStack.getItem() instanceof ItemBlock) {
		        Block block = ((ItemBlock) itemStack.getItem()).getBlock();
		        if (block instanceof BlockContainer) {
		        	mc.thePlayer.swingItem();
		            mc.playerController.onPlayerRightClick(mc.thePlayer, mc.theWorld, itemStack, mc.objectMouseOver.getBlockPos(), mc.objectMouseOver.sideHit, mc.objectMouseOver.hitVec);
		        }
		    }




	}


	
 
		
		
	
	
	@Override
	public void onEvent(Event e) {
		
		
		
		mc.thePlayer.isCollided = true;
		mc.thePlayer.isCollidedVertically = true;
		mc.thePlayer.isCollidedHorizontally = true;
		
		if(timer.hasTimeElapsed(5700/10,100,true) && !mc.thePlayer.isDead) {
		
		mc.thePlayer.jump();
		
		
		
		super.onEvent(e);
	}}
	@Override
	public void onDisable() {
		
		Client.moduleManager.getModuleByName("Sprint").toggled = true;
		
		super.onDisable();
	}

}
