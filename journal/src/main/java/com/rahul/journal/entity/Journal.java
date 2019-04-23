package com.rahul.journal.entity;

import java.sql.Blob;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Indexed;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.rahul.journal.util.Tag;

@Entity
@Indexed
public class Journal 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Type(type = "objectid")
    private String id;
	
	private String title;
	
	private String journal;
	
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

	public String getId() 
	{
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getJournal() {
		return journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	@Override
	public String toString() {
		return "Journal [id=" + id + ", title=" + title + ", journal=" + journal + ", time=" + time + ", date=" + date
				+ ", tagValue=" + tagValue + ", attachments=" + attachments + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Journal other = (Journal) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
