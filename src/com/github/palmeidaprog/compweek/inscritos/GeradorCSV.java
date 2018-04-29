package com.github.palmeidaprog.compweek.inscritos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GeradorCSV {
    private File output;

    public GeradorCSV(File output) throws IOException {
        this.output = output;
        criar();
    }

    private void criar() throws IOException {
        try(BufferedWriter out = new BufferedWriter(new FileWriter(output))) {
            ControllerInscrito inscritos = new ControllerInscrito();
            out.write("Matricula;Nome;Curso;Fralda;Horas Total; ")
            for(int i = 0; i < inscritos.size(); i++) {

            }
        } catch(IOException e) {
            throw new IOException("Não foi possível salvar " + output);
        }
    }


}
