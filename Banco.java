package Banco;
import Agencias.*;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Set;

public class Banco {
     HashMap<String,Agencia> agencias = new HashMap<String,Agencia>();
     String nome;
     int num;
     Calendar data=Calendar.getInstance();
     
    public Banco(String nome,int num){
   this.num=num;
   this.nome=nome;
    }
    
    public String hoje(){
    	return "hoje é "+data.get(Calendar.DAY_OF_MONTH)+"/"+(data.get(Calendar.MONTH)+1)+"/"+data.get(Calendar.YEAR);

    }
    public void proxMes(){
    	data.add(Calendar.MONTH, 1);
    }
    public void antMes(){
    	data.add(Calendar.MONTH, -1);
    }
    public void proxDia(){
    	data.add(Calendar.DAY_OF_MONTH, 1);
    }
    public void antDia(){
    	data.add(Calendar.DAY_OF_MONTH, -1);
    }
    public void criarAgencia(int numA,String nomeA,String telA,String endereço,String nomeGerente){
     Agencia x=new Agencia(numA,nomeA,endereço,telA,nomeGerente);
     agencias.put(String.valueOf(numA),x); 
     System.out.println(numA+"t");
     }
    public String dadosB(){
    	return "Nome:"+nome+".\nNumero de registro:"+num+".\n";
    }
    public String dadosA(String chaveAgencia){
    	if(agencias.get(chaveAgencia)!=null){
    		return agencias.get(chaveAgencia).dadosA();
    	}
    	return "A Agencia procurada não existe";
    	
    }
     
    public Agencia buscarA(int numA){
    	return agencias.get(String.valueOf(numA));
}
    
  public void listaAgencias(){
    	System.out.println("As Agencias deste Banco são:\n");
        Set<String> chavesA = agencias.keySet();
        for(String chave: chavesA){
            System.out.println(agencias.get(chave).dadosA()+"\n");}
    }
  
  public void calcPoupança(){
  	Set<String> chavesA = agencias.keySet();
      for(String chave: chavesA){
    	  agencias.get(chave).calcPoupança(data);
    	  }
  }
  public void deleteA(int chave){
	  agencias.remove(String.valueOf(chave));
  }
}
