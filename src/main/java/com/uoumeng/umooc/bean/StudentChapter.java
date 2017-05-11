package com.uoumeng.umooc.bean;

/**
 * Created by chenjun on 2017/5/10.
 */
public class StudentChapter {
    private Integer chid;
    private String chname;
    private String chdesc;
    private String flag;
    private Integer formalScore;
    private Integer projectScore;
    public StudentChapter(){}

    public StudentChapter(Integer chid, String chname, String chdesc, String flag, Integer formalScore, Integer projectScore) {
        this.chid = chid;
        this.chname = chname;
        this.chdesc = chdesc;
        this.flag = flag;
        this.formalScore = formalScore;
        this.projectScore = projectScore;
    }

    public Integer getChid() {
        return chid;
    }

    public void setChid(Integer chid) {
        this.chid = chid;
    }

    public String getChname() {
        return chname;
    }

    public void setChname(String chname) {
        this.chname = chname;
    }

    public String getChdesc() {
        return chdesc;
    }

    public void setChdesc(String chdesc) {
        this.chdesc = chdesc;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getFormalScore() {
        return formalScore;
    }

    public void setFormalScore(Integer formalScore) {
        this.formalScore = formalScore;
    }

    public Integer getProjectScore() {
        return projectScore;
    }

    public void setProjectScore(Integer projectScore) {
        this.projectScore = projectScore;
    }

    @Override
    public String toString() {
        return "StudentChapter{" +
                "chid=" + chid +
                ", chname='" + chname + '\'' +
                ", chdesc='" + chdesc + '\'' +
                ", flag=" + flag +
                ", formalScore=" + formalScore +
                ", projectScore=" + projectScore +
                '}';
    }
}
