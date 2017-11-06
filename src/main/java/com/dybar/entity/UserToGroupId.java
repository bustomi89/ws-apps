package com.dybar.entity;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UserToGroupId generated by hbm2java
 */
@Embeddable
public class UserToGroupId implements java.io.Serializable {

	private String userId;
	private String groupId;

	public UserToGroupId() {
	}

	public UserToGroupId(String userId, String groupId) {
		this.userId = userId;
		this.groupId = groupId;
	}

	@Column(name = "user_id", nullable = false, length = 20)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "group_id", nullable = false, length = 20)
	public String getGroupId() {
		return this.groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserToGroupId))
			return false;
		UserToGroupId castOther = (UserToGroupId) other;

		return ((this.getUserId() == castOther.getUserId()) || (this.getUserId() != null
				&& castOther.getUserId() != null && this.getUserId().equals(castOther.getUserId())))
				&& ((this.getGroupId() == castOther.getGroupId()) || (this.getGroupId() != null
						&& castOther.getGroupId() != null && this.getGroupId().equals(castOther.getGroupId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result + (getGroupId() == null ? 0 : this.getGroupId().hashCode());
		return result;
	}

}