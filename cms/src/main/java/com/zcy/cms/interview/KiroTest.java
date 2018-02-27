package com.zcy.cms.interview;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class KiroTest {

    public static void main(String[] args) {
        try {
            Kryo kryo = new Kryo();
            AnoymousClass a = new AnoymousClass();
            a.setName("zcy");
            File file = new File("C://a.zcy");
            Output out = new Output(new FileOutputStream(file));
            kryo.writeObject(out, a);
            out.close();

            System.out.println("序列化完毕。");

            Input input = new Input(new FileInputStream(new File("C://a.zcy")));
            AnoymousClass aa = kryo.readObject(input, AnoymousClass.class);
            System.out.println(aa.getName());






        Jdk9 j = new Jdk9();
        j.setName("zxcy");
        File file2 = new File("C://ax.xml");
        Output out2 = new Output(new FileOutputStream(file));
        XMLEncoder encoder = new XMLEncoder(out2);
        encoder.writeObject(j);
        out.close();


            System.out.println("序列化完毕。");

//            Input input2 = new Input(new FileInputStream(new File("C://a.zcy")));
//            encoder.re
//            AnoymousClass aa2 = kryo.readObject(input, AnoymousClass.class);
//
//            System.out.println(aa.getName());

        }catch (Exception e){
            e.printStackTrace();
        }

//    // ...
//    Output output = new Output(new FileOutputStream("file.bin"));
//    SomeClass someObject = ...
//            kryo.writeObject(output, someObject);
//    output.close();
//    // ...
//    Input input = new Input(new FileInputStream("file.bin"));
//    SomeClass someObject = kryo.readObject(input, SomeClass.class);
//    input.close();
    }

}
