package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Invitations;
import com.revature.services.InvitationsService;

@RestController
@CrossOrigin
@RequestMapping("invitations")
public class InvitationsController {

	@Autowired
	private InvitationsService is;

	// Find All Users
	@GetMapping
	public List<Invitations> findAll() {
		System.out.println("Finding all Invitations");
		List<Invitations> invitations = new ArrayList<>();
		return is.findAll();
	}

	@CrossOrigin
	@GetMapping("{id}")
	public Invitations findById(@PathVariable int id) {
		Invitations invitations = is.findOne(id);
		return invitations;
	}

	@GetMapping("event/{id}")
	public List<Invitations> findAllInvitations(@PathVariable int id) {
		List<Invitations> invitations = is.findByEventId(id);
//		return invitations.getInvitations();
		return invitations;
	}

	@GetMapping("event/{eventId}/status/{statusId}")
	public List<Invitations> findAttendees(@PathVariable int eventId, @PathVariable int statusId) {
		List<Invitations> invitations = is.findByEventAndStatusId(eventId, statusId);
		return invitations;
	}

//	//Update Invitation Status
//	@PutMapping("/status/{id}")
//	Attendees replaceStatus( @PathVariable int id, @RequestBody Attendees newStatus) {
//		Attendees attendees = as.replaceStatus(id, newStatus);
//		return attendees;
//	}

}
