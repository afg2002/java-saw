
package javasaw.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bobot {
    private int id;
    private int idKriteria;
    private double nilaiBobot;
}