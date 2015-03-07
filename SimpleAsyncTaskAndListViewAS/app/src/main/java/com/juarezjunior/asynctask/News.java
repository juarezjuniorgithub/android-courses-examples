package com.juarezjunior.asynctask;

import java.io.Serializable;

public class News implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String headline;
	private String reporter;
	private String date;
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getReporterName() {
		return reporter;
	}

	public void setReporterName(String reporterName) {
		this.reporter = reporterName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "[ headline=" + headline + ", reporter Name=" + reporter + " , date=" + date + "]";
	}
}
