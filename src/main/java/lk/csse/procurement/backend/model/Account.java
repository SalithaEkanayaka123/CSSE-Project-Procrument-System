package lk.csse.procurement.backend.model;

public class Account {
    private int accountNo;
    private String accountName;
    private String description;
    private double totalFund;

    public Account (){

    }

    public Account(int accountNo, String accountName, String description, double totalFund) {
        this.accountNo = accountNo;
        this.accountName = accountName;
        this.description = description;
        this.totalFund = totalFund;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTotalFund() {
        return totalFund;
    }

    public void setTotalFund(double totalFund) {
        this.totalFund = totalFund;
    }
}
