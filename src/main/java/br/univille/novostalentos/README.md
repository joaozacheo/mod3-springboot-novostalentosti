# Criando uma nova página

- Criar Entity
    - variáveis
    - gerar getters e setters
    - colocar @'s onde for preciso

</br>

- Criar Controller
    - public class *entity*Controller(){}
    - colocar @Controller
    - criar @Autowired do service
    - criar index
    ```Java
    @GetMapping
    public ModelAndView index(){
        //var lista*Entity* = service.getAll() é adicionado depois
        return new ModelAndView("*entity*/index", "lista*Entity*", lista*Entity*);
    }
    ```

</br>

- Criar Repository
    - public interface *Entity*Repository extends JpaRepository(){}
    - colocar @Repository

</br>

- Criar Service
    - public interface *Entity*Service(){}
    - ir adicionando as funcoes de acordo com a necessidade

</br>

- Criar ServiceImpl
    - public class *Entity*ServiceImpl implements *Entity*Service(){}
    - colocar @Service
    - criar @Autowired do repositorio
    - ir criando os @Override's de acordo com a necessidade

</br>

- Criar index.html (templates/*entity*)
    - iniciar com:
    ```HTML
    <!DOCTYPE html>
    <html xmlns:th="http://www.thymeleaf.org" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">

        <head th:include="layout :: head"></head>

        <body>
            <nav th:replace="layout :: menu"></nav>
            <main class="container">

            </main>
            <footer th:include="layout :: footer"></footer>
        </body>
    </html>
    ```

</br>

- Criar form.html (templates/*entity*)
    - iniciar com:
    ```HTML
    <!DOCTYPE html>
    <html xmlns:th="http://www.thymeleaf.org" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">

        <head th:include="layout :: head"></head>

        <body>
            <nav th:replace="layout :: menu"></nav>
            <main class="container">
                   
            </main>
            <footer th:include="layout :: footer"></footer>
        </body>
    </html>
    ```