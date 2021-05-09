-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 26, 2018 at 12:33 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 5.6.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perpuskota`
--

-- --------------------------------------------------------

--
-- Table structure for table `inputbuku`
--

CREATE TABLE `inputbuku` (
  `kode` varchar(15) NOT NULL,
  `judul_buku` varchar(50) NOT NULL,
  `pengarang` varchar(50) NOT NULL,
  `penerbit` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inputbuku`
--

INSERT INTO `inputbuku` (`kode`, `judul_buku`, `pengarang`, `penerbit`) VALUES
('121', 'modul pbo', 'upn', 'upn'),
('122', 'modul jaringan', 'upn', 'upn'),
('123', 'modul strukdat', 'upn', 'upn');

-- --------------------------------------------------------

--
-- Table structure for table `inputmember`
--

CREATE TABLE `inputmember` (
  `id` varchar(15) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `ttl` varchar(30) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `pekerjaan` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inputmember`
--

INSERT INTO `inputmember` (`id`, `nama`, `ttl`, `alamat`, `pekerjaan`) VALUES
('131', 'tyas', 'yogya,28 juli 1999', 'gowok', 'mahasiswa'),
('132', 'cahya', 'depok,2 april 1990', 'depok', 'pegawai');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('perpuskota', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `id` varchar(15) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `kode` varchar(15) NOT NULL,
  `tgl_pinjam` varchar(20) NOT NULL,
  `tgl_kembali` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `inputbuku`
--
ALTER TABLE `inputbuku`
  ADD PRIMARY KEY (`kode`);

--
-- Indexes for table `inputmember`
--
ALTER TABLE `inputmember`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`kode`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
