package bean;

import java.sql.Date;

public class ToDo {
private String title;
private String description;
private String todostatus;
private Date date;
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getTodostatus() {
	return todostatus;
}
public void setTodostatus(String todostatus) {
	this.todostatus = todostatus;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public ToDo(String title, String description, String todostatus, Date date) {
	super();
	this.title = title;
	this.description = description;
	this.todostatus = todostatus;
	this.date = date;
}
public ToDo() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "ToDo [title=" + title + ", description=" + description + ", todostatus=" + todostatus + ", date=" + date
			+ "]";
}

}
