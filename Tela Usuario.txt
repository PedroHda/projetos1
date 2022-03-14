Create DATABASE Clinica_Psico;
use Clinica_Psico;

Create Table Usuario(
	id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Nome Varchar(50) not null,
	Login Varchar(15) not null,
	senha Varchar(20) not null,
	CPF int(11) not null,
	CEP int(9) not null,
	Complemento varchar(30),
	tipo_de_usuario varchar(13) not null,
	entrada varchar(5) not null,
	saida varchar(5) not null);
	
