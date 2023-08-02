package machine;

public enum CoffeeRecipe {
    OPTION_1(1, 250, 16, 0, 4),
    OPTION_2(2, 350, 20, 75, 7),
    OPTION_3(3, 200, 12, 100, 6);

    private final int optionCode;
    private final int water;
    private final int coffee;
    private final int milk;
    private final int cost;

    CoffeeRecipe(int optionCode, int water, int coffee, int milk, int cost) {
        this.optionCode = optionCode;
        this.water = water;
        this.coffee = coffee;
        this.milk = milk;
        this.cost = cost;
    }

    public int getOptionCode() {
        return optionCode;
    }

    public int getWater() {
        return water;
    }

    public int getCoffee() {
        return coffee;
    }

    public int getMilk() {
        return milk;
    }

    public int getCost() {
        return cost;
    }

    public static CoffeeRecipe getByOptionCode(int optionCode) {
        for (CoffeeRecipe option : values()) {
            if (option.optionCode == optionCode) {
                return option;
            }
        }

        return OPTION_3;
    }
}
