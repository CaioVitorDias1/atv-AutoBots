# atv-AutoBots
Repositório para conclusão da atividade da matéria de Desenvolvimento Web


## ATV1

### Resumo

Como uma fornecedora de sistema para gestão de lojas de manutenção veicular e autopeças, o objetivo é criar uma aplicação flexível e facilmente integrada a outros sistemas utilizando uma arquitetura de microserviços.

### Regras de negócio

* Elaborar as operações de inserção, atualização, seleção e deleção das entidades.
* Melhorar código já existente.

## ATV2

### Resumo

Depois de elaborado todo as operções de CRUD das entidades faltentes, e melhorado a estrutura do código, o objetivo agora é fazer com que a aplicação contemple todos os 4 níveis de maturidade que uma aplicação precisa ter.

### Regras de negócio 

* Implementar na aplicação: Protocolo http, uri única por recurso, Uso dos métodos e suas semânticas e Hateoas.

## ATV3

### Resumo

Depois de contemplado os níveis de maturidade, o objetivo agora é adicionar novas funcionalidades à aplicação, como o registro de usuários, serviços, veiculos e peças de forma que também contemplem os níveis de maturidade.

### Regras de negócio

* Cadastro de empresas
* Cadastro de veículos
* Associação de usuário à uma empresa
* Definição dos tipos de usuários
* Credenciais de acesso para os usuários

## ATV4

### Resumo

Com as funcionalidades em pronto, o que falta agora para a "equipe" é atualizar o processo de autenticação para usar o JWT, e definir 
as devidas autorizações para os tipos certos de usuários em cada rota.

### Regras de negócio

* Aplicação do controle de acesso 
* Atualização para autenticação JWT

## ATV5

### Resumo

Para finalizar, a próxima etapa é a criação de uma API separada que fará comunicação com o sistema automanager. Essa API
possuirá novas funcionalidades que se relacionarão com o sistema.

### Regras de negócio

* Listagem de todos os clientes e funcionários
* Listagem de mercadorias e serviços disponéveis 
* Listagem de todos os serviços e peças por empresa
* Listagemd dos veículos atendidos por empresa
