package com.company;

public class Main {
    public static void main(String[] args) {
        Clothes []clothes={
                new Pants(Size.XXS,"gray",4500,"Pants"),
                new Skirt(Size.XS,"pink",2500,"Sweater"),
                new Tie(Size.S,"black",1000,"Tie"),
                new TeeShirt(Size.M,"white",1500,"T-shirt"),
                new Pants(Size.L,"blue",3000,"shirt"),
        };
        for (int i = 0; i< clothes.length; i++) {
            System.out.println(clothes[i].name);
            System.out.println(clothes[i].size);
            System.out.println(clothes[i].color);
            System.out.println(clothes[i].price);
            System.out.println(" ");
        }
    }
}
enum Size {
    XXS(32) {
        @Override
        public String getDescription() {
            return "Child size";
        }
    },
    XS(34),
    S(36),
    M(38),
    L(40);

    Size(int euroSize) {
        EuroSize = euroSize;
    }
    public String getDescription() {
        return "Adult size";
    }
    @Override
    public String toString() {
        return name() + "(" + EuroSize + ") " + getDescription();
    }
    private int EuroSize;
}
interface Mensclothing{
    static void DressMens() {
        System.out.println("Dressing a man");
    }
}
interface Womensclothing{
    static void DressWomen(){
        System.out.println("We dress a woman");
    }
}
abstract class Clothes{
    Size size;
    String color;
    String name;
    int price;

    public Clothes(Size size,String color,int price, String name){
        this.size=size;
        this.color=color;
        this.price=price;
        this.name=name;
    }
}
class TeeShirt extends Clothes implements Mensclothing,Womensclothing{
    public TeeShirt(Size size, String color,int price, String name) {
        super(size, color,price, name);
    }
}
class Pants extends Clothes implements Mensclothing,Womensclothing {
    public Pants(Size size, String color, int price, String name) {
        super(size, color, price, name);
    }
}
class Skirt extends Clothes implements  Womensclothing {
    public Skirt(Size size, String color, int price, String name) {
        super(size, color, price, name);
    }
}
class Tie extends Clothes implements Mensclothing{
    public Tie(Size size, String color,int price, String name) {
        super(size, color,price, name);
    }
}
class Atelier {
    public void DressMens(Clothes[] clothes){
        System.out.println("Men's clothing in stock: ");
        for (Clothes clothes1 : clothes){
            if (clothes1 instanceof Mensclothing){
                System.out.println(clothes1);
            }
        }
    }
    public void DressWomen(Clothes[]clothes){
        System.out.println("Women's clothing in stock: ");
        for (Clothes clothes1 : clothes){
            if (clothes1 instanceof Womensclothing){
                System.out.println(clothes1);
            }
        }
    }
}