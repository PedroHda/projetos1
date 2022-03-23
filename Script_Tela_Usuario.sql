Create DATABASE Clinica_Psico;
use Clinica_Psico;

Create Table Usuario(
	id INT(2) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Nome Varchar(50) not null,
	Login Varchar(15) not null UNIQUE ,           
	senha Varchar(20) not null,           
	CPF int(11) not null UNIQUE ,                 
	CEP int(9) not null,
	Complemento varchar(30),
	tipo_de_usuario varchar(13) not null, -- Criar 'check constraint' que restrinja a apenas duas opções
	entrada varchar(5) not null,          -- tipo DATE
	saida varchar(5) not null);           -- tipo DATE
	
	

Create Table Perguntas(
	id_pergunta int(2),
	PRIMARY KEY (id_pergunta),
	Pergunta_Anamnese Varchar(100)
);

Create Table Paciente(
	id_paciente INT(3) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Nome Varchar(50) not null,
	Idade INT(3) NOT NULL,
	Nascimento int(10) NOT NULL,          -- tipo DATE
	Escolaridade Varchar(20) NOT NULL,    -- Criar 'check constraint' que restrinja a apenas algumas opções
	Estado_Civil Varchar(20) NOT NULL,    -- Criar 'check constraint' que restrinja a apenas duas opções
	Filhos INT(1) NOT NULL
);

Create Table Anamnese(
	id_pergunta int(2),
	id_paciente int(3) UNSIGNED,
	resposta Varchar(400) not null,
	FOREIGN KEY (id_pergunta) REFERENCES Perguntas(id_pergunta),
	FOREIGN KEY (id_paciente) REFERENCES Paciente(id_paciente),
	Primary KEY (id_pergunta,id_paciente)
);
	
