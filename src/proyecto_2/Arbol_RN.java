package proyecto_2;

import javax.swing.JOptionPane;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

/**
 *
 * @author Hector
 */
public class Arbol_RN {
    
    private Nodo root;
    
    /**CONSTRUCTOR
     *
     */
    public Arbol_RN(){
        
        this.root = null;
        
    }

    /**
     *
     * @return RAIZ DE ARBOL
     */
    public Nodo getRoot() {
        return root;
    }

    /**CAMBIA LA RAIZ
     *
     * @param root
     */
    public void setRoot(Nodo root) {
        this.root = root;
    }
    
    /**
     *
     * @return
     */
    public boolean isEmpty(){
        return root == null;
    }
    
    /**
     *
     */
    public void AllEmpty(){
        this.root = null;
    }

    /** RECORRER ARBOL DE MENOR A MAYOR
     *
     * @param rz
     */
    
    public void Recorrido_InOrden(Nodo rz){
        
        if (rz != null) {  
            Recorrido_InOrden(rz.getHijoIzq());
            System.out.println(rz.getCedula() + "------" + rz.getNombre() + "------" + rz.getColor());
            Recorrido_InOrden(rz.getHijoDer());

        }
        
    }
    

    /**RETORNA LA ALTURA DEL NODO PARAMETRO
     *
     * @param rz
     * @return ALTURA
     */

    
    public int Height(Nodo rz){
        if (rz == null) {
            return 0;            
        }
        return rz.getHeight();
    }
    
    /**
     *
     * @param x
     * @param y
     * @return
     */
    public int Maximo(int x, int y){
        return (x > y) ? x : y;
    }
    
    /**
     *
     * @param rz
     * @return
     */
    public Nodo Max(Nodo rz){
        Nodo act = rz;
        
        while(rz.getHijoDer() != null){
            act = act.getHijoDer();
        }
        
        return act;
    }
    
    /**
     *
     * @param rz
     * @return
     */
    public Nodo Minimo(Nodo rz){
        Nodo act = rz;
        
        while(act.getHijoIzq() != null){
            act = act.getHijoIzq();      
        }
        
        return act;
    }
    
    
    /** VALIDA SI EL ARBOL ESTA balanceado
     *
     * @param rz
     * @return FACTOR DE EQUILIBRIO
     */
    public int Balanceo(Nodo rz){
        if (rz == null) {
            return 0;
        }
        return Height(rz.getHijoIzq()) - Height(rz.getHijoDer());
        
    }
    
    
    /**ROTACIÓN A LA DERECHA
     *
     * @param rz 
     */
    public void RotationRight(Nodo rz){
    
        Nodo aux = rz.getHijoIzq();
        rz.setHijoIzq(aux.getHijoDer());
        
        if (aux.getHijoDer() != null) {
            aux.getHijoDer().setFather(rz);
        }
        aux.setFather(rz.getFather());
        if (rz.getFather() == null) {
            this.root = aux;
        } else if (rz == rz.getFather().getHijoDer()) {
            rz.getFather().setHijoDer(aux);
        } else {
            rz.getFather().setHijoIzq(aux);
        }
        
        aux.setHijoDer(rz);
        rz.setFather(aux);

    }
    
    /**ROTACION A LA IZQUIERDA
     *
     * @param rz
     */
    public void RotationLeft(Nodo rz){
   
        Nodo aux = rz.getHijoDer();
        rz.setHijoDer(aux.getHijoIzq());
        
        if (aux.getHijoIzq() != null) {
            aux.getHijoIzq().setFather(rz);
        }
        aux.setFather(rz.getFather());
        if (rz.getFather() == null) {
            this.root = aux;
        } else if (rz == rz.getFather().getHijoIzq()) {
            rz.getFather().setHijoIzq(aux);
        } else {
            rz.getFather().setHijoDer(aux);
        }
        
        aux.setHijoIzq(rz);
        rz.setFather(aux);
    } 
    
