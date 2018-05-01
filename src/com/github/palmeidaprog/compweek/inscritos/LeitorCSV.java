package com.github.palmeidaprog.compweek.inscritos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class LeitorCSV {
    private File input;
    private int atualizados;
    private int adicionados;

    public LeitorCSV(File input) throws IOException {
        this.input = input;
        ler();
    }

    private void ler() throws IOException {
        try(BufferedReader in = new BufferedReader(new FileReader(input))) {
            String s = in.readLine();
            if(!s.startsWith("Matricula") && !s.startsWith("Matrícula")) {
                throw new IOException("Arquivo escolhido não é valido!");
            }

            while((s = in.readLine()) != null) {
                int fim = s.indexOf(";");
                String matricula = data(s);
                s = next(s);
                String nome = data(s);
                s = next(s);
                String curso = data(s);
                s = next(s);
                Inscrito ins = new Inscrito(nome, matricula, curso);
                String fralda = data(s);
                s = next(s);
                if(fralda.equals("Ok")) {
                    ins.setFralda(true);
                }
                String ignorada = data(s); // ignored data (Total)
                s = next(s);
                ins.sethMachine(dataNum(s));
                s = next(s);
                ins.sethReact(dataNum(s));
                s = next(s);
                ins.sethCompeticao(dataNum(s));
                s = next(s);
                ins.sethModelagem(dataNum(s));
                s = next(s);
                ins.sethPython(dataNum(s));
                s = next(s);
                ins.sethIA(dataNum(s));
                s = next(s);
                ins.sethUnity(dataNum(s));
                s = next(s);
                ins.sethGame(dataNum(s));

                ControllerInscrito c = new ControllerInscrito();
                if(c.isInscrito(ins.getMatricula())) {
                    atualiza(ins);
                } else {
                    c.adicionar(ins);
                    ++adicionados;
                }
            }

        } catch (IOException e) {
            throw new IOException("Arquivo escolhido não é valido!");
        }
    }

    private String data(String s) {
        if(s.contains(";")) {
            return s.substring(0, s.indexOf(";"));
        } else {
            return s;
        }

    }

    private String next(String s) {
        return s.substring(s.indexOf(";") + 1);
    }

    private double dataNum(String s) {
        return Double.parseDouble(data(s));
    }

    private void atualiza(Inscrito novo) {
        ControllerInscrito contr = new ControllerInscrito();
        Inscrito atual;

        try {
            atual = contr.get(novo.getMatricula());
        } catch(NotFoundException e) {
            return ; // impossible
        }

        ++atualizados;
        atual.sethMachine(Math.max(atual.gethMachine(), novo.gethMachine()));
        atual.sethReact(Math.max(atual.gethReact(), novo.gethReact()));
        atual.sethCompeticao(Math.max(atual.gethCompeticao(), novo
                .gethCompeticao()));
        atual.sethModelagem(Math.max(atual.gethModelagem(), novo
                .gethModelagem()));
        atual.sethPython(Math.max(atual.gethPython(), novo.gethPython()));
        atual.sethIA(Math.max(atual.gethIA(), novo.gethIA()));
        atual.sethUnity(Math.max(atual.gethUnity(), novo.gethUnity()));
        atual.sethGame(Math.max(atual.gethGame(), novo.gethGame()));
        contr.update(); // atualiza DAO
    }

    public int getAtualizados() {
        return atualizados;
    }

    public int getAdicionados() {
        return adicionados;
    }
}
