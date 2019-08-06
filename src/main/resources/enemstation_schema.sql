DROP TABLE IF EXISTS usuario;
CREATE TABLE usuario
(
  id_usuario int(11) AUTO_INCREMENT, ativo bit(1) NOT NULL,
  email varchar(255) NOT NULL, foto longblob NULL, 
  nome varchar(255) NOT NULL, permissao int(11) NULL, 
  senha varchar(255) NOT NULL, PRIMARY KEY (id_usuario)
);

DROP TABLE IF EXISTS tb_disciplina;
CREATE TABLE tb_disciplina
(
  id int(11) NOT NULL AUTO_INCREMENT,
  descricao varchar(100) NULL, caminho_imagem varchar(100) NOT NULL,
 PRIMARY KEY (ID)
);

DROP TABLE IF EXISTS tb_dificuldade;
CREATE TABLE tb_dificuldade
(
  id int(11) NOT NULL AUTO_INCREMENT,
  descricao varchar(255) NOT NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS questoes_grafico;
CREATE TABLE questoes_grafico
(
  id int(11) NOT NULL AUTO_INCREMENT,
  acertos int(11) NOT NULL, erros int(11) NOT NULL, 
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS login_gmail;
CREATE TABLE login_gmail
(
  id int(11) AUTO_INCREMENT, email varchar(30) NULL,
  nome varchar(50) NULL, PRIMARY KEY(id)
);

DROP TABLE IF EXISTS tb_assunto;
CREATE TABLE tb_assunto
(
  id int(11) NOT NULL AUTO_INCREMENT,
  descricao varchar(100) NULL, id_disciplina int(11) NOT NULL, 
  id_questoes int(11) NULL, PRIMARY KEY (ID), 
  CONSTRAINT FK_DISCIPLINA FOREIGN KEY(id_disciplina) REFERENCES tb_disciplina(id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

DROP TABLE IF EXISTS tb_questoes;
CREATE TABLE tb_questoes
(
  id int(255) NOT NULL AUTO_INCREMENT,
  comentario varchar(5000) NULL, enunciado varchar(5000) NOT NULL, 
  imagem tinyblob NULL, texto varchar(10000) NULL, 
  id_dificuldade int(11) NOT NULL, grafico_id int(11) NULL, id_assunto int(11) NULL,
  PRIMARY KEY (id), CONSTRAINT FK_DIFICULDADE FOREIGN KEY(id_dificuldade) REFERENCES tb_dificuldade(id) ON DELETE NO ACTION ON UPDATE NO ACTION, 
  CONSTRAINT FK_QUESTOES_GRAFICO FOREIGN KEY(grafico_id) REFERENCES questoes_grafico(id) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT FK_ASSUNTO FOREIGN KEY(id_assunto) REFERENCES tb_assunto(id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

DROP TABLE IF EXISTS dados_usuario;
CREATE TABLE dados_usuario
(
  id_usuario int(11) AUTO_INCREMENT, cidade varchar(255) NULL,
  curso_pretendido varchar(255) NULL, data_nascimento date NULL,
  enem varchar(255) NULL, escolaridade varchar(255) NULL,
  estado varchar(255) NULL, instituicao varchar(255) NULL,
  provas varchar(255) NULL, sexo varchar(255) NULL,
  tipo_instituicao varchar(255) NULL, usuario_id_usuario int(11) NULL,
  PRIMARY KEY(id_usuario), CONSTRAINT FK_USUARIO FOREIGN KEY(usuario_id_usuario) 
  REFERENCES usuario(id_usuario) ON DELETE SET NULL ON UPDATE SET NULL
);

DROP TABLE IF EXISTS material;
CREATE TABLE material
(
  codigo int(11) AUTO_INCREMENT, caminho_arquivo varchar(255) NULL,
  link varchar(50), titulo varchar(20), id_disciplina int(11) NULL,
  PRIMARY KEY(codigo), CONSTRAINT FK_DISCIPLINA_MAT FOREIGN KEY(id_disciplina)
  REFERENCES tb_disciplina(id) ON DELETE SET NULL ON UPDATE SET NULL
);

DROP TABLE IF EXISTS senha_token;
CREATE TABLE senha_token
(
  id bigint(20) AUTO_INCREMENT, expirydate datetime NOT NULL,
  token varchar(255) NOT NULL, id_usuario int(11) NOT NULL, PRIMARY KEY(id),
  CONSTRAINT FK_USUARIO_SEN FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario)
  ON DELETE CASCADE ON UPDATE NO ACTION
);

DROP TABLE IF EXISTS tb_alternativas;
CREATE TABLE tb_alternativas
(
  id int(255) AUTO_INCREMENT, descricao varchar(255) NOT NULL,
  resposta int(11) NULL, id_questoes int(11) NULL, PRIMARY KEY(id),
  CONSTRAINT FK_QUESTOES_ALT FOREIGN KEY(id_questoes) REFERENCES tb_questoes(id)
  ON DELETE SET NULL ON UPDATE SET NULL
);
