/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admision;

import Menus.Menu_Principal;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Pascualon
 */
public class FichaIngreso extends javax.swing.JFrame {

    //VARIABLES GLOBALES--------------------------------------------------------
    // Hilo para la hora
    Thread h1;
    // Variables para el reloj
    String sHora, sMinutos, sSegundos, ampm;

    public FichaIngreso() {
        initComponents();
        //FECHA Y HORA----------------------------------------------------------
        // Inicio del hilo
        h1 = new Hora("Abrir reloj");
        h1.start();
        Date dFecha = new Date();
        DateFormat df = DateFormat.getDateInstance();
        lblFecha.setText(df.format(dFecha));
        //----------------------------------------------------------------------
    }

    private class Hora extends Thread {

        public Hora(String sNomProceso) {
            super(sNomProceso);
        }

        public void run() {
            Thread ct = Thread.currentThread();

            while (ct == h1) {
                calcula();
                lblHora.setText(sHora + ":" + sMinutos + ":" + sSegundos + " " + ampm);
                if (lblHora.getText().equals("00:00:00 AM")) {
                    Date dFecha = new Date();
                    DateFormat df = DateFormat.getDateInstance();
                    lblFecha.setText(df.format(dFecha));
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

            }

        }

        private void calcula() {
            Calendar calendario = new GregorianCalendar();
            Date fechaHoraActual = new Date();
            calendario.setTime(fechaHoraActual);

            ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
            if (ampm.equals("PM")) {
                int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
                sHora = h > 9 ? "" + h : "0" + h;
            } else {
                sHora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
            }
            sMinutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
            sSegundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNombreNiño = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTutor1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtDiscapacidad = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtServicioMedico = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtDomicilio = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtProcedencia = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtNombreFamiliarEmergencia = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        cbxEdadNiño = new javax.swing.JComboBox();
        cbxEdadTutor1 = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cbxSala = new javax.swing.JComboBox<String>();
        jLabel5 = new javax.swing.JLabel();
        cbxNumCuarto = new javax.swing.JComboBox<String>();
        jLabel6 = new javax.swing.JLabel();
        cbxCuota = new javax.swing.JComboBox<String>();
        jLabel7 = new javax.swing.JLabel();
        txtApellidoPaternoNiño = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtApellidoMaternoNiño = new javax.swing.JTextField();
        btnBuscarPaciente = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();

        jLabel9.setText("jLabel9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Voluntarias Vicentinas De Chihuahua A.C.");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, -1));

        jLabel2.setText("Albergue San Vicente De Paúl");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 300, 10));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("FICHA DE INGRESO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, 40));

        jLabel10.setText("Nombre del niño:");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, 20));

        txtNombreNiño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreNiñoActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombreNiño, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 290, -1));

        jLabel11.setText("Tutor 1:");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, 20));
        getContentPane().add(txtTutor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 330, -1));

        jLabel12.setText("Discapacidad:");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, 20));
        getContentPane().add(txtDiscapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 510, -1));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Servicio Médico:");
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, 20));
        getContentPane().add(txtServicioMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 500, -1));

        jLabel14.setText("Domicilio:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 60, 20));
        getContentPane().add(txtDomicilio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 500, -1));

        jLabel15.setText("Procedencia:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, 20));
        getContentPane().add(txtProcedencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 500, -1));

        jLabel16.setText("Nombre de Familiar para casos de emergencia:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, 20));

        jLabel17.setText("Edad:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, -1, 20));

        jLabel18.setText("Edad:");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, -1, 20));
        getContentPane().add(txtNombreFamiliarEmergencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 310, -1));

        jLabel19.setText("Teléfono:");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, 20));
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 220, -1));

        jLabel20.setText("Celular:");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, -1, 20));
        getContentPane().add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 410, 250, -1));

        cbxEdadNiño.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Edad", "Maternal", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110" }));
        getContentPane().add(cbxEdadNiño, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 160, -1));

        cbxEdadTutor1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Edad", "Maternal", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110" }));
        getContentPane().add(cbxEdadTutor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 160, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel21.setText("FAMILIARES QUE LO ACOMPAÑAN");
        jLabel21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, 240, 40));

        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 20, 100, 20));

        jLabel22.setText("Fecha:");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, -1, 20));

        jLabel23.setText("Hora:");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 60, 40, 20));

        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHora.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 60, 100, 20));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido Paterno", "Apellido Materno", "Parentesco", "Edad"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, -1, 100));

        jLabel4.setText("Sala:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 360, -1, 20));

        cbxSala.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione sala" }));
        getContentPane().add(cbxSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 360, -1, -1));

        jLabel5.setText("Núm. Cuarto:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 360, -1, 20));

        cbxNumCuarto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Número cuarto" }));
        getContentPane().add(cbxNumCuarto, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 360, -1, -1));

        jLabel6.setText("Cuóta $:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 360, -1, 20));

        cbxCuota.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cuóta" }));
        getContentPane().add(cbxCuota, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 360, -1, -1));

        jLabel7.setText("Apellido paterno:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, 20));
        getContentPane().add(txtApellidoPaternoNiño, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 160, -1));

        jLabel8.setText("Apellido materno:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, -1, 20));
        getContentPane().add(txtApellidoMaternoNiño, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 200, 230, -1));

        btnBuscarPaciente.setText("Buscar ");
        btnBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPacienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 110, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 300, 460, 10));

        jLabel24.setText("jLabel24");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 460, 50, 50));

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreNiñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreNiñoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreNiñoActionPerformed

    private void btnBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPacienteActionPerformed
        // TODO add your handling code here:
        Busqueda_Huesped b = new Busqueda_Huesped();
        b.setVisible(true);
        Busqueda_Huesped.lblTipo.setText("FichaIngreso");
    }//GEN-LAST:event_btnBuscarPacienteActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        Menus.Menu_Principal m = new Menu_Principal();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(FichaIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FichaIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FichaIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FichaIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FichaIngreso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarPaciente;
    public static javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbxCuota;
    public static javax.swing.JComboBox cbxEdadNiño;
    public static javax.swing.JComboBox cbxEdadTutor1;
    private javax.swing.JComboBox<String> cbxNumCuarto;
    private javax.swing.JComboBox<String> cbxSala;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    public static javax.swing.JLabel lblFecha;
    public static javax.swing.JLabel lblHora;
    public static javax.swing.JTextField txtApellidoMaternoNiño;
    public static javax.swing.JTextField txtApellidoPaternoNiño;
    public static javax.swing.JTextField txtCelular;
    public static javax.swing.JTextField txtDiscapacidad;
    public static javax.swing.JTextField txtDomicilio;
    public static javax.swing.JTextField txtNombreFamiliarEmergencia;
    public static javax.swing.JTextField txtNombreNiño;
    public static javax.swing.JTextField txtProcedencia;
    public static javax.swing.JTextField txtServicioMedico;
    public static javax.swing.JTextField txtTelefono;
    public static javax.swing.JTextField txtTutor1;
    // End of variables declaration//GEN-END:variables
}
