package contract;

/**
 * @author Felipe Coelho
 * Classe de contrato das API
 * As classes de importação da API deverão respeitar e implementar os metodos obrigatórios.
 */
public interface APIClient {
    String getBody() throws Exception;
    TypeEnum type();
}
