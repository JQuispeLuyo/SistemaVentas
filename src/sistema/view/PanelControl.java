package sistema.view;

import static com.sun.deploy.trace.TraceLevel.UI;
import java.awt.Color;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import sistema.modelo.LoginM;

public class PanelControl extends javax.swing.JFrame {

    LoginM loginM;
    int posx,posy;
    int nPnl,pnlActualClick;
    
    @SuppressWarnings("empty-statement")
    public PanelControl() {
        
        loginM = LoginM.getInstance();
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
                if("Windows".equals(info.getName())){
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }   
        } catch (Exception e) {    
        }
        initComponents();
        pnlActualClick = 0;
        
        nPnl = pnlMenuOptions.getComponentCount();
        pnlInicio.setOpaque(true);
        for (int i = 0; i < nPnl; i++) {
            pnlMenuOptions.getComponent(i).setBackground(pnlMenu.getBackground());
        }
        this.setLocationRelativeTo(null);
        lblUsername.setText(loginM.getUser());
        hoverMenu(0);
    }
    
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        pnlMenu = new javax.swing.JPanel();
        pnlInfoUser = new javax.swing.JPanel();
        imgUser = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        pnlMenuOptions = new javax.swing.JPanel();
        pnlInicio = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pnlItem2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlItem3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        pnlItem4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pnlItem5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pnlItem6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        pnlItem7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        pnlCabezera = new javax.swing.JPanel();
        pnlAcceso = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        btnMinimizar = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        pnlPrincipal = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jScrollPane3.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 650));
        setMinimumSize(new java.awt.Dimension(800, 650));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMenu.setBackground(new java.awt.Color(41, 124, 214));
        pnlMenu.setAlignmentX(0.0F);
        pnlMenu.setAlignmentY(0.0F);
        pnlMenu.setMaximumSize(new java.awt.Dimension(200, 500));
        pnlMenu.setMinimumSize(new java.awt.Dimension(200, 500));
        pnlMenu.setName(""); // NOI18N
        pnlMenu.setPreferredSize(new java.awt.Dimension(200, 500));
        pnlMenu.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnlMenuMouseMoved(evt);
            }
        });

        pnlInfoUser.setOpaque(false);

        imgUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/man.png"))); // NOI18N

        lblUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(237, 237, 237));
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsername.setText("Jose luis");
        lblUsername.setToolTipText("");
        lblUsername.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        pnlMenuOptions.setOpaque(false);

        pnlInicio.setBackground(new java.awt.Color(153, 153, 153));
        pnlInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlInicio.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnlInicioMouseMoved(evt);
            }
        });
        pnlInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlInicioMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Inicio");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N

        javax.swing.GroupLayout pnlInicioLayout = new javax.swing.GroupLayout(pnlInicio);
        pnlInicio.setLayout(pnlInicioLayout);
        pnlInicioLayout.setHorizontalGroup(
            pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlInicioLayout.setVerticalGroup(
            pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlItem2.setBackground(new java.awt.Color(153, 153, 153));
        pnlItem2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlItem2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnlItem2MouseMoved(evt);
            }
        });
        pnlItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlItem2MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Entrada");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N

        javax.swing.GroupLayout pnlItem2Layout = new javax.swing.GroupLayout(pnlItem2);
        pnlItem2.setLayout(pnlItem2Layout);
        pnlItem2Layout.setHorizontalGroup(
            pnlItem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlItem2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(13, 13, 13)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlItem2Layout.setVerticalGroup(
            pnlItem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlItem3.setBackground(new java.awt.Color(153, 153, 153));
        pnlItem3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlItem3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnlItem3MouseMoved(evt);
            }
        });
        pnlItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlItem3MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Usuarios");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N

        javax.swing.GroupLayout pnlItem3Layout = new javax.swing.GroupLayout(pnlItem3);
        pnlItem3.setLayout(pnlItem3Layout);
        pnlItem3Layout.setHorizontalGroup(
            pnlItem3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlItem3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlItem3Layout.setVerticalGroup(
            pnlItem3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlItem4.setBackground(new java.awt.Color(153, 153, 153));
        pnlItem4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlItem4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnlItem4MouseMoved(evt);
            }
        });
        pnlItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlItem4MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Empresa");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N

        javax.swing.GroupLayout pnlItem4Layout = new javax.swing.GroupLayout(pnlItem4);
        pnlItem4.setLayout(pnlItem4Layout);
        pnlItem4Layout.setHorizontalGroup(
            pnlItem4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlItem4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlItem4Layout.setVerticalGroup(
            pnlItem4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlItem5.setBackground(new java.awt.Color(153, 153, 153));
        pnlItem5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlItem5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnlItem5MouseMoved(evt);
            }
        });
        pnlItem5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlItem5MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Provedores");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N

        javax.swing.GroupLayout pnlItem5Layout = new javax.swing.GroupLayout(pnlItem5);
        pnlItem5.setLayout(pnlItem5Layout);
        pnlItem5Layout.setHorizontalGroup(
            pnlItem5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlItem5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlItem5Layout.setVerticalGroup(
            pnlItem5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlItem6.setBackground(new java.awt.Color(153, 153, 153));
        pnlItem6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlItem6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnlItem6MouseMoved(evt);
            }
        });
        pnlItem6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlItem6MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Configuracion");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N

        javax.swing.GroupLayout pnlItem6Layout = new javax.swing.GroupLayout(pnlItem6);
        pnlItem6.setLayout(pnlItem6Layout);
        pnlItem6Layout.setHorizontalGroup(
            pnlItem6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlItem6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        pnlItem6Layout.setVerticalGroup(
            pnlItem6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlItem7.setBackground(new java.awt.Color(153, 153, 153));
        pnlItem7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlItem7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnlItem7MouseMoved(evt);
            }
        });
        pnlItem7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlItem7MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Cerrar sesión");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N

        javax.swing.GroupLayout pnlItem7Layout = new javax.swing.GroupLayout(pnlItem7);
        pnlItem7.setLayout(pnlItem7Layout);
        pnlItem7Layout.setHorizontalGroup(
            pnlItem7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlItem7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlItem7Layout.setVerticalGroup(
            pnlItem7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlMenuOptionsLayout = new javax.swing.GroupLayout(pnlMenuOptions);
        pnlMenuOptions.setLayout(pnlMenuOptionsLayout);
        pnlMenuOptionsLayout.setHorizontalGroup(
            pnlMenuOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlItem2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlItem3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlItem4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlItem5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlItem6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlItem7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlMenuOptionsLayout.setVerticalGroup(
            pnlMenuOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuOptionsLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(pnlInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlItem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlItem3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlItem4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlItem5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlItem6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlItem7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlInfoUserLayout = new javax.swing.GroupLayout(pnlInfoUser);
        pnlInfoUser.setLayout(pnlInfoUserLayout);
        pnlInfoUserLayout.setHorizontalGroup(
            pnlInfoUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInfoUserLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imgUser)
                .addGap(67, 67, 67))
            .addGroup(pnlInfoUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInfoUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMenuOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlInfoUserLayout.setVerticalGroup(
            pnlInfoUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoUserLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(imgUser, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlMenuOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInfoUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addComponent(pnlInfoUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        getContentPane().add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 650));

        pnlCabezera.setBackground(new java.awt.Color(255, 255, 255));
        pnlCabezera.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(41, 124, 214)));
        pnlCabezera.setMaximumSize(new java.awt.Dimension(800, 50));
        pnlCabezera.setMinimumSize(new java.awt.Dimension(800, 50));
        pnlCabezera.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlCabezeraMouseDragged(evt);
            }
        });
        pnlCabezera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlCabezeraMousePressed(evt);
            }
        });

        pnlAcceso.setBackground(new java.awt.Color(255, 255, 255));
        pnlAcceso.setMaximumSize(new java.awt.Dimension(100, 45));
        pnlAcceso.setMinimumSize(new java.awt.Dimension(100, 45));
        pnlAcceso.setPreferredSize(new java.awt.Dimension(100, 45));
        pnlAcceso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cerrar.png"))); // NOI18N
        btnCerrar.setBorder(null);
        btnCerrar.setBorderPainted(false);
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.setFocusPainted(false);
        btnCerrar.setMargin(null);
        btnCerrar.setMaximumSize(new java.awt.Dimension(35, 35));
        btnCerrar.setMinimumSize(new java.awt.Dimension(35, 35));
        btnCerrar.setPreferredSize(new java.awt.Dimension(35, 35));
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        pnlAcceso.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 40, 50));

        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Minimize.png"))); // NOI18N
        btnMinimizar.setBorder(null);
        btnMinimizar.setBorderPainted(false);
        btnMinimizar.setContentAreaFilled(false);
        btnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimizar.setFocusPainted(false);
        btnMinimizar.setMargin(null);
        btnMinimizar.setMaximumSize(new java.awt.Dimension(35, 35));
        btnMinimizar.setMinimumSize(new java.awt.Dimension(35, 35));
        btnMinimizar.setPreferredSize(new java.awt.Dimension(35, 35));
        btnMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizarActionPerformed(evt);
            }
        });
        pnlAcceso.add(btnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 40, 50));

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(41, 124, 214));
        lblTitle.setText("Administrador");

        javax.swing.GroupLayout pnlCabezeraLayout = new javax.swing.GroupLayout(pnlCabezera);
        pnlCabezera.setLayout(pnlCabezeraLayout);
        pnlCabezeraLayout.setHorizontalGroup(
            pnlCabezeraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCabezeraLayout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 294, Short.MAX_VALUE)
                .addComponent(pnlAcceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlCabezeraLayout.setVerticalGroup(
            pnlCabezeraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAcceso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlCabezeraLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(pnlCabezera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 50));

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlPrincipal.setMaximumSize(new java.awt.Dimension(600, 600));
        pnlPrincipal.setMinimumSize(new java.awt.Dimension(600, 600));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.setGridColor(new java.awt.Color(255, 255, 255));
        jTable2.setRequestFocusEnabled(false);
        jTable2.setSelectionBackground(new java.awt.Color(41, 124, 214));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap(459, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(pnlPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 600, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        setExtendedState(JFrame.CROSSHAIR_CURSOR);
    }//GEN-LAST:event_btnMinimizarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed
                            
    private void pnlCabezeraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCabezeraMousePressed
       posx=evt.getX(); //Capturar la posicion del mouse en X
        posy=evt.getY(); //Capturar la posicion del mouse en Y
    }//GEN-LAST:event_pnlCabezeraMousePressed

    private void pnlCabezeraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCabezeraMouseDragged
        int xp = evt.getXOnScreen()-posx;
        int yp = evt.getYOnScreen()-posy;
        this.setLocation(xp, yp);   //Cambiar la posicion del frame (ventana)
    }//GEN-LAST:event_pnlCabezeraMouseDragged

    private void pnlInicioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlInicioMouseMoved
        hoverMenu(0);
    }//GEN-LAST:event_pnlInicioMouseMoved

    private void pnlItem2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlItem2MouseMoved
        hoverMenu(1);
    }//GEN-LAST:event_pnlItem2MouseMoved

    private void pnlItem3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlItem3MouseMoved
        hoverMenu(2);
    }//GEN-LAST:event_pnlItem3MouseMoved

    private void pnlItem5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlItem5MouseMoved
        hoverMenu(4);
    }//GEN-LAST:event_pnlItem5MouseMoved

    private void pnlItem4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlItem4MouseMoved
        hoverMenu(3);
    }//GEN-LAST:event_pnlItem4MouseMoved

    private void pnlItem6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlItem6MouseMoved
        hoverMenu(5);
    }//GEN-LAST:event_pnlItem6MouseMoved

    private void pnlItem7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlItem7MouseMoved
        hoverMenu(6);
    }//GEN-LAST:event_pnlItem7MouseMoved

    private void pnlMenuMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMenuMouseMoved
        hoverMenu(-1);
    }//GEN-LAST:event_pnlMenuMouseMoved

    private void pnlInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlInicioMouseClicked
        hoverMenuClick(0);
    }//GEN-LAST:event_pnlInicioMouseClicked

    private void pnlItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlItem2MouseClicked
        hoverMenuClick(1);
    }//GEN-LAST:event_pnlItem2MouseClicked

    private void pnlItem3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlItem3MouseClicked
        hoverMenuClick(2);
    }//GEN-LAST:event_pnlItem3MouseClicked

    private void pnlItem4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlItem4MouseClicked
        hoverMenuClick(3);
    }//GEN-LAST:event_pnlItem4MouseClicked

    private void pnlItem5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlItem5MouseClicked
        hoverMenuClick(4);
    }//GEN-LAST:event_pnlItem5MouseClicked

    private void pnlItem6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlItem6MouseClicked
        hoverMenuClick(5);
    }//GEN-LAST:event_pnlItem6MouseClicked

    private void pnlItem7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlItem7MouseClicked
        hoverMenuClick(6);
    }//GEN-LAST:event_pnlItem7MouseClicked
    
    private void hoverMenuClick(int Actual){
        pnlActualClick = Actual;
        hoverMenu(Actual);
    }
    private void hoverMenu (int pnlActual){
        for (int i = 0; i < nPnl; i++) {
            if(i == pnlActual || i == pnlActualClick){
                pnlMenuOptions.getComponent(i).setBackground(new java.awt.Color(20, 110, 214));
            }else{
                pnlMenuOptions.getComponent(i).setBackground(new java.awt.Color(41, 124, 214));
            }  
        }
    }
    
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PanelControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelControl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JLabel imgUser;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel pnlAcceso;
    private javax.swing.JPanel pnlCabezera;
    private javax.swing.JPanel pnlInfoUser;
    private javax.swing.JPanel pnlInicio;
    private javax.swing.JPanel pnlItem2;
    private javax.swing.JPanel pnlItem3;
    private javax.swing.JPanel pnlItem4;
    private javax.swing.JPanel pnlItem5;
    private javax.swing.JPanel pnlItem6;
    private javax.swing.JPanel pnlItem7;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlMenuOptions;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
