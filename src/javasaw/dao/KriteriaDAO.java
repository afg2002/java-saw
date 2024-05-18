/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javasaw.dao;

import java.util.List;
import javasaw.model.Kriteria;

/**
 *
 * @author afgha
 */
public interface KriteriaDAO {
    void insertKriteria(Kriteria kriteria);
    void updateKriteria(Kriteria kriteria);
    void deleteKriteria(int id);
    List<Kriteria> getAllKriteria();
    Kriteria getKriteriaById(int id);
}
