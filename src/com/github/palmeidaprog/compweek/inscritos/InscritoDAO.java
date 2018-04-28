package com.github.palmeidaprog.compweek.inscritos;

import java.util.ArrayList;
import java.util.List;

public class InscritoDAO {
    List<Inscrito> inscritos = new ArrayList<>();

    //--Singleton-------------------------------------------------------------
    private InscritoDAO() { }
    private static volatile InscritoDAO instance;
    public static synchronized InscritoDAO getInstance() {
        if(instance == null) {
            instance = new InscritoDAO();
        }
        return instance;
    }

    public void adicionar(Inscrito inscrito) {
        inscritos.add(inscrito);
    }

    public Inscrito get(String matricula) throws NotFoundException {
        for(Inscrito i : inscritos) {
            if(i.getMatricula().equals(matricula)) {
                return i;
            }
        }
        throw new NotFoundException(matricula + " não achado!");
    }

}
