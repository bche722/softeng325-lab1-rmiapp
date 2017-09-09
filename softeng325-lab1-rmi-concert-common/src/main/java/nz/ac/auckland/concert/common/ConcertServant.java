package nz.ac.auckland.concert.common;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import nz.ac.auckland.concert.common.Concert;
import nz.ac.auckland.concert.common.ConcertDetails;

public class ConcertServant extends UnicastRemoteObject implements Concert {

	private static final long serialVersionUID = 1L;
	
	private ConcertDetails _state;
	private Long _id;
	
	public ConcertServant(ConcertDetails cd, Long id) throws RemoteException {
		super();
		this._state = cd;
		this._id = id;
	}

	public synchronized ConcertDetails getAllState() throws RemoteException {
		return _state;
	}

	public synchronized Long getId() throws RemoteException {
		return _id;
	}
}
