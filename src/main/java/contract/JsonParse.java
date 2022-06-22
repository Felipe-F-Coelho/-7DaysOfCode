package contract;

import java.util.List;

/**
 * @author Felipe Coelho
 * Classe de contrato dos Parse
 * As classes de parse deverão obrigatoriamente implementar os metodos para posteriormente serem consumidos.
 */
public interface JsonParse {
    List<? extends Content> getParse();
}
