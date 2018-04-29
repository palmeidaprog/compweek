package com.github.palmeidaprog.compweek.inscritos;

import java.io.*;

public class GeradorCSV {
    private File output;

    public GeradorCSV(File output) throws IOException {
        this.output = output;
        criar();
    }

    private void criar() throws IOException {
        try(PrintWriter out = new PrintWriter(new FileWriter(output))) {
            ControllerInscrito inscritos = new ControllerInscrito();
            out.println("Matrícula;Nome;Curso;Fralda;Horas Total;" +
                    "Machine Learning;React;Competição;Modelagem;Python;" +
                    "Introd. IA;Unity;Game Sound;");
            for(int i = 0; i < inscritos.size(); i++) {
                out.println(inscritos.get(i).getMatricula() + ";" +
                        inscritos.get(i).getNome() + ";" + inscritos.get(i).
                        getCurso() + ";" + (inscritos.get(i).isFralda() ? "Ok"
                         : " ") + ";" + inscritos.get(i).horasTotal() + ";" +
                        inscritos.get(i).gethMachine() + ";" + inscritos
                        .get(i).gethReact() + ";" + inscritos.get(i)
                        .gethCompeticao() + ";" + inscritos.get(i)
                        .gethModelagem() + ";" + inscritos.get(i).gethPython()
                        + ";" + inscritos.get(i).gethIA() + ";" + inscritos
                        .get(i).gethUnity() + ";" + inscritos.get(i)
                        .gethGame() + ";");
            }
        } catch(IOException e) {
            throw new IOException("Não foi possível salvar " + output);
        }
    }


}
