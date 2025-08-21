
# 🛠️ Como rodar o projeto

## 📥 Clonar o repositório
```sh
git clone https://github.com/Bufonn/CrudJDBC.git
```

---

## ▶️ Executar o programa

1. Abra o repositório no **VSCode**
2. Pressione `Ctrl + "` para abrir o terminal integrado
3. Acesse a pasta `src`:

   ```sh
   cd src
   ```
4. Compile os arquivos Java:

   ```sh
   javac -cp "../lib/*" *.java
   ```
5. Execute o programa:

   ```sh
   java -cp "../lib/*;." Main
   ```

---

## 🗄️ Banco de Dados (MySQL)

Para o projeto funcionar, é necessário criar um banco de dados com o **MySQL**.

### 🔽 Instalação do MySQL

Caso o MySQL não esteja instalado, faça o download:
👉 [MySQL Installer](https://downloads.mysql.com/archives/installer/)

* Na opção **Product Version**, escolha `8.0.42`
* Clique na **segunda opção de Download**
* Execute o instalador e siga este tutorial para configurar o MySQL:
  👉 [Tutorial de instalação do MySQL (YouTube)](https://www.youtube.com/watch?v=IEUgVwjXF0o)

### ⚙️ Configuração no Workbench

1. Abra o **MySQL Workbench** (se não abrir automaticamente, procure por `MySQL` no menu iniciar do Windows).

2. Clique no retângulo central para abrir a conexão (será pedida a senha definida na instalação).

3. Na aba **Query 1**, insira o seguinte código SQL:

   ```sql
   CREATE DATABASE loja;

   USE loja;

   CREATE TABLE produtos (
       id INT AUTO_INCREMENT PRIMARY KEY,
       nome VARCHAR(100),
       preco DECIMAL(10,2)
   );

   CREATE TABLE categorias (
       id INT AUTO_INCREMENT PRIMARY KEY,
       nome VARCHAR(100),
       ativo BOOLEAN
   );
   ```

4. Clique no **raiozinho** (⚡) sem nada no meio, logo abaixo de *Query 1*, para executar o script.

---

✅ Pronto! O projeto está configurado e pronto para rodar 🚀

