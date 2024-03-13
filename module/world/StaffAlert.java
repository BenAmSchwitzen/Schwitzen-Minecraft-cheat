package schwitzen.module.world;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import schwitzen.events.Event;
import schwitzen.module.Module;
import schwitzen.module.Module.Category;
import schwitzen.util.ChatUtil;

public class StaffAlert extends Module {
	
 
	private ArrayList<String> modNames = new ArrayList();
	
	
	
	public StaffAlert() {
		super("StaffAlert",Keyboard.KEY_Q,Category.World);
		addModsToList();
	}
	
	@Override
	public void onEvent(Event e) {
	
		if(staffInLobby1() ) {
			ChatUtil.sendMessage("Staff detected");
		}
		
		super.onEvent(e);
	}

	
	public boolean staffInLobby1() {
		if (Minecraft.getMinecraft().isSingleplayer()) {
			return true;
		}
		for (NetworkPlayerInfo o : Minecraft.getMinecraft().getNetHandler().getPlayerInfoMap()) {
			NetworkPlayerInfo playerInfo = o;
			
			for(String modName : modNames ) {
			
			if (playerInfo.getGameProfile().getName().equals(modName)) {
			
			return true;
		}}}
		return false;	
	
	}
	
	
	public void addModsToList() {
		
		modNames.add("VortexWkeys");
		modNames.add("m9_X");
		modNames.add("cybernife");
		modNames.add("BellaWasTaaken");
		
	}
	
	
	
	
	
	
	
	
	
	
	}
