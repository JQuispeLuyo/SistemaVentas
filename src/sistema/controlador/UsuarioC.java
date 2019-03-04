package sistema.controlador;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import sistema.dao.UsuarioD;
import sistema.modelo.UsuarioM;
import sistema.view.PnlUsuariosContainer;
import static sistema.view.PnlUsuariosContainer.txtNombreUsuario;
import static sistema.view.PnlUsuariosContainer.txtApellidoUsuario;

/**
 *
 * @author Jose Luis
 */
public class UsuarioC {

    UsuarioD usuarioD = new UsuarioD();
    UsuarioM usuarioM = new UsuarioM();
    private ArrayList<String> DatosPersona = new ArrayList<String>();

    public void resPersona(String dni) {

        DatosPersona = usuarioD.resPersona(dni);

        if (!DatosPersona.isEmpty()) {
            txtNombreUsuario.setText(DatosPersona.get(2));
            txtApellidoUsuario.setText(DatosPersona.get(0) + " " + DatosPersona.get(1));
        }
    }

    public void guardarUsuario() throws Exception {
        usuarioD.guardarUsuario(usuarioM);
    }

    public void editarUsuario() throws Exception {
        usuarioD.editarUsuarioDatos(usuarioM);
    }

    public void editarUsuarioLogin() throws Exception {
        usuarioD.editarUsuarioContraseña(usuarioM);
    }

    public void eliminarUsuario() throws Exception {
        usuarioD.eliminarUsuario(usuarioM.getCODPER());
    }

    public void listarUsuarioTabla(DefaultTableModel modeloTablaUsuario, int tipo, String dato) throws Exception {
        usuarioD.listarUsuarioTabla(modeloTablaUsuario, tipo, dato);
    }

    public static JRadioButton getSelection(ButtonGroup group) {
        for (Enumeration e = group.getElements(); e.hasMoreElements();) {
            JRadioButton b = (JRadioButton) e.nextElement();
            if (b.getModel() == group.getSelection()) {
                return b;
            }
        }

        return null;
    }

    public void cargarVariables() {

        if (!"".equals(PnlUsuariosContainer.txtCodigoUsuario.getText().trim())) {
            usuarioM.setCODPER(Integer.parseInt((PnlUsuariosContainer.txtCodigoUsuario.getText())));
        }

        usuarioM.setNOMPER(PnlUsuariosContainer.txtNombreUsuario.getText());
        usuarioM.setAPEPER(PnlUsuariosContainer.txtApellidoUsuario.getText());
        usuarioM.setRUCDNIPER(PnlUsuariosContainer.txtDniUsuario.getText());

        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            usuarioM.setFECNAC(Date.valueOf(formatoFecha.format(PnlUsuariosContainer.jcaNacimientoUsuario.getDate())));
        } catch (Exception e) {
            System.out.println("Algo anda  mal");
        }

        usuarioM.setUBIPER(PnlUsuariosContainer.txtUbigeoUsuario.getText());

        usuarioM.setDIRPER(PnlUsuariosContainer.txtDireccionUsuario.getText());
        usuarioM.setTEL1PER(PnlUsuariosContainer.txtTelefonoUsuario.getText());

        JRadioButton jrb = getSelection(PnlUsuariosContainer.rdGrupoGenero);
        usuarioM.setGENPER(jrb.getActionCommand());

