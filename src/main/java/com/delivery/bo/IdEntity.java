package com.delivery.bo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public abstract class IdEntity implements Serializable {
	private static final long serialVersionUID = -1815967322184167421L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "hid", unique = true, nullable = false, length = 32)
	protected String hid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update_dt", length = 0, nullable = false)
	protected Date lastUpdateDt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_dt", length = 0, nullable = false)
	protected Date createDt;

	@Column(name = "last_update_opr", length = 64, nullable = false)
	protected String lastUpdateOpr;

	public String getHid() {
		return hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}

	public Date getLastUpdateDt() {
		return lastUpdateDt;
	}

	public void setLastUpdateDt(Date lastUpdateDt) {
		this.lastUpdateDt = lastUpdateDt;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public String getLastUpdateOpr() {
		return lastUpdateOpr;
	}

	public void setLastUpdateOpr(String lastUpdateOpr) {
		this.lastUpdateOpr = lastUpdateOpr;
	}
}
