import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;


public class UDP_P_CLIENT {

	
	public static void main(String[] args) throws IOException 
	{
	 InetAddress addr=InetAddress.getLocalHost();
	 /*this class represents IP address*/
	 
	 
	 DatagramSocket s=new DatagramSocket(1080);
	 /* This class represents a socket for sending and receiving datagram packets
	  * this class creates a datagram socket & binds it to available port
	  * */
	 
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 /* BufferedReader reads text from a character input-stream,buffering characters*/
	 
	 byte[] buffer=new byte[20];
	 /* The Byte class wraps a value of primitive type byte in an object.
	  * this class provides several methods for converting a byte to a String and a String to a byte,*/
	 
	 String str="";
	 
	 while(!str.equals("bye"))
	 {
		 System.out.println("Client:");
		 str=br.readLine(); 							//reads a line of text
		 buffer=str.getBytes();                        // stores the byte version of data..This method  properly convert characters into bytes
		 
		 DatagramPacket p1=new DatagramPacket(buffer,buffer.length,addr,1055);      //wrapping data in packet
		 /* this class represenrs datagram packets
		  * datagaram packets are used to implment a connectionless packet delevery service*/
		 
		 s.send(p1);  //sending packet p1 to server
		 
		 byte[] buffer1=new byte[20]; 
		 
		 DatagramPacket p2=new DatagramPacket(buffer1, buffer1.length);   //creating packet
		 
		 s.receive(p2);    //receives data in packet
		 
		 buffer1=p2.getData();    //converts the data from string format to byte version
		 
		 String str1=new String(buffer1,StandardCharsets.UTF_8);  //converting data from byte format to string format
		 
		 System.out.println("Server:"+str1);
		 
		 
		 
	 }
	 
	 

	}

}

/*



C:\Users\Alvis\Downloads>javac UDP_P_CLIENT.java

C:\Users\Alvis\Downloads>java UDP_P_CLIENT
Client:
helooo
Server:boloo
Client:
bye
Server:ok

C:\Users\Alvis\Downloads>


*/
