package com.theatre;

import java.util.HashSet;
import java.util.Set;

public class SeatGroup {
	
	private Set<Seat> seatGroup= new HashSet<Seat>();
	
	public void addSeat(Seat seat) {
		seatGroup.add(seat);
	}
	
	public int getSize() {
		return seatGroup.size();
	}

	@Override
	public String toString() {
		return " [seatGroup=" + seatGroup + "]";
	}
	

}
