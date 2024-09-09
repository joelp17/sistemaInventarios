/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.5-10.4.32-MariaDB : Database - sistemainventarios
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sistemainventarios` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `sistemainventarios`;

/*Table structure for table `movimientosinventario` */

DROP TABLE IF EXISTS `movimientosinventario`;

CREATE TABLE `movimientosinventario` (
  `idmovimiento` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime DEFAULT NULL,
  `tipo_movimiento` int(11) DEFAULT NULL COMMENT '1.- Ingreso. 2.- Salida',
  `cantidad` int(11) DEFAULT NULL,
  `idubicacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`idmovimiento`),
  KEY `idubicacion` (`idubicacion`),
  CONSTRAINT `movimientosinventario_ibfk_2` FOREIGN KEY (`idubicacion`) REFERENCES `ubicaciones` (`idubicacion`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `movimientosinventario` */

/*Table structure for table `productos` */

DROP TABLE IF EXISTS `productos`;

CREATE TABLE `productos` (
  `idproducto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) NOT NULL,
  `codigo` varchar(20) NOT NULL,
  `descripcion` varchar(250) NOT NULL,
  `precio` decimal(11,2) NOT NULL,
  `cantidad_stock` int(11) NOT NULL,
  `idubicacion` int(11) NOT NULL,
  PRIMARY KEY (`idproducto`),
  KEY `idubicacion` (`idubicacion`),
  CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`idubicacion`) REFERENCES `ubicaciones` (`idubicacion`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `productos` */

/*Table structure for table `ubicaciones` */

DROP TABLE IF EXISTS `ubicaciones`;

CREATE TABLE `ubicaciones` (
  `idubicacion` int(11) NOT NULL AUTO_INCREMENT,
  `sector` varchar(100) DEFAULT NULL,
  `seccion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idubicacion`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `ubicaciones` */

insert  into `ubicaciones`(`idubicacion`,`sector`,`seccion`) values (1,'Electronica','Celulares'),(2,'Electronica','Computadoras'),(3,'Ropa','Estante 5'),(4,'Deportes','Zona central');

/*Table structure for table `usuarios` */

DROP TABLE IF EXISTS `usuarios`;

CREATE TABLE `usuarios` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `contrasenia` varchar(60) DEFAULT NULL,
  `estatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `usuarios` */

insert  into `usuarios`(`idusuario`,`nombre`,`contrasenia`,`estatus`) values (1,'joel','$2a$12$Fkt2Mppe1ynyxN1MTpyhc.U608NjX6V2v8sM.zClNGLdriPEKXeom',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
