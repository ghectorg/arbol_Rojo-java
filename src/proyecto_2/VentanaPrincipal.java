/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_2;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

/**
 *
 * @author Miguel
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    static Graph grafico;
    static Arbol_RN arbol;
    static Funciones fc;
    boolean exisTree;
    public VentanaPrincipal() {
        
        grafico = new SingleGraph("ARBOL RN");
        arbol = new Arbol_RN();
        fc = new Funciones();
        initComponents();
        this.setLocationRelativeTo(null);
        this.exisTree = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cargar = new javax.swing.JButton();
        add = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        search = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        close = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("RED BLACKS TREES");

        cargar.setText("CARGAR DATOS");
        cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarActionPerformed(evt);
            }
        });

        add.setText("AGREGAR HABITANTE");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        delete.setText("ELIMINAR HABITANTE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        search.setText("BUSCAR HABITANTE");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        guardar.setText("GUARDAR");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        close.setText("CERRAR");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(cargar)
                        .addGap(67, 67, 67)
                        .addComponent(close)))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(add)
                        .addGap(32, 32, 32)
                        .addComponent(search)
                        .addGap(35, 35, 35)
                        .addComponent(delete))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar)
                    .addComponent(cargar)
                    .addComponent(close))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        
        //añadir nuevo nodo preguntando nombre y cedula
        try{
            
            if (exisTree) {
               
                String valor = JOptionPane.showInputDialog(this, "Igrese la cedula");
                String nombre = JOptionPane.showInputDialog(this, "Igrese el nombre");           
                
                arbol.setRoot(arbol.Insert(Integer.parseInt(valor), nombre));
                
                Nodo nodoInsertado = arbol.BuscarNodo(arbol.getRoot(), Integer.parseInt(valor));
                Nodo padre = nodoInsertado.getFather();
                
                if (padre != null) {
                    
                    Node aux = grafico.getNode(""+padre.getCedula());
                    Node a = grafico.addNode(valor);                 
                    grafico.addEdge(aux+valor, ""+aux, ""+a, true);
                                 
                    a.setAttribute("ui.label", valor);
                    
                } else{
                    
                    Node a = grafico.addNode(valor);
                    a.setAttribute("ui.label", valor);
                }
                
            } else{
                JOptionPane.showMessageDialog(this, "ERROR!!! DEBE CARGAR DATOS EN UN ARBOL ANTES DE INSERTAR UN NODO!");
            }
     
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, "ERROR!!! NO SE QUÉ HICISTE PERO MAL!");
        };
    }//GEN-LAST:event_addActionPerformed

    private void cargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarActionPerformed
        JFileChooser fx = new JFileChooser();
        
        int seleccion = fx.showOpenDialog(this);
        
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            
            File fichero = fx.getSelectedFile();
            
            arbol = fc.Leer_csv(fichero.getAbsolutePath());
        }
        
        grafico = arbol.CrearGrafica_arbol();
        
        arbol.CrearNodes(grafico, arbol.getRoot());
        arbol.CrearEdges(grafico, arbol.getRoot());
        
        exisTree = true;
        
    }//GEN-LAST:event_cargarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        
        try{          
            
            if (exisTree) {
                fc.Escribir_csv(arbol);    
            } else{
                JOptionPane.showMessageDialog(this, "ERROR!!! DEBE CARGAR DATOS EN UN ARBOL ANTES DE INSERTAR UN NODO!");
            }
     
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, "ERROR!!! NO SE QUÉ HICISTE PERO MAL!");
        };
        
        
    }//GEN-LAST:event_guardarActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here: busca un nodo por la clave cedula y mostrar el nombre
        try{
            
            jTextArea1.setText("");
            if (exisTree) {
                String valor = JOptionPane.showInputDialog(this, "Igrese la cedula");
                
                Nodo buscado  = arbol.BuscarNodo(arbol.getRoot(), Integer.parseInt(valor));
                
                jTextArea1.setText("INFORMACIÓN DE PERSONA BUSCADA\n"+ "Cédula: "+ valor + "\n" + "Nombre Completo: " + buscado.getNombre());
                
            } else{
                JOptionPane.showMessageDialog(this, "ERROR!!! DEBE CARGAR DATOS EN UN ARBOL ANTES DE INSERTAR UN NODO!");
            }
     
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, "ERROR!!! NO SE QUÉ HICISTE PERO MAL!");
        };
    }//GEN-LAST:event_searchActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:eliminar un nodo dada la cedula
        try{
            
            if (exisTree) {
                String valor = JOptionPane.showInputDialog(this, "Igrese la cedula");
                
                arbol.setRoot(arbol.Delete(arbol.getRoot(), Integer.parseInt(valor)));
                Node aux = grafico.getNode(""+valor);
                grafico.removeNode(aux);
                
            } else{
                JOptionPane.showMessageDialog(this, "ERROR!!! DEBE CARGAR DATOS EN UN ARBOL ANTES DE INSERTAR UN NODO!");
            }
     
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, "ERROR!!! NO SE QUÉ HICISTE PERO MAL!");
        };
    }//GEN-LAST:event_deleteActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton cargar;
    private javax.swing.JButton close;
    private javax.swing.JButton delete;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
