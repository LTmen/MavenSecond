package com.lt.physic.pojo;

public class gspg {
	private String gid=null;
	private String gname=null;
	private String gdz=null;
	private String grzfw=null;
	private String gtimeto=null;
	private String gfzjg=null;
	private String gtimestart=null;
	private int jname ;
	
	public int getJname() {
		return jname;
	}
	public void setJname(int jname) {
		this.jname = jname;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGdz() {
		return gdz;
	}
	public void setGdz(String gdz) {
		this.gdz = gdz;
	}
	public String getGrzfw() {
		return grzfw;
	}
	public void setGrzfw(String grzfw) {
		this.grzfw = grzfw;
	}
	public String getGtimeto() {
		return gtimeto;
	}
	public void setGtimeto(String gtimeto) {
		this.gtimeto = gtimeto;
	}
	public String getGfzjg() {
		return gfzjg;
	}
	public void setGfzjg(String gfzjg) {
		this.gfzjg = gfzjg;
	}
	public String getGtimestart() {
		return gtimestart;
	}
	public void setGtimestart(String gtimestart) {
		this.gtimestart = gtimestart;
	}
	@Override
	public String toString() {
		return "gspg [gid=" + gid + ", gname=" + gname + ", gdz=" + gdz
				+ ", grzfw=" + grzfw + ", gtimeto=" + gtimeto + ", gfzjg="
				+ gfzjg + ", gtimestart=" + gtimestart + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gdz == null) ? 0 : gdz.hashCode());
		result = prime * result + ((gfzjg == null) ? 0 : gfzjg.hashCode());
		result = prime * result + ((gid == null) ? 0 : gid.hashCode());
		result = prime * result + ((gname == null) ? 0 : gname.hashCode());
		result = prime * result + ((grzfw == null) ? 0 : grzfw.hashCode());
		result = prime * result
				+ ((gtimestart == null) ? 0 : gtimestart.hashCode());
		result = prime * result + ((gtimeto == null) ? 0 : gtimeto.hashCode());
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
		gspg other = (gspg) obj;
		if (gdz == null) {
			if (other.gdz != null)
				return false;
		} else if (!gdz.equals(other.gdz))
			return false;
		if (gfzjg == null) {
			if (other.gfzjg != null)
				return false;
		} else if (!gfzjg.equals(other.gfzjg))
			return false;
		if (gid == null) {
			if (other.gid != null)
				return false;
		} else if (!gid.equals(other.gid))
			return false;
		if (gname == null) {
			if (other.gname != null)
				return false;
		} else if (!gname.equals(other.gname))
			return false;
		if (grzfw == null) {
			if (other.grzfw != null)
				return false;
		} else if (!grzfw.equals(other.grzfw))
			return false;
		if (gtimestart == null) {
			if (other.gtimestart != null)
				return false;
		} else if (!gtimestart.equals(other.gtimestart))
			return false;
		if (gtimeto == null) {
			if (other.gtimeto != null)
				return false;
		} else if (!gtimeto.equals(other.gtimeto))
			return false;
		return true;
	}
	
	
}
