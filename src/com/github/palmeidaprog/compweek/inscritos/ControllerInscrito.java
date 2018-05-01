package com.github.palmeidaprog.compweek.inscritos;

import org.omg.CosNaming.NamingContextPackage.NotFound;

public class ControllerInscrito {
    public InscritoDAO dao = InscritoDAO.getInstance();


    public void adicionar(Inscrito inscrito) {
        dao.adicionar(inscrito);
    }

    public Inscrito get(String matricula) throws NotFoundException {
        return dao.get(matricula);
    }

    public Inscrito getNome(String nome) throws NotFoundException {
        return dao.getNome(nome);
    }

    public Inscrito get(int index) {
        return dao.get(index);
    }

    public boolean isInscrito(String matricula) {
        try {
            dao.get(matricula);
            return true;
        } catch(NotFoundException e) {
            return false;
        }
    }

    public int size() {
        return dao.size();
    }

    public void update() {
        dao.update();
    }
}
