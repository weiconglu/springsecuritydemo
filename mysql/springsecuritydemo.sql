DROP DATABASE IF EXISTS springsecuritydemo;
CREATE DATABASE springsecuritydemo /*!40100 DEFAULT CHARACTER SET UTF8MB4 */;
USE springsecuritydemo;

CREATE TABLE IF NOT EXISTS tb_t_book (
    id INT(11) PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50),
    author VARCHAR(50),
    description VARCHAR(50),
    isbn VARCHAR(50)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COMMENT='book';

insert into tb_t_book(title,author,description,isbn) values('西游记','吴承恩','中国古代第一部浪漫主义章回体长篇神魔小说','ISBN0001');
insert into tb_t_book(title,author,description,isbn) values('三国演义','罗贯中','中国文学史上第一部章回小说，是历史演义小说的开山之作','ISBN0002');
insert into tb_t_book(title,author,description,isbn) values('红楼梦','曹雪芹','章回体长篇小说','ISBN0003');
insert into tb_t_book(title,author,description,isbn) values('水浒传','施耐庵','一部以描写古代农民起义为题材的长篇小说','ISBN0004');

CREATE TABLE IF NOT EXISTS tb_t_user (
    id INT(11) PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR(50),
    authority VARCHAR(50)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COMMENT='user';

insert into tb_t_user(username,password,authority) values('root','root','root');
insert into tb_t_user(username,password,authority) values('guest','guest','guest');