package proyecto_2;

import com.csvreader.CsvWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 *
 * @author Labu
 */
public class Funciones {
    
    /**
     *
     */
    public Funciones(){   
        
    }
    
    public String CargarDatos(Nodo rz, String aux){
        
        if (rz == null) {
            return aux;
        } else {
            if (rz.getHijoIzq() != null && rz.getHijoDer() != null) {
                aux = aux + rz.getNombre() + "," + rz.getCedula() + "\n" + "||";
                CargarDatos(rz.getHijoIzq(), aux);
                CargarDatos(rz.getHijoDer(), aux);
            } else if (rz.getHijoIzq() != null && rz.getHijoDer() == null) {
                aux = aux + rz.getNombre() + "," + rz.getCedula() + "\n" + "||";
                CargarDatos(rz.getHijoIzq(), aux);
            } else if (rz.getHijoIzq() == null && rz.getHijoDer() != null) {
                aux = aux + rz.getNombre() + "," + rz.getCedula() + "\n" + "||";
                CargarDatos(rz.getHijoDer(), aux);
            } else{
               aux = aux + rz.getNombre() + "," + rz.getCedula() + "\n" + "||"; 
            }
        }
        return aux;
    }

    /**
     *
     * @param l
     */
    public void Escribir_csv(Arbol_RN l){
        try{
            
            CsvWriter exArchivo = new CsvWriter("test\\Datos.csv");
            String datos = "";
            String[] titulo1 = {"nombre","Apellido","CI"};
            exArchivo.writeRecord(titulo1);
            String[] personas_csv = CargarDatos(l.getRoot(), datos).split("||");
            exArchivo.writeRecord(personas_csv);

            exArchivo.close();
            
            JOptionPane.showMessageDialog(null, "Exito al Registrar!");
            
        } catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Error al Registrar!");
        }
        
    }
    
    /**
     *
     * @param path
     * @return
     */
    public Arbol_RN Leer_csv(String path){
        
        Arbol_RN habitantes = new Arbol_RN();
        
        String line;
        String users_csv = "";
        Nodo aux;
        File file = new File(path);
        
        try{
            if (!file.exists()) {
                
                file.createNewFile();
                
            } else{
                FileReader fr = new FileReader(file);
                
                BufferedReader br = new BufferedReader(fr);
                
                while((line = br.readLine())!= null){
                    
                    if (!line.isEmpty()) { 
                        users_csv += line + "\n";  
                    }
                    
                }
                if (!"".equals(users_csv)) {
                    String[] users_split = users_csv.split("\n");
                    
                    for (String users_split1 : users_split) {
                        
                        if (!users_split1.equals("nombre,Apellido,CI")) {
                            String[] user = users_split1.split(",");
                            habitantes.setRoot(habitantes.Insert(Integer.parseInt(user[2]), user[0]+" "+user[1]));
                        }                      
                    }     
                }
                br.close();
                JOptionPane.showMessageDialog(null, "Exito al leer!");
            }
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al leer!");
        }
        
        return habitantes;
    }
    
}
