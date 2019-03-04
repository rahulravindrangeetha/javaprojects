package com.rahul.journal.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.springframework.stereotype.Indexed;

import com.rahul.journal.util.GoalType;

@Entity
@Indexed
public class Goal 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Type(type="objectid")
	private String id;
	
	private String desc;
	
	private int version;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private LocalDate expectedEndDate;
	
	private GoalType type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalDate getExpectedEndDate() {
		return expectedEndDate;
	}

	public void setExpectedEndDate(LocalDate expectedEndDate) {
		this.expectedEndDate = expectedEndDate;
	}

	public GoalType getType() {
		return type;
	}

	public void setType(GoalType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Goal [id=" + id + ", desc=" + desc + ", version=" + version + ", startDate=" + startDate + ", endDate="
				+ endDate + ", expectedEndDate=" + expectedEndDate + ", type=" + type + "]";
	}
	
	
	
	
	

}
