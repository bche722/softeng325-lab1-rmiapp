package nz.ac.auckland.concert.common;

import java.io.Serializable;
import org.joda.time.DateTime;

public class Concert implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long _id;
	private String _title;
	private DateTime _date;

	public Concert(Long id, String title, DateTime date) {
		_id = id;
		_title = title;
		_date = date;
	}
	
	public Concert(Long id, Concert concert) {
		_id = id;
		_title = concert._title;
		_date = concert._date;
	}
	
	public Concert(String title, DateTime date) {
		this(null, title, date);
	}
	
	public void setDate(DateTime date) {
		_date = date;
	}
	
	public Long getId() {
		return _id;
	}
	
	public String getTitle() {
		return _title;
	}
	
	public DateTime getDate() {
		return _date;
	}
}
