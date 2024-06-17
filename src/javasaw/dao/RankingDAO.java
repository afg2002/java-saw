/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package javasaw.dao;

import java.util.List;
import javasaw.model.Ranking;

/**
 *
 * @author Afghan
 */
public interface RankingDAO {
     public void insertFinalScore(int alternatifId, double finalScore);
     public void deleteAllFinalScores();
     public List<Ranking> getRankingFinalScore();
}