    /**BUSCA UN NODO
     *
     * @param rz
     * @param ci
     * @return NODO ENCONTRADO
     */
    public Nodo BuscarNodo(Nodo rz, int ci){
        
        if (rz == null) {
            return null;            
        } else{
            if (rz.getCedula() == ci) {
                return rz;                
            } else {
                if (rz.getCedula() > ci) {
                    return BuscarNodo(rz.getHijoIzq(), ci);                    
                } else{
                    return BuscarNodo(rz.getHijoDer(), ci);
                }
            }
        }
      
    }
    
    /**
     *
     * @param rz
     */
    public void ColorearInsertar(Nodo rz){
        Nodo abuelo = null;
        Nodo padre = null;
        Nodo tio;
                
        while(rz != null && !"black".equals(rz.getColor()) && "red".equals(rz.getFather().getColor())){
            padre = rz.getFather();
            abuelo = padre.getFather();
            
            //Caso: padre del nodo insertado es hijo izquierdo del abuelo
            if (padre == abuelo.getHijoIzq()) {
                tio = abuelo.getHijoDer();
                if (tio != null && "red".equals(tio.getColor())) {
                    //caso 1
                    tio.setColor("black");
                    padre.setColor("black");
                    abuelo.setColor("red");
                    rz = abuelo;
                } else {
                    if (rz == padre.getHijoDer()) {
                        //caso 2
                        RotationLeft(padre);
                        rz = padre;
                        padre = rz.getFather();
                    }
                    //caso 3
                    RotationRight(abuelo);
                    String color = padre.getColor();
                    padre.setColor(abuelo.getColor());
                    abuelo.setColor(color);
                    rz = padre;
                }  
            } else {
                //Caso inverso
                tio = abuelo.getHijoIzq();
                        
                if (tio != null && "red".equals(tio.getColor())) {
                    //mirror caso 1
                    tio.setColor("black");
                    padre.setColor("black");
                    abuelo.setColor("red");
                    rz = abuelo;
                } else {
                    if (rz == padre.getHijoIzq()) {
                        //mirror caso 2
                        RotationRight(padre);
                        rz = padre;
                        padre = rz.getFather();
                    }
                    //mirror 3
                    RotationLeft(abuelo);
                    String color = padre.getColor();
                    padre.setColor(abuelo.getColor());
                    abuelo.setColor(color);
                    rz = padre;
                }
            } 
            if (rz == this.root) {
                break;
            }
        }
        
        this.root.setColor("black");
    }
    
    /**INSERTA NODO EN EL ARBOL CUMPLIENDO CON LAS CONDICIONES DEL REDBLACK TREE
     *
     * @param ci
     * @param nombre
     * @return RAIZ DEL ARBOL MODIFICADO
     */
    public Nodo Insert(int ci, String nombre){
       Nodo nodo = new Nodo(ci, nombre);
       
       Nodo padre = null;
       Nodo raiz = this.root;
       
       while(raiz != null){
           padre = raiz;
           if (nodo.getCedula() < raiz.getCedula()) {
               raiz = raiz.getHijoIzq();
           } else{
               raiz = raiz.getHijoDer();
           }
           
       }
       
       nodo.setFather(padre);
       
        if (padre == null) {
            this.root = nodo;
        } else if (nodo.getCedula() < padre.getCedula()) {
            padre.setHijoIzq(nodo);
        } else {
            padre.setHijoDer(nodo);
        }
        
        if (nodo.getFather() == null) {
            nodo.setColor("black");
            return this.root;
        }
        if (nodo.getFather().getFather() == null) {
            return this.root;  
        }
        ColorearInsertar(nodo);
        return this.root;
    }
    
