package com.my.spring.chapter04;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

public class FileSourceExample {
    public static void main(String[] args) {
        try {
            String filePath="F:/JavaProject/tc/Workspace/spring/src/main/resource/file1.txt";
            WritableResource resource=new PathResource(filePath);
            Resource resource2=new ClassPathResource("file1.txt");
            
            OutputStream ouStream=resource.getOutputStream();
            ouStream.write("欢迎光临\n小春论坛".getBytes());
            ouStream.close();
            
            InputStream inputStream=resource.getInputStream();
            InputStream inputStream2=resource2.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
            int i=0;
            while((i=inputStream.read())!=-1) {
                byteArrayOutputStream.write(i);
            }
            System.out.println(byteArrayOutputStream.toString());
            System.out.println("res1:"+resource.getFilename());
            System.out.println("res2"+resource2.getFilename());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
