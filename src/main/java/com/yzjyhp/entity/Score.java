package com.yzjyhp.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "score")
public class Score {

	private int id;
	private int stuId;
	private String subjectName;
	private float score;
	private Date examTime;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	@Column(nullable = false, name = "STUDENTID") // 这里说一下，我使用指定数据库列的时候，使用小写会不起作用，修改为大写便正常了。不知道为何，如果遇到一样问题的可以尝试下。
	public int getStuId() {
		return stuId;
	}

	@Column(nullable = false, name = "SUBJECTNAME")
	public String getSubjectName() {
		return subjectName;
	}

	@Column(nullable = false)
	public float getScore() {
		return score;
	}

	@Column(nullable = false, name = "EXAMTIME")
	public Date getExamTime() {
		return examTime;
	}

	/**
	 * set方法
	 */

	public void setId(int id) {
		this.id = id;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public void setExamTime(Date examTime) {
		this.examTime = examTime;
	}

}
