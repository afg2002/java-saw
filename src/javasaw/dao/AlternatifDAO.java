/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javasaw.dao;

import java.util.List;
import javasaw.model.Alternatif;

/**
 *
 * @author afgha
 */
public interface AlternatifDAO {
    void insertAlternatif(Alternatif alternatif);
    void updateAlternatif(Alternatif alternatif);
    
    void deleteAlternatif(int id);
    List<Alternatif> getAllAlternatif();
    List<Alternatif> getAllAlternatifsWithKeyword(String keyword);
    Alternatif getAlternatifById(int id);
    Integer getCountAlternatif();
}
