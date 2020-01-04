package PageBeans;

import org.apache.commons.lang.RandomStringUtils;

public class PersonalInfoBean {

    private boolean isJoint;
    private String fname;
    private String lname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String dobDay;
    private String dobMonth;
    private String dobYear;
    private String income;
    private String addIncome;
    private String email;
    private String password;

    //Default Constructor
    public PersonalInfoBean(String email){
        this.email = email;
        this.isJoint = false;
        this.fname = RandomStringUtils.randomAlphabetic(9);
        this.lname = RandomStringUtils.randomAlphabetic(9);
        this.street = "Howard";
        this.city = "San Francisco";
        this.state = "CA";
        this.zip = "94015";
        this.dobDay = "21";
        this.dobMonth = "10";
        this.dobYear = "1985";
        this.income = "122000";
        this.addIncome = "6500";
        this.password = RandomStringUtils.randomAlphanumeric(9);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public boolean isJoint() {
        return isJoint;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getDobDay() {
        return dobDay;
    }

    public String getDobMonth() {
        return dobMonth;
    }

    public String getDobYear() {
        return dobYear;
    }

    public String getIncome() {
        return income;
    }

    public String getAddIncome() {
        return addIncome;
    }
}
