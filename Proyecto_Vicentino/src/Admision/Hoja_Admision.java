/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admision;

import Herramientas.conectar;
import Menus.Menu_Principal;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DateFormat;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author luis
 */
public class Hoja_Admision extends javax.swing.JFrame {

    // VARIABLES GLOBALES
    DateFormat df = DateFormat.getDateInstance();
    public byte[] foto;

    /**
     * Creates new form Hoja_Admision
     */
    public Hoja_Admision() {
        initComponents();
        SinLetras(txtTelCasaTutor);
        SinLetras(txtTelFamiliar1);
        SinLetras(txtTelFamiliar2);
        SinLetras(txtCelFamiliar1);
        SinLetras(txtCelFamiliar2);
        SinLetras(txtCelTutor);
        SinNumeros(txtNombreNiño);
        SinNumeros(txtNombreTutor);
        SinNumeros(txtAcompañante1);
        SinNumeros(txtAcompañante2);
        SinNumeros(txtAlergia);
        SinNumeros(txtDiagnostico);
        SinNumeros(txtFamiliar1);
        SinNumeros(txtFamiliar2);
        SinNumeros(txtParentesco1);
        SinNumeros(txtParentesco2);
    }

    //METODOS PARA FOTO
    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    // Metodo para guardar los datos Hoja_Admision

