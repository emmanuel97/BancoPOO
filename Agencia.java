
import java.util.HashMap;


public class Agencia {
    HashMap<String,Cliente> clientes = new HashMap<>();
     HashMap<String,Conta> contas = new HashMap<>();
    public Agencia(int numero,String nome,String endereço,String nomegerente){
        
  
   
    }
     /**
     *cria um novo cliente
     * @param chaveCliente
     * @param nomeC
     * @param telC
     * @param emailC
     */
    public void criarCliente(String chaveCliente,String nomeC,String telC,String emailC){
     Cliente x;
     clientes.put(chaveCliente,x=new Cliente(nomeC,telC,emailC)); 
     }
    public void criarConta(Cliente c,String chaveConta,int numConta,int limiteConta, String tipoConta){
        if ("C".equals(tipoConta)){
            ContaC x;
            contas.put(chaveConta,x=new ContaC());
        }else if("P".equals(tipoConta)){
            ContaP x;
         contas.put(chaveConta,x=new ContaP());
       }
    }
}
