package nz.ac.auckland.concert.common;

import java.io.Serializable;

import org.joda.time.DateTime;

public class ConcertDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String _title;
	private DateTime _date;

	public ConcertDetails(String title, DateTime date) {
		_title = title;
		_date = date;
	}
	
	public String getTitle() {
		return _title;
	}
	
	public DateTime getDateTime() {
		return _date;
	}
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(getClass().getName());
		buffer.append(":title=");
		buffer.append(_title);
		buffer.append(",date=");
		buffer.append(_date);
		buffer.append("]");
		return buffer.toString();
	}
}
