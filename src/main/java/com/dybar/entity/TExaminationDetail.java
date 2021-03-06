package com.dybar.entity;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TExaminationDetail generated by hbm2java
 */
@Entity
@Table(name = "t_examination_detail", schema = "public")
public class TExaminationDetail implements java.io.Serializable {

	private BigDecimal examDetailId;
	private Date modifiedOn;
	private String modifiedBy;
	private Date createdOn;
	private String createdBy;
	private BigDecimal examId;
	private BigDecimal paramExamId;
	private String flagExam;

	public TExaminationDetail() {
	}

	public TExaminationDetail(BigDecimal examDetailId) {
		this.examDetailId = examDetailId;
	}

	public TExaminationDetail(BigDecimal examDetailId, Date modifiedOn, String modifiedBy, Date createdOn,
			String createdBy, BigDecimal examId, BigDecimal paramExamId, String flagExam) {
		this.examDetailId = examDetailId;
		this.modifiedOn = modifiedOn;
		this.modifiedBy = modifiedBy;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.examId = examId;
		this.paramExamId = paramExamId;
		this.flagExam = flagExam;
	}

	@Id
	@Column(name="exam_detail_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="t_examination_detail_seq_id")
	@SequenceGenerator(name="t_examination_detail_seq_id",sequenceName="t_examination_detail_seq",allocationSize=1)
	public BigDecimal getExamDetailId() {
		return this.examDetailId;
	}

	public void setExamDetailId(BigDecimal examDetailId) {
		this.examDetailId = examDetailId;
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

	@Column(name = "exam_id", precision = 65535, scale = 65531)
	public BigDecimal getExamId() {
		return this.examId;
	}

	public void setExamId(BigDecimal examId) {
		this.examId = examId;
	}

	@Column(name = "param_exam_id", precision = 65535, scale = 65531)
	public BigDecimal getParamExamId() {
		return this.paramExamId;
	}

	public void setParamExamId(BigDecimal paramExamId) {
		this.paramExamId = paramExamId;
	}

	@Column(name = "flag_exam", length = 1)
	public String getFlagExam() {
		return this.flagExam;
	}

	public void setFlagExam(String flagExam) {
		this.flagExam = flagExam;
	}

}
