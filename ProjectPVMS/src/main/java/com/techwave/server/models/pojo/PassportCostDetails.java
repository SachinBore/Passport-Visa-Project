package com.techwave.server.models.pojo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "passport_cost_details")
public class PassportCostDetails {

	@EmbeddedId
	PassportCostDetailsCompositeKey id;
	private Double amount;

	public PassportCostDetails() {
		super();
	}

	public PassportCostDetails(PassportCostDetailsCompositeKey id, Double amount) {
		super();
		this.id = id;
		this.amount = amount;
	}

	public PassportCostDetailsCompositeKey getId() {
		return id;
	}

	public void setId(PassportCostDetailsCompositeKey id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
