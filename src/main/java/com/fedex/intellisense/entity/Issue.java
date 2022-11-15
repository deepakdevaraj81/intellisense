package com.fedex.intellisense.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name = "ISSUE")
public class Issue implements Serializable {
	
	private static final long serialVersionUID = -156767367637367367L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ISSUE_ID")
	private Long issueId;
	@Column(name = "ISSUE_NAME")
	private String issueName;
	@Column(name = "ISSUE_DESC")
	private String issueDescription;
	
	public Long getIssueId() {
		return issueId;
	}
	public void setIssueId(Long issueId) {
		this.issueId = issueId;
	}
	public String getIssueName() {
		return issueName;
	}
	
	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}
	public String getIssueDescription() {
		return issueDescription;
	}
	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}
	
	
	

}
