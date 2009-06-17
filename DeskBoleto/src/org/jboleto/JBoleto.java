/*
 * Esta biblioteca e um software livre, que pode ser redistribuido e/ou
 * modificado sob os termos da Licença Publica Geral Reduzida GNU,
 * conforme publicada pela Free Software Foundation, versao 2.1 da licenca.
 *
 * Esta biblioteca e distribuida na experanca de ser util aos seus usuarios,
 * porem NAO TEM NENHUMA GARANTIA, EXPLICITAS OU IMPLICITAS, COMERCIAIS OU
 * DE ATENDIMENTO A UMA DETERMINADA FINALIDADE.
 * Veja a Licenca Publica Geral Reduzida GNU para maiores detalhes.
 * A licenca se encontra no arquivo lgpl-br.txt
 */

package org.jboleto;

import org.jboleto.bancos.BancoBrasil;
import org.jboleto.bancos.BancoReal;
import org.jboleto.bancos.Bradesco;
import org.jboleto.bancos.CaixaEconomica;
import org.jboleto.bancos.Hsbc;
import org.jboleto.bancos.Itau;
import org.jboleto.bancos.NossaCaixa;
import org.jboleto.bancos.Santander;
import org.jboleto.bancos.Unibanco;
import org.jboleto.control.Generator;


/**
 * Classe resposavel por setar todas as configuracoes necessarias para a geracao do titulo / boleto
 * 
 * @author Flavio Brasil *
 */
public class JBoleto {
    
    public static final int BANCO_DO_BRASIL = 1;
    public static final int BRADESCO = 237;
    public static final int ITAU = 341;
    public static final int BANCO_REAL = 356;
    public static final int CAIXA_ECONOMICA = 104;
    public static final int UNIBANCO = 409;
    public static final int HSBC = 399;
    public static final int NOSSACAIXA = 151;
    public static final int SANTANDER = 353;
    
    private Generator generator;
    private JBoletoBean boleto;
    private Banco banco;

    public JBoleto(Generator generator, JBoletoBean boleto, int codBanco) {
        
        this.boleto = boleto;
        
        if (codBanco == JBoleto.BANCO_DO_BRASIL) {
            
            banco = new BancoBrasil(boleto);
        } 
        else if (codBanco == JBoleto.BRADESCO) {
            
            banco = new Bradesco(boleto);
        } 
        else if (codBanco == JBoleto.ITAU) {
            
            banco = new Itau(boleto);
        } 
        else if (codBanco == JBoleto.BANCO_REAL) {
            
            banco = new BancoReal(boleto);
        } 
        else if (codBanco == JBoleto.CAIXA_ECONOMICA) {
            
            banco = new CaixaEconomica(boleto);
        } 
        else if (codBanco == JBoleto.UNIBANCO) {
            
            banco = new Unibanco(boleto);
        } 
        else if (codBanco == JBoleto.HSBC) {
            
            banco = new Hsbc(boleto);
        } 
        else if (codBanco == JBoleto.NOSSACAIXA) {
            
            banco = new NossaCaixa(boleto);
        }
        else if (codBanco == JBoleto.SANTANDER) {
            
            banco = new Santander(boleto);
        }
                
        /**
         * Alterado por Gladyston/EAC Software
         * seta as inf no objeto boleto p/ serem acessadas atraves do main
         */
        boleto.setCodigoBarras(banco.getCodigoBarras());
        boleto.setLinhaDigitavel(banco.getLinhaDigitavel());
                
        this.generator = generator;
    }
    
    /**
     * Metodo responsavel por adicionar um boleto na fila para a geracao e identificando o seu respectivo banco
     */
    public void addBoleto(){
        
        generator.addBoleto(boleto, banco);
    }
    
    /**
     * Metodo que cria o arquivo loca no disco
     */
    public void closeBoleto(String caminho){
        
        try{

            generator.closeBoleto(caminho);            
        } 
        catch (Exception ex) {
            
            ex.printStackTrace();
        }
    }           
}