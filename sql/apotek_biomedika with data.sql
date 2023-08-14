-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 14, 2023 at 04:02 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `apotek_biomedika`
--
CREATE DATABASE IF NOT EXISTS `apotek_biomedika` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `apotek_biomedika`;

-- --------------------------------------------------------

--
-- Table structure for table `data_barang`
--

CREATE TABLE `data_barang` (
  `id` int(10) UNSIGNED NOT NULL,
  `nama_barang` varchar(255) NOT NULL,
  `batch` varchar(50) NOT NULL,
  `tanggal_kedaluwarsa` date NOT NULL,
  `harga_satuan` int(11) UNSIGNED NOT NULL,
  `harga_jual` int(11) UNSIGNED NOT NULL,
  `qty` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `data_barang`
--

INSERT INTO `data_barang` (`id`, `nama_barang`, `batch`, `tanggal_kedaluwarsa`, `harga_satuan`, `harga_jual`, `qty`) VALUES
(1, 'Paracetamol 500mg', 'BATCH123', '2024-08-31', 3000, 5000, 100),
(2, 'Ibuprofen 400mg', 'BATCH456', '2023-12-15', 5000, 8000, 50),
(3, 'Amoxicillin 250mg', 'BATCH789', '2024-05-20', 2000, 3500, 30),
(4, 'Cetirizine 10mg', 'BATCH101', '2023-11-30', 1500, 3000, 20),
(5, 'Aspirin 100mg', 'BATCH202', '2024-06-25', 2500, 4000, 11),
(6, 'Lansoprazole 30mg', 'BATCH303', '2024-09-30', 10000, 15000, 50),
(7, 'Omeprazole 20mg', 'BATCH404', '2024-11-15', 8000, 12000, 30),
(8, 'Vitamin C 500mg', 'BATCH505', '2023-10-20', 5000, 8000, 100),
(9, 'Zinc Supplement', 'BATCH606', '2023-12-30', 3000, 6000, 70),
(10, 'Magnesium Oil', 'BATCH707', '2024-07-25', 20000, 25000, 20);

-- --------------------------------------------------------

--
-- Table structure for table `data_user`
--

CREATE TABLE `data_user` (
  `id` int(10) UNSIGNED NOT NULL,
  `nama` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `data_user`
--

INSERT INTO `data_user` (`id`, `nama`, `password`) VALUES
(1, 'admin', '$2a$10$v4iES1P8Yq2JCcEP64OJpOultrHG5lzTBXYkTstcYYDZrmUqvEOqa');

-- --------------------------------------------------------

--
-- Table structure for table `pbf_distributor`
--

CREATE TABLE `pbf_distributor` (
  `id` int(10) UNSIGNED NOT NULL,
  `nama` varchar(255) NOT NULL,
  `no_telp` varchar(20) NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pbf_distributor`
--

INSERT INTO `pbf_distributor` (`id`, `nama`, `no_telp`, `alamat`) VALUES
(1, 'PT Bintang Farma', '08123456789', 'Jalan Merdeka No. 123'),
(2, 'CV Sejahtera Medika', '08234567890', 'Jalan Raya No. 456'),
(3, 'UD Sentosa Pharmindo', '08345678901', 'Jalan Gatot Subroto No. 789'),
(4, 'PT Harmoni Farmasi', '08456789012', 'Jalan Sudirman No. 1011'),
(5, 'Apotek Bumi Sehat', '08567890123', 'Jalan Diponegoro No. 1213');

-- --------------------------------------------------------

--
-- Table structure for table `pembelian`
--

CREATE TABLE `pembelian` (
  `id` int(10) UNSIGNED NOT NULL,
  `tanggal_terima` date NOT NULL,
  `pbf_id` int(10) UNSIGNED NOT NULL,
  `no_faktur` varchar(50) NOT NULL,
  `tanggal_faktur` date NOT NULL,
  `jatuh_tempo` date NOT NULL,
  `tanggal_lunas` date DEFAULT NULL,
  `bayar_total` bigint(20) UNSIGNED DEFAULT NULL,
  `bayar_kembalian` bigint(20) DEFAULT NULL,
  `keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pembelian`
--

INSERT INTO `pembelian` (`id`, `tanggal_terima`, `pbf_id`, `no_faktur`, `tanggal_faktur`, `jatuh_tempo`, `tanggal_lunas`, `bayar_total`, `bayar_kembalian`, `keterangan`) VALUES
(1, '2023-08-13', 1, 'PINV/20230813/1', '2023-08-13', '2023-08-13', '2023-08-13', 0, 0, 'Pembelian dari PBF'),
(2, '2023-08-13', 4, 'PINV/20230813/2', '2023-08-13', '2023-09-13', '2023-08-14', 750000, 10000, '-'),
(3, '2023-08-14', 3, 'PINV/20230814/3', '2023-08-14', '2023-09-14', '2023-08-14', 1120000, 10000, 'ok'),
(4, '2023-08-14', 1, 'PINV/20230814/4', '2023-08-14', '2023-08-14', '2023-08-14', 10000, 2500, '-');

-- --------------------------------------------------------

--
-- Table structure for table `pembelian_detail`
--

CREATE TABLE `pembelian_detail` (
  `id` int(10) UNSIGNED NOT NULL,
  `no_faktur` varchar(50) NOT NULL,
  `barang_id` int(10) UNSIGNED NOT NULL,
  `qty` int(10) UNSIGNED NOT NULL,
  `harga_total` bigint(20) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pembelian_detail`
--

INSERT INTO `pembelian_detail` (`id`, `no_faktur`, `barang_id`, `qty`, `harga_total`) VALUES
(1, 'PINV/20230813/1', 1, 10, 30000),
(2, 'PINV/20230813/1', 2, 5, 100000),
(3, 'PINV/20230813/1', 3, 2, 25000),
(4, 'PINV/20230813/1', 4, 3, 75000),
(5, 'PINV/20230813/1', 5, 1, 5000),
(6, 'PINV/20230813/2', 6, 50, 500000),
(7, 'PINV/20230813/2', 7, 30, 240000),
(8, 'PINV/20230814/3', 8, 100, 500000),
(9, 'PINV/20230814/3', 9, 70, 210000),
(10, 'PINV/20230814/3', 10, 20, 400000),
(11, 'PINV/20230814/4', 5, 3, 7500);

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE `penjualan` (
  `id` int(10) UNSIGNED NOT NULL,
  `tanggal_jual` date NOT NULL,
  `no_faktur` varchar(30) NOT NULL,
  `total` bigint(20) UNSIGNED NOT NULL,
  `bayar` bigint(20) UNSIGNED NOT NULL,
  `pelanggan_id` int(10) UNSIGNED NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`id`, `tanggal_jual`, `no_faktur`, `total`, `bayar`, `pelanggan_id`) VALUES
(1, '2023-08-14', 'SINV/14082023/1', 8000, 10000, 0);

-- --------------------------------------------------------

--
-- Table structure for table `penjualan_detail`
--

CREATE TABLE `penjualan_detail` (
  `id` int(10) UNSIGNED NOT NULL,
  `no_faktur` varchar(30) NOT NULL,
  `barang_id` int(10) UNSIGNED NOT NULL,
  `nama_barang` varchar(255) NOT NULL,
  `tanggal_kedaluwarsa` date NOT NULL,
  `harga_jual` int(10) UNSIGNED NOT NULL,
  `qty` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `penjualan_detail`
--

INSERT INTO `penjualan_detail` (`id`, `no_faktur`, `barang_id`, `nama_barang`, `tanggal_kedaluwarsa`, `harga_jual`, `qty`) VALUES
(1, 'SINV/14082023/1', 5, 'Aspirin 100mg', '2024-06-25', 4000, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_barang`
--
ALTER TABLE `data_barang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `data_user`
--
ALTER TABLE `data_user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pbf_distributor`
--
ALTER TABLE `pbf_distributor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pembelian`
--
ALTER TABLE `pembelian`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pembelian_detail`
--
ALTER TABLE `pembelian_detail`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `penjualan_detail`
--
ALTER TABLE `penjualan_detail`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `data_barang`
--
ALTER TABLE `data_barang`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `data_user`
--
ALTER TABLE `data_user`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `pbf_distributor`
--
ALTER TABLE `pbf_distributor`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `pembelian`
--
ALTER TABLE `pembelian`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `pembelian_detail`
--
ALTER TABLE `pembelian_detail`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `penjualan`
--
ALTER TABLE `penjualan`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `penjualan_detail`
--
ALTER TABLE `penjualan_detail`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
