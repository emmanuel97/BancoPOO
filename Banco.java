
import java.util.HashMap;

public class Banco {
     HashMap<String,Agencia> agencias = new HashMap<>();
    public Banco(String nome,int num){
   
  
        
  
 
    }
     /**
     *cria uma nova agencia
     * @param chave
     * @param numA
     * @param nomeA
     * @param telA
     * @param nomeGerente
     */
    public void criarAgencia(String chave,int numA,String nomeA,String telA,String nomeGerente){
     Agencia x;
     agencias.put(chave,x=new Agencia(numA,nomeA,telA,nomeGerente)); 
     }
    public void criarCliente(Agencia x,String chaveCliente,String nomeC,String telC,String emailC){
    x.criarCliente( chaveCliente, nomeC, telC, emailC);
    }
    public void criarConta(Agencia x,Cliente c,String chaveConta,int numConta,int limiteConta, String tipoConta){
    x.criarConta( c, chaveConta, numConta, limiteConta,  tipoConta);
    }
}
