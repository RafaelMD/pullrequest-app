package com.rafaelmd.pullrequest.interfaces;

import java.util.List;

import com.rafaelmd.pullrequest.models.PullRequest;

public interface PullRequestDataProvider {
    List<PullRequest> list();
    PullRequest insert(PullRequest pr);
}

