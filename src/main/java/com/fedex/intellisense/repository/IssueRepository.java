package com.fedex.intellisense.repository;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fedex.intellisense.entity.Issue;

@Repository
public interface IssueRepository extends JpaRepository<Issue , Long> {

	
	Logger log = LogManager.getLogger(IssueRepository.class);
	
	@Query(value = "SELECT ISSUE_ID, ISSUE_NAME, ISSUE_DESC FROM ISSUE", nativeQuery = true)
	public List<Issue> getIssues();
	
	public Issue save( Issue issue);
	
	
}
