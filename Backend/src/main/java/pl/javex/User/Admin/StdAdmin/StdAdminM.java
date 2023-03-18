package pl.javex.User.Admin.StdAdmin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import pl.javex.User.Admin.AdminM;

@Entity
@Table(name = "stdadmins")
public class StdAdminM extends AdminM {

	@Column(name = "privlvl")
	private long priv_lvl;
	@Column(name = "wphone")
	private int work_phone_number;
	protected long getPriv_lvl() {
		return priv_lvl;
	}
	protected void setPriv_lvl(long priv_lvl) {
		this.priv_lvl = priv_lvl;
	}
	protected int getWork_phone_number() {
		return work_phone_number;
	}
	protected void setWork_phone_number(int work_phone_number) {
		this.work_phone_number = work_phone_number;
	}
	
	
	
}
