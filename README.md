# Projeto módulo 3 Spring Boot

## Spring Framework
Conjunto de bibliotecas escritas em Java para simplificar o desenvolvimento de aplicações WEB

## Spring Boot
Ferramenta para acelerar o início de um projeto utilizando o Spring Framework
- Documentação: https://spring.io/projects/spring-boot
- Start: https://start.spring.io/
Site que cria a estrutura de um projeto utilizando o Spring Boot

## Configuração do ambiente
- Java Development Kit (JDK)
- Maven (Gerenciador de pacotes e ferramentas de build)
- VSCode
        - Extension Pack for Java (Microsoft)
        - Extension Pack for Spring Boot (Pivotal)
- Banco de dados (MariaDB)

## Passo a passo para criar um novo projeto Springboot no VSCode
- Criar uma pasta no disco do computador
- Abrir a pasta no VSCode usando a opção *File → Open Folder*
- *Ctrl + Shift + P*
- Digitar *Spring*
- Selecionar *Spring Initializr: Create a Maven Project*
- Qual a versão do Spring Framework? A última estável
- Qual a linguagem? Java
- Qual o pacote base do projeto? Domínio da empresa invertido (br.univille)
- Qual o nome do projeto? (não usar espaço ou caracter especial)
- Qual a forma de empacotamento? JAR (normalmente)
- Qual a versão do JDK? 11 (depende da versão instalada no computador)
- Quais são as dependências do projeto?
    - Spring Web (clicar para selecionar)
    - Spring Boot DevTool (clicar para selecionar)
    - Thymeleaf (clicar para selecionar)
- Clicar em *Selected n dependencies*
- Selecionar a pasta onde o projeto será criado (usar a mesma que foi utilizada no passo 1)
- Retorno que o projeto foi criado com sucesso, clicar em OPEN

## Adicionando uma nova dependência no projeto
- Opção 1
    - *Ctrl + Shift + P*
    - Procurar *Spring Inicializr: Add Starters*
    - Digitar o nome da dependência (ex: Thymeleaf)
    - Clicar sobre o nome da dependência desejada
    - *Selected n dependencies*
    - Clicar em *Proceed* no pop-up para continuar
    - Salvar o arquivo POM

**Obs:** Se aparecer "*A build file was modified. Do you want to shynchronize the java classpath?*", selecionar "*Always*"
- Opção 2
    - Acessar o site https://mvnrepository.com/
    - Procurar pela dependência desejada (ex: Bootstrap ou JQuery)
    - Selecionar a opção mais usada
    - Selecionar a versão desejada (normalmente a mais recente)
    - Copiar o XML, sugerido pelo site, necessário para incluir a dependência
    - Voltar no projeto e abrir o arquivo *pom.xml*
    - Procurar a tag *< dependencies >*
    - Dentro do corpo da tag, colar o XML copiado do site
    - Salvar o arquivo

## Configuração paraa conexão no banco de dados relacional
- Adicionar dependências (Spring Data JPA, H2, MariaDB Driver JDBC)

## Estrutura do projeto
- Pacote src: todo o código da aplicação (Java, HTML, CSS, JS)
- Pacote target: código compilado e gerado pelo Maven
- Arquivo *pom.xml*: arquivo descritor utilzado pelo Maven para download das dependências e build de aplicação
- < nomedoprojeto >Application.java - main da aplicação Java
- Pacote controller: classes que são responsáveis por tratar as requisições HTTP enviadas para as rotas definidas por anotação

## Executar a aplicação
- Encontrar o *Spring Boot Dashboard*
- Clicar no ícone ▷ do lado de nome do projeto