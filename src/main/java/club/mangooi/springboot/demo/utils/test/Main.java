package club.mangooi.springboot.demo.utils.test;


import static club.mangooi.springboot.demo.utils.test.NyPizza.Size.*;

public class Main {
    public static void main(String[] args){
        NyPizza nyPizza = new NyPizza.Builder(SMALL).build();
        NyPizza.Builder nyPizzaBuild = new NyPizza.Builder(MEDIUM).self();
        NyPizza pizza = nyPizzaBuild.build();
        System.out.println(nyPizza.toppings);
        System.out.println(pizza.getSize());
    }
}
