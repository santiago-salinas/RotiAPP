package Dominio;
// Santiago Salinas 266628 / Natalia Vazquez 266986
import Interfaz.Inicio;
import java.io.*;

public class Start {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Rotiseria rotiseria = new Rotiseria();
        boolean continuar = false;
        //Se trata de conseguir el archivo de persistencia
        try {
            FileInputStream file = new FileInputStream("archivo");
            BufferedInputStream b = new BufferedInputStream(file);
            ObjectInputStream o = new ObjectInputStream(b);

            rotiseria = (Rotiseria) o.readObject();
            o.close();
            //Como gestor (properyChangeSupport) es transient, debo volver a ponerlo
            rotiseria.newGestor();
            continuar = true;
            
        } catch (FileNotFoundException e) {
            rotiseria = new Rotiseria();
        }
        
        //A la ventana inicio le paso el dato de si se pudo conseguir la persistencia
        //Y el objeto de rotiseria, ya sea vacio o con los datos
        Inicio inicio = new Inicio(rotiseria, continuar);
        inicio.setVisible(true);
        //Abre la ventana en el centro
        inicio.setLocationRelativeTo(null);
    }

}
