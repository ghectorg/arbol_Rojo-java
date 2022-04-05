package proyecto_2;

/**
 *
 * @author Hector
 */
public class Nodo {
    
    private Nodo hijoIzq, hijoDer, father;    
    private int height, cedula;
    private String color, nombre;
    
    public Nodo(int info){
        
        this.hijoIzq = this.hijoDer = this.father = null;
        this.cedula = info;
        this.nombre = "";
        this.height = 0;
        this.color = "red";
    }
    
    public Nodo(int info, String nom){
        
        this.hijoIzq = this.hijoDer = this.father = null;
        this.cedula = info;
        this.nombre = nom;
        this.height = 0;
        this.color = "red";
    }

    public Nodo getFather() {
        return father;
    }

    public void setFather(Nodo father) {
        this.father = father;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int Data) {
        this.cedula = Data;
    }

    public Nodo getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(Nodo hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public Nodo getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(Nodo hijoDer) {
        this.hijoDer = hijoDer;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
