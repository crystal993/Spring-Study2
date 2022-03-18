package hello.core.singleton;

public class StatefulService {

    // 값이 공유될 위험 존재
    //    private int price; // 상태를 유지하는 필드

    // 새로운 메서드를 짰음.
    public int order(String name, int price){
        System.out.println("name = " + name + " price = " + price);
//        this.price = price; //여기가 문제!!
        return price;
    }

    public void getPrice() {
//        return price;
    }
}
