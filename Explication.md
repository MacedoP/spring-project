# @Entity =>
A anotação @Entity é usada para indicar que uma classe Java é uma 
entidade JPA e deve ser mapeada para uma tabela em um banco de dados.

# @Table => 


## Passos para fazer conexao com um banco de dados que neste caso foi PostGresql
* spring.datasource.url= jdbc:postgresql://localhost:5432/products-api
* spring.datasource.username=postgres
* spring.datasource.password=banco123
* spring.jpa.hibernate.ddl-auto=update //esta linha vai gerar as colunas no nosso banco de dados automaticamente sem precisarmos criar elas


* spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
* junit => é um ambiente de execucao que permite testar os nosso teste unitarios
* Mockito => é uma bibliotecas que nos oferece varias ferramentas 