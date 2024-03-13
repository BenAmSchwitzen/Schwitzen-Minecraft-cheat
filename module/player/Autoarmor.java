package schwitzen.module.player;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.resources.FolderResourcePack;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import schwitzen.events.Event;
import schwitzen.module.Module;
import schwitzen.util.Timer;

public class Autoarmor extends Module {
	
	private int [] bestArmorReducement;
	private int [] bestArmorSlots;
	
	
	
	Timer timer = new Timer();

	
	public Autoarmor() {
		super("Autoarmor", Keyboard.KEY_K, Category.PLAYER);
		
	}
	

	public void onEvent(Event e) {
		
	       
		
	searchForBestArmor();
	 
		
		
		for(int i = 0;i<4;i++) {
			
			
		
			
			if(bestArmorSlots[i] != -1) {
				int bestSlot = bestArmorSlots[i];
				
				ItemStack oldArmor = mc.thePlayer.inventory.armorItemInSlot(i);
				
				if(oldArmor !=null && oldArmor.getItem() !=null) {
					
				
					
					mc.playerController.windowClick(mc.thePlayer.inventoryContainer.windowId,8-i,0,1,mc.thePlayer);
					
			  
				}
				
				
				mc.playerController.windowClick(mc.thePlayer.inventoryContainer.windowId,bestSlot <9? bestSlot+36:bestSlot,0,1,mc.thePlayer);
				
			
		
				
				
			}}
		}
		
		
		
	
	
	private void searchForBestArmor() {
		
		bestArmorReducement = new int [4];
		bestArmorSlots = new int [4];
		
		
		
		
		Arrays.fill(bestArmorReducement,-1);
		Arrays.fill(bestArmorSlots, -1);
		
		
		// 1. Get Current  Armor-Items (equipped)
		
		for(int i = 0;i<bestArmorSlots.length;i++) {
			
			ItemStack itemStack = mc.thePlayer.inventory.armorItemInSlot(i);
		
			if(itemStack !=null && itemStack.getItem() !=null) {
				
				if(itemStack.getItem() instanceof ItemArmor) {
					
					ItemArmor armor = (ItemArmor)itemStack.getItem();
					
					bestArmorReducement[i] = armor.damageReduceAmount;
					
				}
				
				
			}
			
		}
		
		for(int i = 0;i<9*4;i++) {
			
			ItemStack itemStack = mc.thePlayer.inventory.getStackInSlot(i);
			
			if(itemStack == null || itemStack.getItem() == null) continue;
			
			if(itemStack.getItem() instanceof ItemArmor) {
			
				ItemArmor armor = (ItemArmor) itemStack.getItem();
				int armorType  = 3-armor.armorType;
				
				if(bestArmorReducement[armorType] < armor.damageReduceAmount) {
					
					
					
					bestArmorReducement[armorType] = armor.damageReduceAmount;
					bestArmorSlots[armorType] = i;
					
					
					
				}
				
			}
			
		}
		
	
		
	
	}
	

		
	
		
		
		
	
	}
	
