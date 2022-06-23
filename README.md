# 7DaysOfCode - Alura Java

Em 7 dias foi desenvolvido usando apenas código Java, consumir uma API para pesquisar os top 250 filmes da lista do IMDB e criar um HTML com os resultados JSON devolvidos. Você também terá que pensar em classes, interfaces, construtores e muitos outros conceitos.

## Informações sobre os dias de desenvolvimento do projeto

### Dia 01

Neste primeiro dia do desafio, desenvovi o consumer da API do IMDB, o meu objetivo era imprimir os resultados de uma busca na linha de comando Utilizando a API para pesquisar os top 250 filmes e imprimir o JSON correspondente no console da IDE.

Para isso, foi precisso acessar o webservice ou API da plataforma e efetuar a solicitação get no endpoint:

[Acessar API-IMDB](https://imdb-api.com/api)

| Task | Descrição                                                                                                                                                                         |
|:----:| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|   1  | - Criar uma conta no IMDB para ter a chave de acesso ao serviço (apiKey), mas cuidado, essa chave não deve ser commitada no Github ou em outro repositório!                       |
|   2  | - Criar o código Java que executará uma requisição HTTP do tipo GET. Você pode usar o pacote java.net.http e as classes HttpRequest, HttpClient e HttpResponse, além da classe URI|
|   3  | - Executar a requisição e pegar a resposta (o JSON)                                                                                                                               |
|   4  | - Imprimir o corpo da resposta no console                                                                                                                                         |

- Observação: É necessário se cadastrar e assim podemos gerar a ApiKey.
### Dia 02

No segundo dia, tivemos a tarefa de parsear essa resposta gerada no dia anterior. Em outras palavras, extrair as informações do JSON gerado.

A tarefa foi extrair o título do filme e a URL da imagem a partir da resposta JSON. 

Com o resultado do parseamento, foi necessário criar diferentes listas, cada uma com um atributo do filme. Uma lista com os títulos, outra com a URL da imagem e assim por diante..

### Dia 03

No terceiro dia, a ideia era iniciar a modelagem para melhorar o código.

Em vez de ter várias listas diferentes, uma para cada atributo do filme, efetuamos uma organização para isso em uma única List<Movie>, onde cada filme encapsula os seus próprios dados, seguindo os seguintes atributos:

- título (title)
- URL da imagem do pôster (urlImage)
- nota (rating)
- ano (year)

### Dia 04

No quarto dia, trabalhamos com a saída e geraramos uma página HTML a partir da lista de objetos que já tinhamos no código Java.

A ideia erá criar uma página HTML onde possamos ver as informações sobre o filme, incluindo o pôster, algo como:

<img src="/imagens/Movie.jpg" alt="Movie"/>


### Dia 05
### Dia 06
### Dia 07

## Cronograma
