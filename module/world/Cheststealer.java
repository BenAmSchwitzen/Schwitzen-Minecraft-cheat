package schwitzen.module.world;

import org.lwjgl.input.Keyboard;

import joptsimple.ValueConversionException;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.item.ItemStack;
import schwitzen.events.Event;
import schwitzen.events.listeners.EventUpdate;
import schwitzen.module.Module;
import schwitzen.module.ModuleManager;
import schwitzen.util.TimeHelper;


public class Cheststealer extends Module {
	
	TimeHelper time = new TimeHelper();
	

	public Cheststealer() {
		super("Cheststealer", Keyboard.KEY_P, Category.PLAYER);
		
	}
	
	
	public void onUpdate(EventUpdate e) {
    if(e instanceof EventUpdate) {
			
			if(e.isPre()) {
		if((this.mc.thePlayer.openContainer != null && !(mc.thePlayer.openContainer instanceof ContainerChest))) {
			ContainerChest chest = (ContainerChest) this.mc.thePlayer.openContainer;
			for(int i = 0;i<chest.getLowerChestInventory().getSizeInventory();i++) {
				if((chest.getLowerChestInventory().getStackInSlot(i) !=null) && (this.time.hasReached(40L))) {
					
					this.mc.playerController.windowClick(chest.windowId, i,0, 1, this.mc.thePlayer);
					this.time.reset();
				}
			}
			if(chest.getInventory().isEmpty()) {
				this.mc.displayGuiScreen(null);
			}
			
		}}
		
		
		
		
		
	}
	
	

}}
