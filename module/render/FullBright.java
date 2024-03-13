package schwitzen.module.render;

import org.lwjgl.input.Keyboard;



import schwitzen.events.Event;
import schwitzen.events.listeners.EventUpdate;
import schwitzen.module.Module;

public class FullBright extends Module {

	public FullBright() {
		super("FullBright", Keyboard.KEY_X, Category.RENDER);
		
	}
	
	
	
	public void onEnable() {
		
	mc.gameSettings.gammaSetting = 100;
		
		
	}
	
	public void onDisable() {
		
		mc.gameSettings.gammaSetting = 1;
		
		
	}

}
