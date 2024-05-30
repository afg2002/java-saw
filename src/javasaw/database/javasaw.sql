-- Tabel untuk menyimpan informasi kriteria
CREATE TABLE Kriteria (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nama_kriteria VARCHAR(255) NOT NULL,
    bobot DECIMAL(5,2) NOT NULL
);

-- Tabel untuk menyimpan informasi alternatif
CREATE TABLE Alternatif (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nama_alternatif VARCHAR(255) NOT NULL
);

-- Tabel untuk menyimpan bobot relatif kriteria
CREATE TABLE Bobot (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_kriteria INT,
    FOREIGN KEY (id_kriteria) REFERENCES Kriteria(id),
    nilai_bobot DECIMAL(5,2) NOT NULL
);

-- Tabel untuk menyimpan nilai penilaian setiap alternatif pada setiap kriteria
CREATE TABLE Penilaian (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_alternatif INT,
    FOREIGN KEY (id_alternatif) REFERENCES Alternatif(id),
    id_kriteria INT,
    FOREIGN KEY (id_kriteria) REFERENCES Kriteria(id),
    nilai DECIMAL(5,2) NOT NULL
);

CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
