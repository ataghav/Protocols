package javasample.entity;

import javax.persistence.*;

@Entity
@Table(name="tbl_account")
public class BankAccount {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="f_id")
    private int id;
    @Column(name="f_number")
    private int number;
    @Column(name="f_owner")
    private String owner;
    @Column(name="f_balance")
    private long balance;

    public BankAccount() {
    }

    public BankAccount(int number, String owner, long balance) {
        this.number = number;
        this.owner = owner;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
    
}
