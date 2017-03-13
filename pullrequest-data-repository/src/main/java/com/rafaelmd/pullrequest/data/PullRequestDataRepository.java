package com.rafaelmd.pullrequest.data;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.rafaelmd.pullrequest.interfaces.PullRequestDataProvider;
import com.rafaelmd.pullrequest.models.PullRequest;

@Repository
public class PullRequestDataRepository implements PullRequestDataProvider {

	@Override
	public List<PullRequest> list() {
		List<PullRequest> list = new ArrayList<PullRequest>();
		PullRequest pr  = new PullRequest();
		pr.url = "http://repo.com";
		list.add(pr);
		return list;
	}

	@Override
	public PullRequest insert(PullRequest pr) {
		return pr;
	}

}
