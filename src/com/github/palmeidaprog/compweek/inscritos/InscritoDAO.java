package com.github.palmeidaprog.compweek.inscritos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InscritoDAO {
    ObservableList<Inscrito> inscritos = FXCollections.observableArrayList();


    //--Singleton-------------------------------------------------------------
    private InscritoDAO() {
        File f = new File("inscritos.ser");
        if(!f.exists()) {
            try {
                f.createNewFile();
            } catch(IOException e) {
                e.printStackTrace();
            }
        } else if(f.length() > 0) {
            read();
        }
    }
    private static volatile InscritoDAO instance;
    public static synchronized InscritoDAO getInstance() {
        if(instance == null) {
            instance = new InscritoDAO();
        }
        return instance;
    }

    public void adicionar(Inscrito inscrito) {
        inscritos.add(inscrito);
        save();
    }

    public Inscrito get(String matricula) throws NotFoundException {
        for(Inscrito i : inscritos) {
            if(i.getMatricula().equals(matricula)) {
                return i;
            }
        }
        throw new NotFoundException(matricula + " não achado!");
    }

    public void save() {
        try(ObjectOutputStream objOut = new ObjectOutputStream(new
                FileOutputStream("inscritos.ser"))) {
            List<Inscrito> lst = new ArrayList<>();
            Collections.addAll(lst);
            objOut.writeObject(lst);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void read() {
        try(ObjectInputStream objIn = new ObjectInputStream(new
                FileInputStream("inscritos.ser"))) {
            inscritos = FXCollections.observableList((List<Inscrito>)
                    objIn.readObject());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
