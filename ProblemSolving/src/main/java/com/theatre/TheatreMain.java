package com.theatre;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TheatreMain {
	
	public static void main(String[] arg) {
		Map<String,List<Seat>> theatre = new TreeMap<String,List<Seat>>();
		
		fillSeats(theatre);
		sortValues(theatre);
		System.out.println(theatre);
		System.out.println("Empty seats are "+findEmptySeatGroups(theatre));
		//Collections.sort(theatre);
		/*for (Entry<String,List<Seat>> entry : theatre.entrySet()) {
			System.out.println("Key is "+ entry.getKey() + " and value is "+entry.getValue());
		}*/
		
	}
	
	private static void sortValues(Map<String,List<Seat>> theatre) {
		for (Entry<String,List<Seat>> entry : theatre.entrySet()) {
			Collections.sort(entry.getValue());
		}
	}
	
	private static List<SeatGroup> findEmptySeatGroups(Map<String,List<Seat>> theatre) {
		List<SeatGroup> seatGroup = new ArrayList<SeatGroup>();
		for (Entry<String,List<Seat>> entry : theatre.entrySet()) {
			SeatGroup group = new SeatGroup();
			for (Seat seat : entry.getValue()) {
				if (!seat.isOccupied()) {
					group.addSeat(seat);
				}else {
					group = new SeatGroup();
				}
				if (group.getSize() >=3) {
					seatGroup.add(group);
					group = new SeatGroup();
				}
			}
		}
		return seatGroup;
	}
	
	private static void fillSeats(Map<String,List<Seat>> theatre) {
		List<Seat> seatings = new ArrayList<Seat>();
		seatings.add(Seat.getNewSeat(2,"A").personName("Temp2"));
		seatings.add(Seat.getNewSeat(1,"A").personName("abc"));
		seatings.add(Seat.getNewSeat(3,"A"));
		seatings.add(Seat.getNewSeat(5,"A"));
		seatings.add(Seat.getNewSeat(4,"A"));
		theatre.put("A", seatings);
		
		seatings = new ArrayList<Seat>();
		seatings.add(Seat.getNewSeat(3,"B"));
		seatings.add(Seat.getNewSeat(1,"B"));
		seatings.add(Seat.getNewSeat(2,"B"));
		theatre.put("B", seatings);
		
		seatings = new ArrayList<Seat>();
		seatings.add(Seat.getNewSeat(1,"C"));
		seatings.add(Seat.getNewSeat(2,"C"));
		seatings.add(Seat.getNewSeat(3,"C").personName("nm"));
		seatings.add(Seat.getNewSeat(4,"C"));
		seatings.add(Seat.getNewSeat(5,"C"));
		seatings.add(Seat.getNewSeat(6,"C"));
		theatre.put("C", seatings);
		
		
	}

}
