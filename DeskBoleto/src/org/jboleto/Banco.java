/*
 * Esta biblioteca e um software livre, que pode ser redistribuido e/ou
 * modificado sob os termos da LicenÃ§a Publica Geral Reduzida GNU,
 * conforme publicada pela Free Software Foundation, versao 2.1 da licenca.
 *
 * Esta biblioteca e distribuida na experanca de ser util aos seus usuarios,
 * porem NAO TEM NENHUMA GARANTIA, EXPLICITAS OU IMPLICITAS, COMERCIAIS OU
 * DE ATENDIMENTO A UMA DETERMINADA FINALIDADE.
 * Veja a Licenca Publica Geral Reduzida GNU para maiores detalhes.
 * A licenca se encontra no arquivo lgpl-br.txt
 */

package org.jboleto;

/**
 * @author Flavio Brasil
 *
 */
public interface Banco {

    /**
     * Recupera o codigo do banco
     */
    public String getNumero();

    /**
     * Recupera o numero necessario para a geracao do codigo de barras
     */
    public String getCodigoBarras();

    /**
     * Recupera a numeracao para a geracao da linha digitavel do boleto
     */
    public String getLinhaDigitavel();

    /**
     * @return Recupera a carteira no padrao especificado pelo banco
     * @author Gladyston Batista/Eac Software
     */
    public String getCarteiraFormatted();

    /**
     * @return Recupera a agencia/codigo cedente no padrao especificado pelo banco
     * @author Gladyston Batista/Eac Software
     */
    public String getAgenciaCodCedenteFormatted();

    /**
     * @return Recupera o nosso numero no padrao especificado pelo banco
     * @author Gladyston Batista/Eac Software
     */
    public String getNossoNumeroFormatted();
}