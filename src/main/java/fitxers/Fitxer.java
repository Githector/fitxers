package fitxers;

import java.io.*;

import static java.lang.System.*;

public class Fitxer {

    File fitxer,carpeta;
    FileWriter fwriter;
    BufferedWriter buffWriter;
    FileReader freader;
    BufferedReader buffReader;

    public Fitxer(){
        creaDirectori();
        crearFitxer();
        escriureAFitxer();
        llegirFitxer();
        updateFile();
        llegirFitxer();
    }

    private void updateFile() {
        File fileTemp = new File("dades" + File.separator + "fitxerTemp.txt");
        try {
            freader = new FileReader(fitxer);
            fwriter = new FileWriter(fileTemp);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        buffReader = new BufferedReader(freader);
        buffWriter = new BufferedWriter(fwriter);
        String currentLine="";
        while(true){
            try {
                if (!((currentLine = buffReader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(currentLine.contains("text")){
                try {
                    buffWriter.write("Hector crack!!!"+System.getProperty("line.separator"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                continue;
            }else{
                try {
                    buffWriter.write(currentLine+System.getProperty("line.separator"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            buffWriter.close();
            buffReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        fitxer.delete();
        out.println(fileTemp.renameTo(fitxer));


    }

    private void llegirFitxer() {
        try {
            freader = new FileReader(fitxer);
            buffReader = new BufferedReader(freader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    String currentLine="";
        while (true) {
            try {
                if (!((currentLine = buffReader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.println(currentLine);
        }

        try {
            buffReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void escriureAFitxer() {
        try {
            fwriter = new FileWriter(fitxer,false);
            buffWriter = new BufferedWriter(fwriter);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            buffWriter.write("Hola k ase");
            buffWriter.write(System.lineSeparator());
            buffWriter.write("Més text");
            buffWriter.write(System.lineSeparator());
            buffWriter.write("Altres coses");
            buffWriter.write(System.lineSeparator());
            buffWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void crearFitxer() {
        fitxer = new File("dades" + File.separator + "fitxer.txt");
        if (fitxer.exists()) {
            out.println("El fitxer ja existeix");
        }else{
            try {
                if(fitxer.createNewFile()) {
                    out.println("Fitxer creat correctament");
                }else {
                    out.println("Error al crear el fitxer...");
                }
            } catch (IOException e) {
                out.println("Error al crear el fitxer: "+e);
            }
        }

    }

    private void creaDirectori() {
        carpeta = new File("dades");
        if (carpeta.mkdir()) {
            out.println("Carpeta creada correctament");
        } else {
            err.println("Error al crear el directori, potser ja estava creat..");
        }
    }
}
