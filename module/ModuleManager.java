package schwitzen.module;

import java.util.ArrayList;

import schwitzen.events.Event;

import schwitzen.module.combat.*;

import schwitzen.module.movement.*;
import schwitzen.module.player.*;
import schwitzen.module.render.*;
import schwitzen.module.world.*;
import schwitzen.ui.ClickGUIM;
import schwitzen.module.movement.*;

public class ModuleManager {
	
	public  ArrayList<Module> mods = new ArrayList<Module>();
	
	
	public ModuleManager() {
		
		
		
		
		
		
		//COMBAT
		newMod(new Killaura());
		//newMod(new NoSlowDown());
		newMod(new Velocity());
		newMod(new Antibot());
		
		
		
		
		
		//MOVEMENT
		newMod(new Fly());
		newMod(new Sprint());
		newMod(new Speed());
		newMod(new Step());
		
		
		
		
		
		//PLAYER
		newMod(new NoFall());
		
		
		
		//RENDER
		newMod(new FullBright());
		
		
		//PLAYER
		newMod(new Cheststealer());
		newMod(new Killaura2());
		
		newMod(new Tower());
		newMod(new AntiAim());
		newMod(new PlayerESP());
		newMod(new FastBow());
		newMod(new StaffAlert());
		newMod(new TargetStrafe());
		newMod(new Autoarmor());
		newMod(new ClickGUIM());
	
		
		
		
	}
	
	public void onKeyPress(int key) {
		
		for(Module m : mods) {
			
			if(m.getKey()== key)  {
				
				m.toggle();
				
			}
			
		}
		
	}
	
	public void onEvent(Event e) {
		
		for(Module m : mods) {
			
			if(!m.toggled) {
				continue;
			}
			m.onEvent(e);
			
		}
		
		
	}
	
	public void newMod(Module m) {
	
		mods.add(m);
		
	}

	public ArrayList<Module> getMods() {
		return mods;
	}
	
	public Module getModuleByName(String name) {
		
		for(int i = 0;i<mods.size();i++) {
			
		      if(mods.get(i).getName().equals(name)) {
		    	  
		    	  return mods.get(i);
		    	  
		      }
			
		}
		return null;
		
	}
	
	
	

}
