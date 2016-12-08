dasfsfdsfdsfs



public class APP {
     HashMap<String,Banco> bancos = new HashMap<>();
   
    public void criarBanco(String chave,String nomeB,String numB){
     Banco x=new Banco( nomeB,numB);
     bancos.put(chave,x); 
     }
    public void criarAgencia(Banco x,String chaveAgencia,String numA,String nomeA,String telA,String nomeGerente){
        x.criarAgencia(numA, nomeA, telA, nomeGerente);
    }
    public void criarContaC(Banco x,Agencia y,Cliente c,String chaveConta,String numConta,double limite){
       x.criarContaC(y, c, chaveConta, numConta, limite);
}
    public void criarContaP(Banco x,Agencia y,Cliente c,String chaveConta,String numConta){
        x.criarContaP(y, c, chaveConta, numConta);
 }
   
    public void criarClienteF(Banco x,Agencia y,String chaveCliente,String nomeC,String telC,String emailC,String CPF){
    x.criarClienteF(y, chaveCliente, nomeC, telC, emailC,CPF);
    }
        
     public void criarClienteJ(Banco x,Agencia y,String chaveCliente,String nomeC,String telC,String emailC,String NF,String CNPJ){
     x.criarClienteJ(y, chaveCliente, nomeC, telC, emailC,NF,CNPJ);
     }
    
    public Banco buscarB(String chaveBanco){
    	return bancos.get(chaveBanco);
    }
    public Agencia buscarA(Banco x,String chaveAgencia){
    	return x.buscarA(chaveAgencia);
    }
    public Cliente buscarClienteF(Banco y,Agencia x,String chaveCliente){
    	return y.buscarClienteF(x,chaveCliente);
    }
    public ContCorrente buscarContaC(Banco y,Agencia x,String chaveConta){
    	return y.buscarContaC(x,chaveConta);
    }
    public Cliente buscarClienteJ(Banco y,Agencia x,String chaveCliente){
    	return y.buscarClienteJ(x,chaveCliente);
    }
    public ContaPoupança buscarContaP(Banco y,Agencia x,String chaveConta){
    	return y.buscarContaP(x,chaveConta);
    }
    public void listaClientes(Banco x,Agencia y){
    	x.listaClientes(y);
    }
    
    public void listaAgencias(Banco x){
    	x.listaAgencias();
    }
    
    public void listaBancos(){
    	System.out.println("Os Bancos cadastrados neste programa são\n");
        Set<String> chavesB = bancos.keySet();
        for(String chave: chavesB){
            System.out.println(bancos.get(chave).dadosB()+"\n");}
    }

}
