package schwitzen.module;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import schwitzen.events.Event;

public class Module {
	
	public String name;
	private int keyCode;
	public boolean toggled;
	private Category category;
	
	protected Minecraft mc = Minecraft.getMinecraft();

	
	
	
	public Module(String name, int keyCode, Category category) {
		
		this.name = name;
		this.keyCode = keyCode;
		this.category = category;
		
		this.toggled = false;
	}
	
	public boolean isEnabled() {
		
		return toggled;
		
	}
	
	public void onEnable() {
		
		
	}
	
	public void onDisable() {
		
		
		
	}
	
	public int getKey() {
		
		return keyCode;
		
	}
	
	public void toggle() {
		
		toggled = !toggled;
		if(toggled) {
			onEnable();
		}
		else {
			onDisable();
		}
		
	}
	
	public enum Category {
		
		COMBAT("Combat"),
		MOVEMENT("Movement"),
		PLAYER("Player"),
		RENDER("Render"),
		World("World"),
		NONE("None");
		
		public String name;
		int rt  =3;
		private Category(String name) {
			this.name = name;
		}
		
	}
	
	public void onEvent(Event e) {
		
		
	}
	
	public String getName() {
		
		return this.name;
	}
	
	
	
}
