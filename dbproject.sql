-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 24, 2020 at 02:47 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `datamasuk`
--

CREATE TABLE `datamasuk` (
  `kodeBarang` varchar(30) NOT NULL,
  `namaBarang` varchar(60) NOT NULL,
  `harga` int(11) NOT NULL,
  `jumlahBeli` int(11) NOT NULL,
  `totalHarga` int(11) NOT NULL,
  `tanggal` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `datamasuk`
--

INSERT INTO `datamasuk` (`kodeBarang`, `namaBarang`, `harga`, `jumlahBeli`, `totalHarga`, `tanggal`) VALUES
('CPU_3', 'LG 24MK600M-B', 2000000, 1, 2000000, '2020-12-22'),
('CPU_3', 'LG 24MK600M-B', 2000000, 2, 4000000, '2020-12-22'),
('MON_6', 'Logitech-G312', 300000, 2, 600000, '2020-12-22'),
('CPU_3', 'LG 24MK600M-B', 2000000, 2, 4000000, '2020-12-22'),
('CPU_5', 'ASUS-VX238H', 2000000, 2, 4000000, '2020-12-22'),
('CPU_6', 'Lenovo Legion', 25000000, 12, 300000000, '2020-12-22'),
('KEY_5', 'Logitech-K380', 200000, 2, 400000, '2020-12-22'),
('CPU_2', 'ASUSROG-GL10CS', 12000000, 1, 12000000, '2020-12-22'),
('KEY_4', 'Logitech-G312', 300000, 1, 300000, '2020-12-22'),
('CPU_1', 'Digital-AllianceT', 8000000, 1, 8000000, '2020-12-22'),
('KEY_2', 'Genius-KB-210', 500000, 1, 500000, '2020-12-23'),
('CPU_2', 'ASUSROG-GL10CS', 12000000, 1, 12000000, '2020-12-24'),
('KEY_3', 'Logitech-G213', 300000, 2, 600000, '2020-12-24'),
('MON_5', 'Dell-UltraSharp', 2000000, 1, 2000000, '2020-12-24');

-- --------------------------------------------------------

--
-- Table structure for table `stok`
--

CREATE TABLE `stok` (
  `kodeBarang` varchar(30) NOT NULL,
  `nama` varchar(60) NOT NULL,
  `harga` int(11) NOT NULL,
  `jumlahStok` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stok`
--

INSERT INTO `stok` (`kodeBarang`, `nama`, `harga`, `jumlahStok`) VALUES
('CPU_1', 'Digital-AllianceT', 8000000, 20),
('CPU_2', 'ASUSROG-GL10CS', 12000000, 20),
('CPU_3', 'Dell GamingInspiron', 12000000, 20),
('CPU_4', 'MSI Nightblade', 14000000, 20),
('CPU_5', 'HP Omen Obelisk', 24000000, 20),
('CPU_6', 'Lenovo Legion', 25000000, 20),
('MON_1', 'LG 24MK600M-B', 2000000, 20),
('MON_2', 'AOC-24G2E5', 2000000, 20),
('MON_3', 'ASUS-VX238H', 2000000, 20),
('MON_4', 'Lenovo-G2510', 2000000, 20),
('MON_5', 'Dell-UltraSharp', 2000000, 19),
('MON_6', 'LG-27GL650F-B', 2000000, 20),
('KEY_1', 'Fantech-K3M', 400000, 20),
('KEY_2', 'Genius-KB-210', 500000, 19),
('KEY_3', 'Logitech-G213', 300000, 18),
('KEY_4', 'Logitech-G312', 300000, 20),
('KEY_5', 'Logitech-K380', 200000, 20),
('KEY_6', 'RazerCynosa-V2', 400000, 20);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
