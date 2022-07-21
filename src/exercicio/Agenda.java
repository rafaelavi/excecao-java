package exercicio;

import java.util.Arrays;

public class Agenda extends Contato{
    private Contato[] contatos;

    public Agenda(){
        contatos= new Contato[5];
    }
    public boolean adiciona(Contato contato) throws AgendaCheiaException{
        boolean cheia = true;
        for(int i = 0; i< contatos.length; i++){
            if(contatos[i] == null){
                contatos[i] = contato;
                cheia = false;
                break;
            }
        }

        if(cheia){
            throw new AgendaCheiaException();
        }

        return false;
    }

    public int pesquisaPorNome(String nome) throws ContatoNaoExisteException{
        for(int i = 0; i< contatos.length; i++){
            if(contatos[i].getNome().equalsIgnoreCase(nome)){
                return i;
            }
        }
        throw new ContatoNaoExisteException(nome);
    }

    @Override
    public String toString() {
        String s ="";
        for(Contato c : contatos){
            if(c != null){
                s += c.toString() + "\n";
            }
        }

        return s;
    }
}
