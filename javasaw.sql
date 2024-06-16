-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.30 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for javasaw
CREATE DATABASE IF NOT EXISTS `javasaw` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `javasaw`;

-- Dumping structure for table javasaw.alternatif
CREATE TABLE IF NOT EXISTS `alternatif` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nama_alternatif` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table javasaw.alternatif: ~5 rows (approximately)
INSERT IGNORE INTO `alternatif` (`id`, `nama_alternatif`) VALUES
	(35, 'Rizky Samur'),
	(36, 'Retno Melani'),
	(37, 'Ayu Saraswati'),
	(38, 'Pahlevi'),
	(39, 'Vendi Sando');

-- Dumping structure for table javasaw.bobot
CREATE TABLE IF NOT EXISTS `bobot` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_kriteria` int DEFAULT NULL,
  `nilai_bobot` decimal(5,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_kriteria` (`id_kriteria`),
  CONSTRAINT `bobot_ibfk_1` FOREIGN KEY (`id_kriteria`) REFERENCES `kriteria` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table javasaw.bobot: ~0 rows (approximately)

-- Dumping structure for table javasaw.kriteria
CREATE TABLE IF NOT EXISTS `kriteria` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nama_kriteria` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `tipe_kriteria` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `bobot_kriteria` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table javasaw.kriteria: ~4 rows (approximately)
INSERT IGNORE INTO `kriteria` (`id`, `nama_kriteria`, `tipe_kriteria`, `bobot_kriteria`) VALUES
	(25, 'Pengalaman', 'Benefit', 30),
	(26, 'Pendidikan', 'Benefit', 20),
	(27, 'Usia', 'Benefit', 20),
	(28, 'Status', 'Cost', 15),
	(29, 'Alamat', 'Cost', 15);

-- Dumping structure for table javasaw.normalisasi
CREATE TABLE IF NOT EXISTS `normalisasi` (
  `id` int NOT NULL AUTO_INCREMENT,
  `alternatif_id` int NOT NULL,
  `kriteria_id` int NOT NULL,
  `nilai_normalisasi` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `alternatif_id` (`alternatif_id`),
  KEY `kriteria_id` (`kriteria_id`),
  CONSTRAINT `normalisasi_ibfk_1` FOREIGN KEY (`alternatif_id`) REFERENCES `alternatif` (`id`),
  CONSTRAINT `normalisasi_ibfk_2` FOREIGN KEY (`kriteria_id`) REFERENCES `kriteria` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table javasaw.normalisasi: ~0 rows (approximately)
INSERT IGNORE INTO `normalisasi` (`id`, `alternatif_id`, `kriteria_id`, `nilai_normalisasi`) VALUES
	(176, 35, 25, 0.9),
	(177, 35, 26, 0.9),
	(178, 35, 27, 0.9),
	(179, 35, 28, 0.4444444444444444),
	(180, 35, 29, 0.2222222222222222),
	(181, 36, 25, 0.85),
	(182, 36, 26, 0.95),
	(183, 36, 27, 1),
	(184, 36, 28, 0.4),
	(185, 36, 29, 0.5),
	(186, 37, 25, 0.9),
	(187, 37, 26, 0.2),
	(188, 37, 27, 0.7),
	(189, 37, 28, 0.45977011494252873),
	(190, 37, 29, 0.36363636363636365),
	(191, 38, 25, 0.99),
	(192, 38, 26, 1),
	(193, 38, 27, 0.5),
	(194, 38, 28, 0.6666666666666666),
	(195, 38, 29, 0.20202020202020202),
	(196, 39, 25, 1),
	(197, 39, 26, 1),
	(198, 39, 27, 1),
	(199, 39, 28, 1),
	(200, 39, 29, 1);

-- Dumping structure for table javasaw.ranking
CREATE TABLE IF NOT EXISTS `ranking` (
  `id` int NOT NULL AUTO_INCREMENT,
  `alternatif_id` int NOT NULL,
  `skor_akhir` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `alternatif_id` (`alternatif_id`),
  CONSTRAINT `ranking_ibfk_1` FOREIGN KEY (`alternatif_id`) REFERENCES `alternatif` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table javasaw.ranking: ~0 rows (approximately)
INSERT IGNORE INTO `ranking` (`id`, `alternatif_id`, `skor_akhir`) VALUES
	(41, 35, 0.7300000000000001),
	(42, 36, 0.78),
	(43, 37, 0.573510971786834),
	(44, 38, 0.7273030303030302),
	(45, 39, 1);

-- Dumping structure for table javasaw.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table javasaw.users: ~0 rows (approximately)
INSERT IGNORE INTO `users` (`id`, `username`, `password`, `created_at`, `updated_at`) VALUES
	(1, 'afghan', 'afghan', '2024-05-11 08:29:21', '2024-05-11 08:29:21');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
