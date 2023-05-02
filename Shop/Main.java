import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
    
    public static void main(String[] args) {
        boolean flag = true;
        ArrayList<Toys> shopStorage = new ArrayList<>();

        while(flag){
            int operation = view();
            if (operation == 0) operation = view();
            else if (operation == 1) {
                shopStorage = add_toys(shopStorage);
            }
            else if (operation == 2) {
                share_toys(shopStorage);
            }
            else if (operation == 3) System.out.println("Игрушки на складе:\n" + shopStorage);
            else if (operation == 4) flag = false;
            else {
                System.out.println("Введенной команды не существует, попробуйте выбрать команду заново.");
                operation = view();
            }
        }
    }

    private static ArrayList<Toys> add_toys(ArrayList<Toys> shopStorage){

        System.out.println("Сейчас ты будешь покупать игрушки!");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введи название игрушки:  ");
        String name = sc.nextLine();
        System.out.println("Введи количество игрушек, которое надо купить:  ");
        int amount = sc.nextInt();
        // sc.close();
        Random r = new Random();
        int toy_id = r.nextInt(100001);
        int precent_chance = r.nextInt(101); 

        shopStorage.add(new Toys(toy_id, name, amount, precent_chance));
        System.out.println("Поздравляю, вы купили новые игрушки. Вот список игрушек, которые находятся на складе\n");
        System.out.println(shopStorage + "\n");
        return shopStorage;
    }

    private static int view(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Добро пожаловать в наш магазин, Директор. Ты можешь:\n1 - Закупиться игрушками\n"+
                           "2 - Организовать розыгрыш\n3 - Просмотр скалда с игрушками\n4 - Выход из магазина");
        try{
            int operation = sc.nextInt();
            return operation;
        } catch(Exception ex){
            System.out.println("Вы ввели несуществующую команду. Необходимо ввсети число\n");
            return 0;
        }
        
    }

    private static void share_toys(ArrayList<Toys> shopStorage){
        System.out.println("Ты решил организовать розыгрыш игрушек. Что ж, ты можешь разыграть не больше количества"+
        " игрушек, которое есть на складе\n");
        int Sum = 0;
        for (int i = 0; i < shopStorage.size(); i++){
            Sum = Sum + shopStorage.get(i).getAmount();   
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Всего на складе "+ Sum + " различных игрушек. Выбери количество победителей(меньше, чем игрушек на скалде):");
        int count = sc.nextInt();
        if (count > Sum || count <= 0){
            System.out.println("Введено неверное значение.Попробуй еще раз");
        } else{
            Random r = new Random();
            while(count > 0){
                int num = r.nextInt(shopStorage.size());
                int temp = shopStorage.get(num).getAmount();
                if (count > temp){
                    int temp2 = r.nextInt(temp+1);
                    temp -= temp2;
                    count -= temp2;
                } else{
                    int temp2 = r.nextInt(count+1);
                    temp -= temp2;
                    count -= temp2;
                }
                shopStorage.get(num).setAmount(temp);
                System.out.println("Из количества игрушек "+ shopStorage.get(num).getToy_name() + " осталось"+
                " на складе " + temp + " игрушек. Осталось еще взять " + count + " игрушек на розыгрыш");
            }
            System.out.println("Запланированное количество игрушек было разыгранно! Все довольны и счастливы");
            System.out.println(shopStorage);
        }
    }   
}
