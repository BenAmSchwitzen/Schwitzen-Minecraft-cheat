package schwitzen.util;





import java.awt.Component;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import schwitzen.Client;

public class ChatUtil  {
	
	static String prefix = "[" + Client.name + "]";
	
	public static void sendMessage(String msg) {
		
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(prefix + "  " + msg));
		Minecraft.getMinecraft().thePlayer.sendChatMessage("test");
	}

}
