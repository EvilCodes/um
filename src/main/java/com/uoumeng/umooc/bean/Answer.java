package com.uoumeng.umooc.bean;

import java.util.List;

public class Answer {
	private String chId;
	private String seId;
	private List<SingleAnswer> single;
	private List<CheckBoxAnswer> checkbox;
	private List<JudgeAnswer> judge;

	public Answer() {
		super();
	}

	public Answer(String chId, String seId, List<SingleAnswer> single, List<CheckBoxAnswer> checkbox, List<JudgeAnswer> judge) {
		this.chId = chId;
		this.seId = seId;
		this.single = single;
		this.checkbox = checkbox;
		this.judge = judge;
	}

	public String getChId() {
		return chId;
	}

	public void setChId(String chId) {
		this.chId = chId;
	}

	public String getSeId() {
		return seId;
	}

	public void setSeId(String seId) {
		this.seId = seId;
	}

	public List<SingleAnswer> getSingle() {
		return single;
	}

	public void setSingle(List<SingleAnswer> single) {
		this.single = single;
	}

	public List<CheckBoxAnswer> getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(List<CheckBoxAnswer> checkbox) {
		this.checkbox = checkbox;
	}

	public List<JudgeAnswer> getJudge() {
		return judge;
	}

	public void setJudge(List<JudgeAnswer> judge) {
		this.judge = judge;
	}

	@Override
	public String toString() {
		return "Answer{" +
				"chId='" + chId + '\'' +
				", seId='" + seId + '\'' +
				", single=" + single +
				", checkbox=" + checkbox +
				", judge=" + judge +
				'}';
	}
}
