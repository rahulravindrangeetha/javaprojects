package com.rahul.journal.entity;

import java.sql.Blob;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.rahul.journal.util.Tag;

@Document
public class Journal 
{
	@GeneratedValue
	@Id
	private int id;
	
	private String title;
	
	private Blob journal;
	
	@JsonDeserialize(using=LocalTimeDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	//@Convert(converter=TimeConvertor.class)
	private LocalTime time;
	
	@JsonDeserialize(using=LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	//@Convert(converter=DateConvertor.class)
	private LocalDate date;
	
	private Tag tagValue;
	
	@OneToMany(mappedBy="journal")
	private List<Attachment> attachments;
		
	
	
	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Tag getTagValue()
	{
		return tagValue;
	}

	public void setTagValue(Tag tagValue) 
	{
		this.tagValue = tagValue;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Blob getJournal() {
		return journal;
	}

	public void setJournal(Blob journal) {
		this.journal = journal;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}
	
	

}
