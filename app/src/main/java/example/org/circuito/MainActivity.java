package example.org.circuito;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MainActivity extends AppCompatActivity {

    private String letra="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {


            InetAddress receiverHost = InetAddress.getByName("10.2.4.81");

            DatagramSocket mySocket = new DatagramSocket();

            int reciverPort = 2222;

            while (true) {



                byte[] buffer = letra.getBytes();

                DatagramPacket datagram = new DatagramPacket(buffer, buffer.length, receiverHost, reciverPort);
                mySocket.send(datagram);
                Thread.sleep(50);
            }

        } catch (Exception ex) {

            ex.printStackTrace();

        }
    }

    public void lanzarAdelante() {
        this.letra="w";
    }
    public void lanzarDerecha() {
        this.letra="d";
    }
    public void lanzarIzquierda() {
        this.letra="a";
    }
    public void lanzarAtras() {
        this.letra="s";
    }
    public String getLetra(){
        return this.letra;
    }
}
