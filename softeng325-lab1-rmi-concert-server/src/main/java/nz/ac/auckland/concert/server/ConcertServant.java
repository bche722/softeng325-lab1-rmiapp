package nz.ac.auckland.concert.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import nz.ac.auckland.concert.common.Concert;


/**
 * An implementation of the Shape interface. A ShapeServant instance is a 
 * remotely accessible object that represents a particular Shape on a shared 
 * whiteboard. 
 * 
 */
public class ConcertServant extends UnicastRemoteObject implements Concert {

	private static final long serialVersionUID = 1L;
	
	private Concert _state;
	private int _id;
	
	/**
	 * Creates a new ShapeServant instance. 
	 * @param graphic the state of the new ShapeServant object.
	 * @param id the unique ID of the new ShapeServant object.
	 * @throws RemoteException if the ShapeServant instance cannot be created. 
	 * This can happen if the RMI run-time does not have sufficient resources
	 * (e.g. sockets) to host an additional remote object.
	 */
	public ConcertServant(Concert concert, Integer id) throws RemoteException {
		super();
		this._state = concert;
		this._id = id;
	}

	public synchronized Concert getAllState() throws RemoteException {
		return _state;
	}

	public synchronized Integer getId() throws RemoteException {
		return _id;
	}

}
