CREATE TABLE pessoa (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
    ativo BOOL,
    logradouro VARCHAR(150),
	numero VARCHAR(6),
    complemento VARCHAR(150),
    bairro VARCHAR(50),
    cep VARCHAR(13),
    cidade VARCHAR(50),
    estado VARCHAR(4)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa(nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
VALUES ('Luan', true, "Rua 7", "129", "Lot. Jardim messejana", "coaçu", "60840780", "Fortaleza", "CE");

INSERT INTO pessoa(nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
VALUES ('Natanael', true, "Rua 7", "129", "Lot. Jardim messejana", "coaçu", "60840780", "Fortaleza", "CE");

INSERT INTO pessoa(nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
VALUES ('Jessica', true, "Rua 7", "129", "Lot. Jardim messejana", "coaçu", "60840780", "Fortaleza", "CE");

INSERT INTO pessoa(nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
VALUES ('Kilvia', true, "Rua 7", "129", "Lot. Jardim messejana", "coaçu", "60840780", "Fortaleza", "CE");

INSERT INTO pessoa(nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
VALUES ('Jardel', true, "Rua 8", "28", "", "coaçu", "60840780", "Fortaleza", "CE");