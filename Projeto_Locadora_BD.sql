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
senha TEXT PRIMARY KEY
)
