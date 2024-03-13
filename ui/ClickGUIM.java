package schwitzen.ui;

import org.lwjgl.input.Keyboard;

import schwitzen.module.Module;

public class ClickGUIM extends Module{

	public ClickGUIM() {
		super("ClickGUI", Keyboard.KEY_N, Category.NONE);
		
	}
	public void onRender() {
		
		mc.displayGuiScreen(new ClickGUI());
		
	}
	
	@Override
	public void onEnable() {
		mc.displayGuiScreen(new ClickGUI());
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		
		super.onDisable();
	}

}
