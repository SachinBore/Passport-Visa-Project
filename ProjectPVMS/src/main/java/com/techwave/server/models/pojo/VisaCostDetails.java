package com.techwave.server.models.pojo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "visa_cost_details")
public class VisaCostDetails {

	@EmbeddedId
	private VisaCostDetailsCompositeKey id;
	private double cost;

	public VisaCostDetails() {
		super();
	}

	public VisaCostDetails(VisaCostDetailsCompositeKey id, double cost) {
		super();
		this.id = id;
		this.cost = cost;
	}

	public VisaCostDetailsCompositeKey getId() {
		return id;
	}

	public void setId(VisaCostDetailsCompositeKey id) {
		this.id = id;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
}
