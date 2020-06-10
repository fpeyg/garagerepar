*** Projet Garage réparations véhicules ***
=
MySQL création de la database 'garagerep'
-
mysql> CREATE DATABASE garagerep;  
mysql> CREATE USER 'fred'@'localhost' IDENTIFIED BY 'lolwhat'; <br/> 
mysql> GRANT ALL PRIVILEGES ON garagerep.* TO 'fred'@'localhost'; <br/> 

Création application.properties avant le premier lancement 
-
spring.datasource.url=jdbc:mysql://localhost:3306/garagerep?useSSL=false&serverTimezone=UTC <br/>
spring.datasource.username=fred <br/>
spring.datasource.password=lolwhat <br/>
spring.jpa.hibernate.ddl-auto=create <br/>
spring.datasource.initialization-mode=always <br/>

au démarrage, pour laisser hibernate créer les tables <br/>

Erreur au démarrage , spécifique à Swing
-
<em>Exception in thread "AWT-EventQueue-0" java.awt.HeadlessException </em> <br/>

Modifier les paramètres dans > Run > Edit Configurations...  <br/>
VM options : -Djava.awt.headless=false <br/> 

Modification application.properties après le premier lancement
-
spring.datasource.url=jdbc:mysql://localhost:3306/garagerep?useSSL=false&serverTimezone=UTC <br/>
spring.datasource.username=fred <br/>
spring.datasource.password=lolwhat <br/>
spring.jpa.hibernate.ddl-auto=update <br/>
spring.datasource.initialization-mode=always <br/>

modification du 'create' en 'update' pour insérer des enregistrements dans les tables <br/> 