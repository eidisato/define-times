
# defineTimes

Aplicação Java Spring Boot para cadastro e sorteio de jogadores em times equilibrados, baseado na nota de cada jogador.

---

## Funcionalidades

- Cadastro de jogadores com nome e nota (1 a 5)
- Listagem de jogadores cadastrados
- Sorteio automático de 3 times balanceados (6 jogadores cada) conforme as notas
- Armazenamento dos jogadores na memória (em memória no momento)
- API REST para gerenciar jogadores e times

---

## Endpoints Principais

- `POST /api/jogadores` - Adicionar jogador individualmente  
  Exemplo de JSON:  
  ```json
  {
    "nome": "João",
    "nota": 4
  }
  ```

- `POST /api/jogadores/batch` - Adicionar vários jogadores de uma vez  
  Exemplo de JSON:  
  ```json
  [
    {"nome": "João", "nota": 4},
    {"nome": "Maria", "nota": 3}
  ]
  ```

- `GET /api/jogadores` - Listar todos os jogadores

- `GET /api/jogadores/times` - Sortear 3 times balanceados com os jogadores cadastrados

---

## Como Executar

1. Certifique-se que tenha Java 17+ instalado  
2. Clone o projeto:  
   ```bash
   git clone https://github.com/seu-usuario/defineTimes.git
   ```  
3. Entre na pasta do projeto:  
   ```bash
   cd defineTimes/defineTimes
   ```  
4. Execute a aplicação com Maven:  
   ```bash
   ./mvnw spring-boot:run
   ```  
   ou  
   ```bash
   mvn spring-boot:run
   ```  
5. Acesse a API via: `http://localhost:8080/api/jogadores`

---

## Tecnologias Utilizadas

- Java 17+
- Spring Boot 3
- Maven
- REST API

---

## Melhorias Futuras

- Persistência dos dados em banco (MySQL, PostgreSQL, etc) DONE
- Autenticação e autorização DONE
- Frontend para interface amigável
- Validações avançadas 50%
- Testes automatizados

---

## Contato

- Desenvolvedor: Vinicius Sato  
- GitHub: https://github.com/eidisato
- Email: viniciuseidisato@gmail.com

---
