package com.github.palmeidaprog.compweek.inscritos;

public class ControllerInscrito {
    public InscritoDAO dao = InscritoDAO.getInstance();


    public void adicionar(Inscrito inscrito) {
        dao.adicionar(inscrito);
    }
}
