package com.rafaelmd.pullrequest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelmd.pullrequest.interfaces.PullRequestDataProvider;
import com.rafaelmd.pullrequest.models.PullRequest;

@RestController
public class PullRequestController {
	
	@Autowired
	private PullRequestDataProvider provider;
	
	@RequestMapping("/pullrequest")
    public List<PullRequest> list() {
    	return provider.list();
    }
	
	@RequestMapping(value="/pullrequest", method=RequestMethod.POST)
    public PullRequest insert(@RequestBody() PullRequest pr) {
    	return provider.insert(pr);
    }
}
