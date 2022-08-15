public class StringEx2 {
    public static void main(String[] args) {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        String text = new String(chars);
        System.out.println(text);
        text = text.concat(" ");
        text = text.concat(args[0]);
        System.out.println("new value is "+text);
        System.out.println("hello java".equals(text));
    }
}
