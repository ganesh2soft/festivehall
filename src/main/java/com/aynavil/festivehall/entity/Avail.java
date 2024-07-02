package com.aynavil.festivehall.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table
public class Avail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long availId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date availabilityDateTime;

    public enum AvailableStatus {
        BOOKED,
        AVAILABLE,
        MAINTENANCE
    }

    @Enumerated(EnumType.STRING)
    private AvailableStatus availableStatus;

    @ManyToOne
    @JoinColumn(name = "hallcodeno",referencedColumnName = "hallId")
    private PartyHall partyhall;

    public Avail() {
        this.availableStatus = AvailableStatus.MAINTENANCE; // Set default value
    }

	public Long getAvailId() {
		return availId;
	}

	public void setAvailId(Long availId) {
		this.availId = availId;
	}

	public Date getAvailabilityDateTime() {
		return availabilityDateTime;
	}

	public void setAvailabilityDateTime(Date availabilityDateTime) {
		this.availabilityDateTime = availabilityDateTime;
	}

	public AvailableStatus getAvailableStatus() {
		return availableStatus;
	}

	public void setAvailableStatus(AvailableStatus availableStatus) {
		this.availableStatus = availableStatus;
	}

	public PartyHall getPartyhall() {
		return partyhall;
	}

	public void setPartyhall(PartyHall partyhall) {
		this.partyhall = partyhall;
	}

	public Avail(Long availId, Date availabilityDateTime, AvailableStatus availableStatus, PartyHall partyhall) {
		super();
		this.availId = availId;
		this.availabilityDateTime = availabilityDateTime;
		this.availableStatus = availableStatus;
		this.partyhall = partyhall;
	}

	
}
