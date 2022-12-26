CREATE TABLE Cliente(
Id_Cliente SERIAL PRIMARY KEY,
name TEXT,
idade INT,
telefone TEXT,
endereco TEXT
);

INSERT INTO Cliente(name, idade, telefone, endereco) VALUES ('Bruno William', 20, 84988248208, 'Rua Candido Martins, 1130')

SELECT * FROM Cliente

CREATE TABLE Aluguel(
Data_aluguel TEXT,
Data_entrega TEXT,
valor_aluguel INT,
FK_Cliente FOREIGN, 
FK_DVD FOREIGN
)

CREATE TABLE DVD(
Id_DVD SERIAL PRIMARY KEY,
FK_Filme FOREIGN,
Qnt_DVD TEXT	
)

CREATE TABLE Filme(
Id_Filme SERIAL PRIMARY KEY,
categoria TEXT,
título TEXT
)

CREATE TABLE Dono(
Id_Dono INT PRIMARY KEY, 
senha TEXT PRIMARY KEY, 
FK_Cliente FOREIGN, 
)


