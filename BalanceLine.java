import java.io.*;
import java.util.LinkedList;

public class BalanceLine {
    
    public static void balanceLine(String arqMestre, String arqTrans, String arqSaida, String arqErros) throws IOException{
        DataInputStream mestre = new DataInputStream(new FileInputStream(arqMestre));
        DataInputStream trans = new DataInputStream(new FileInputStream(arqTrans));
        DataOutputStream saida = new DataOutputStream(new FileOutputStream(arqSaida));
        DataOutputStream erros = new DataOutputStream(new FileOutputStream(arqErros));
        
        LinkedList<Cliente> clientes = obtemClientes(mestre);
        mestre.close();
        
        processaTransacoes(trans, clientes, erros);
        trans.close();
        erros.close();
        
        for(Cliente c : clientes)
            c.salva(saida);
        
        saida.close();
    }
    
    public static LinkedList<Cliente> obtemClientes(DataInputStream in) throws IOException{
        LinkedList<Cliente> resp = new LinkedList<Cliente>();
        try{
            while(true)
                resp.add(new Cliente(in));
        }catch(EOFException e){}
        return resp;
    }
    
    public static void processaTransacoes(DataInputStream in, LinkedList<Cliente> c, DataOutputStream erros) throws IOException{
        try{
            Transacao t;
            Cliente cliente;
            while(true){
                t = new Transacao(in);
                cliente = busca(c, t.getCod());
                switch(t.getTipo()){
                    case 'I':
                        if(cliente != null)
                            t.salva(erros);
                        insereOrdenado(new Cliente(t.getCod(), t.getDado1(), t.getDado2()), c);
                        break;
                    case 'E':
                        if(cliente == null)
                            t.salva(erros);
                        else
                            c.remove(cliente);
                        break;
                    case 'M':
                        if(cliente == null)
                            t.salva(erros);
                        else{
                            if(t.getDado1().equals("nome"))
                                cliente.setNome(t.getDado2());
                            else
                                cliente.setData(t.getDado2());
                        }
                        break;
                }
            }
        }catch(EOFException e){}
    }
    
    public static void insereOrdenado(Cliente c, LinkedList<Cliente> lista){
        int i;
        for(i = 0; i < lista.size(); i++){
            if(lista.get(i).getCod() > c.getCod())
                break;
        }
        lista.add(i, c);
    }
    
    public static Cliente busca(LinkedList<Cliente> lista, int cod){
        int inicio = 0;
        int fim = lista.size() - 1;
        int meio;
        Cliente atual;
        if(fim >= 0){
            while(inicio <= fim){
                meio = (inicio + fim) / 2;
                atual = lista.get(meio);
                if(atual.getCod() == cod)
                    return atual;
                if(atual.getCod() < cod)
                    inicio = meio + 1;
                else
                    fim = meio - 1;
            }
        }
        return null;
    }
    
}
