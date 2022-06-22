package contract;

/**
 * @author Felipe Coelho
 * Classe de contrato dos Parse
 * As classes de domain deverão obrigatoriamente implementar os metodos para posteriormente serem consumidos em listagem genéricas.
 */
import java.util.List;

public interface JsonParce {
    List<? extends Content> getParse();
}
