package com.uoumeng.umooc.bean;

import java.util.List;

public class CheckBoxAnswer {
	private String id;
	private List<String> checked;
	public CheckBoxAnswer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CheckBoxAnswer(String id, List<String> checked) {
		super();
		this.id = id;
		this.checked = checked;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getChecked() {
		return checked;
	}
	public void setChecked(List<String> checked) {
		this.checked = checked;
	}
	@Override
	public String toString() {
		return "CheckBoxAnswer [id=" + id + ", checked=" + checked + "]";
	}
	
	
}
