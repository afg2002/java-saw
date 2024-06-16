/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package javasaw.dao;

/**
 *
 * @author Afghan
 */
public interface NormalisasiDAO {
   public void insertNormalizedValue(int alternatifId, int kriteriaId, double normalizedValue);
   public void deleteAllNormalizedValues();
}
