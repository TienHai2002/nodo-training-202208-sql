package chuong2;

import chuong2.TryCatchEx;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThrowableExemple {
    private final static Logger LOGGER = Logger.getLogger(ThrowableExemple.class.getName());
    public static int toNumber(String value) throws TryCatchEx.SaiSoException {
        try {
            Integer integer = Integer.parseInt(value);
            return integer.intValue();
        }catch (NumberFormatException e){
            throw new TryCatchEx.SaiSoException(value);
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("number = " + toNumber(args[0]));
        }catch (TryCatchEx.SaiSoException e){
//            System.err.println(e.getMessage());
            LOGGER.log(Level.WARNING, e.getMessage());
        }
    }
}
