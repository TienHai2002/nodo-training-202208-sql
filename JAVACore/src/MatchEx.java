public class MatchEx {
    public static void main(String[] args) {
        int i = 4;
        int j = -8;
        double x = 47.1;
        double y = 1.79;
        System.out.println("|" + j + "|" + Math.abs(j));
        System.out.println("|" + x + "|" + Math.abs(x));

        System.out.println(x + " is approximately" + Math.round(x));
        System.out.println(" The ceiling of " + i + " is " + Math.ceil(i));
        System.out.println(" The ceiling of " + y + " is " + Math.ceil(y));
        System.out.println(" The floor of " + x + " is " + Math.floor(x));
        System.out.println(" min(" + x + "," + y + ") is " + Math.min(x,y));

        System.out.println(" Pi is " + Math.PI);
        double angle = 45.0 * 2.0 * Math.PI/360.0;
        System.out.println(" cos ( " + angle + " ) is " + Math.cos(angle));

        double value = 0.707;
        System.out.println(" acos ( " + value + " ) is " + Math.cos(value));

        System.out.println(" exp ( 0.0 ) is " + Math.exp(0.0));
        System.out.println(" log ( 10.0 ) is " + Math.log(10.0));
        System.out.println(" pow ( 2.0, 2.0 ) is " + Math.pow(2.0,2.0));

        System.out.println(" Here's one random number : " + Math.random());
    }
}
