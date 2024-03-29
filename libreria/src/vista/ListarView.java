/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dao.LibroDaoImpl;
import dao.LibroDAO;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import modelo.Libro;

/**
 *
 * @author administrador
 */
public class ListarView extends javax.swing.JFrame {
    private JTable jTable = new JTable();
    public ListarView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtId = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar Libros");
        setBackground(new java.awt.Color(204, 255, 255));

        txtId.setText("Ingrese id");
        txtId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIdFocusGained(evt);
            }
        });

        btnBuscar.setText("buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Título", "Autor", "Precio", "Disponibilidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDatos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String titulo, autor;
        int precio, id;
        boolean disponible;
        DefaultTableModel modelo = (DefaultTableModel) tblDatos.getModel();

        try {
            id = Integer.parseInt(txtId.getText());
        } catch (Exception ex) {
            id = 0;
        }

        modelo.setRowCount(0);

        if (id == 0) { // listsr todos
            LibroDAO libroDAO = new LibroDaoImpl();
            for(Libro libro : libroDAO.getAllLibros()){
                titulo = libro.getTitulo();
                autor = libro.getAutor();
                precio = libro.getPrecio();
                disponible = libro.isDisponible();
            modelo.addRow(new Object[]{titulo, autor, precio, disponible});

        }} else { //consulta por id
            LibroDAO libroDAO = new LibroDaoImpl();
            Libro libro = libroDAO.getLibroById(id);
            titulo = libro.getTitulo();
            autor = libro.getAutor();
            precio = libro.getPrecio();
            disponible = libro.isDisponible();

            modelo.addRow(new Object[]{titulo, autor, precio, disponible});

        }
        
   
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusGained
        txtId.setText("");
    }//GEN-LAST:event_txtIdFocusGained

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
//necesito un metodo que refresque la tabla
    public void printLibrosPrueba(){
        DefaultTableModel tm = (DefaultTableModel) tblDatos.getModel();
        tm.

    }
        
    public JTable getJtable(){
        String[] colName = {"Nombre", "Autor", "Año de Publicación", "Precio", "Disponibilidad"};
        if(jTable == null){
            jTable = new JTable(){
                public boolean isCellEditable(int row, int nCol){
                    return false;
                }
            };
        }
        DefaultTableModel contactTableModel = (DefaultTableModel) jTable
            .getModel();
        contactTableModel.setColumnIdentifiers(colName);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        return jTable;
    }
}
