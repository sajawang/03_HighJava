package kr.or.ddit.vo;

public class AttemptVO {
	private int attempt_no;
	private int view_no;
	private String cus_id;
	private String attempt_myanswer;
	private String attempt_result;

	public int getAttempt_no() {
		return attempt_no;
	}

	public void setAttempt_no(int attempt_no) {
		this.attempt_no = attempt_no;
	}

	public int getView_no() {
		return view_no;
	}

	public void setView_no(int view_no) {
		this.view_no = view_no;
	}

	public String getCus_id() {
		return cus_id;
	}

	public void setUser_id(String cus_id) {
		this.cus_id = cus_id;
	}

	public String getAttempt_myanswer() {
		return attempt_myanswer;
	}

	public void setAttempt_myanswer(String attempt_myanswer) {
		this.attempt_myanswer = attempt_myanswer;
	}

	public String getAttempt_result() {
		return attempt_result;
	}

	public void setAttempt_result(String attempt_result) {
		this.attempt_result = attempt_result;
	}
	
	
}
