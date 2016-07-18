
import java.util.HashMap;



public class APP {
     HashMap<String,Banco> bancos = new HashMap<>();
    public APP(){
   
  
    }
     /**
     *cria um novo banco
     * @param chave
     * @param nomeB
     * @param numB
     */
    public void criarBanco(String chave,String nomeB,int numB){
     Banco x;
     bancos.put(chave,x=new Banco( nomeB,numB)); 
     }
    public void criarAgencia(Banco x,String chave,int numA,String nomeA,String telA,String nomeGerente){
        x.criarAgencia( chave, numA, nomeA, telA, nomeGerente);
    }
    public void criarConta(Banco x,Agencia y,Cliente c,String chaveConta,int numConta,int limiteConta, String tipoConta){
       x.criarConta(y, c, chaveConta, numConta, limiteConta, tipoConta);
}
    public void criarCliente(Banco x,Agencia y,String chaveCliente,String nomeC,String telC,String emailC){
         x.criarCliente(y, chaveCliente, nomeC, telC, emailC);
}
}
