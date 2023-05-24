public class Main {
    public static void main(String[] args){
        Person p = new Person("Jason", 2032, 12.56);
        System.out.println(p.name() + ", " + p.id()+", "+p.pay());   
        System.out.println( p.equals(new Person("Jason", 2032, 12.56)));
        System.out.println(p.hashCode());
        System.out.println(p); // toString() is called
    }
}
