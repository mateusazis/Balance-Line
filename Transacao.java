import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class Transacao {

    private int cod;
    private char tipo;
    private String dado1, dado2;

    public Transacao(int cod, char tipo, String dado1, String dado2){
        this.cod = cod;
        this.tipo = tipo;
        this.dado1 = dado1;
        this.dado2 = dado2;
    }
    
    public Transacao(int cod, char tipo){
        this(cod, tipo, null, null);
    }
    
    public Transacao(DataInputStream in) throws IOException{
        cod = in.readInt();
        tipo = in.readChar();
        if(tipo != 'E'){
            dado1 = in.readUTF();
            dado2 = in.readUTF();
        }
    }
    
    public void salva(DataOutputStream out) throws IOException{
        out.writeInt(cod);
        out.writeChar(tipo);
        if(tipo != 'E'){
            out.writeUTF(dado1);
            out.writeUTF(dado2);
        }
    }
    
    @Override
    public String toString(){
        String resp = cod + " " + tipo;
        if(tipo != 'E')
            resp += " " + dado1 + " " + dado2;
        return resp;
    }
    
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDado1() {
        return dado1;
    }

    public void setDado1(String dado1) {
        this.dado1 = dado1;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public String getDado2() {
        return dado2;
    }

    public void setDado2(String dado2) {
        this.dado2 = dado2;
    }
    
    
    
}
