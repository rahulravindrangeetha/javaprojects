package com.rahul.journal.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;
import org.springframework.stereotype.Indexed;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.rahul.journal.util.GoalType;

@Entity
@Indexed
public class GoalHub 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Type(type="objectid")
	private String id;
	
	private String desc;
	
	@JsonDeserialize(using=LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate startDate;
	
	@JsonDeserialize(using=LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate endDate;
		
	private GoalType type;
	
	@ManyToOne
	private Category category;

	public String getId() 
	{
		return id;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getDesc() 
	{
		return desc;
	}

	public void setDesc(String desc) 
	{
		this.desc = desc;
	}

	public LocalDate getStartDate() 
	{
		return startDate;
	}

	public void setStartDate(LocalDate startDate)
	{
		this.startDate = startDate;
	}

	public LocalDate getEndDate() 
	{
		return endDate;
	}

	public void setEndDate(LocalDate endDate) 
	{
		this.endDate = endDate;
	}

	public GoalType getType() 
	{
		return type;
	}

	public void setType(GoalType type) 
	{
		this.type = type;
	}

	public Category getCategory() 
	{
		return category;
	}

	public void setCategory(Category category) 
	{
		this.category = category;
	}
	
	

}
