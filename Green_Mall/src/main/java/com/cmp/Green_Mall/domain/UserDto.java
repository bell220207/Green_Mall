package com.cmp.Green_Mall.domain;

public class UserDto {

	private String id;
	private String pwd;
	private String name;
	private String email;
	private String birth;
	private String idCheck;
	private String profileImg;
	
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getPwd() { return pwd; }
	public void setPwd(String pwd) { this.pwd = pwd; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public String getBirth() { return birth; }
	public void setBirth(String birth) { this.birth = birth; }
	public String getIdCheck() { return idCheck; }
	public void setIdCheck(String idCheck) { this.idCheck = idCheck; }
	
	/*추가*/
	public String getProfileImg() {	return profileImg; }
	public void setProfileImg(String profileImg) { this.profileImg = profileImg; }
	
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", birth=" + birth
				+ ", idCheck=" + idCheck + ", profileImg=" + profileImg + "]";
	}
	
}
