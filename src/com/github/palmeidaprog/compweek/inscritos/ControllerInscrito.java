package com.github.palmeidaprog.compweek.inscritos;

public class ControllerInscrito {
    public InscritoDAO dao = InscritoDAO.getInstance();


    public void adicionar(Inscrito inscrito) {
        dao.adicionar(inscrito);
    }

    public Inscrito get(String matricula) throws NotFoundException {
        return dao.get(matricula);
    }

    public boolean isInscrito(String matricula) {
        try {
            dao.get(matricula);
            return true;
        } catch(NotFoundException e) {
            return false;
        }
    }

    public void update() {
        dao.update();
    }
}
