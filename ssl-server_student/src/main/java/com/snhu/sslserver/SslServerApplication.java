package com.snhu.sslserver;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SslServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SslServerApplication.class, args);
	}

}
//FIXME: Add route to enable check sum return of static data example:  String data = "Hello World Check Sum!"
public static String getChecksum(Serializable object) throws IOException, NoSuchAlgorithmException {
    ByteArrayOutputStream baos = null;
    ObjectOutputStream oos = null;
    try {
        baos = new ByteArrayOutputStream();
        oos = new ObjectOutputStream(baos);
        oos.writeObject(object);
        MessageDigest md = MessageDigest.getInstance("Hello World Check Sum!");
        byte[] thedigest = md.digest(baos.toByteArray());
        return DatatypeConverter.printHexBinary(thedigest);
    } finally {
        oos.close();
        baos.close();
    }
}