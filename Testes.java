import java.io.IOException;
import java.util.LinkedList;
public class Testes {
    
    public static String mestre = "mestre.txt";
    public static String trans = "trans.txt";
    public static String saida = "saida.txt";
    public static String erros = "erros.txt";
    public static LinkedList<Cliente> c;
    public static LinkedList<Transacao> t;
    

    public static void exibeResultados() throws IOException{
        System.out.println("Arquivo de saída: ");
        Geral.exibeClientes(saida);
        System.out.println("Arquivo de erros: ");
        Geral.exibeTransacoes(erros);
    }
    
    public static void testa() throws IOException{
        Geral.escreveClientes(mestre, c.toArray(new Cliente[0]));
        Geral.escreveTransacoes(trans, t.toArray(new Transacao[0]));
        BalanceLine.balanceLine(mestre, trans, saida, erros);
        exibeResultados();
    }
    
    public static void testaArquivosVazios() throws IOException{
        testa();
    }
    
    public static void testaTransacoesVazio() throws IOException{
        c.add(new Cliente(1, "João", "12/04/2000"));
        c.add(new Cliente(5, "Maria", "14/06/1999"));
        c.add(new Cliente(7, "Pedro", "23/07/1992"));
        testa();
    }
    
    public static void testaMestreVazio() throws IOException{
        t.add(new Transacao(1, 'I', "João", "12/04/2000"));
        t.add(new Transacao(5, 'I', "Maria", "14/06/1999"));
        t.add(new Transacao(7, 'I', "Pedro", "23/07/1992"));
        testa();
    }
    
    public static void testaMestreVazioComErros() throws IOException{
        t.add(new Transacao(1, 'I', "João", "12/04/2000"));
        t.add(new Transacao(5, 'I', "Maria", "14/06/1999"));
        t.add(new Transacao(6, 'M', "nome", "Marta"));
        t.add(new Transacao(7, 'I', "Pedro", "23/07/1992"));
        testa();
    }
    
    public static void testaInsercao() throws IOException{
        c.add(new Cliente(3, "Ana", "21/03/2000"));
        c.add(new Cliente(4, "Miriam", "25/07/1998"));
        
        t.add(new Transacao(1, 'I', "João", "12/04/2000"));
        t.add(new Transacao(5, 'I', "Maria", "14/06/1999"));
        t.add(new Transacao(7, 'I', "Pedro", "23/07/1992"));
        testa();
    }
            
    public static void testaExclusao() throws IOException{
        c.add(new Cliente(1, "João", "12/04/2000"));
        c.add(new Cliente(3, "Ana", "21/03/2000"));
        c.add(new Cliente(4, "Miriam", "25/07/1998"));
        c.add(new Cliente(5, "Maria", "14/06/1999"));
        c.add(new Cliente(7, "Pedro", "23/07/1992"));
        
        t.add(new Transacao(3, 'E'));
        t.add(new Transacao(5, 'E'));
        testa();
    }
    
    public static void testaCompleto() throws IOException{
        c.add(new Cliente(1, "João", "12/04/2000"));
        c.add(new Cliente(5, "Maria", "14/06/1999"));
        c.add(new Cliente(7, "Pedro", "23/07/1992"));
        c.add(new Cliente(10, "Jonas", "21/01/1975"));
        
        t.add(new Transacao(3, 'I', "Rodrigo", "25/05/1980"));
        t.add(new Transacao(5, 'M', "nome", "Marta"));
        t.add(new Transacao(7, 'E'));
        testa();
    }
    
    public static void testaCompletoComErros() throws IOException{
        c.add(new Cliente(1, "João", "12/04/2000"));
        c.add(new Cliente(5, "Maria", "14/06/1999"));
        c.add(new Cliente(7, "Pedro", "23/07/1992"));
        c.add(new Cliente(10, "Jonas", "21/01/1975"));
        
        t.add(new Transacao(2, 'I', "Rodrigo", "25/05/1980"));
        t.add(new Transacao(6, 'M', "nome", "Marta"));
        t.add(new Transacao(7, 'E'));
        t.add(new Transacao(11, 'E'));
        testa();
    }
    
    public static void main(String[] args) throws IOException{
        c = new LinkedList<Cliente>();
        t = new LinkedList<Transacao>();
//        testaArquivosVazios();
//        testaTransacoesVazio();
//        testaMestreVazio();
//        testaMestreVazioComErros();
//        testaInsercao();
//        testaExclusao();
//        testaCompleto();
        testaCompletoComErros();
    }
    
}
