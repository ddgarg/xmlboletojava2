/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jboleto.control;

import org.jboleto.Banco;
import org.jboleto.JBoletoBean;

/**
 * Interface responsavel por ditar as regras para gerar os boletos
 *
 * @author Fabio Souza
 */
public interface Generator {

    /**
     * Adiciona um boleto na fila de boletos, ou seja, adiciona uma pagina ao documento com o boleto.
     * @param jBoletoBean
     * @param banco
     */
    public void addBoleto(JBoletoBean jBoletoBean, Banco banco);
    
    /**
     * Fecha o arquivo que foram gerados os boletos.
     * @param caminho Caminho onde será armazenado o arquivo com os boletos
     */
    public void closeBoleto(String caminho);
}
