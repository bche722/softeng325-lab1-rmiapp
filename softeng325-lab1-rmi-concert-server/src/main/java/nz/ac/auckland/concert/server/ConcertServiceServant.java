package nz.ac.auckland.concert.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import nz.ac.auckland.concert.common.Concert;
import nz.ac.auckland.concert.common.ConcertServant;
import nz.ac.auckland.concert.common.ConcertService;

public class ConcertServiceServant extends UnicastRemoteObject implements ConcertService { 

	private static final long serialVersionUID = 1L;
	
	private Map<Long,Concert> _concerts;
	private AtomicLong _idCounter;
	
	public ConcertServiceServant() throws RemoteException {
		super();
		_concerts = new HashMap<Long,Concert>();
		_idCounter = new AtomicLong();
	}

	@Override
	public Concert createConcert(Concert concert) throws RemoteException {
		Long id=_idCounter.incrementAndGet();
		Concert newConcert = new ConcertServant(concert.getAllState(), id);
		_concerts.put(id, newConcert);
		return newConcert;
	}

	@Override
	public Concert getConcert(Long id) throws RemoteException {
		return _concerts.get(id);
	}

	@Override
	public boolean updateConcert(Concert concert) throws RemoteException {
		if(_concerts.containsKey(concert.getId())){
			_concerts.replace(concert.getId(), concert);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean deleteConcert(Long id) throws RemoteException {
		if(_concerts.containsKey(id)){
			_concerts.remove(id);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<Concert> getAllConcerts() throws RemoteException {
		List<Concert> list= new ArrayList<Concert>();
		for(Long a:_concerts.keySet()){
			list.add(_concerts.get(a));
		}
		return list;
	}

	@Override
	public void clear() throws RemoteException {
		_concerts = new HashMap<Long,Concert>();
		_idCounter = new AtomicLong();
	}
	

}