    /**
     *
     * @param rz
     */
    public void ColorearDelete(Nodo rz){
        Nodo hermano;
        
        while(rz != this.root && !"black".equals(rz.getColor())){
            if (rz == rz.getFather().getHijoIzq()) {
                hermano = rz.getFather().getHijoDer();
                if ("red".equals(hermano.getColor())) {
                    //caso 3.1
                    hermano.setColor("black");
                    rz.getFather().setColor("red");
                    RotationLeft(rz.getFather());
                    hermano = rz.getFather().getHijoDer();
                }
                
                if ("black".equals(hermano.getHijoIzq().getColor()) && "black".equals(hermano.getHijoDer().getColor())) {
                    //caso 3.2
                    hermano.setColor("red");
                    rz = rz.getFather();
                } else {
                    //caso 3.3
                    if ("black".equals(hermano.getHijoDer().getColor())) {
                        hermano.getHijoIzq().setColor("black");
                        hermano.setColor("red");
                        RotationRight(hermano);
                        hermano = rz.getFather().getHijoDer();
                    }
                    //caso 3.4
                    hermano.setColor(rz.getFather().getColor());
                    rz.getFather().setColor("black");
                    hermano.getHijoDer().setColor("black");
                    RotationLeft(rz.getFather());
                    rz = this.root;
                }
            } else {       
                hermano = rz.getFather().getHijoIzq();
                
                if ("red".equals(hermano.getColor())) {
                    //caso 3.1
                    hermano.setColor("black");
                    rz.getFather().setColor("red");
                    RotationRight(rz.getFather());
                    hermano = rz.getFather().getHijoIzq();
                }
                
                if ("black".equals(hermano.getHijoDer().getColor()) && "black".equals(hermano.getHijoIzq().getColor())) {
                    //caso 3.2
                    hermano.setColor("red");
                    rz = rz.getFather();
                } else {
                    if ("black".equals(hermano.getHijoIzq().getColor())) {
                        //caso 3.3
                        hermano.getHijoDer().setColor("black");
                        hermano.setColor("red");
                        RotationLeft(hermano);
                        hermano = rz.getFather().getHijoIzq();
                    }
                    //caso 3.4
                    hermano.setColor(rz.getFather().getColor());
                    rz.getFather().setColor("black");
                    hermano.getHijoIzq().setColor("black");
                    RotationRight(rz.getFather());
                    rz = this.root;
                }            
                
            } 
        }
        rz.setColor("black");

    }
    
    /**
     *
     * @param rz
     * @param aux
     */
    public void Transplante(Nodo rz, Nodo aux){
        
        if (rz.getFather() == null) {
            this.root = aux;
        } else if (rz == rz.getFather().getHijoIzq()) {
            rz.getFather().setHijoIzq(aux);
        } else{
            rz.getFather().setHijoDer(aux);
        }
               
    }
    
     
    /**ELIMINA EL NODO PARAMETRO Y MANTIENE EL EQUILIBRIO DEL ARBOL
     *
     * @param rz
     * @param info
     * @return
     */
    public Nodo Delete(Nodo rz, int info){
        
        Nodo temp = BuscarNodo(rz, info);
        Nodo sust, act;
        
        if (temp == null) {
            JOptionPane.showMessageDialog(null, "EL ELEMENTO NO EXISTE!");
            return this.root;
        }
        
        act = temp;
        String colorOriginal = act.getColor();
        
        if (temp.getHijoIzq() == null) {
            sust = temp.getHijoDer();
            Transplante(temp, temp.getHijoDer());
        } else if (temp.getHijoDer() == null) {
            sust = temp.getHijoIzq();
            Transplante(temp, temp.getHijoIzq());
        } else {
            act = Minimo(temp.getHijoDer());
            colorOriginal = act.getColor();
            sust = act.getHijoDer();
            
            if (act.getFather() == temp) {
                sust.setFather(act);
            } else {
                Transplante(act, act.getHijoDer());
                act.setHijoDer(temp.getHijoDer());
                act.getHijoDer().setFather(act);
            }
            
            Transplante(temp, act);
            act.setHijoIzq(temp.getHijoIzq());
            act.getHijoDer().setFather(act);
            act.setColor(temp.getColor());
        }
        
        if ("black".equals(colorOriginal)) {
            ColorearDelete(sust);
        }
           
        return this.root;
       
    }
    
