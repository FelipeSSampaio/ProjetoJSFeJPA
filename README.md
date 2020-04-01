# ProjetoJSFeJPA
Projeto básico que utiliza Maven, JSF, JPA e BootStrap.

----------------------
PASSOS NECESSÁRIOS
----------------------
1 - MAVEN

Após clonar o projeto será preciso realizar um Maven Install para realizar o download das Libs.

2 - Banco de Dados

Também será preciso instalar o Postgres, caso queira manter o mesmo banco de dados que estou usando para persistir os dados.
Para download do Postgres: https://www.enterprisedb.com/downloads/postgres-postgresql-downloads

Caso não queira utilizar o Postgres, basta alterar as seguintes propriedades no persistence.xml:

"javax.persistence.jdbc.driver" e "hibernate.dialect"

Além de lembrar de colocar o 'user' e 'password' de acordo com o utilizado no banco.

Outro ponto importante é que terá que alterar o pom.xml para poder alterar a dependência do banco Postgres para o banco de sua escolha.

Não se esqueça de criar banco de dados com o nome 'Investimentos' ou altere "javax.persistence.jdbc.url" para adicionar o nome que deseja.

A construção do banco está definida em 'hibernate.hbm2ddl.auto' com update, ou seja, serão adicionadas estruturas no banco, mas não serão excluídas as já existentes.

3 - Página inicial da aplicação

http://localhost:8080/Investimentos/cadastraAtivo.xhtml

----------------------
POSSÍVEIS PROBLEMAS
----------------------
Pode ser que seu eclipse fique reclamando da JPA (é um bug do eclipse) e para resolver isso basta:

1 - Ir no Build Path -> Project Faces, desmarcar o checkbox da JPA e aplicar a mudança.

2 - O erro vai desaparecer. Com isso, volte em Build Path -> Project Faces e remarque o checkbox JPA.

----------------------
OUTRAS INFORMAÇÕES
----------------------
Deixei no código uma representação de persistência através de JDBC para que fique evidente a diferença entre as soluções.

