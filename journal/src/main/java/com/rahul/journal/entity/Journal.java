package com.rahul.journal.entity;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

import com.rahul.journal.util.Tag;

@Entity
public class Journal 
{
	@GeneratedValue
	private int id;
	
	private String title;
	
	private Blob journal;
	
	private Timestamp timestamp;
	
	private Tag tagValue;
	
	@OneToMany(mappedBy="journal")
	private List<Attachment> attachments;
		
	
	public Tag getTagValue()
	{
		return tagValue;
	}

	public void setTagValue(Tag tagValue) 
	{
		this.tagValue = tagValue;
	}

	public Timestamp getTimestamp() 
	{
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp)
	{
		this.timestamp = timestamp;
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
