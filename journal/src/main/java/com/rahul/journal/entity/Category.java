package com.rahul.journal.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.springframework.stereotype.Indexed;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

@Entity
@Indexed
public class Category 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Type(type="objectid")
	private String id;
	
	private String desc;
	
	@JsonDeserialize(using=LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate addedDate;

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

	public LocalDate getAddedDate() 
	{
		return addedDate;
	}

	public void setAddedDate(LocalDate addedDate)
	{
		this.addedDate = addedDate;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", desc=" + desc + ", addedDate=" + addedDate + "]";
	}
	
	
	
	
	
	
	

}
