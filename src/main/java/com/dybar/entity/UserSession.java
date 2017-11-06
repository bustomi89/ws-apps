package com.dybar.entity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * UserSession generated by hbm2java
 */
@Entity
@Table(name = "user_session", schema = "public")
public class UserSession implements java.io.Serializable {

	private String sessionid;
	private String userId;
	private Date sessionTimeout;
	private String ipadress;
	private String hostname;

	public UserSession() {
	}

	public UserSession(String sessionid) {
		this.sessionid = sessionid;
	}

	public UserSession(String sessionid, String userId, Date sessionTimeout, String ipadress, String hostname) {
		this.sessionid = sessionid;
		this.userId = userId;
		this.sessionTimeout = sessionTimeout;
		this.ipadress = ipadress;
		this.hostname = hostname;
	}

	@Id

	@Column(name = "sessionid", unique = true, nullable = false, length = 100)
	public String getSessionid() {
		return this.sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

	@Column(name = "user_id", length = 20)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "session_timeout", length = 8)
	public Date getSessionTimeout() {
		return this.sessionTimeout;
	}

	public void setSessionTimeout(Date sessionTimeout) {
		this.sessionTimeout = sessionTimeout;
	}

	@Column(name = "ipadress", length = 20)
	public String getIpadress() {
		return this.ipadress;
	}

	public void setIpadress(String ipadress) {
		this.ipadress = ipadress;
	}

	@Column(name = "hostname", length = 20)
	public String getHostname() {
		return this.hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

}