package com.partnerconnect.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.partnerconnect.controller.LoginController;
import com.partnerconnect.model.Partner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:application-context.xml")
public class PartnerConnectTest {
	@Autowired
	 LoginController loginController;

	@Test
	public void testSavePartner() {
		for (int i = 0; i < 1000; i++) {
			String partnerName = "Sangeetha" + i;
			String group = "Che";
			String streetAddress = "therku";
			String city = "sundu";
			String state = "Gobi";
			int zipCode = 233;
			Partner addPartner = new Partner();
			addPartner.setPartnerName(partnerName);
			addPartner.setGroup(group);
			addPartner.setStreetAddress(streetAddress);
			addPartner.setCity(city);
			addPartner.setState(state);
			addPartner.setZipCode(zipCode);
			//Map<String, String> map = 
			loginController.savePartner(addPartner);
			/*String result = map.values().iterator().next();
			Assert.assertEquals("Partner saved successfully", result);*/
		}

	}

}
