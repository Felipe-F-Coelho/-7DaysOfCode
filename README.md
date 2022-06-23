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

![Movie](https://raw.githubusercontent.com/Felipe-F-Coelho/-7DaysOfCode/main/imagens/Movie.JPG)

| Task | Descrição                                                                                                                                                                                                                 |
|:----:| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|   1  | - Crie uma nova classe HTMLGenerator, que irá receber no construtor um Writer (por exemplo, PrintWriter)                                                                                                                  |
|   2  | - Adicione um método chamado ‘generate’, que irá receber uma List<Movie>. Nesse método, gere todo o HTML a partir da lista, usando as informações do objeto. pode-se usar métodos privados para delegar responsabilidades.|

### Dia 05

No quinto dia, o desafio foi encapsular a chamada da API dentro de uma nova classe.

Além disso, uma segunda tarefa: o código que faz o parseamento do JSON ainda estava “solto”, para melhorar o encapsulamento e separaramos todas as responsabilidades em suas devidas classes.

### Dia 06

O código evoluiu bastante e, olhando para o método main, já identificamos as 3 responsabilidades principais:

- chamar a API
- parsear o JSON
- gerar o HTML

No sexto dia, deveriamos deixar o código mais genérico, ou seja, preparado para receber dados de outras APIs. Para isso, entramram em cena as interfaces, que permitiram implementações diferentes.

Resumindo, criamos duas abstrações: uma para o seu modelo chamado de Content e outra para o JsonParser. Basta que futuras implementações sigam essas interfaces e o seu gerador de HTML continuará funcionando! Ou seja, desacoplou o parseamento do JSON da geração de HTML.

| Task | Descrição                                                                                                                                                                                                                 |
|:----:| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|   1  | - Voltando para a motivação inicial, a API da Marvel, crie uma interface chamada 'APIClient' com um método getBody().                                                                                                     |
|   2  | - Tente consumir a API da Marvel criando um cliente da API e JsonParser. Aqui também, você precisará de uma conta para gerar a API Key (chave pública e privada).                                                         |
|   3  | - Adicione um novo método na interface chamado type(). Esse método irá devolver o tipo do conteúdo em questão, por exemplo: Movie, Series, ComicBook, etc.                                                                |

Obs: Foi enviado para nós um link muito interessante sobre a disciplina de Orientação a Objeto que eu achei fantástico e irei compartilhar logo abaixo:

[Acessar POO: o que é programação orientada a objetos?](https://bit.ly/3tQ4UV9)

### Dia 07

Neste ultimo dia, "Brincamos" com algumas classes de ordenamentos e implementamos alguns metodos destas classes e simular alguns comportamentos.

| Task | Descrição                                                                                                                                                                                                                 |
|:----:| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|   1  | - Implemente a interface Comparable<? extends Content> na classe (ou record) Movie (e também na classe Series, se você a tiver criado).Para começar, você pode implementar o método usando a nota (rating) como parâmetro de comparação.                                                                                                                                                                                                                        |
|   2  | - O método sort() está sobrecarregado, então você pode passar um Comparator como segundo parâmetro para inverter a lista                                                                                                  |

## Agradecimentos

Quero agradecer a toda a equipe da Alura pelo desenvolvimento dessa problematica e fornecer para toda a comunidade de forma gratuita, essas atitudes que visão o bem de toda a comunidade fazem muita diferência.

Caso queiram me adicionar no linkedin e tirar alguma duvida sobre o projeto estou a disposição.

[Linkedin - Felipe Coelho](https://www.linkedin.com/in/felipe-coelho-a2b996b5/)

Muito obrigado, Felipe Coelho.