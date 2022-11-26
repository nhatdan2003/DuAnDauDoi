package Entity;

import java.util.Date;

/**
 *
 * @author haoireal
 */
public class Account {
        String fullName;
	String userName;
	String passWord;
	Boolean gender;
	Date birthDay;
	int phone;
	String email;
	String addRess;
	Boolean role;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Boolean isGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddRess() {
        return addRess;
    }

    public void setAddRess(String addRess) {
        this.addRess = addRess;
    }

    public Boolean isRole() {
        return role;
    }

    public void setRole(Boolean role) {
        this.role = role;
    }

	
	
	@Override
    public String toString() {
        return "Hello: " + userName ;
    }
}
