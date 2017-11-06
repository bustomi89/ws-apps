package com.dybar.entity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * GroupUser generated by hbm2java
 */
@Entity
@Table(name = "group_user", schema = "public")
public class GroupUser implements java.io.Serializable {

	private String groupId;
	private Date modifiedOn;
	private String modifiedBy;
	private Date createdOn;
	private String createdBy;
	private String groupName;
	private String description;

	public GroupUser() {
	}

	public GroupUser(String groupId) {
		this.groupId = groupId;
	}

	public GroupUser(String groupId, Date modifiedOn, String modifiedBy, Date createdOn, String createdBy,
			String groupName, String description) {
		this.groupId = groupId;
		this.modifiedOn = modifiedOn;
		this.modifiedBy = modifiedBy;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.groupName = groupName;
		this.description = description;
	}

	@Id

	@Column(name = "group_id", unique = true, nullable = false, length = 20)
	public String getGroupId() {
		return this.groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_on", length = 8)
	public Date getModifiedOn() {
		return this.modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	@Column(name = "modified_by", length = 20)
	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on", length = 8)
	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Column(name = "created_by", length = 20)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "group_name", length = 100)
	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Column(name = "description", length = 200)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}