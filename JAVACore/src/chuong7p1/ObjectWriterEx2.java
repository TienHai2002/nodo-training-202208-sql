package chuong7p1;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;
public class ObjectWriterEx2 {
    public static void main(String[] args) throws Exception{
        File file = new File("C://Users//Admin//Downloads//io_sample.txt");
        ObjectInputStream inputStream=new ObjectInputStream(
                new FileInputStream(new File(file,"my_object")));
        Object obj = inputStream.readObject();
        Method method = obj.getClass().getMethod("run",new Class[0]);
        method.invoke(obj,new Object[0]);
        inputStream.close();
    }
}
