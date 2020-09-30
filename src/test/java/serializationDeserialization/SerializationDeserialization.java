package serializationDeserialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Test implements Serializable{
	
	int i=10,  j =20;
}



public class SerializationDeserialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Test t1= new Test();
		
		//Serialization
		FileOutputStream fos=new FileOutputStream("text.txt");
		ObjectOutputStream oos= new ObjectOutputStream(fos);
		oos.writeObject(t1);
		
		//DeSerialization
		FileInputStream fis = new FileInputStream("text.txt");
		ObjectInputStream ois= new ObjectInputStream(fis);
		
		Test t2=(Test)ois.readObject();
		System.out.println(t2.i+" "+t2.j);
	}

}
