package com.theatre;

public class Seat implements Comparable<Seat>{
	
	private Integer seatNo;
	
	private String rowName;
	
	private String personName;
	
	private Seat() {}
	
	public static Seat getNewSeat(Integer seatNo,String rowName) {
		Seat seat = new Seat();
		seat.setRowName(rowName);
		return seat.seatNo(seatNo);
	}
	
	
	
	public boolean isOccupied() {
		return personName !=null;
	}

	public Integer getSeatNo() {
		return seatNo;
	}

	public Seat personName(String personName) {
		this.personName = personName;
		return this;
	}
	
	public Seat seatNo(Integer seatNo) {
		this.seatNo = seatNo;
		return this;
	}

	

	@Override
	public int compareTo(Seat o) {
		if (o == null || this.getSeatNo() > o.getSeatNo()) {
			return 1;
		}else if (this.getSeatNo() < o.getSeatNo()) {
			return -1;
		}
		return 0;
	}

	public String getRowName() {
		return rowName;
	}

	public void setRowName(String rowName) {
		this.rowName = rowName;
	}

	@Override
	public String toString() {
		return "Seat [seatNo=" + seatNo + ", rowName=" + rowName + "]";
	}

	
	

}
