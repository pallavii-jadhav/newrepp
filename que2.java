import java.util.*;
class Animal{
void show(){
System.out.println("Sound of Animal");
}
}
class Dog extends Animal{
void show(){
System.out.println("This Sound is dog");
}
}
class Cat extends Animal{
void show(){
System.out.println("This Sound is Cat");
}
}

class Test{
public static void main(String args[]){
Dog obj1=new Dog();
obj1.show();
Cat obj2=new Cat();
obj2.show();
}
}