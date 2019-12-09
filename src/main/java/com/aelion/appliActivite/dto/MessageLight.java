package com.aelion.appliActivite.dto;


public class MessageLight {
	
	private String title;
	
	private Long idSender;
	
	/**
	 * GETTERS SETTERS
	 */

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getIdSender() {
		return idSender;
	}

	public void setIdSender(Long idSender) {
		this.idSender = idSender;
	}

	@Override
	public String toString() {
		return "MessageLight [title=" + title + ", idSender=" + idSender + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idSender == null) ? 0 : idSender.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		MessageLight other = (MessageLight) obj;
		if (idSender == null) {
			if (other.idSender != null)
				return false;
		} else if (!idSender.equals(other.idSender))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	

}
