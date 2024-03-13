package schwitzen.events;

import net.minecraft.network.Packet;
import schwitzen.events.com.darkmagician6.eventapi.events.Cancellable;
import schwitzen.events.com.darkmagician6.eventapi.events.Event;

public  class ReceivePacketEvent implements Event,Cancellable{
	   public  Packet packet;
	   public boolean isCancelled;
	   public PacketState state;

	   public ReceivePacketEvent(Packet packet,PacketState state) {
	      this.packet = packet;
	      this.state = state;
	   }

	   public Packet getPacket() {
	      return this.packet;
	   }
	   
	   public PacketState getState() {
		   return this.state;
	   }

	@Override
	public boolean isCancelled() {
		
		return isCancelled;
	}

	@Override
	public void setCancelled(boolean cancelled) {
		
		isCancelled = cancelled;
		
	}
	
	public enum PacketState {
		PRE,POST
	}
	}