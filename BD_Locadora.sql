CREATE TABLE Cliente(
Id_Cliente SERIAL PRIMARY KEY,
name TEXT,
idade INT,
telefone TEXT,
endereco TEXT
);

INSERT INTO Cliente(name, idade, telefone, endereco) VALUES ('Bruno William', 20, 84988248208, 'Rua Candido Martins, 1130')

CREATE TABLE Aluguel(
Data_aluguel TEXT,
Data_entrega TEXT,
valor_aluguel INT,
FK_Cliente FOREIGN, 
FK_DVD FOREIGN
)

CREATE TABLE Filme(
Id_Filme SERIAL PRIMARY KEY,
categoria TEXT,
título TEXT
)

CREATE TABLE Dono(
Id_Dono INT PRIMARY KEY, 
senha TEXT NOT NULL,
nome TEXT
)

SELECT data_aluguel, data_entrega, valor_aluguel, fk_filme FROM cliente,aluguel WHERE id = fk_cliente AND id = 17

ALTER TABLE aluguel ADD id_aluguel SERIAL PRIMARY KEY 

ALTER TABLE aluguel ADD fk_filme INT

ALTER TABLE aluguel ADD FOREIGN KEY (fk_filme) REFERENCES filme(id_filme)

ALTER TABLE aluguel ADD fk_cliente INT

ALTER TABLE aluguel ADD FOREIGN KEY (fk_cliente) REFERENCES cliente(id)

SELECT * FROM clientes

SELECT * FROM aluguel

SELECT * FROM filme

SELECT * FROM cliente
