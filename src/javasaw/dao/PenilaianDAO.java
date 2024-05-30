/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javasaw.dao;

import java.util.List;
import javasaw.model.Penilaian;

/**
 *
 * @author afgha
 */
public interface PenilaianDAO {
    void insertPenilaian(Penilaian penilaian);
    void updatePenilaian(Penilaian penilaian);
    void deletePenilaian(int id);
    List<Penilaian> getAllPenilaian();
    Penilaian getPenilaianById(int id);
}
