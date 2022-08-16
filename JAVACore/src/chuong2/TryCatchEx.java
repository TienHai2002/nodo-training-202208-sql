package chuong2;

public class TryCatchEx {
   static    int toNumber(String value){
        try {
            Integer integer = Integer.parseInt(value);
            return integer.intValue();
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        return -1;
    }

    public static void main(String[] args) {
        int number = toNumber("34");
        System.out.println("number = " + number);
        number = toNumber("as");
        System.out.println("number = " +number);
    }
    public static class SaiSoException extends Exception{
       private String so;
       public SaiSoException(String value){
           this.so = value;
       }
       public String getMessage(){
           return "gia tri \'" + so + "\' khong la so";
       }
    }

}
