package com.medify.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "public_question")
public class PublicQuestion implements Serializable{


	private static final long serialVersionUID = -4418385212599292654L;
	
	private Long QUESTION_ID;
	private String problem;
	private String content;
	private Long postedBy;
	private Date postedAt;
	private Long speciality;
	
	private String questionReply;
	private Integer questionView=0;
	private Integer questionLike=0;
	private Long repliedBy;
	private Date repliedAt;
	
	private String filePath;
	
	/**
	 * @return the qUESTION_ID
	 */
	
	 @Id
	 @GeneratedValue
	 @Column(name = "QUESTION_ID")
	public Long getQUESTION_ID() {
		return QUESTION_ID;
	}
	/**
	 * @param qUESTION_ID the qUESTION_ID to set
	 */
	public void setQUESTION_ID(Long qUESTION_ID) {
		QUESTION_ID = qUESTION_ID;
	}

	
	/**
	 * @return the content
	 */
	
	 @Column(name = "CONTENT")
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the postedBy
	 */
	
	 @Column(name = "POSTED_BY")
	public Long getPostedBy() {
		return postedBy;
	}
	/**
	 * @param postedBy the postedBy to set
	 */
	public void setPostedBy(Long postedBy) {
		this.postedBy = postedBy;
	}
	/**
	 * @return the postedAt
	 */
	
	 @Column(name = "POSTED_AT")
	public Date getPostedAt() {
		return postedAt;
	}
	/**
	 * @param postedAt the postedAt to set
	 */
	public void setPostedAt(Date postedAt) {
		this.postedAt = postedAt;
	}
	/**
	 * @return the speciality
	 */
	
	 @Column(name = "SPECIALITY")
	public Long getSpeciality() {
		return speciality;
	}
	/**
	 * @param speciality the speciality to set
	 */
	public void setSpeciality(Long speciality) {
		this.speciality = speciality;
	}
	/**
	 * @return the problem
	 */
	
	@Column(name = "PROBLEM")
	public String getProblem() {
		return problem;
	}
	/**
	 * @param problem the problem to set
	 */
	public void setProblem(String problem) {
		this.problem = problem;
	}
	/**
	 * @return the questionReply
	 */
	
	@Column(name = "QUESTION_REPLY")
	public String getQuestionReply() {
		return questionReply;
	}
	/**
	 * @param questionReply the questionReply to set
	 */
	public void setQuestionReply(String questionReply) {
		this.questionReply = questionReply;
	}
	/**
	 * @return the questionView
	 */
	
	@Column(name = "QUESTION_VIEW")
	public Integer getQuestionView() {
		return questionView;
	}
	/**
	 * @param questionView the questionView to set
	 */
	public void setQuestionView(Integer questionView) {
		this.questionView = questionView;
	}
	/**
	 * @return the questionLike
	 */
	
	@Column(name = "QUESTION_LIKE")
	public Integer getQuestionLike() {
		return questionLike;
	}
	/**
	 * @param questionLike the questionLike to set
	 */
	public void setQuestionLike(Integer questionLike) {
		this.questionLike = questionLike;
	}
	/**
	 * @return the repliedBy
	 */
	
	@Column(name = "REPLIED_BY")
	public Long getRepliedBy() {
		return repliedBy;
	}
	/**
	 * @param repliedBy the repliedBy to set
	 */
	public void setRepliedBy(Long repliedBy) {
		this.repliedBy = repliedBy;
	}
	/**
	 * @return the repliedAt
	 */
	
	@Column(name = "REPLIED_AT")
	public Date getRepliedAt() {
		return repliedAt;
	}
	/**
	 * @param repliedAt the repliedAt to set
	 */
	public void setRepliedAt(Date repliedAt) {
		this.repliedAt = repliedAt;
	}
	/**
	 * @return the filePath
	 */
	
	@Column(name = "Q_FILE_PATH")
	public String getFilePath() {
		return filePath;
	}
	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	

}
