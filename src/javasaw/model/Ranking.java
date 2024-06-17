/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javasaw.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Afghan
 */
@Data
@NoArgsConstructor
public class Ranking {
    int id;
    int alternatif_id;
    String nama_alternatif;
    double skor_akhir;
    int ranking;
}
