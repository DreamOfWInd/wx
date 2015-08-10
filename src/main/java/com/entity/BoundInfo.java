package com.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@Entity
@Table(name = "BOUNDINFO", schema = "wx")
public class BoundInfo  implements Serializable{

	// Fields
	
	private String id;
	private Employee employee;
	private String oppenId;
	// Constructors

	/** default constructor */
	public BoundInfo() {
	}

	/** minimal constructor */
	public BoundInfo(String id) {
		this.id = id;
	}

	/** full constructor */
	public BoundInfo(Employee employee, String oppenId) {
		this.employee = employee;
		this.oppenId = oppenId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "BoundID", unique = true, nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Employee_ID", nullable = false)
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@Column(name = "WXNO", nullable = false)
	public String getOppenId() {
		return this.oppenId;
	}

	public void setOppenId(String oppenId) {
		this.oppenId = oppenId;
	}
	
}