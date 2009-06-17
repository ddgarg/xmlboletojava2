package org.jboleto.exemplos;

import java.math.BigDecimal;
import java.util.Vector;
import org.jboleto.JBoleto;
import org.jboleto.JBoletoBean;
import org.jboleto.control.Generator;
import org.jboleto.control.PDFGenerator;

/**
 * @author Vitor Motta - Fly Solution
 */
public class ExemploNossaCaixa {
    
    public static void main(String args[]) {        
        
        JBoletoBean boleto = new JBoletoBean();
        JBoleto jBoleto = null;
            
        Generator generator = new PDFGenerator(boleto, JBoleto.NOSSACAIXA);
        
        BigDecimal valor;
         
        for (int i = 0; i < 5; i++) {
         
            boleto.setAgencia("0016"); // sem digito
            boleto.setDvAgencia("7");
            boleto.setContaCorrente("04 002330"); // modalidade(2) + conta(6)
            boleto.setDvContaCorrente("1"); // digito
            boleto.setMoeda("9"); // 9 = real
            boleto.setCedente("Fly Solution");
            boleto.setCarteira("CEDENT"); // exigencia do banco
            boleto.setLocalPagamento("Pague preferencialmente no Banco Nossa Caixa S.A. ou na rede banc�ria at� o vencimento."); // obrigat�rio essa frase
            boleto.setLocalPagamento2("");
            Vector descricoes = new Vector();
            descricoes.add("Boleto para teste - Nossa Caixa");
            descricoes.add("Fly Solution - www.flysolution.com.br");
            boleto.setDescricoes(descricoes);
            boleto.setInstrucao1("Texto e emiss�o do boleto de Responsabilidade do Cedente"); // texto exigido pelo banco
            boleto.setInstrucao2("N�o Receber ap�s o vencimento");
            boleto.setInstrucao3("Multa de 10% ap�s vencimento");
            boleto.setEspecieDocumento("DS");
         
            boleto.setDataDocumento("15/03/2007");
            boleto.setDataProcessamento("15/03/2007");
            boleto.setDataVencimento("30/0"+ (i+3) +"/2007");
            boleto.setNossoNumero( String.valueOf(i+1),7);
         
            boleto.setNomeSacado("Cliente Compra Tudo");
            boleto.setEnderecoSacado("Rua Treze de Maio, 768");
            boleto.setBairroSacado("Centro");
            boleto.setCidadeSacado("Piracicaba");
            boleto.setUfSacado("SP");
            boleto.setCepSacado("13400-902");
            boleto.setCpfSacado("123.456.789-01");
         
            valor = new BigDecimal( 50 * (i+1) );
         
            boleto.setValorBoleto(valor.toString());

            jBoleto = new JBoleto(generator, boleto, JBoleto.NOSSACAIXA);         

            jBoleto.addBoleto();
         
        }
        
        jBoleto.closeBoleto("nossa_caixa.pdf");
    }
}
