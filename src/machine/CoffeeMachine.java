package machine;

import java.util.Scanner;

public class CoffeeMachine {

    private int machineMoney = 550;
    private int machineWater = 400;
    private int machineMilk = 540;
    private int machineCoffee = 120;
    private int machineCups = 9;

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        coffeeEntryPoint();
    }

    private static void coffeeEntryPoint() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        String option;
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            option = scanner.nextLine();
            System.out.println();

            switch (option) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String coffeeOpt = scanner.nextLine();
                    if (coffeeOpt.equals("back")) {
                        break;
                    }
                    coffeeMachine.buyCoffee(Integer.parseInt(coffeeOpt));
                    break;
                case "fill":
                    coffeeMachine.fillMachine(scanner);
                    break;
                case "take":
                    coffeeMachine.takeMoney();
                    break;
                case "remaining":
                    coffeeMachine.printMachineInventory();
                    break;
                default:
                    break;
            }
        } while (!option.equalsIgnoreCase("exit"));
    }

    private void buyCoffee(int option) {
        CoffeeRecipe recipe = CoffeeRecipe.getByOptionCode(option);
        boolean enoughCoffee = this.getMachineCoffee() - recipe.getCoffee() >= 0;
        boolean enoughWater = this.getMachineWater() - recipe.getWater() >= 0;
        boolean enoughMilk = this.getMachineMilk() - recipe.getMilk() >= 0;
        boolean enoughCups = this.getMachineCups() - 1 >= 0;

        if (!enoughCoffee) {
            System.out.println("Sorry, not enough coffee!");
        } else if (!enoughCups) {
            System.out.println("Sorry, not enough cups!");
        } else if (!enoughMilk) {
            System.out.println("Sorry, not enough milk!");
        } else if (!enoughWater) {
            System.out.println("Sorry, not enough water!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            this.setMachineCoffee(this.getMachineCoffee() - recipe.getCoffee());
            this.setMachineCups(this.getMachineCups() - 1);
            this.setMachineMilk(this.getMachineMilk() - recipe.getMilk());
            this.setMachineWater(this.getMachineWater() - recipe.getWater());
            this.setMachineMoney(this.getMachineMoney() + recipe.getCost());
        }
    }

    private void fillMachine(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add:");
        String water = scanner.nextLine();
        this.setMachineWater(this.getMachineWater() + Integer.parseInt(water));
        System.out.println("Write how many ml of milk you want to add:");
        String milk = scanner.nextLine();
        this.setMachineMilk(this.getMachineMilk() + Integer.parseInt(milk));
        System.out.println("Write how many grams of coffee beans you want to add:");
        String coffee = scanner.nextLine();
        this.setMachineCoffee(this.getMachineCoffee() + Integer.parseInt(coffee));
        System.out.println("Write how many disposable cups you want to add:");
        String cups = scanner.nextLine();
        this.setMachineCups(this.getMachineCups() + Integer.parseInt(cups));
    }

    private void takeMoney() {
        System.out.println("I gave you $" + this.getMachineMoney());
        this.setMachineMoney(0);
    }

    private void printMachineInventory() {
        System.out.println("The coffee machine has:");
        System.out.println(this.getMachineWater() + " ml of water");
        System.out.println(this.getMachineMilk() + " ml of milk");
        System.out.println(this.getMachineCoffee() + " g of coffee beans");
        System.out.println(this.getMachineCups() + " disposable cups");
        System.out.println("$" + this.getMachineMoney() + " of money");
    }

    public int getMachineMoney() {
        return machineMoney;
    }

    public int getMachineWater() {
        return machineWater;
    }

    public int getMachineMilk() {
        return machineMilk;
    }

    public int getMachineCoffee() {
        return machineCoffee;
    }

    public int getMachineCups() {
        return machineCups;
    }

    public void setMachineMoney(int machineMoney) {
        this.machineMoney = machineMoney;
    }

    public void setMachineWater(int machineWater) {
        this.machineWater = machineWater;
    }

    public void setMachineMilk(int machineMilk) {
        this.machineMilk = machineMilk;
    }

    public void setMachineCoffee(int machineCoffee) {
        this.machineCoffee = machineCoffee;
    }

    public void setMachineCups(int machineCups) {
        this.machineCups = machineCups;
    }
}