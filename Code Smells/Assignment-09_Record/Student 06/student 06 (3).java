public record Place(int x, int y){

    public static void main(String[] args){
        Place lugar = new Place(20, 30);
        System.out.println(lugar.x() + ", " + lugar.y());
        System.out.println(lugar.equals(new Place(20,30)));
        System.out.println(lugar.hashCode());
        System.out.println(lugar);

        equivalent eq = new equivalent(20, 30);
        System.out.println(eq.x() + ", " + lugar.y());
        System.out.println(eq.equals(new Place(20,30)));
        System.out.println(eq.hashCode());
        System.out.println(eq);
    }

}
