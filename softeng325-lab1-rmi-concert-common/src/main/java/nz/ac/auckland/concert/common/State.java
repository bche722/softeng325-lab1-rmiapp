package nz.ac.auckland.concert.common;

import java.io.Serializable;
import java.rmi.RemoteException;

import org.joda.time.DateTime;

public class State implements Concert,Serializable {

private static final long serialVersionUID = 1L;
	
	private String _title;
	private DateTime _date;

	public State(String title, DateTime date) {
		_title = title;
		_date = date;
	}
	
	public void setDate(DateTime date) {
		_date = date;
	}
		
	public String getTitle() {
		return _title;
	}
	
	public DateTime getDate() {
		return _date;
	}
	
	@Override
	public State getAllState() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getId() throws RemoteException {
		return null;
	}


	
}
