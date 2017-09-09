package nz.ac.auckland.concert.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import nz.ac.auckland.concert.common.Concert;
import nz.ac.auckland.concert.common.ConcertService;
import nz.ac.auckland.concert.common.Config;

public class Client {

	private static ConcertService _proxy;

	@BeforeClass
	public static void getProxy() {
		try {
			Registry lookupService = LocateRegistry.getRegistry("localhost", Config.REGISTRY_PORT);
			_proxy = (ConcertService) lookupService.lookup(Config.SERVICE_NAME);
		} catch (RemoteException e) {
			System.out.println("Unable to connect to the RMI Registry");
		} catch (NotBoundException e) {
			System.out.println("Unable to acquire a proxy for the Concert service");
		}
	}

	@Test
	public void testCreate() throws RemoteException {
		try {
			Concert concertA = _proxy.createConcert(new Concert(null, null, null));
			Concert concertB = _proxy.createConcert(new Concert(null, null, null));

			System.out.println("ConcertA's Id is " + concertA.getId());
			System.out.println("ConcertB's Id is " + concertB.getId());

			List<Concert> remoteConcerts = _proxy.getAllConcerts();

			assertTrue(remoteConcerts.contains(concertA));
			assertTrue(remoteConcerts.contains(concertB));
			assertEquals(2, remoteConcerts.size());

			for (Concert c : remoteConcerts) {
				System.out.println(c.toString());
			}
		} catch (Exception e) {
			fail();
		}
	}
}
