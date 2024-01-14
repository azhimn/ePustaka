-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 14, 2024 at 09:07 AM
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
-- Database: `pbo_pustaka`
--

-- --------------------------------------------------------

--
-- Table structure for table `anggota`
--

CREATE TABLE `anggota` (
  `id` int(11) NOT NULL,
  `nama` char(50) NOT NULL,
  `email` char(20) NOT NULL,
  `telepon` char(14) DEFAULT NULL,
  `alamat` char(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `anggota`
--

INSERT INTO `anggota` (`id`, `nama`, `email`, `telepon`, `alamat`) VALUES
(1, 'Bina Kacana', 'bkacanaa@gmail.com', '6289123456789', 'JL KEBUN JERUK NO 3'),
(2, 'Yuli Handayana', 'yulihann@gmail.com', '6282345897743', 'JL TAPIR PUTIH NO 12'),
(3, 'Goro Majima', 'goromajima@yahoo.jp', '819782974432', 'KAMURO ST NO 56');

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `id` int(11) NOT NULL,
  `judul` char(100) NOT NULL,
  `isbn` char(13) NOT NULL,
  `penulis` char(50) NOT NULL,
  `penerbit` char(50) NOT NULL,
  `tahun` year(4) NOT NULL,
  `kategori` char(15) NOT NULL,
  `lokasi` char(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`id`, `judul`, `isbn`, `penulis`, `penerbit`, `tahun`, `kategori`, `lokasi`) VALUES
(1, 'Gagal Menjadi Manusia', '9786237351306', 'Dazai Osamu', 'Penerbit Mai', '2020', 'Fiksi', 'A-1'),
(2, 'THREE DAYS OF HAPINESS', '9786230302176', 'Miaki Sugaru', 'm&c!', '2020', 'Fiksi', 'A-2'),
(3, 'I Want To Eat Your Pancreas', '9786026388345', 'Sumino Yoru', 'Penerbit Haru', '2017', 'Fiksi', 'A-2'),
(4, 'Death Note Another Note: The Los Angeles BB Murder Cases', '9786024285043', 'Nisio Isin', 'm&c!', '2017', 'Fiksi', 'A-2'),
(5, 'Membuat Aplikasi Mobile Native dengan JAVASCRIPT by NATIVESCRIPT', '9786026231178', 'Kang Cahya', 'Penerbit Lokomedia', '2018', 'Non-fiksi', 'B-1');

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `id` int(11) NOT NULL,
  `fk_anggota` int(11) NOT NULL,
  `fk_buku` int(11) NOT NULL,
  `mulai` date NOT NULL DEFAULT curdate(),
  `tenggat` date NOT NULL DEFAULT (curdate() + interval 7 day),
  `status` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`id`, `fk_anggota`, `fk_buku`, `mulai`, `tenggat`, `status`) VALUES
(4, 2, 5, '2024-01-02', '2024-01-08', 1),
(5, 1, 1, '2024-01-14', '2024-01-21', 0),
(6, 1, 1, '2024-01-07', '2024-01-14', 0);

-- --------------------------------------------------------

--
-- Table structure for table `pustakawan`
--

CREATE TABLE `pustakawan` (
  `id` int(11) NOT NULL,
  `nama` char(50) NOT NULL,
  `email` char(20) NOT NULL,
  `telepon` char(15) NOT NULL,
  `alamat` char(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `admin` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pustakawan`
--

INSERT INTO `pustakawan` (`id`, `nama`, `email`, `telepon`, `alamat`, `password`, `admin`) VALUES
(1, 'Kala Oliya', 'kalaoliya@gmail.com', '6281269244522', 'JL KEBUN JERUK NO 42', 'kucingkulucu234', 1),
(2, 'Rusdi Handayana', 'mankrusd@gmail.com', '6289542055569', 'JL MACET KAPAN LANCAR NO 72', 'selamatmakanbang', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `anggota`
--
ALTER TABLE `anggota`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_email` (`email`);

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_isbn` (`isbn`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`id`),
  ADD KEY `r_fk_anggota` (`fk_anggota`),
  ADD KEY `r_fk_buku` (`fk_buku`);

--
-- Indexes for table `pustakawan`
--
ALTER TABLE `pustakawan`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `anggota`
--
ALTER TABLE `anggota`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `buku`
--
ALTER TABLE `buku`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `peminjaman`
--
ALTER TABLE `peminjaman`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `pustakawan`
--
ALTER TABLE `pustakawan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `r_fk_anggota` FOREIGN KEY (`fk_anggota`) REFERENCES `anggota` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `r_fk_buku` FOREIGN KEY (`fk_buku`) REFERENCES `buku` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
