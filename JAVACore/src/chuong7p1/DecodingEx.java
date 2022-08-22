package chuong7p1;

import java.io.UnsupportedEncodingException;

public class DecodingEx {
    public static void main(String[] args) throws UnsupportedEncodingException {
        int [] value = {120,105,110,32,99,104,-61,-96,111};
        byte [] bytes = new byte[value.length];
        for (int i = 0 ; i < bytes.length;i++){
          bytes [i] =(byte) value[i];
        }
        System.out.println(new String(bytes,"utf8"));
    }
}