        usuarioM.setUSEPER(PnlUsuariosContainer.txtUsuarioUsuario.getText());
        usuarioM.setCONPER(PnlUsuariosContainer.txtContraseñaUsuario.getText());
        usuarioM.setTIPPER("U");
        usuarioM.setESTAPER("A");

    }

    public void cargarVariablesLogin() {
        String contraseña = String.valueOf(PnlUsuariosContainer.txtContraseñaUsuario.getPassword());
        usuarioM.setCODPER(Integer.parseInt((PnlUsuariosContainer.txtCodigoUsuario.getText())));
        usuarioM.setCONPER(contraseña);

    }

    public boolean validarCredencialLogin() {

        if ("".equals(PnlUsuariosContainer.txtUsuarioUsuario.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Ingrese Usuario");
            return false;
        }

        if ("".equals(PnlUsuariosContainer.txtContraseñaUsuario.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Ingrese Contraseña");
            return false;
        }

        if (PnlUsuariosContainer.txtContraseñaUsuario.getText().length() < 4) {
            JOptionPane.showMessageDialog(null, "La contraseña debe tener como minimo 4 caracteres");
            return false;
        }

        try {
            if (validarExistenciaUsuarioLogin(PnlUsuariosContainer.txtUsuarioUsuario.getText())) {
                return false;
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    public boolean validarExistenciaUsuarioLogin(String usuario) throws Exception {

        System.out.println("control " + usuario);

        if (usuarioD.validarExistenciaUsuarioLogin(usuario)) {
            JOptionPane.showMessageDialog(null, "Nombre de usuario Existente");
            return true;
        }
        return false;
    }

    public boolean validarExistenciaUsuario(String DNI) throws Exception {

        System.out.println("control " + DNI);

        if (usuarioD.validarExistenciaUsuario(DNI)) {
            JOptionPane.showMessageDialog(null, "Usuario Existente");
            return true;
        }
        return false;
    }

    public boolean validar() throws Exception {

        if ("".equals(PnlUsuariosContainer.txtDniUsuario.getText().trim())
                || PnlUsuariosContainer.txtDniUsuario.getText().length() < 8) {
            JOptionPane.showMessageDialog(null, "Ingrese DNI (8 digitos)");
            return false;
        }

        if ("".equals(PnlUsuariosContainer.txtNombreUsuario.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Ingrese Nombre");
            return false;
        }

        if ("".equals(PnlUsuariosContainer.txtApellidoUsuario.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Ingrese Apellido");
            return false;
        }

        if (PnlUsuariosContainer.jcaNacimientoUsuario.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Ingrese fecha");
            return false;
        }
//        
//        if (VALIDAR UBIGEO) {
//            JOptionPane.showMessageDialog(null, "Ingrese Codigo");
//            return false;
//        }

        if (!"".equals(PnlUsuariosContainer.txtTelefonoUsuario.getText().trim())) {
            if (PnlUsuariosContainer.txtTelefonoUsuario.getText().length() < 9) {
                JOptionPane.showMessageDialog(null, "Ingrese Telefono (9 digitos)");
                return false;
            }
        }

        if (getSelection(PnlUsuariosContainer.rdGrupoGenero) == null) {
            JOptionPane.showMessageDialog(null, "Selecione Genero");
            return false;
        }

        if (!"".equals(PnlUsuariosContainer.txtUsuarioUsuario.getText().trim())) {
            if (!validarCredencialLogin()) {
                return false;
            }
        }

        return true;
    }

    public boolean validarEditarUsuario() throws Exception {

        if ("".equals(PnlUsuariosContainer.txtDniUsuario.getText().trim())) {

            JOptionPane.showMessageDialog(null, "Ingrese DNI");
            return false;
        }

        if ("".equals(PnlUsuariosContainer.txtNombreUsuario.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Ingrese Nombre");
            return false;
        }

        if ("".equals(PnlUsuariosContainer.txtApellidoUsuario.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Ingrese Apellido");
            return false;
        }
        
        if (!"".equals(PnlUsuariosContainer.txtTelefonoUsuario.getText().trim())) {
            if (PnlUsuariosContainer.txtTelefonoUsuario.getText().length() < 9) {
                JOptionPane.showMessageDialog(null, "Ingrese Telefono (9 digitos)");
                return false;
            }
        }
        
        if (PnlUsuariosContainer.jcaNacimientoUsuario.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Ingrese fecha");
            return false;
        }
//        
//        if (VALIDAR UBIGEO) {
//            JOptionPane.showMessageDialog(null, "Ingrese Codigo");
//            return false;
//        }

        if (getSelection(PnlUsuariosContainer.rdGrupoGenero) == null) {
            JOptionPane.showMessageDialog(null, "Selecione Genero");
            return false;
        }

        return true;
    }

    public void limpiarVariables() {
        PnlUsuariosContainer.txtCodigoUsuario.setText("");
        PnlUsuariosContainer.txtNombreUsuario.setText("");
        PnlUsuariosContainer.txtApellidoUsuario.setText("");
        PnlUsuariosContainer.txtDniUsuario.setText("");

        PnlUsuariosContainer.jcDepartamentoUsuario.setSelectedIndex(0);
//        PnlUsuariosContainer.jcaNacimientoUsuario.setCalendar(null);
//        PnlUsuariosContainer.jcaNacimientoUsuario.setCalendar(null);

        PnlUsuariosContainer.txtDireccionUsuario.setText("");
        PnlUsuariosContainer.txtTelefonoUsuario.setText("");

        PnlUsuariosContainer.rdGrupoGenero.clearSelection();

        PnlUsuariosContainer.jcaNacimientoUsuario.setCalendar(null);

        PnlUsuariosContainer.txtUsuarioUsuario.setText("");
        PnlUsuariosContainer.txtContraseñaUsuario.setText("");
    }
}
