package com.dybar.entity;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AuditTableFieldsId generated by hbm2java
 */
@Embeddable
public class AuditTableFieldsId implements java.io.Serializable {

	private String tableName;
	private String fieldName;
	private String fieldDesc;

	public AuditTableFieldsId() {
	}

	public AuditTableFieldsId(String tableName, String fieldName, String fieldDesc) {
		this.tableName = tableName;
		this.fieldName = fieldName;
		this.fieldDesc = fieldDesc;
	}

	@Column(name = "table_name", length = 100)
	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Column(name = "field_name", length = 100)
	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	@Column(name = "field_desc", length = 100)
	public String getFieldDesc() {
		return this.fieldDesc;
	}

	public void setFieldDesc(String fieldDesc) {
		this.fieldDesc = fieldDesc;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AuditTableFieldsId))
			return false;
		AuditTableFieldsId castOther = (AuditTableFieldsId) other;

		return ((this.getTableName() == castOther.getTableName()) || (this.getTableName() != null
				&& castOther.getTableName() != null && this.getTableName().equals(castOther.getTableName())))
				&& ((this.getFieldName() == castOther.getFieldName()) || (this.getFieldName() != null
						&& castOther.getFieldName() != null && this.getFieldName().equals(castOther.getFieldName())))
				&& ((this.getFieldDesc() == castOther.getFieldDesc()) || (this.getFieldDesc() != null
						&& castOther.getFieldDesc() != null && this.getFieldDesc().equals(castOther.getFieldDesc())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTableName() == null ? 0 : this.getTableName().hashCode());
		result = 37 * result + (getFieldName() == null ? 0 : this.getFieldName().hashCode());
		result = 37 * result + (getFieldDesc() == null ? 0 : this.getFieldDesc().hashCode());
		return result;
	}

}
