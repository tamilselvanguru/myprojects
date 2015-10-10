package com.partnerconnect.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.partnerconnect.model.Partner;
import com.partnerconnect.model.Critical;
import com.partnerconnect.model.Groups;
import com.partnerconnect.model.User;
import com.partnerconnect.service.UserService;
/*
* Login controller for user login
*/
@Controller("loginController")
public class LoginController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/loginController", method = RequestMethod.GET)
	public ModelAndView verifyAuthentication(@ModelAttribute User user) {
		try {
			System.out.println("login");
			System.out.println(user);
			user = userService.getUser(user);
			ModelAndView mv = new ModelAndView("partnerConnect", "user", user);
			return mv;
		} catch (Exception e) {
			ModelAndView mv = new ModelAndView("error", "message",
					e.getMessage());
			return mv;
		}
	}

	@RequestMapping(value = "/critical", method = RequestMethod.GET)
	public @ResponseBody
	List<Critical> getEmailInfo() {
		return userService.getEmailInfo();

	}

	@RequestMapping(value = "/group", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, String> getGroupId(@RequestParam("name") String name) {
		Map<String, String> map = new HashMap<String, String>();

		Groups groups = userService.getGroupId(name);
		if (groups != null) {
			String groupId = groups.getGroupId();
			map.put("data", groupId);

			return map;
		} else {
			String value = "No group found";
			map.put("emptyData", value);
			System.out.println(map.toString());
			return map;
		}

	}

	@RequestMapping(value = "/addPartner", method = RequestMethod.POST)
	public @ResponseBody
	Map savePartner(@ModelAttribute Partner partner) {
		Map map = new HashMap();
		// AddPartner addPartner = new AddPartner();
		/*
		 * addPartner.setPartnerName(partnerName);
		 * 
		 * addPartner.setGroup(group);
		 * addPartner.setStreetAddress(streetAddress); addPartner.setCity(city);
		 * addPartner.setState(state); addPartner.setZipCode(zipCode);
		 */
		if (partner != null && partner.getId() == 0) {
			int id = userService.savePartner(partner);

			System.out.println("partner is saved" + id);
			map.put("partnerId", id);
			String message = "Partner object saved successfully";
			map.put("message", message);
		} else {
userService.savePartner(partner);
map.put("data","Partner details updated successfully");
		}

		return map;

	}

	@RequestMapping(value = "/partnersList", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody
	Map getPartnersList() {
		Map map = new HashMap();
		List list = userService.partnersList();
		if (list != null && list.size() > 0) {
			map.put("partnerList", list);
			return map;
		} else {
			map.put("empty", "List is Empty");
			return map;
		}

	}

	@RequestMapping(value = "/getPartner", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Partner> getPartner(@RequestParam("name") String name) {
		Partner partner = userService.getPartner(name);
		System.out.println("selected partner");
		Map<String, Partner> map = new HashMap<String, Partner>();
		map.put("partner", partner);
		return map;

	}

	@RequestMapping(value = "/deletePartner", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, String> deletePartner(@RequestParam("uid") int id) {
		System.out.println("delete partner");
		Map<String, String> map = new HashMap<String, String>();
		userService.deletePartner(id);
		map.put("data", "Partner deleted successfully" + id);
		return map;

	}
}
