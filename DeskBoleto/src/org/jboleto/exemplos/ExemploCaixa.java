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

package org.jboleto.exemplos;

import java.util.Vector;
import org.jboleto.JBoleto;
import org.jboleto.JBoletoBean;
import org.jboleto.control.Generator;
import org.jboleto.control.PDFGenerator;


/**
 * @author Fabio Souza
 */
class ExemploCaixa {
    
    public static void main(String args[]) {
        JBoletoBean jBoletoBean = new JBoletoBean();
        
        jBoletoBean.setDataDocumento("31/05/2007");
        jBoletoBean.setDataProcessamento("31/05/2007");
        
        jBoletoBean.setCedente("KOBI SYSTEM LTDA ME");
        
        jBoletoBean.setNomeSacado("Teste");
        jBoletoBean.setEnderecoSacado("Rua teste");
        jBoletoBean.setBairroSacado("XXXX");
        jBoletoBean.setCidadeSacado("Rio de Janeiro");
        jBoletoBean.setUfSacado("RJ");
        jBoletoBean.setCepSacado("22753-501");
        jBoletoBean.setCpfSacado("87524988753");
        jBoletoBean.setCarteira("052358");
        jBoletoBean.setLocalPagamento("ATE O VENCIMENTO, PREFERENCIALMENTE NA CAIXA ECONOMICA");
        jBoletoBean.setLocalPagamento2("APOS O VENCIMENTO, SOMENTE NA CAIXA ECONOMICA");
        
        Vector descricoes = new Vector();
        descricoes.add("Hospedagem I - teste descricao1 - R$ 39,90");
        descricoes.add("Manutencao - teste ricao2 - R$ 32,90");
        descricoes.add("Sistema - teste ssssde descricao3 - R$ 45,90");
        descricoes.add("Extra - teste de descricao4 - R$ 78,90");
        
        jBoletoBean.setDescricoes(descricoes);
        
        jBoletoBean.setInstrucao1("APOS O VENCIMENTO COBRAR MULTA DE 2%");
        jBoletoBean.setInstrucao2("APOS O VENCIMENTO COBRAR R$ 0,50 POR DIA DE ATRASO");
        jBoletoBean.setInstrucao3("Inclusao de mais uma linha");
        jBoletoBean.setInstrucao4("");
        
        jBoletoBean.setAgencia("0027");
        jBoletoBean.setContaCorrente("00000023");
        jBoletoBean.setDvContaCorrente("1");
        
        jBoletoBean.setCarteira("24"); //pode ser 80 ou 81 ou 82 (Confirmar com gerente)
        jBoletoBean.setCodigoOperacao("444");
        jBoletoBean.setCodigoFornecidoAgencia("00000324");
        jBoletoBean.setDvCodigoFornecidoAgencia("2");
        
        jBoletoBean.setNossoNumero("200282532",9);
        jBoletoBean.setDvNossoNumero("0");
        jBoletoBean.setNoDocumento("");
        
        jBoletoBean.setValorBoleto("4.00");
        jBoletoBean.setDataVencimento("14/12/2008");
        
        Generator generator = new PDFGenerator(jBoletoBean, JBoleto.CAIXA_ECONOMICA);
        JBoleto jBoleto = new JBoleto(generator, jBoletoBean, JBoleto.CAIXA_ECONOMICA);
        jBoleto.addBoleto();
        
        jBoleto.closeBoleto("caixa001.pdf");
        
    }
}
