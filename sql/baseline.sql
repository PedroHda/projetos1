DROP DATABASE IF exists Clinica_Psico_Production;
Create DATABASE Clinica_Psico_Production;
use Clinica_Psico_Production;

Create Table Usuario(
	id_usuario INT AUTO_INCREMENT PRIMARY KEY,
	Nome Varchar(50) not null,
	Login Varchar(15) not null UNIQUE ,           
	senha Varchar(64) not null,                 
	CEP int(9) not null,
	Complemento varchar(30),
	tipo_de_usuario varchar(13) not null, -- Criar 'check constraint' que restrinja a apenas duas opções
	entrada varchar(5) not null,          -- tipo DATE
	saida varchar(5) not null             -- tipo DATE
);
	
Create Table Perguntas(
	id_pergunta int(2) auto_increment PRIMARY KEY,
	Pergunta_Anamnese Varchar(100)
);

Create Table Paciente(
	id_paciente INT(3) AUTO_INCREMENT PRIMARY KEY,
	Nome Varchar(50) not null,           
	CPF int(11) not null UNIQUE ,
	Nascimento int(10) NOT NULL,          -- tipo DATE
	Escolaridade Varchar(20) NOT NULL,    -- Criar 'check constraint' que restrinja a apenas algumas opções
	Estado_Civil Varchar(20) NOT NULL,    -- Criar 'check constraint' que restrinja a apenas duas opções
	Filhos INT(1) NOT NULL
);

Create Table Profissional_Paciente(
	id_profissional_paciente int(2) PRIMARY KEY,
	id_usuario INT(2),
	id_paciente int(3),
	FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario),
	FOREIGN KEY (id_paciente) REFERENCES Paciente(id_paciente)
);


Create Table Anamnese(
	id_profissional_paciente int(2) PRIMARY KEY,
	id_pergunta int(2),
	resposta Varchar(400) not null,
	FOREIGN KEY (id_pergunta) REFERENCES Perguntas(id_pergunta),
	FOREIGN KEY (id_profissional_paciente) REFERENCES Profissional_Paciente(id_profissional_paciente)
);
	

Create Table Agendamento(
	id_agendamento int(2) PRIMARY KEY,
	id_profissional_paciente int(2),
	FOREIGN KEY (id_profissional_paciente) REFERENCES Profissional_Paciente(id_profissional_paciente),
	Dia int(2),
	Hora int(6),
	Status int(1)
);
CREATE Table TimeLine(
	id_TimeLine int(4) AUTO_INCREMENT PRIMARY KEY,
	id_agendamento int(2),
	anotacoes VARCHAR(400),
	FOREIGN KEY (id_agendamento) REFERENCES Agendamento(id_agendamento)
);

insert into clinica_psico_production.usuario -- (nome,login,senha,cep,Complemento,tipo_de_usuario,entrada,saida)
	values
	(
		1,
		'ADMIN',
		'ADMIN',
		MD5('ADMIN'),
		123456789,
		'ADMIN',
		'Profissional',
		'07:00',
		'18:00'
	);
			
insert 
	into 
		perguntas(Pergunta_Anamnese) 
	value
		("O que traz você aqui?"),
		("Como ocorreu a busca pelo processo?"),
		("Como se sente em relação à queixa?"),
		("Foi encaminhado?"),
		("Reconhece a necessidade do tratamento?"),
		("Por que você reconhece a necessidade do tratamento? Caso nao reconheça, deixe em branco."),
		("Quais sao os sintomas?"),
		("Desde quando os sintomas aparecem?"),
		("O que Aconteceu nesse periodo?(Mudanças bruscas, Lutos, Novidades, Expectativas, etc)."),
		("Queixas Secundarias."),
		("Contem alguma doença cronica? Se sim, descreva."),
		("Uso de medicamentos? Se sim, Quais?"),
		("Contem casos de internação? Se sim, descreva."),
		("Eventos Marcantes (Gestação, perdas, entre outros.)"),
		("Caracteristicas na infância e adolescência (Timido, amistoso, agressivo, etc)"),
		("Meio Familiar (quem sao os principais membros, e como é seu relacionamento com eles)"),
		("Quais papeis o sujeito exerce em seu meio social?"),
		("Como se vê? E como pensa que o veem?"),
		("Como esta a situação no se meio de trabalho?"),
		("Sua relação com os colegas, chefes, e demais funcionarios"),
		("Satisfeito com o trabalho atual?");
