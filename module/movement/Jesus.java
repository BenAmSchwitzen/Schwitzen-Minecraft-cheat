package schwitzen.module.movement;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import schwitzen.events.Event;
import schwitzen.module.Module;

public class Jesus extends Module {

	public Jesus() {
		super("Jesus",Keyboard.KEY_J,Category.MOVEMENT);
		
	}
	
	@Override
	public void onEvent(Event e) {
		
	
		
		super.onEvent(e);
	}

}
