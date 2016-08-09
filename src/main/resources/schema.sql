DROP DATABASE IF EXISTS solrexample;
CREATE DATABASE solrexample;
USE solrexample;

CREATE TABLE IF NOT EXISTS product (
  id INT AUTO_INCREMENT NOT NULL,
  name VARCHAR(40) NOT NULL,
  code VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS detail (
  id INT AUTO_INCREMENT NOT NULL,
  product_id int NOT NULL,
  snippet text NOT NULL,
  text text NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`product_id`) REFERENCES `product`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO product VALUES (1, 'book1', '0001');
INSERT INTO product VALUES (2, 'book2', '0002');

INSERT INTO detail VALUES (1, 1, 'snippet for book1', 'text for book2');
INSERT INTO detail VALUES (2, 2, 'snippet for book2', 'text for book2');