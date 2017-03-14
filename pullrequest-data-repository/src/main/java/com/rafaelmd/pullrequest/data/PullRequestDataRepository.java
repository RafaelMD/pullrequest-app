package com.rafaelmd.pullrequest.data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.rafaelmd.pullrequest.interfaces.PullRequestDataProvider;
import com.rafaelmd.pullrequest.models.PullRequest;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.datastax.driver.core.utils.UUIDs;

@Repository
public class PullRequestDataRepository implements PullRequestDataProvider {
	private final String KEYSPACE = "PullRequestListKeySpace";
    private final String TABLE = "PullRequest";

    private Session session;

    @Autowired
    public PullRequestDataRepository(Session session){
        this.session = session;
    }

    @Override
    public List<PullRequest> list() {
        Select select = QueryBuilder.select().from(KEYSPACE, TABLE);
        ResultSet resultSet = session.execute(select);
        return convertPullRequests(resultSet);
    }

    @Override
    public PullRequest insert(PullRequest pr) {
        UUID id = UUIDs.timeBased();

        Insert insert = QueryBuilder.insertInto(KEYSPACE, TABLE)
                .value("id", id)
                .value("url", pr.url)
                .value("branch", pr.branch)
                .value("comment", pr.comment);
        session.execute(insert);

        pr.id = id;
        return pr;
    }

    private List<PullRequest> convertPullRequests(ResultSet resultSet) {
        List<PullRequest> list = new ArrayList<>();

        for(Row row: resultSet.all())
            list.add(convertPullRequest(row));

        return list;
    }

    private PullRequest convertPullRequest(Row row) {
        PullRequest pr = new PullRequest();
        pr.comment = row.getString("comment");
        pr.url = row.getString("url");
        pr.branch = row.getString("branch");
        pr.id = row.getUUID("id");
        return pr;
    }
}
