/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.view;

import javax.swing.border.EmptyBorder;
import sistema.controlador.UsuarioC;
import utilidad.Hover;
/**
 *
 * @author Jose Luis
 */
public class PnlClienteContainer extends javax.swing.JPanel {
    
    private int tipoFiltro = 0;
    private String datoFiltro = "";
    
    int nPnl, pnlActualClick;
    
    UsuarioC usuarioC = new UsuarioC();
    Hover hover;
    
    public PnlClienteContainer() {
        
        initComponents();
        txtCodigoCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        //Añanidor hover al menu
        nPnl = pnlOptionPersona.getComponentCount();
        hover = new Hover(nPnl, pnlOptionPersona);
        hover.menu(-1);
        
        this.setBorder(new EmptyBorder(20, 40, 40, 40));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdGrupoGenero = new javax.swing.ButtonGroup();
        rdGRupoTipo = new javax.swing.ButtonGroup();
        pnlUsuariosForm = new javax.swing.JPanel();
        pnlCodigo = new javax.swing.JPanel();
        txtCodigoCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        pnlNombre = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        pnlApellido = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtApellidoCliente = new javax.swing.JTextField();
        pnlDni = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtDniCliente = new javax.swing.JTextField();
        btnBuscarPersona = new javax.swing.JButton();
        pnlUbicacion = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        pnlGenero = new javax.swing.JPanel();
        rdGeneroMasculino = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        pnlApellido1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtDirecionCliente = new javax.swing.JTextField();
        pnlOptionPersona = new javax.swing.JPanel();
        item0 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        item1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        item2 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        item3 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        item4 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pnlContainerFiltro = new javax.swing.JPanel();
        PnlFiltro = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        txtCodigoProducto1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jcCategoriaFiltro = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPersona = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new java.awt.BorderLayout());

