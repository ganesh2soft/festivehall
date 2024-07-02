package com.aynavil.festivehall.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class PartyHall {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "partyHall_seq")
    @SequenceGenerator(name = "partyHall_seq", sequenceName = "partyHall_sequence", allocationSize = 1, initialValue = 51)
	private Long hallId;
	@Column(nullable = false, unique = true)
	private String hallName; // Golden Park
	@Column(nullable = false)
	private int hallCapacity; // 1000
	@Column(nullable = false)
	private String hallAc; // AC
	@Column(nullable = false)
	private String diningCapacity; // 500
	@Column(nullable = false)
	private String diningType; // lawn or buffet or regular
	@Column(nullable = false)
	private int hallChargeperday; // 700000
	@Column(nullable = false)
	private String hallImage;
	public Long getHallId() {
		return hallId;
	}
	public void setHallId(Long hallId) {
		this.hallId = hallId;
	}
	public String getHallName() {
		return hallName;
	}
	public void setHallName(String hallName) {
		this.hallName = hallName;
	}
	public int getHallCapacity() {
		return hallCapacity;
	}
	public void setHallCapacity(int hallCapacity) {
		this.hallCapacity = hallCapacity;
	}
	public String getHallAc() {
		return hallAc;
	}
	public void setHallAc(String hallAc) {
		this.hallAc = hallAc;
	}
	public String getDiningCapacity() {
		return diningCapacity;
	}
	public void setDiningCapacity(String diningCapacity) {
		this.diningCapacity = diningCapacity;
	}
	public String getDiningType() {
		return diningType;
	}
	public void setDiningType(String diningType) {
		this.diningType = diningType;
	}
	public int getHallChargeperday() {
		return hallChargeperday;
	}
	public void setHallChargeperday(int hallChargeperday) {
		this.hallChargeperday = hallChargeperday;
	}
	public String getHallImage() {
		return hallImage;
	}
	public void setHallImage(String hallImage) {
		this.hallImage = hallImage;
	}
	@Override
	public String toString() {
		return "PartyHall [hallId=" + hallId + ", hallName=" + hallName + ", hallCapacity=" + hallCapacity + ", hallAc="
				+ hallAc + ", diningCapacity=" + diningCapacity + ", diningType=" + diningType + ", hallChargeperday="
				+ hallChargeperday + ", hallImage=" + hallImage + "]";
	}
	public PartyHall() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PartyHall(Long hallId, String hallName, int hallCapacity, String hallAc, String diningCapacity,
			String diningType, int hallChargeperday, String hallImage) {
		super();
		this.hallId = hallId;
		this.hallName = hallName;
		this.hallCapacity = hallCapacity;
		this.hallAc = hallAc;
		this.diningCapacity = diningCapacity;
		this.diningType = diningType;
		this.hallChargeperday = hallChargeperday;
		this.hallImage = hallImage;
	}
}
