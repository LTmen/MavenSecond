package com.lt.physic.pojo;

public class accountk {
	private String kname=null;
	private String kback=null;
	private String kid=null;
	private int jname ;
	
	public int getJname() {
		return jname;
	}
	public void setJname(int jname) {
		this.jname = jname;
	}
	public String getKname() {
		return kname;
	}
	public void setKname(String kname) {
		this.kname = kname;
	}
	public String getKback() {
		return kback;
	}
	public void setKback(String kback) {
		this.kback = kback;
	}
	public String getKid() {
		return kid;
	}
	public void setKid(String kid) {
		this.kid = kid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kback == null) ? 0 : kback.hashCode());
		result = prime * result + ((kid == null) ? 0 : kid.hashCode());
		result = prime * result + ((kname == null) ? 0 : kname.hashCode());
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
		accountk other = (accountk) obj;
		if (kback == null) {
			if (other.kback != null)
				return false;
		} else if (!kback.equals(other.kback))
			return false;
		if (kid == null) {
			if (other.kid != null)
				return false;
		} else if (!kid.equals(other.kid))
			return false;
		if (kname == null) {
			if (other.kname != null)
				return false;
		} else if (!kname.equals(other.kname))
			return false;
		return true;
	}
	

}