        pnlUsuariosForm.setMaximumSize(new java.awt.Dimension(570, 400));
        pnlUsuariosForm.setMinimumSize(new java.awt.Dimension(860, 500));
        pnlUsuariosForm.setOpaque(false);
        pnlUsuariosForm.setPreferredSize(new java.awt.Dimension(550, 300));
        pnlUsuariosForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlCodigo.setBackground(new java.awt.Color(102, 153, 255));
        pnlCodigo.setOpaque(false);
        pnlCodigo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCodigoCliente.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txtCodigoCliente.setForeground(new java.awt.Color(102, 102, 102));
        txtCodigoCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtCodigoCliente.setEnabled(false);
        txtCodigoCliente.setOpaque(false);
        pnlCodigo.add(txtCodigoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 80, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel4.setText("Codigo");
        pnlCodigo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 30));

        pnlUsuariosForm.add(pnlCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, -1));

        pnlNombre.setOpaque(false);
        pnlNombre.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel2.setText("Nombre");
        pnlNombre.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 30));

        txtNombreCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNombreCliente.setForeground(new java.awt.Color(102, 102, 102));
        txtNombreCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        txtNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreClienteActionPerformed(evt);
            }
        });
        pnlNombre.add(txtNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 180, 30));

        pnlUsuariosForm.add(pnlNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 180, -1));

        pnlApellido.setOpaque(false);
        pnlApellido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel3.setText("Apellido");
        pnlApellido.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 30));

        txtApellidoCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtApellidoCliente.setForeground(new java.awt.Color(102, 102, 102));
        txtApellidoCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        txtApellidoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoClienteActionPerformed(evt);
            }
        });
        pnlApellido.add(txtApellidoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 180, 30));

        pnlUsuariosForm.add(pnlApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 180, -1));

        pnlDni.setOpaque(false);
        pnlDni.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel6.setText("DNI");
        pnlDni.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 30));

        txtDniCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDniCliente.setForeground(new java.awt.Color(102, 102, 102));
        txtDniCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDniCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        txtDniCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniClienteActionPerformed(evt);
            }
        });
        pnlDni.add(txtDniCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 100, 30));

        btnBuscarPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btnBuscarPersona.setBorder(null);
        btnBuscarPersona.setBorderPainted(false);
        btnBuscarPersona.setContentAreaFilled(false);
        btnBuscarPersona.setFocusPainted(false);
        btnBuscarPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarPersonaMouseClicked(evt);
            }
        });
        pnlDni.add(btnBuscarPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 40, 40));

        pnlUsuariosForm.add(pnlDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 140, -1));

        pnlUbicacion.setOpaque(false);
        pnlUbicacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        pnlUbicacion.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 140, 30));

        jComboBox2.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        pnlUbicacion.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 150, 30));

        jComboBox3.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlUbicacion.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 130, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel7.setText("Ubicación");
        pnlUbicacion.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 30));

        pnlUsuariosForm.add(pnlUbicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 490, 70));

        pnlGenero.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        pnlGenero.setOpaque(false);
        pnlGenero.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rdGrupoGenero.add(rdGeneroMasculino);
        rdGeneroMasculino.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        rdGeneroMasculino.setText("Masculino");
        rdGeneroMasculino.setActionCommand("M");
        rdGeneroMasculino.setOpaque(false);
        rdGeneroMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdGeneroMasculinoActionPerformed(evt);
            }
        });
        pnlGenero.add(rdGeneroMasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        rdGrupoGenero.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jRadioButton2.setText("Femenino");
        jRadioButton2.setActionCommand("F");
        jRadioButton2.setOpaque(false);
        pnlGenero.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel10.setText("Genero");
        pnlGenero.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 70, 70));

        pnlUsuariosForm.add(pnlGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 180, 70));

        pnlApellido1.setOpaque(false);
        pnlApellido1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel5.setText("Dirección");
        pnlApellido1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 30));

        txtDirecionCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDirecionCliente.setForeground(new java.awt.Color(102, 102, 102));
        txtDirecionCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        txtDirecionCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDirecionClienteActionPerformed(evt);
            }
        });
        pnlApellido1.add(txtDirecionCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 300, 30));

        pnlUsuariosForm.add(pnlApellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 300, 60));

        add(pnlUsuariosForm, java.awt.BorderLayout.CENTER);

        pnlOptionPersona.setBackground(new java.awt.Color(204, 102, 255));
        pnlOptionPersona.setMaximumSize(new java.awt.Dimension(150, 300));
        pnlOptionPersona.setOpaque(false);
        pnlOptionPersona.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnlOptionPersonaMouseMoved(evt);
            }
        });
        pnlOptionPersona.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        item0.setBackground(new java.awt.Color(204, 204, 204));
        item0.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                item0MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                item0MouseMoved(evt);
            }
        });
        item0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                item0MouseClicked(evt);
            }
        });
        item0.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel17.setText("Guardar");
        item0.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 50, 50));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Producto/price-tag (2).png"))); // NOI18N
        item0.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 50));

        pnlOptionPersona.add(item0, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 120, 50));

        item1.setBackground(new java.awt.Color(204, 204, 204));
        item1.setEnabled(false);
        item1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                item1MouseMoved(evt);
            }
        });
        item1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                item1MouseClicked(evt);
            }
        });
        item1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel19.setText("Editar");
        item1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 50, 50));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Producto/price-tag7.png"))); // NOI18N
        item1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 50));

        pnlOptionPersona.add(item1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 120, 50));

        item2.setBackground(new java.awt.Color(204, 204, 204));
        item2.setEnabled(false);
        item2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                item2MouseMoved(evt);
            }
        });
        item2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                item2MouseClicked(evt);
            }
        });
        item2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel21.setText("Eliminar");
        item2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 50, 50));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Producto/price-tag (4).png"))); // NOI18N
        item2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 50));

        pnlOptionPersona.add(item2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 120, 50));

        item3.setBackground(new java.awt.Color(204, 204, 204));
        item3.setEnabled(false);
        item3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                item3MouseMoved(evt);
            }
        });
        item3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                item3MouseClicked(evt);
            }
        });
        item3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel23.setText("Nuevo");
        item3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 50, 50));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Producto/price-tag (1).png"))); // NOI18N
        item3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 30, 50));

        pnlOptionPersona.add(item3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 120, 50));

        item4.setBackground(new java.awt.Color(204, 204, 204));
        item4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                item4MouseMoved(evt);
            }
        });
        item4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                item4MouseClicked(evt);
            }
        });
        item4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel25.setText("Imprimir");
        item4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 50));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Producto/price-tag (6).png"))); // NOI18N
        item4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 50));

        pnlOptionPersona.add(item4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 120, 50));

        jPanel1.setOpaque(false);
        pnlOptionPersona.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 120, 30));

        add(pnlOptionPersona, java.awt.BorderLayout.LINE_END);

        pnlContainerFiltro.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        pnlContainerFiltro.setMinimumSize(new java.awt.Dimension(800, 250));
        pnlContainerFiltro.setOpaque(false);
        pnlContainerFiltro.setPreferredSize(new java.awt.Dimension(800, 250));
        pnlContainerFiltro.setLayout(new java.awt.BorderLayout());

        PnlFiltro.setMaximumSize(new java.awt.Dimension(570, 80));
        PnlFiltro.setMinimumSize(new java.awt.Dimension(570, 80));
        PnlFiltro.setOpaque(false);
        PnlFiltro.setPreferredSize(new java.awt.Dimension(570, 80));
        PnlFiltro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(102, 153, 255));
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCodigoProducto1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txtCodigoProducto1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 204)));
        txtCodigoProducto1.setOpaque(false);
        jPanel7.add(txtCodigoProducto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 180, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel16.setText("BUSCAR");
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 60, 20));

        PnlFiltro.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 180, 60));

        jcCategoriaFiltro.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jcCategoriaFiltro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcCategoriaFiltroItemStateChanged(evt);
            }
        });
        jcCategoriaFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcCategoriaFiltroActionPerformed(evt);
            }
        });
        jcCategoriaFiltro.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jcCategoriaFiltroPropertyChange(evt);
            }
        });
        jcCategoriaFiltro.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jcCategoriaFiltroVetoableChange(evt);
            }
        });
        PnlFiltro.add(jcCategoriaFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 190, 30));

        pnlContainerFiltro.add(PnlFiltro, java.awt.BorderLayout.PAGE_START);

        jtPersona.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jtPersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtPersona.setGridColor(new java.awt.Color(255, 255, 255));
        jtPersona.setRowHeight(25);
        jtPersona.setSelectionBackground(new java.awt.Color(20, 110, 214));
        jtPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtPersonaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtPersona);

        pnlContainerFiltro.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(pnlContainerFiltro, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreClienteActionPerformed

    private void txtApellidoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoClienteActionPerformed

    private void txtDniClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniClienteActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jcCategoriaFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcCategoriaFiltroItemStateChanged

    }//GEN-LAST:event_jcCategoriaFiltroItemStateChanged

    private void jcCategoriaFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcCategoriaFiltroActionPerformed

    }//GEN-LAST:event_jcCategoriaFiltroActionPerformed

    private void jcCategoriaFiltroPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jcCategoriaFiltroPropertyChange

    }//GEN-LAST:event_jcCategoriaFiltroPropertyChange

    private void jcCategoriaFiltroVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jcCategoriaFiltroVetoableChange

    }//GEN-LAST:event_jcCategoriaFiltroVetoableChange

    private void jtPersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPersonaMouseClicked
        
        int fila = jtPersona.getSelectedRow(); // el nro de fila seleccionada

        if (fila >= 0) {

            //Botones
            desactivarBotones(2);
            hover.menu(-1);

            //Campos de formularios
            txtCodigoCliente.setText(jtPersona.getValueAt(fila, 0).toString());
            txtNombreCliente.setText(jtPersona.getValueAt(fila, 1).toString());
            txtApellidoCliente.setText(jtPersona.getValueAt(fila, 1).toString());
            
//            String unidad = jtPersona.getValueAt(fila, 2).toString();
//            for (int index = 0; index < jcUnidadMedida.getItemCount(); index++) {
//                if (jcUnidadMedida.getItemAt(index).getDESUNI().equals(unidad)) {
//                    jcUnidadMedida.setSelectedIndex(index);
//                    break;
//                };
//            }
//
//            txtPrecioProducto.setText(jtPersona.getValueAt(fila, 3).toString());
//
//            String categoria = jtPersona.getValueAt(fila, 4).toString();
//            for (int index = 0; index < jtPersona.getItemCount(); index++) {
//                if (jcCategoria.getItemAt(index).getDESCAT().equals(categoria)) {
//                    jcCategoria.setSelectedIndex(index);
//                    break;
//                };
//            }

        }
        
        
    }//GEN-LAST:event_jtPersonaMouseClicked

    private void item0MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_item0MouseDragged

    }//GEN-LAST:event_item0MouseDragged

    private void item0MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_item0MouseMoved
         hover.menu(0);
    }//GEN-LAST:event_item0MouseMoved

    private void item0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_item0MouseClicked
       
    }//GEN-LAST:event_item0MouseClicked

    private void item1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_item1MouseMoved
        hover.menu(1);
    }//GEN-LAST:event_item1MouseMoved

    private void item1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_item1MouseClicked
        
    }//GEN-LAST:event_item1MouseClicked

    private void item2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_item2MouseMoved
        hover.menu(2);
    }//GEN-LAST:event_item2MouseMoved

    private void item2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_item2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_item2MouseClicked

    private void item3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_item3MouseMoved
        hover.menu(3);
    }//GEN-LAST:event_item3MouseMoved

    private void item3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_item3MouseClicked

    }//GEN-LAST:event_item3MouseClicked

    private void item4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_item4MouseMoved
        hover.menu(4);
    }//GEN-LAST:event_item4MouseMoved

    private void item4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_item4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_item4MouseClicked

    private void pnlOptionPersonaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlOptionPersonaMouseMoved
        hover.menu(-1);
    }//GEN-LAST:event_pnlOptionPersonaMouseMoved

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    

    private void rdGeneroMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdGeneroMasculinoActionPerformed

    }//GEN-LAST:event_rdGeneroMasculinoActionPerformed

    private void btnBuscarPersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarPersonaMouseClicked
        usuarioC.resPersona(txtDniCliente.getText());
    }//GEN-LAST:event_btnBuscarPersonaMouseClicked

    private void txtDirecionClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDirecionClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDirecionClienteActionPerformed

    
    
    
    private void desactivarBotones(int tipo) {

        switch (tipo) {
            case 1:
                item0.setEnabled(true);
                item1.setEnabled(false);
                item2.setEnabled(false);
                item3.setEnabled(false);
                item4.setEnabled(true);
                txtCodigoCliente.setEnabled(true);

                break;

            case 2:
                item0.setEnabled(false);
                item1.setEnabled(true);
                item2.setEnabled(true);
                item3.setEnabled(true);
                item4.setEnabled(false);
                txtCodigoCliente.setEnabled(false);

                break;

            case 3:
                item0.setEnabled(false);
                item1.setEnabled(false);
                item2.setEnabled(false);
                item3.setEnabled(false);
                item4.setEnabled(false);
                txtCodigoCliente.setEnabled(false);
                break;
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnlFiltro;
    private javax.swing.JButton btnBuscarPersona;
    private javax.swing.JPanel item0;
    private javax.swing.JPanel item1;
    private javax.swing.JPanel item2;
    private javax.swing.JPanel item3;
    private javax.swing.JPanel item4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    public static javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JComboBox jcCategoriaFiltro;
    private javax.swing.JTable jtPersona;
    private javax.swing.JPanel pnlApellido;
    private javax.swing.JPanel pnlApellido1;
    private javax.swing.JPanel pnlCodigo;
    private javax.swing.JPanel pnlContainerFiltro;
    private javax.swing.JPanel pnlDni;
    private javax.swing.JPanel pnlGenero;
    private javax.swing.JPanel pnlNombre;
    private javax.swing.JPanel pnlOptionPersona;
    private javax.swing.JPanel pnlUbicacion;
    private javax.swing.JPanel pnlUsuariosForm;
    private javax.swing.ButtonGroup rdGRupoTipo;
    public static javax.swing.JRadioButton rdGeneroMasculino;
    private javax.swing.ButtonGroup rdGrupoGenero;
    public static javax.swing.JTextField txtApellidoCliente;
    public static javax.swing.JTextField txtCodigoCliente;
    public static javax.swing.JTextField txtCodigoProducto1;
    public static javax.swing.JTextField txtDirecionCliente;
    public static javax.swing.JTextField txtDniCliente;
    public static javax.swing.JTextField txtNombreCliente;
    // End of variables declaration//GEN-END:variables
}
