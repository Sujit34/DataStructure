package StreamAPI.models;

public class Transaction {
    public Transaction(String date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    public String date;
    public int amount;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
