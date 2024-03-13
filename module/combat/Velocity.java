package schwitzen.module.combat;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C00PacketKeepAlive;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.server.S00PacketKeepAlive;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S27PacketExplosion;
import schwitzen.events.Event;
import schwitzen.events.EventMotion;
import schwitzen.events.EventType;
import schwitzen.events.ReceivePacketEvent;
import schwitzen.events.com.darkmagician6.eventapi.EventTarget;
import schwitzen.events.listeners.EventUpdate;

public class Velocity extends schwitzen.module.Module{

	public Velocity() {
		super("Velocity", Keyboard.KEY_C, Category.COMBAT);
		
	}
	
	// Gamer134f
	
	
	
   @EventTarget
   public void onEvent( ReceivePacketEvent event) {
	   
	   if(event.packet instanceof S12PacketEntityVelocity) {
		   final S12PacketEntityVelocity packet = (S12PacketEntityVelocity)event.packet;
		   if(event.getPacket() instanceof S12PacketEntityVelocity || event.getPacket() instanceof C00PacketKeepAlive || event.getPacket() instanceof S00PacketKeepAlive) {
			   System.out.println("test");
			   event.setCancelled(true);
		   }
	   }
	   
   }
	
	
	

}