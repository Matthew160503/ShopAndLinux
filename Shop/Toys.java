public class Toys{
    private int toy_id;
    private String toy_name;
    private int amount;
    private int precent_chance;

    public Toys(int toy_id, String toy_name, int amount, int precent_chance) {
        this.toy_id = toy_id;
        this.toy_name = toy_name;
        this.amount = amount;
        this.precent_chance = precent_chance;
    }

    public int getToy_id() {
        return toy_id;
    }

    public String getToy_name() {
        return toy_name;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrecent_chance() {
        return precent_chance;
    }

    @Override
    public String toString() {
        return "[id=" + toy_id + ", название игрушки =" + toy_name + ", количество=" + amount
                + ", шанс выигрыша=" + precent_chance + "]";
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }   
}