    /**GRAFICA EL ARBOL VACIO
     *
     * @return GRAFICO PARA LA INSERCIÓN DE NODOS Y ENLACES
     * 
     */
    public Graph CrearGrafica_arbol(){
        
        System.setProperty("org.graphstream.ui", "swing");
        
        Graph graph = new SingleGraph("ARBOL RN");
        graph.setAttribute("ui.stylesheet", "graph { padding: 40px; } edge { arrow-shape: arrow; arrow-size: 20px, 4px; } node { size: 20px; fill-color: red, black; fill-mode: gradient-horizontal; text-alignment: at-right; text-padding: 3px, 2px; text-background-mode: rounded-box; text-background-color: #EB2; text-color: #222; } ");    
        
        graph.display();
        
        return graph;
    }
    
    /** CREA TODOS LOS NODOS DEL GRAFICO
     *
     * @param grafico
     * @param rz
     * @return GRAFICO LISTO CON TODOS LOS NODOS
     */
    public Graph CrearNodes(Graph grafico, Nodo rz){
        
        if (rz == null) {
            Node a = grafico.addNode("A");
            a.setAttribute("ui.label", "NULL");
        } else {
            if (rz.getHijoIzq() != null && rz.getHijoDer() != null) {
                IndividualNode(grafico, rz);
                CrearNodes(grafico, rz.getHijoIzq());
                CrearNodes(grafico, rz.getHijoDer());
            } else if (rz.getHijoIzq() != null && rz.getHijoDer() == null) {
                IndividualNode(grafico, rz);
                CrearNodes(grafico, rz.getHijoIzq());
                
            } else if (rz.getHijoIzq() == null && rz.getHijoDer() != null) {
                IndividualNode(grafico, rz);
                CrearNodes(grafico, rz.getHijoDer());
            } else{
                IndividualNode(grafico, rz);
            }
        }     
        return grafico;        
    }

    /**
     *
     * @param grafico
     * @param rz
     * @return
     */
    public Graph CrearEdges(Graph grafico, Nodo rz){
        
        if (rz == null) {
            Edge ab = grafico.addEdge("a-->b", "a", "b", true);
            ab.setAttribute("ui.label", "NULL");
        } else {
            if (rz.getHijoIzq() != null && rz.getHijoDer() != null) {
                IndividualEdge(grafico, rz, rz.getHijoIzq());
                IndividualEdge(grafico, rz, rz.getHijoDer());
                CrearEdges(grafico, rz.getHijoIzq());
                CrearEdges(grafico, rz.getHijoDer());
            }else if (rz.getHijoIzq() != null && rz.getHijoDer() == null) {
                IndividualEdge(grafico, rz, rz.getHijoIzq());
                CrearEdges(grafico, rz.getHijoIzq());
            }else if (rz.getHijoIzq() == null && rz.getHijoDer() != null) {
                IndividualEdge(grafico, rz, rz.getHijoDer());
                CrearEdges(grafico, rz.getHijoDer());
            }else {
                
            }  
        }
        
        return grafico;
    }

    /** CREA UN ENLACE CON EL NODO 
     *
     * @param graph
     * @param origen
     * @param destino
     * @return
     */
    public Graph IndividualEdge(Graph graph, Nodo origen, Nodo destino){
        graph.addEdge(""+origen.getCedula()+"-->"+destino.getCedula(), ""+origen.getCedula(), ""+destino.getCedula(), true);
        return graph;
    }
    
    /**CREA UN NODO INDIVIDUAL
     *
     * @param graph
     * @param cualquiera
     * @return EL GRAFICO CON EL NODO INSERTADO
     */
    public Graph IndividualNode(Graph graph, Nodo cualquiera){
       Node aux = graph.addNode(""+cualquiera.getCedula());
       aux.setAttribute("ui.label", cualquiera.getCedula()+"--"+cualquiera.getColor());
       aux.setAttribute("ui.color", cualquiera.getColor()+","+cualquiera.getColor());
       return graph;
    }   
    
}
