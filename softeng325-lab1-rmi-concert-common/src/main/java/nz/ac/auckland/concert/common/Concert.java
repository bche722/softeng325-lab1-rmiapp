package nz.ac.auckland.concert.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Concert extends Remote {
	
	ConcertDetails getAllState() throws RemoteException;
	
	Long getId() throws RemoteException;
}
