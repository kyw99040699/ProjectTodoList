package com.todo.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TodoItem {
    private String title;
    private String desc;
    private String current_date;
    private String category;
    private String due_date;
    private String people;
    private String place;
	private int id;
	private int comp;


	
    public TodoItem(String title, String desc, String category, String due_date) {
		super();
		this.title = title;
		this.desc = desc;
		this.category = category;
		this.due_date = due_date;
        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");
        this.current_date=f.format(new Date());
	}

	public TodoItem(String title, String desc, String category, String due_date, String people, String place) {
        this.category=category;
		this.title=title;
        this.desc=desc;
        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");
        this.current_date=f.format(new Date());
        this.due_date=due_date;
        this.people = people;
        this.place = place;
        this.comp = 0;
	}

	public TodoItem(String title, String desc, String category, String due_date, String people, String place, int comp) {
        this.category=category;
		this.title=title;
        this.desc=desc;
        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");
        this.current_date=f.format(new Date());
        this.due_date=due_date;
        this.people = people;
        this.place = place;
        this.comp = comp;
	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setCurrent_date(String current_date) {
		this.current_date = current_date;
	}
    

    public String toSaveString() {
    	return category + "##" + title + "##" + desc + "##" + due_date + "##" + current_date + "##" + people + "##" + place + "\n";
    }
    
    
    @Override
	public String toString() {
		return "TodoItem [id=" + id + ", title=" + title + ", desc=" + desc + ", current_date=" + current_date + ", category="
				+ category + ", due_date=" + due_date + ", people=" + people + ", place=" + place + ", comp=" + comp + "]";
	}

	public String getCurrent_date() {
		// TODO Auto-generated method stub
		return current_date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPeople() {
		return people;
	}

	public void setPeople(String people) {
		this.people = people;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getComp() {
		return comp;
	}

	public void setComp(int comp) {
		this.comp = comp;
	}
	
}
