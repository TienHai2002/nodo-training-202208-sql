package chuong7p1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
public class ObjectWriterEx {
    public static void main(String[] args) throws Exception{
        File folder = new File("C://Users//Admin//Downloads//io_sample.txt");
        ObjectOutputStream outputStream = null;
        FileOutputStream fileOutPut=new FileOutputStream(new File(folder,"my_object"));
        outputStream = new ObjectOutputStream(fileOutPut);
        PrintMessage printMessage = new PrintMessage("Cau noi noi");
        outputStream.writeObject(printMessage);
    }
}
