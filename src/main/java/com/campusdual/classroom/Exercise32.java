package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.io.*;

public class Exercise32 {

    public static void main(String[] args) {
        String mensaje = generateUserInputToSave();
        printToFile(mensaje);

    }

    public static String generateStringToSave(String string) {
        if(string == null){
          return generateUserInputToSave();
        }else{
            return string;
        }
    }
    private static String generateUserInputToSave(){
        StringBuilder sb = new StringBuilder();
        System.out.println("Escribe debajo el texto que quieras. Pulsa \"ENTER\" 2 veces seguidas para finalizar:");

       String mensaje =  Utils.string();
        sb.append(mensaje);
        while (!(mensaje = Utils.string()).isEmpty()){
            sb.append(mensaje).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void printToFile(String string) {
        if((new File("src/main/resources")).mkdir()){
            File archivo = new File("src/main/resources/data.txt");
        }
        BufferedWriter varBuffWriter = null;
        try {

            varBuffWriter = new BufferedWriter (new FileWriter("src/main/resources/data.txt"));
            varBuffWriter.write(string);
            varBuffWriter.flush();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo");
        }finally {
            try {
                if (varBuffWriter != null) varBuffWriter.close();
            } catch (IOException ex) {
                System.out.println("Error al cerrar el archivo");
            }
        }
    }


}
