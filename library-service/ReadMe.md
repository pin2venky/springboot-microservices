####Setup Mysql database and user
create database bookdb;
CREATE USER  'bookUser'@'localhost'
IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON bookdb.* TO 'bookUser'@'localhost';
FLUSH PRIVILEGES;

#####
https://medium.com/backend-habit/intellij-idea-running-multiple-project-microservices-in-one-workspace-d61126fe0eef
