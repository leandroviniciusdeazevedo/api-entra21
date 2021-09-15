INSERT INTO USUARIO(nome, email, senha) VALUES('Programador', 'dev@king.com', '222222');

INSERT INTO CURSO(nome, categoria) VALUES('Java Web', 'Back-end');
INSERT INTO CURSO(nome, categoria) VALUES('HTML/CSS', 'Front-end');

INSERT INTO TOPICO(titulo, mensagem, status, autor_id, curso_id) VALUES('Como fazer API', 'Estou aprendendo API e preciso de ajuda', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, status, autor_id, curso_id) VALUES('Ajuda para estilizar', 'Procuro quem tenha habilidade em CSS', 'NAO_RESPONDIDO', 1, 2);