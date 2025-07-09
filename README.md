ProjetoViasoft

Desafio técnico back-end para a Viasoft — aplicação REST para simulação de envio de e-mails com adaptação de payload conforme configuração.

Sumário

    Descrição

    Tecnologias

    Como rodar o projeto

    Configuração

    Exemplo de requisição

    Validações

    Tratamento de erros

    Testes

    Diferenciais

Descrição

Este projeto simula o envio de e-mails por diferentes plataformas (AWS ou OCI), adaptando o objeto de entrada para o formato correto conforme configuração no application.properties. O objetivo é demonstrar arquitetura em camadas, uso de design patterns, validação, tratamento de erros e boas práticas REST.

Tecnologias

    Java 17

    Spring Boot 3.5.3

    Maven

    Lombok

    Bean Validation (Jakarta Validation)

    JUnit 5 & Mockito (testes)

Como rodar o projeto

    Clone o repositório:

bash
git clone https://github.com/seu-usuario/ProjetoViasoft.git
cd ProjetoViasoft

Compile e rode:

    bash
    mvn clean install
    mvn spring-boot:run

    Acesse o endpoint:

        URL: http://localhost:8080/api/email

        Método: POST

        Content-Type: application/json

Configuração

No arquivo src/main/resources/application.properties defina qual plataforma será simulada:

text
mail.integracao=AWS
# ou
mail.integracao=OCI

Exemplo de requisição
Payload de entrada (EmailRequestDTO):

json
{
  "destinatarioEmail": "destino@exemplo.com",
  "destinatarioNome": "Nome Destinatário",
  "remetenteEmail": "remetente@exemplo.com",
  "assunto": "Assunto do email",
  "conteudo": "Conteúdo do email"
}

Exemplo de objeto adaptado (impresso no console):
Para AWS:

json
{
  "recipient": "destino@exemplo.com",
  "recipientName": "Nome Destinatário",
  "sender": "remetente@exemplo.com",
  "subject": "Assunto do email",
  "content": "Conteúdo do email"
}

Para OCI:

json
{
  "recipientEmail": "destino@exemplo.com",
  "recipientName": "Nome Destinatário",
  "senderEmail": "remetente@exemplo.com",
  "subject": "Assunto do email",
  "body": "Conteúdo do email"
}

Validações

    Todos os campos são obrigatórios.

    E-mails devem ser válidos.

    Limites de tamanho são rigorosamente respeitados conforme o desafio.

    Validações automáticas via Bean Validation e manuais nos adapters.

Tratamento de erros

    Erros de validação retornam status 400 e um JSON com os campos inválidos e suas mensagens.

    Exemplo de resposta:

    json
    {
      "destinatarioEmail": "não deve estar em branco",
      "remetenteEmail": "deve ser um endereço de e-mail bem formado"
    }

    Erros de regras de negócio (ex: campo excedendo limite) também retornam status 400 com mensagem clara.

Testes

    Testes unitários cobrindo adapters e serviços, utilizando Mockito para mocks e verificação de chamadas.

    Para rodar os testes:

    bash
    mvn test

Diferenciais

    Código modular, limpo e desacoplado.

    Uso de padrões de projeto (Factory, Adapter).

    Tratamento global de exceções.

    Pronto para futura integração real com serviços de e-mail.

    Fácil de evoluir e manter.

Desenvolvido por Matheus Menses para o desafio técnico Viasoft.
