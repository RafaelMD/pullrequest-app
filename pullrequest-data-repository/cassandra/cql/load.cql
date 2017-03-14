CREATE KEYSPACE IF NOT EXISTS PullRequestListKeySpace
WITH REPLICATION = {'class': 'SimpleStrategy', 'replication_factor': 1};

USE PullRequestListKeySpace;

CREATE TABLE IF NOT EXISTS PullRequest (
  id UUID PRIMARY KEY,
  url TEXT,
  branch TEXT,
  comment TEXT
);