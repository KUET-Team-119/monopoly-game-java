package domain.component.building;

public abstract class Building {

    protected int count;
    protected int price;

    protected Building(int price) {
        count = 0;
        this.price = price;
    }

    public abstract boolean canBuild();

    public void build() {
        count++;
    }

    public void destroy() {
        count = 0;
    }

    public int getRent() {
        return count * price;
    }

    public int getPrice() {
        return price;
    }
}
