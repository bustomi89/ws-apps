package com.dybar.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * AuditTableFields generated by hbm2java
 */
@Entity
@Table(name = "audit_table_fields", schema = "public")
public class AuditTableFields implements java.io.Serializable {

	private AuditTableFieldsId id;

	public AuditTableFields() {
	}

	public AuditTableFields(AuditTableFieldsId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "tableName", column = @Column(name = "table_name", length = 100)),
			@AttributeOverride(name = "fieldName", column = @Column(name = "field_name", length = 100)),
			@AttributeOverride(name = "fieldDesc", column = @Column(name = "field_desc", length = 100)) })
	public AuditTableFieldsId getId() {
		return this.id;
	}

	public void setId(AuditTableFieldsId id) {
		this.id = id;
	}

}