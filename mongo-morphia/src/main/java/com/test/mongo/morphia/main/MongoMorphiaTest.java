package com.test.mongo.morphia.main;

import java.net.UnknownHostException;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.test.mongo.morphia.Address;
import com.test.mongo.morphia.Hotel;

public class MongoMorphiaTest {

	/**
	 * @param args
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) throws UnknownHostException {
		Mongo mongo = new MongoClient("localhost");
		Morphia morphia = new Morphia();
		morphia.map(Hotel.class).map(Address.class);
		Datastore ds = morphia.createDatastore(mongo, "testdb");

		for (int i = 0; i < 100; i++) {
			Hotel hotel = new Hotel();
			hotel.setName("My Hotel");
			hotel.setStars(4);

			Address address = new Address();
			address.setStreet("123 Some street");
			address.setCity("Some city");
			address.setPostCode("123 456");
			address.setCountry("Some country");

			// set address
			hotel.setAddress(address);
			System.out.println("" + (i + 1));
			ds.save(hotel);
		}
	}
}
