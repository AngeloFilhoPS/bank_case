<h1 align="center">
Bank Case
<br><br>
    <img alt="A programming stuff" height="480" src="https://t4.ftcdn.net/jpg/05/07/09/69/360_F_507096927_zHjcMUXsByxiHGb3n6yuYTXHFCh39bnP.jpg" > 
<br><br>
<hr>
</h1>

* [Overview 📄](#overview)
* [Instalação ⏬](#installation)
    - [Repositório 🗂️](#repository)
    - [Configuração ⚙️](#configure)
* [Endpoints 📜](#endpoints)
* [Banco de dados 🏦](#database)
* [Contato 📲](#contact)

<div id='overview'></div>

## Overview 📄

Serviço responsável pelo gerenciamento de contas e transações para o bank case para empresa internacional

**Algumas** das funcionalidades desse serviço são:

- Cadastro e obtenção de contas 
- Cadastro e listagem de transações

**Melhorias futuras**:


<div id='installation'></div>

## Instalação ⏬
**Antes de tudo, é necessário o seguinte pré-requisito**: Usar uma JDK com o projeto e suas features com Springboot, é recomendado versões mais novas do Java JDK como a 21 assim como Docker na máquina que for executar o projeto

Exemplo: JDK 21.0.4
<br>
Instalação do docker em sua máquina:

https://docs.docker.com/desktop/

<hr>
<div id='repository'></div>

### Repositório 🗂️

Para clonar o repositório usando a linha de comando, execute:

```bash
git clone https://github.com/AngeloFilhoPS/bank_case.git
```
<div id='configure'></div>

### Configuração ⚙️



## Endpoints 📜

# Account
### POST Account (curl)

``` 
curl --location 'localhost:8080/v1/accounts' \
--header 'Content-Type: application/json' \
--data '{
    "documentNumber":"023155295460"
}'
```
### GET Account (curl
```
curl --location 'localhost:8080/v1/accounts/1'
```
# 



<div id='regulation'></div>






## Contato 📲
Projeto criado para entrevista de emprego por <strong>Angelo Márcio</strong> e pertence ao mesmo<u><strong> o uso desse mesmo código para entrevistas posteriores pode acarretar em desclassificação</strong></u>.

---
