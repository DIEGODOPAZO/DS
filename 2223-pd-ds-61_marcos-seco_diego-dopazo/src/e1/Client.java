package e1;

public class Client {
    private String email;
    private float money;

    public Client(String email, float money){
        this.email = email;
        this.money = money;
    }

    public float payment(float amount){
        if(amount <= money){
            money -= amount;
            return amount;
        }

        return -1;
    }

    public void getReturnMoney(float amount){
        money += amount;
    }
}
