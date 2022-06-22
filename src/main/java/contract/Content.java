package contract;

import java.util.List;

/**
 * @author Felipe Coelho
 * Classe de contrato dos domain
 * As classes de domain deverão obrigatoriamente implementar os metodos para posteriormente serem consumidos em listagem genéricas.
 */
public interface Content{
    String title();
    String urlImage();
    Integer rating();
    Integer year();
}
