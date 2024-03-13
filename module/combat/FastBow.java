package schwitzen.module.combat;
import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemBow;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C07PacketPlayerDigging.Action;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import schwitzen.module.Module;

public class FastBow extends Module {

	public FastBow() {
		super("FastBow",Keyboard.KEY_I,Category.COMBAT);
		
	}
	//fs313
	
	public void onUpdate() {
		if
		(
			Minecraft.getMinecraft().thePlayer.getHealth() > 0
			&& (Minecraft.getMinecraft().thePlayer.onGround || Minecraft.getMinecraft().thePlayer.capabilities.isCreativeMode)
			&& Minecraft.getMinecraft().thePlayer.inventory.getCurrentItem() != null
			&& Minecraft.getMinecraft().thePlayer.inventory.getCurrentItem().getItem() instanceof ItemBow
			&& Minecraft.getMinecraft().gameSettings.keyBindUseItem.isPressed()
		)
		{
			Minecraft.getMinecraft().playerController.sendUseItem
			(
				Minecraft.getMinecraft().thePlayer,
				Minecraft.getMinecraft().theWorld,
				Minecraft.getMinecraft().thePlayer.inventory.getCurrentItem()
			);
			Minecraft.getMinecraft().thePlayer.inventory.getCurrentItem().getItem().onItemRightClick
			(
				Minecraft.getMinecraft().thePlayer.inventory.getCurrentItem(),
				Minecraft.getMinecraft().theWorld,
				Minecraft.getMinecraft().thePlayer
			);
			for(int i = 0; i < 20; i++)
				Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(false));
	        Minecraft.getMinecraft().getNetHandler().addToSendQueue(new C07PacketPlayerDigging());
			Minecraft.getMinecraft().thePlayer.inventory.getCurrentItem().getItem().onPlayerStoppedUsing
			(
				Minecraft.getMinecraft().thePlayer.inventory.getCurrentItem(),
				Minecraft.getMinecraft().theWorld,
				Minecraft.getMinecraft().thePlayer,
				10
			);
		}
	}
}


