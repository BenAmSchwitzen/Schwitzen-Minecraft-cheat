package schwitzen.events;

import net.minecraft.network.Packet;

public final class SendPacket extends Cancellable {
	   private final Packet packet;

	   public SendPacket(Packet packet) {
	      this.packet = packet;
	   }

	   public Packet getPacket() {
	      return this.packet;
	   }
	}