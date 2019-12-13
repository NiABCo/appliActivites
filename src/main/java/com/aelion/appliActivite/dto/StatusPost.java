package com.aelion.appliActivite.dto;



public class StatusPost {

	private Long id;

	private String reasonWhy;
	
	private Long idUser;
	
	private Long idActivity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReasonWhy() {
		return reasonWhy;
	}

	public void setReasonWhy(String reasonWhy) {
		this.reasonWhy = reasonWhy;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getIdActivity() {
		return idActivity;
	}

	public void setIdActivity(Long idActivity) {
		this.idActivity = idActivity;
	}

	@Override
	public String toString() {
		return "StatusPost [id=" + id + ", reasonWhy=" + reasonWhy + ", idUser=" + idUser
				+ ", idActivity=" + idActivity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idActivity == null) ? 0 : idActivity.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		result = prime * result + ((reasonWhy == null) ? 0 : reasonWhy.hashCode());
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
		StatusPost other = (StatusPost) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idActivity == null) {
			if (other.idActivity != null)
				return false;
		} else if (!idActivity.equals(other.idActivity))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		if (reasonWhy == null) {
			if (other.reasonWhy != null)
				return false;
		} else if (!reasonWhy.equals(other.reasonWhy))
			return false;
		return true;
	}
	
	
}