    public void GuardarDatosHoja_Admision() {

        String sql;

        int sidHuesped = ControlLlavePrimaria();
        conectar cc = new conectar();
        Connection cn = cc.conexion();
        String sNombreNiño = txtNombreNiño.getText();
        String sApellidoPaterno = txtApPaternoNiño.getText();
        String sApellidoMaterno = txtApMaternoNiño.getText();
        String sEdadNiño = String.valueOf(cbxEdadNiño.getSelectedItem());
        String sSangre = String.valueOf(cbxSangre.getSelectedItem());
        String sFechaNiño = df.format(jfcFechaNiño.getDate());
        String sEscolaridadNiño = String.valueOf(cbxEscolaridad.getSelectedItem());
        String sExtensionCorreo = String.valueOf(cbxCorreo.getSelectedItem());
        String sCorreoNiño = (txtCorreo.getText() + sExtensionCorreo);
        String sDiagnosticoNiño = txtDiagnostico.getText();
        String sServicioMedico = txtServicioMedico.getText();
        String sAlergiaNiño = txtAlergia.getText();
        String sTerapiaNiño = txtTerapias.getText();
        String sDuracionNiño = txtDuracion.getText();
        String sObservaciones1 = txpObservaciones1.getText();
        String sNombreTutor = txtNombreTutor.getText();
        String sEdadTutor = String.valueOf(cbxEdadTutor.getSelectedItem());
        String sDireccionTutor = txtDireccionTutor.getText();
        String sMunicipioTutor = String.valueOf(cbxMunicipio.getSelectedItem());
        String sCPTutor = txtCPTutor.getText();
        String sTelCasaTutor = txtTelCasaTutor.getText();
        String sCelTutor = txtCelTutor.getText();
        String sNombreFamiliar1 = txtFamiliar1.getText();
        String sTelFamiliar1 = txtTelFamiliar1.getText();
        String sCelFamiliar1 = txtCelFamiliar1.getText();
        String sNombreFamiliar2 = txtFamiliar2.getText();
        String sTelFamiliar2 = txtTelFamiliar2.getText();
        String sCelFamiliar2 = txtCelFamiliar2.getText();
        String sAcom1 = txtAcompañante1.getText();
        String sParentesco1 = txtParentesco1.getText();
        String sEdadAcom1 = String.valueOf(cbxEdadAcompañante1.getSelectedItem());
        String sAcom2 = txtAcompañante2.getText();
        String sParentesco2 = txtParentesco2.getText();
        String sEdadAcom2 = String.valueOf(cbxEdadAcompañante2.getSelectedItem());
        String sObservaciones2 = txpObservaciones2.getText();
        String sTiempoAlbergue = txtTiempoAlbergue.getText();
        String sTiempoCRIT = txtTiempoCRIT.getText();
        //GUARDAR RUTA EN UN ARCHIVO
        File f = new File(lblRuta.getText());
        //CONVERTIR IMAGEN A BITS
        try {
            byte[] icono = new byte[(int) f.length()];
            InputStream input = new FileInputStream(f);
            input.read(icono);
            setFoto(icono);
        } catch (Exception ex) {
            setFoto(null);
            ex.printStackTrace();
        }

        sql = "INSERT INTO admision_hojaadmision (idNumHuesped,NombreNiño,Apellido_PaternoNiño,Apellido_MaternoNiño,EdadNiño,SangreNiño,FechaNiño,EscolaridadNiño,CorreoNiño,DiagnosticoNiño,ServicioMedicoNiño,AlergiaNiño,TerapiasNiño,DuracionNiño,Observaciones1,NombreTutor,EdadTutor,DireccionTutor,MunicipioTutor,CPTutor,TelCasaTutor,CelTutor,NombreFamiliar1,TelFamiliar1,CelFamiliar1,NombreFamiliar2,TelFamiliar2,CelFamiliar2,NombreAcom1,ParentescoAcom1,EdadAcom1,NombreAcom2,ParentescoAcom2,EdadAcom2,Observaciones2,TiempoAlbergue,TiempoCRIT,FotoNiño) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sql);

            pst.setInt(1, sidHuesped);
            pst.setString(2, sNombreNiño);
            pst.setString(3, sApellidoPaterno);
            pst.setString(4, sApellidoMaterno);
            pst.setString(5, sEdadNiño);
            pst.setString(6, sSangre);
            pst.setString(7, sFechaNiño);
            pst.setString(8, sEscolaridadNiño);
            pst.setString(9, sCorreoNiño);
            pst.setString(10, sDiagnosticoNiño);
            pst.setString(11, sServicioMedico);
            pst.setString(12, sAlergiaNiño);
            pst.setString(13, sTerapiaNiño);
            pst.setString(14, sDuracionNiño);
            pst.setString(15, sObservaciones1);
            pst.setString(16, sNombreTutor);
            pst.setString(17, sEdadTutor);
            pst.setString(18, sDireccionTutor);
            pst.setString(19, sMunicipioTutor);
            pst.setString(20, sCPTutor);
            pst.setString(21, sTelCasaTutor);
            pst.setString(22, sCelTutor);
            pst.setString(23, sNombreFamiliar1);
            pst.setString(24, sTelFamiliar1);
            pst.setString(25, sCelFamiliar1);
            pst.setString(26, sNombreFamiliar2);
            pst.setString(27, sTelFamiliar2);
            pst.setString(28, sCelFamiliar2);
            pst.setString(29, sAcom1);
            pst.setString(30, sParentesco1);
            pst.setString(31, sEdadAcom1);
            pst.setString(32, sAcom2);
            pst.setString(33, sParentesco2);
            pst.setString(34, sEdadAcom2);
            pst.setString(35, sObservaciones2);
            pst.setString(36, sTiempoAlbergue);
            pst.setString(37, sTiempoCRIT);
            pst.setBytes(38, getFoto());

            int n = pst.executeUpdate();
            if (n > 0) {
            }
            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar " + e);
        }
    }

    public int ControlLlavePrimaria() {
        int i = 1;
        conectar cc = new conectar();
        Connection cn = cc.conexion();
        String sql = "SELECT MAX(idNumHuesped) as NumMaximo FROM admision_hojaadmision";
        try {
            java.sql.Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                i = rs.getInt("NumMaximo");
            }
            cn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Consultar tipo " + ex);
            ex.printStackTrace();
        }
        return i + 1;

    }

    //Metodo para limpiar toda la tabla
    public void Limpiar_Hoja_Admision() {
        txtNombreNiño.setText("");
        txtApPaternoNiño.setText("");
        txtApMaternoNiño.setText("");
        cbxEdadNiño.setSelectedItem("Seleccione Edad");
        cbxSangre.setSelectedItem("Tipo de sangre");
        jfcFechaNiño.setDateFormatString("");
        cbxEscolaridad.setSelectedItem("Seleccione Escolaridad");
        cbxCorreo.setSelectedItem("Seleccione Correo");
        txtCorreo.setText("");
        txtDiagnostico.setText("");
        txtServicioMedico.setText("");
        txtAlergia.setText("");
        txtTerapias.setText("");
        txtDuracion.setText("");
        txpObservaciones1.setText("");
        txtNombreTutor.setText("");
        cbxEdadTutor.setSelectedItem("Seleccione Edad");
        txtDireccionTutor.setText("");
        cbxMunicipio.setSelectedItem("Seleccione Municipio");
        txtCPTutor.setText("");
        txtTelCasaTutor.setText("");
        txtCelTutor.setText("");
        txtFamiliar1.setText("");
        txtTelFamiliar1.setText("");
        txtCelFamiliar1.setText("");
        txtFamiliar2.setText("");
        txtTelFamiliar2.setText("");
        txtCelFamiliar2.setText("");
        txtAcompañante1.setText("");
        txtParentesco1.setText("");
        cbxEdadAcompañante1.setSelectedItem("Seleccione Edad");
        txtAcompañante2.setText("");
        txtParentesco2.setText("");
        cbxEdadAcompañante2.setSelectedItem("Seleccione Edad");
        txpObservaciones2.setText("");
        txtTiempoAlbergue.setText("");
        txtTiempoCRIT.setText("");
        lblRuta.setText("");
        lblFoto.setIcon(null);
    }

    // Metodo para leer las imagenes
    public byte[] AbrirImagen(File f) {
        FileInputStream fiImagen;
        Long l = f.length();
        Integer iTam = l.intValue();

        byte[] bIma = new byte[iTam];
        try {
            fiImagen = new FileInputStream(f);
            fiImagen.read(bIma);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tipo: " + e);
        }
        return bIma;
    }

    // Metodos para proteccion de escritura

    public void SinLetras(JTextField x) {
        x.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
    }

    // Metodo para evitar las Numeros en un JTextField
    public void SinNumeros(JTextField x) {
        x.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c)) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtApMaternoNiño = new javax.swing.JTextField();
        txtDiagnostico = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtServicioMedico = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtAlergia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTerapias = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDuracion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txpObservaciones1 = new javax.swing.JTextPane();
        jLabel11 = new javax.swing.JLabel();
        jfcFechaNiño = new com.toedter.calendar.JDateChooser();
        lblFoto = new javax.swing.JLabel();
        cbxEdadAcompañante2 = new javax.swing.JComboBox();
        cbxEscolaridad = new javax.swing.JComboBox();
        cbxCorreo = new javax.swing.JComboBox();
        btnOtroCorreo = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        cbxSangre = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtNombreTutor = new javax.swing.JTextField();
        txtDireccionTutor = new javax.swing.JTextField();
        txtCPTutor = new javax.swing.JTextField();
        txtTelCasaTutor = new javax.swing.JTextField();
        txtCelTutor = new javax.swing.JTextField();
        txtFamiliar2 = new javax.swing.JTextField();
        txtFamiliar1 = new javax.swing.JTextField();
        txtTelFamiliar2 = new javax.swing.JTextField();
        txtTelFamiliar1 = new javax.swing.JTextField();
        txtCelFamiliar2 = new javax.swing.JTextField();
        txtCelFamiliar1 = new javax.swing.JTextField();
        txtAcompañante2 = new javax.swing.JTextField();
        txtAcompañante1 = new javax.swing.JTextField();
        txtParentesco2 = new javax.swing.JTextField();
        txtParentesco1 = new javax.swing.JTextField();
        cbxEdadNiño = new javax.swing.JComboBox();
        cbxEdadTutor = new javax.swing.JComboBox();
        cbxEdadAcompañante1 = new javax.swing.JComboBox();
        cbxMunicipio = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        txpObservaciones2 = new javax.swing.JTextPane();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txtTiempoCRIT = new javax.swing.JTextField();
        txtTiempoAlbergue = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        lblRuta = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        txtNombreNiño = new javax.swing.JTextField();
        txtApPaternoNiño = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("*Nombre del niño (a):");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 120, 20));
        getContentPane().add(txtApMaternoNiño, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 110, -1));
        getContentPane().add(txtDiagnostico, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 580, -1));

        jLabel2.setText("*Diagnostico: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 80, 20));

        jLabel3.setText("*Escolaridad:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 90, 20));

        jLabel4.setText("*Fecha de nacimiento:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 130, 20));
        getContentPane().add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 100, -1));

        jLabel5.setText("*Edad:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 60, 20));

        jLabel6.setText("*Servicio Médico: ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 120, 20));
        getContentPane().add(txtServicioMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 160, -1));

        jLabel7.setText("Alérgico a:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 70, 20));
        getContentPane().add(txtAlergia, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, 190, -1));

        jLabel8.setText("Programación de terapias:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 150, 20));
        getContentPane().add(txtTerapias, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 160, -1));

        jLabel9.setText("*Duración: ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 70, 20));
        getContentPane().add(txtDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 310, 190, -1));

        jLabel10.setText("Observaciones:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 100, 20));

        jScrollPane1.setViewportView(txpObservaciones1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 650, 80));

        jLabel11.setText("Correo electronico: ");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 110, 20));
        getContentPane().add(jfcFechaNiño, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 190, 140, -1));

        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFotoMouseClicked(evt);
            }
        });
        getContentPane().add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 530, 140, 150));

        cbxEdadAcompañante2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Edad", "Maternal", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110" }));
        getContentPane().add(cbxEdadAcompañante2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 380, 150, -1));

        cbxEscolaridad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Escolaridad", "Sin Educación Formal", "Educación Preescolar", "Educación Primaria", "Educación Secundaria", "Bachillerato / Preparatoria", "Carrera Tecnica", "Licenciatura / Posgrado" }));
        getContentPane().add(cbxEscolaridad, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 170, -1));

        cbxCorreo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Correo", "@hotmail.com", "@gmail.com", "@outlook.com", "@yahoo.com", "@yahoo.com.mx", "@live.com", "@live.com.mx" }));
        getContentPane().add(cbxCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 150, -1));

        btnOtroCorreo.setText("...");
        getContentPane().add(btnOtroCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 220, 30, 20));

        jLabel13.setText("Tipo de sangre:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 90, 20));

        cbxSangre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipo de sangre", "O-", "O+", "A-", "A+", "B+", "B-", "AB-", "AB+", " " }));
        getContentPane().add(cbxSangre, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 120, -1));

        jLabel14.setText("Nombre del tutor:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 160, -1, -1));

        jLabel15.setText("Edad:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 160, -1, 20));

        jLabel16.setText("Dirección:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 190, -1, 20));

        jLabel17.setText("Código postal:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, -1, 20));

        jLabel18.setText("2.");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 300, -1, 20));

        jLabel19.setText("Cel.:");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 300, -1, 20));

        jLabel20.setText("Tel. Casa:");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 220, -1, 20));

        jLabel21.setText("Municipio: ");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 190, -1, 20));

        jLabel22.setText("Personas que acompañan y parentesco:");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 330, -1, 20));

        jLabel23.setText("1.");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 270, -1, 20));

        jLabel24.setText("Cel.:");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 220, -1, 20));

        jLabel25.setText("Tel.:");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 300, -1, 20));

        jLabel26.setText("Cel.:");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 270, -1, 20));

        jLabel27.setText("Tel.:");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 270, -1, 20));

        jLabel28.setText("Nombre de dos familiares para avisar en caso de emergencia:");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 250, -1, 20));

        jLabel29.setText("1.");
        getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 350, -1, 20));

        jLabel30.setText("2.");
        getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 380, -1, 20));

        jLabel31.setText(",");
        getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 350, -1, 20));

        jLabel32.setText(",");
        getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 380, 20, 20));

        jLabel33.setText("Edad:");
        getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 380, -1, 20));

        jLabel34.setText("Edad:");
        getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 350, -1, 20));
        getContentPane().add(txtNombreTutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 160, 300, -1));
        getContentPane().add(txtDireccionTutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 190, 300, -1));
        getContentPane().add(txtCPTutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 220, 90, -1));
        getContentPane().add(txtTelCasaTutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 220, 140, -1));
        getContentPane().add(txtCelTutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 220, 130, 20));
        getContentPane().add(txtFamiliar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 300, 260, 20));
        getContentPane().add(txtFamiliar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 270, 260, 20));
        getContentPane().add(txtTelFamiliar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 300, 130, 20));
        getContentPane().add(txtTelFamiliar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 270, 130, 20));
        getContentPane().add(txtCelFamiliar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 300, 130, 20));
        getContentPane().add(txtCelFamiliar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 270, 130, 20));
        getContentPane().add(txtAcompañante2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 380, 190, 20));
        getContentPane().add(txtAcompañante1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 350, 190, 20));
        getContentPane().add(txtParentesco2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 380, 200, 20));
        getContentPane().add(txtParentesco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 350, 200, 20));

        cbxEdadNiño.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Edad", "Maternal", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110" }));
        getContentPane().add(cbxEdadNiño, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 130, -1));

        cbxEdadTutor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Edad", "Maternal", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110" }));
        getContentPane().add(cbxEdadTutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 160, 150, -1));

        cbxEdadAcompañante1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Edad", "Maternal", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110" }));
        getContentPane().add(cbxEdadAcompañante1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 350, 150, -1));

        cbxMunicipio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Municipio", "Ahumada", "Aldama", "Allende", "Aquiles Serdán", "Ascensión", "Bachíniva", "Balleza", "Batopilas", "Bocoyna", "Buenaventura", "Camargo", "Carichí", "Casas Grandes", "Chihuahua", "Chínipas", "Coronado", "Coyame del Sotol", "Cuauhtémoc", "Cusihuiriachi", "Delicias", "Dr. Belisario Domínguez", "El Tule", "Galeana", "Gómez Farías", "Gran Morelos", "Guachochi", "Guadalupe", "Guadalupe y Calvo", "Guazapares", "Guerrero", "Hidalgo del Parral", "Huejotitán", "Ignacio Zaragoza", "Janos", "Jiménez", "Juárez", "Julimes", "La Cruz", "López", "Madera", "Maguarichi", "Manuel Benavides", "Matachí", "Matamoros", "Meoqui", "Morelos", "Moris", "Namiquipa", "Nonoava", "Nuevo Casas Grandes", "Ocampo", "Ojinaga", "Praxedis G. Guerrero", "Riva Palacio", "Rosales", "Rosario", "San Francisco de Borja", "San Francisco de Conchos", "San Francisco del Oro", "Santa Bárbara", "Santa Isabel", "Satevó", "Saucillo", "Temósachi", "Urique", "Uruachi", "Valle de Zaragoza" }));
        getContentPane().add(cbxMunicipio, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 190, 150, -1));

        jScrollPane2.setViewportView(txpObservaciones2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 430, 620, 80));

        jLabel35.setText("Observaciones:");
        getContentPane().add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 400, 100, 20));

        jLabel36.setText("Tiempo asistiendo al CRIT: ");
        getContentPane().add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 580, -1, 20));

        jLabel37.setText("Tiempo asistiendo al albergue: ");
        getContentPane().add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 540, -1, 20));
        getContentPane().add(txtTiempoCRIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 580, 130, -1));
        getContentPane().add(txtTiempoAlbergue, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 540, 130, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 630, 170, 40));

        jLabel12.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N
        jLabel12.setText("Ave. Industrial II N° 7814, Fracc. Industrual Robinson CP 31384 Tél. 420");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 530, 20));

        jLabel38.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        jLabel38.setText("VOLUNTARIAS VICENTINAS DE CHIHUAHUA A.C.");
        getContentPane().add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 480, 20));

        jLabel39.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N
        jLabel39.setText("Chihuahua, Chih.");
        getContentPane().add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, 140, 20));

        jLabel40.setFont(new java.awt.Font("Yu Gothic Medium", 1, 24)); // NOI18N
        jLabel40.setText("ALBERGUE SAN VICENTE DE PAUL");
        getContentPane().add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 500, 20));

        jLabel41.setBackground(new java.awt.Color(0, 0, 0));
        jLabel41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 48, 1420, -1));

        lblRuta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 690, 140, 20));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 100, 30));

        jLabel42.setText("Ap Materno:");
        getContentPane().add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 70, 20));

        txtNombreNiño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreNiñoActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombreNiño, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 160, -1));
        getContentPane().add(txtApPaternoNiño, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 110, -1));

        jLabel43.setText("*Ap Paterno:");
        getContentPane().add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 70, 20));

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 90, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (!txtNombreNiño.getText().equals("")) {
            GuardarDatosHoja_Admision();
            JOptionPane.showMessageDialog(null, "GUARDADO.");
            Limpiar_Hoja_Admision();
        } else {
            JOptionPane.showMessageDialog(null, "NO DEJE LOS ESPACIOS MARCADOS EN BLANCO.");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void lblFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFotoMouseClicked
        // TODO add your handling code here:
        JFileChooser jfFoto = new JFileChooser();
        File fArchivo;
        byte[] bBytesImagenes;

        if (jfFoto.showDialog(null, "Elegir Foto") == JFileChooser.APPROVE_OPTION) {
            fArchivo = jfFoto.getSelectedFile();
            if (fArchivo.canRead()) {
                if (fArchivo.getName().endsWith("jpg") || fArchivo.getName().endsWith("png") || fArchivo.getName().endsWith("JPG") || fArchivo.getName().endsWith("PNG")) {
                    bBytesImagenes = AbrirImagen(fArchivo);
                    ImageIcon iIcon = new ImageIcon(bBytesImagenes);
                    ImageIcon iImagen = new ImageIcon(iIcon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
                    lblFoto.setIcon(iImagen);
                    String sRuta = jfFoto.getSelectedFile().getAbsolutePath();
                    lblRuta.setText(sRuta);
                } else {
                    JOptionPane.showMessageDialog(null, "Extension de imagen invalida");
                }
            }
        }
    }//GEN-LAST:event_lblFotoMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        Busqueda_Huesped b = new Busqueda_Huesped();
        b.setVisible(true);
        Busqueda_Huesped.lblTipo.setText("HojaAdmision");
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Menus.Menu_Principal m = new Menu_Principal();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Limpiar_Hoja_Admision();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtNombreNiñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreNiñoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreNiñoActionPerformed

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
            java.util.logging.Logger.getLogger(Hoja_Admision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hoja_Admision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hoja_Admision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hoja_Admision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hoja_Admision().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnOtroCorreo;
    public static javax.swing.JComboBox cbxCorreo;
    public static javax.swing.JComboBox cbxEdadAcompañante1;
    public static javax.swing.JComboBox cbxEdadAcompañante2;
    public static javax.swing.JComboBox cbxEdadNiño;
    public static javax.swing.JComboBox cbxEdadTutor;
    public static javax.swing.JComboBox cbxEscolaridad;
    public static javax.swing.JComboBox cbxMunicipio;
    public static javax.swing.JComboBox cbxSangre;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static com.toedter.calendar.JDateChooser jfcFechaNiño;
    public static javax.swing.JLabel lblFoto;
    public static javax.swing.JLabel lblRuta;
    public static javax.swing.JTextPane txpObservaciones1;
    public static javax.swing.JTextPane txpObservaciones2;
    public static javax.swing.JTextField txtAcompañante1;
    public static javax.swing.JTextField txtAcompañante2;
    public static javax.swing.JTextField txtAlergia;
    public static javax.swing.JTextField txtApMaternoNiño;
    public static javax.swing.JTextField txtApPaternoNiño;
    public static javax.swing.JTextField txtCPTutor;
    public static javax.swing.JTextField txtCelFamiliar1;
    public static javax.swing.JTextField txtCelFamiliar2;
    public static javax.swing.JTextField txtCelTutor;
    public static javax.swing.JTextField txtCorreo;
    public static javax.swing.JTextField txtDiagnostico;
    public static javax.swing.JTextField txtDireccionTutor;
    public static javax.swing.JTextField txtDuracion;
    public static javax.swing.JTextField txtFamiliar1;
    public static javax.swing.JTextField txtFamiliar2;
    public static javax.swing.JTextField txtNombreNiño;
    public static javax.swing.JTextField txtNombreTutor;
    public static javax.swing.JTextField txtParentesco1;
    public static javax.swing.JTextField txtParentesco2;
    public static javax.swing.JTextField txtServicioMedico;
    public static javax.swing.JTextField txtTelCasaTutor;
    public static javax.swing.JTextField txtTelFamiliar1;
    public static javax.swing.JTextField txtTelFamiliar2;
    public static javax.swing.JTextField txtTerapias;
    public static javax.swing.JTextField txtTiempoAlbergue;
    public static javax.swing.JTextField txtTiempoCRIT;
    // End of variables declaration//GEN-END:variables
}
