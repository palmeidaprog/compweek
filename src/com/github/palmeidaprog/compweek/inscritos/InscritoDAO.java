package com.github.palmeidaprog.compweek.inscritos;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EventListener;
import java.util.List;

public class InscritoDAO {
    private final String arquivo = "inscritos.ser";
    ObservableList<Inscrito> inscritos = FXCollections.observableArrayList();


    //--Singleton-------------------------------------------------------------
    private InscritoDAO() {
        inscritos = FXCollections.observableArrayList();
        inscritos.addListener(
                new ListChangeListener<Inscrito>() {
            @Override
            public void onChanged(Change<? extends Inscrito> c) {
                save();
            }
        });

        File f = new File(arquivo);
        if(!f.exists()) {
            //download();
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
    }

    public Inscrito get(String matricula) throws NotFoundException {
        for(Inscrito i : inscritos) {
            if(i.getMatricula().equals(matricula)) {
                return i;
            }
        }
        throw new NotFoundException(matricula + " não achado!");
    }

    private void save() {
        try(ObjectOutputStream objOut = new ObjectOutputStream(new
                FileOutputStream(arquivo))) {
            List<Inscrito> lst = new ArrayList<>();
            lst.addAll(inscritos);
            objOut.writeObject(lst);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        save();
    }

    private void read() {
        try(ObjectInputStream objIn = new ObjectInputStream(new
                FileInputStream(arquivo))) {
            inscritos = FXCollections.observableList((List<Inscrito>)
                    objIn.readObject());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public Inscrito get(int index) {
        return inscritos.get(index);
    }

    public Inscrito getNome(String nome) throws NotFoundException {
        for(Inscrito i : inscritos) {
            String n = new String(nome);

            boolean stop = false;
            while(n.contains(" ") && !stop) {
                String palavra = n.substring(0, n.indexOf(" "));
                if(!i.getNome().toLowerCase().contains(palavra
                        .toLowerCase())) {
                    stop = true;
                }
                n = n.substring(n.indexOf(" ") + 1);
            }

            if(stop) {
                continue;
            }

            if(i.getNome().toLowerCase().contains(n.toLowerCase())) {
                    return i;
            }
        }
        throw new NotFoundException("Não existe usuario com essa combinação "
                + "de nomes.");
    }

    public int size() {
        return inscritos.size();
    }

    private void download() {
        try {
            String endereco = "https://www.dropbox.com/s/knb73zxotlwkkv9/" +
                    "inscritos.ser?dl=1";
            URL url = new URL(endereco);
            ReadableByteChannel rbc = Channels.newChannel(url.openStream());
            FileOutputStream fos = new FileOutputStream(arquivo);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            //throw new CouldntSaveException("Não conseguiu baixar os dados da "
            //        + "net");
        }
    }
}
