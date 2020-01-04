package PageBeans;

public class LoanInfoBean {

    private String loanAmount;
    private String loanPurpose;

    public LoanInfoBean(){
        this.loanAmount = "2000";
        this.loanPurpose = "CREDIT_CARD";
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public String getLoanPurpose() {
        return loanPurpose;
    }
}
