package bean;

import java.io.Serializable;

public class KadaiDataBean implements Serializable {
	private static final long serialVersionUID = 1L;
		
	private int student_number;
	private String enrollment_status;
	private String enrollment_confirmation_date;
	private String student_name;
	private String student_furigana;
	private String birthday;
	private String student_post_code;
	private String student_address;
	private String student_phone_number;
	private String student_mail_address;
	private String parent_name;
	private String parent_furigana;
	private String parent_post_code;
	private String parent_address;
	private String parent_phone_number;
	private String parent_mail_address;
	
	public int getStudent_number() {
		return student_number;
	}
	public void setStudent_number(int student_number) {
		this.student_number = student_number;
	}
	public String getEnrollment_status() {
		return enrollment_status;
	}
	public void setEnrollment_status(String strEnrollment_status) {
		this.enrollment_status = strEnrollment_status;
	}
	public String getEnrollment_confirmation_date() {
		return enrollment_confirmation_date;
	}
	public void setEnrollment_confirmation_date(String enrollment_confirmation_date) {
		this.enrollment_confirmation_date = enrollment_confirmation_date;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_furigana() {
		return student_furigana;
	}
	public void setStudent_furigana(String student_furigana) {
		this.student_furigana = student_furigana;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getStudent_post_code() {
		return student_post_code;
	}
	public void setStudent_post_code(String strStudent_post_code) {
		this.student_post_code = strStudent_post_code;
	}
	public String getStudent_address() {
		return student_address;
	}
	public void setStudent_address(String student_address) {
		this.student_address = student_address;
	}
	public String getStudent_phone_number() {
		return student_phone_number;
	}
	public void setStudent_phone_number(String student_phone_number) {
		this.student_phone_number = student_phone_number;
	}
	public String getStudent_mail_address() {
		return student_mail_address;
	}
	public void setStudent_mail_address(String student_mail_address) {
		this.student_mail_address = student_mail_address;
	}
	public String getParent_name() {
		return parent_name;
	}
	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}
	public String getParent_furigana() {
		return parent_furigana;
	}
	public void setParent_furigana(String parent_furigana) {
		this.parent_furigana = parent_furigana;
	}
	public String getParent_post_code() {
		return parent_post_code;
	}
	public void setParent_post_code(String strParent_post_code) {
		this.parent_post_code = strParent_post_code;
	}
	public String getParent_address() {
		return parent_address;
	}
	public void setParent_address(String parent_address) {
		this.parent_address = parent_address;
	}
	public String getParent_phone_number() {
		return parent_phone_number;
	}
	public void setParent_phone_number(String parent_phone_number) {
		this.parent_phone_number = parent_phone_number;
	}
	public String getParent_mail_address() {
		return parent_mail_address;
	}
	public void setParent_mail_address(String parent_mail_address) {
		this.parent_mail_address = parent_mail_address;
	}
	
	
}
