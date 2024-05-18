/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javasaw.dao;

import java.util.List;
import javasaw.model.Bobot;

/**
 *
 * @author afgha
 */
public interface BobotDAO {
    void insertBobot(Bobot bobot);
    void updateBobot(Bobot bobot);
    void deleteBobot(int id);
    List<Bobot> getAllBobot();
    Bobot getBobotById(int id);
}
