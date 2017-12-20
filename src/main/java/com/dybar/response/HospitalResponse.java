package com.dybar.response;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.dybar.entity.TTreatment;
import com.dybar.entity.TTreatmentDetail;


public class HospitalResponse implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal treatmentId;
	private Date modifiedOn;
	private String modifiedBy;
	private Date createdOn;
	private String createdBy;
	private BigDecimal petId;
	private String treatmentPlan;
	private String recommendation;
	private Date reminder;
	private List<TTreatmentDetail> treatmentDetail;

	public HospitalResponse() {
	}

	public HospitalResponse(BigDecimal treatmentId) {
		this.treatmentId = treatmentId;
	}

	public HospitalResponse(BigDecimal treatmentId, Date modifiedOn, String modifiedBy, Date createdOn, String createdBy,
			BigDecimal petId, String treatmentPlan, String recommendation, Date reminder) {
		this.treatmentId = treatmentId;
		this.modifiedOn = modifiedOn;
		this.modifiedBy = modifiedBy;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.petId = petId;
		this.treatmentPlan = treatmentPlan;
		this.recommendation = recommendation;
		this.reminder = reminder;
	}

	public HospitalResponse(TTreatment treatment, List<TTreatmentDetail> treatmentDetail) {
		this.treatmentId = treatment.getTreatmentId();
		this.modifiedOn = treatment.getModifiedOn();
		this.modifiedBy = treatment.getModifiedBy();
		this.createdOn = treatment.getCreatedOn();
		this.createdBy = treatment.getCreatedBy();
		this.petId = treatment.getPetId();
		this.treatmentPlan = treatment.getTreatmentPlan();
		this.recommendation = treatment.getRecommendation();
		this.reminder = treatment.getReminder();
		this.treatmentDetail = treatmentDetail;
	}
	
	public TTreatment getTTreatment() {
		TTreatment tTreatment = new TTreatment();
		tTreatment.setTreatmentId(this.treatmentId);
		tTreatment.setModifiedOn(this.modifiedOn);
		tTreatment.setModifiedBy(this.modifiedBy);
		tTreatment.setCreatedOn(this.createdOn);
		tTreatment.setCreatedBy(this.createdBy);
		tTreatment.setPetId(this.petId);
		tTreatment.setTreatmentPlan(this.treatmentPlan);
		tTreatment.setRecommendation(this.recommendation);
		tTreatment.setReminder(this.reminder);
		return tTreatment;
	}
	
	public BigDecimal getTreatmentId() {
		return this.treatmentId;
	}

	public void setTreatmentId(BigDecimal treatmentId) {
		this.treatmentId = treatmentId;
	}

	public Date getModifiedOn() {
		return this.modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public BigDecimal getPetId() {
		return this.petId;
	}

	public void setPetId(BigDecimal petId) {
		this.petId = petId;
	}

	public String getTreatmentPlan() {
		return this.treatmentPlan;
	}

	public void setTreatmentPlan(String treatmentPlan) {
		this.treatmentPlan = treatmentPlan;
	}

	public String getRecommendation() {
		return this.recommendation;
	}

	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}

	public Date getReminder() {
		return this.reminder;
	}

	public void setReminder(Date reminder) {
		this.reminder = reminder;
	}

	public List<TTreatmentDetail> getTreatmentDetail() {
		return treatmentDetail;
	}

	public void setTreatmentDetail(List<TTreatmentDetail> treatmentDetail) {
		this.treatmentDetail = treatmentDetail;
	}

}