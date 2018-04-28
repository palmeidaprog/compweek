package com.github.palmeidaprog.compweek.inscritos;

import java.io.Serializable;

public class Inscrito implements Serializable {
    private String nome;
    private String matricula;
    private String curso;
    private boolean fralda;
    private double hMachine;
    private double hReact;
    private double hCompeticao;
    private double hModelagem;
    private double hPython;
    private double hIA;
    private double hUnity;
    private double hGame;

    // used for Serializable
    public Inscrito(String nome, String matricula, String curso, boolean
            fralda, double hMachine, double hReact, double hCompeticao,
                    double hModelagem, double hPython, double hIA, double
                            hUnity, double hGame) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.fralda = fralda;
        this.hMachine = hMachine;
        this.hReact = hReact;
        this.hCompeticao = hCompeticao;
        this.hModelagem = hModelagem;
        this.hPython = hPython;
        this.hIA = hIA;
        this.hUnity = hUnity;
        this.hGame = hGame;
    }

    public Inscrito(String nome, String matricula, String curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    public Inscrito(String nome, String matricula, String curso, boolean
            fralda) {
        this(nome, matricula, curso);
        this.fralda = fralda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public boolean isFralda() {
        return fralda;
    }

    public void setFralda(boolean fralda) {
        this.fralda = fralda;
    }

    public double gethMachine() {
        return hMachine;
    }

    public void sethMachine(double hMachine) {
        this.hMachine = hMachine;
    }

    public double gethReact() {
        return hReact;
    }

    public void sethReact(double hReact) {
        this.hReact = hReact;
    }

    public double gethCompeticao() {
        return hCompeticao;
    }

    public void sethCompeticao(double hCompeticao) {
        this.hCompeticao = hCompeticao;
    }

    public double gethModelagem() {
        return hModelagem;
    }

    public void sethModelagem(double hModelagem) {
        this.hModelagem = hModelagem;
    }

    public double gethPython() {
        return hPython;
    }

    public void sethPython(double hPython) {
        this.hPython = hPython;
    }

    public double gethIA() {
        return hIA;
    }

    public void sethIA(double hIA) {
        this.hIA = hIA;
    }

    public double gethUnity() {
        return hUnity;
    }

    public void sethUnity(double hUnity) {
        this.hUnity = hUnity;
    }

    public double gethGame() {
        return hGame;
    }

    public void sethGame(double hGame) {
        this.hGame = hGame;
    }

    @Override
    public String toString() {
        return "Inscrito{" +
                "nome='" + nome + '\'' +
                ", matricula='" + matricula + '\'' +
                ", curso='" + curso + '\'' +
                ", fralda=" + fralda +
                ", hMachine=" + hMachine +
                ", hReact=" + hReact +
                ", hCompeticao=" + hCompeticao +
                ", hModelagem=" + hModelagem +
                ", hPython=" + hPython +
                ", hIA=" + hIA +
                ", hUnity=" + hUnity +
                ", hGame=" + hGame +
                '}';
    }
}
