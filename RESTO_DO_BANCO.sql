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