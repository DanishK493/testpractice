class Main {
    public static void main(String[] args) {
    FoodTruck foodTruck = new FoodTruck("Burger Buggy", 5.00);
    foodTruck.cheeseUpcharge = 0.50;
    foodTruck.baconUpcharge = null; // bacon is not supported at this food truck
    foodTruck.extraPattyUpcharge = 2.00;
    System.out.println(foodTruck.getMenu()); // prints menu example

    Order order = new Order(2);
    order.hamburgers[0] = new Hamburger();
    order.hamburgers[1] = new Hamburger(true, false, true);

    double total = foodTruck.calculateTotal(order);
    System.out.println(total); // prints 12.5
    }
}

class FoodTruck {
    private String name;
    private double baseHamburgerPrice;
    public Double cheeseUpcharge;
    public Double baconUpcharge;
    public Double extraPattyUpcharge;
    public FoodTruck(String name, double baseHamburgerPrice) {
        this.name = name;
        this.baseHamburgerPrice = baseHamburgerPrice;
    }
    public boolean isValidOrder(Order order) {
        for (Hamburger hamburger : order.hamburgers) {
            if (hamburger == null || !(hamburger.hasCheese || cheeseUpcharge == null && hamburger.hasBacon || baconUpcharge == null
            && hamburger.hasExtraPatty || extraPattyUpcharge == null )) {
                return false;
            }
        }
        return true;
    }
    public Double calculateTotal(Order order) {
        Double sum = 0.0;
        if (isValidOrder(order)) {
        for (Hamburger hamburger : order.hamburgers) {
            sum = baseHamburgerPrice;
            if (hamburger.hasCheese) 
                sum += cheeseUpcharge;
            if (hamburger.hasBacon) 
                sum += baconUpcharge;
            if (hamburger.hasExtraPatty) 
                sum += extraPattyUpcharge;
        }
        }
        return sum;
    }
    public String getMenu() {
        return "";
    }
}
class Order {
    Hamburger hamburgers[];
    Order(int hamburgerCount) {
        this.hamburgers = new Hamburger[hamburgerCount];
    }
}
class Hamburger {
    public boolean hasCheese;
    public boolean hasBacon;
    public boolean hasExtraPatty;
    public Hamburger(boolean hasCheese, boolean hasBacon, boolean hasExtraPatty) {
        this.hasCheese = hasCheese;
        this.hasBacon = hasBacon;
        this.hasExtraPatty = hasExtraPatty;
    }
    public Hamburger() {
        this.hasCheese = false;
        this.hasBacon = false;
        this.hasExtraPatty = false;
    }
}