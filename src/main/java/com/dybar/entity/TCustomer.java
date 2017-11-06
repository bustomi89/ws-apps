package com.dybar.entity;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TCustomer generated by hbm2java
 */
@Entity
@Table(name = "t_customer", schema = "public")
public class TCustomer implements java.io.Serializable {

	private BigDecimal customerId;
	private Date modifiedOn;
	private String modifiedBy;
	private Date createdOn;
	private String createdBy;
	private String customerName;
	private Date birthdate;
	private BigDecimal customerAge;
	private String clientAddress;
	private String postalCode;
	private String phoneNumber;
	private String email;
	private String identityType;
	private String identityNumber;
	private String reference;
	private BigDecimal numeric;

	public TCustomer() {
	}

	public TCustomer(BigDecimal customerId) {
		this.customerId = customerId;
	}

	public TCustomer(BigDecimal customerId, Date modifiedOn, String modifiedBy, Date createdOn, String createdBy,
			String customerName, Date birthdate, BigDecimal customerAge, String clientAddress, String postalCode,
			String phoneNumber, String email, String identityType, String identityNumber, String reference,
			BigDecimal numeric) {
		this.customerId = customerId;
		this.modifiedOn = modifiedOn;
		this.modifiedBy = modifiedBy;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.customerName = customerName;
		this.birthdate = birthdate;
		this.customerAge = customerAge;
		this.clientAddress = clientAddress;
		this.postalCode = postalCode;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.identityType = identityType;
		this.identityNumber = identityNumber;
		this.reference = reference;
		this.numeric = numeric;
	}

	@Id

	@Column(name = "customer_id", unique = true, nullable = false, precision = 65535, scale = 65531)
	public BigDecimal getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(BigDecimal customerId) {
		this.customerId = customerId;
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

	@Column(name = "customer_name")
	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "birthdate", length = 8)
	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@Column(name = "customer_age", precision = 65535, scale = 65531)
	public BigDecimal getCustomerAge() {
		return this.customerAge;
	}

	public void setCustomerAge(BigDecimal customerAge) {
		this.customerAge = customerAge;
	}

	@Column(name = "client_address")
	public String getClientAddress() {
		return this.clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	@Column(name = "postal_code", length = 5)
	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Column(name = "phone_number", length = 15)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "identity_type", length = 5)
	public String getIdentityType() {
		return this.identityType;
	}

	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}

	@Column(name = "identity_number", length = 25)
	public String getIdentityNumber() {
		return this.identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	@Column(name = "reference", length = 5)
	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Column(name = "numeric", precision = 65535, scale = 65531)
	public BigDecimal getNumeric() {
		return this.numeric;
	}

	public void setNumeric(BigDecimal numeric) {
		this.numeric = numeric;
	}

}
