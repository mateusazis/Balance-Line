import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
public class Cliente {
    
    private int cod;
    private String nome, data;
    
    public Cliente(int cod, String nome, String data){
        this.cod = cod;
        this.nome = nome;
        this.data = data;
    }
    
    public Cliente(DataInputStream in) throws IOException{
        this(in.readInt(), in.readUTF(), in.readUTF());
    }
    
    public void salva(DataOutputStream out) throws IOException{
        out.writeInt(cod);
        out.writeUTF(nome);
        out.writeUTF(data);
    }
    
    @Override
    public String toString(){
        return cod + " " + nome + " " +data;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
//    @Override
//    public boolean equals(Object o){
//        if(o instanceof Cliente)
//            return ((Cliente)o).cod == cod;
//        return super.equals(o);
//    }
    
}
