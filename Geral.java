import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.EOFException;
public class Geral {
    
    public static void exibeClientes(String arq) throws IOException{
        DataInputStream in = new DataInputStream(new FileInputStream(arq));
        try{
            while(true)
                System.out.println(new Cliente(in));
        } catch(EOFException e){
            in.close();
        }
    }
    
    public static void exibeTransacoes(String arq) throws IOException{
        DataInputStream in = new DataInputStream(new FileInputStream(arq));
        try{
            while(true)
                System.out.println(new Transacao(in));
        } catch(EOFException e){
            in.close();
        }
    }
    
    public static void escreveClientes(String arq, Cliente clientes[]) throws IOException{
        DataOutputStream out = new DataOutputStream(new FileOutputStream(arq));
        for(Cliente c : clientes)
            c.salva(out);
        out.close();
    }
    
    public static void escreveTransacoes(String arq, Transacao transacoes[]) throws IOException{
        DataOutputStream out = new DataOutputStream(new FileOutputStream(arq));
        for(Transacao t : transacoes)
            t.salva(out);
        out.close();
    }
    
}
