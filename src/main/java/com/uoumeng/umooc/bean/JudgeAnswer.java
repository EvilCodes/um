package com.uoumeng.umooc.bean;

public class JudgeAnswer {
	private String id;
	private String checked;

	public JudgeAnswer() {
		super();
	}

	public JudgeAnswer(String id, String checked) {
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

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	@Override
	public String toString() {
		return "SingleAnswer [id=" + id + ", checked=" + checked + "]";
	}

}
