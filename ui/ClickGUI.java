package schwitzen.ui;

import java.awt.Button;
import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import schwitzen.Client;
import schwitzen.module.ModuleManager;

public class ClickGUI extends GuiScreen {
	
	
	
	public ClickGUI() {
		
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
	
	
		
		
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	
	}
	@Override
	public void initGui() {
	
		for(int i = 0;i<Client.moduleManager.mods.size();i++) {
			
			this.buttonList.add(i, new GuiButton(i, 0, i*15,Client.moduleManager.mods.get(i).name));
			
		}
		
		super.initGui();
		
		
	
		
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		
		
		for(int i = 0;i<Client.moduleManager.mods.size();i++) {
			
			if(button.id == i) {
				
				Client.moduleManager.mods.get(i).toggle();
				Client.moduleManager.mods.get(i).toggled = false;
			}
			
		}
		
		super.actionPerformed(button);
	}
	
	@Override
	public void updateScreen() {
	
		super.updateScreen();
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
}
