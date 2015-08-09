package com.lt.physic.pojo;

public class basicinfoj {
	private String jid=null;
	private String jnumber=null;
	private String jdossier=null;
	private int jname ;
	
	public int getJname() {
		return jname;
	}
	public void setJname(int jname) {
		this.jname = jname;
	}
	public String getJid() {
		return jid;
	}
	public void setJid(String jid) {
		this.jid = jid;
	}
	public String getJnumber() {
		return jnumber;
	}
	public void setJnumber(String jnumber) {
		this.jnumber = jnumber;
	}
	public String getJdossier() {
		return jdossier;
	}
	public void setJdossier(String jdossier) {
		this.jdossier = jdossier;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((jdossier == null) ? 0 : jdossier.hashCode());
		result = prime * result + ((jid == null) ? 0 : jid.hashCode());
		result = prime * result + ((jnumber == null) ? 0 : jnumber.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		basicinfoj other = (basicinfoj) obj;
		if (jdossier == null) {
			if (other.jdossier != null)
				return false;
		} else if (!jdossier.equals(other.jdossier))
			return false;
		if (jid == null) {
			if (other.jid != null)
				return false;
		} else if (!jid.equals(other.jid))
			return false;
		if (jnumber == null) {
			if (other.jnumber != null)
				return false;
		} else if (!jnumber.equals(other.jnumber))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "basicinfoj [jid=" + jid + ", jnumber=" + jnumber
				+ ", jdossier=" + jdossier + "]";
	}
	
	
}
