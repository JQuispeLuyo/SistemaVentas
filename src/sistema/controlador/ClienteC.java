package sistema.controlador;

import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import sistema.dao.ClienteD;
import sistema.modelo.ClienteM;
import sistema.view.PnlClienteContainer;

/**
 *
 * @author Jose Luis
 */
public class ClienteC {

    ClienteD clienteD = new ClienteD();
    ClienteM clienteM = new ClienteM();
    private ArrayList<String> DatosPersona = new ArrayList<String>();

    public void resPersona(String dni) {

        DatosPersona = clienteD.resPersona(dni);

        if (!DatosPersona.isEmpty()) {
            PnlClienteContainer.txtNombreCliente.setText(DatosPersona.get(2));
            PnlClienteContainer.txtApellidoCliente.setText(DatosPersona.get(0) + " " + DatosPersona.get(1));
        }
    }

    public void guardarCliente() throws Exception {
        clienteD.guardarCliente(clienteM);
    }

    public void editarCliente() throws Exception {
        clienteD.editarCliente(clienteM);
    }

    public void eliminarCliente() throws Exception {
        System.out.println("cadiog cronto " + clienteM.getCODPER());
        clienteD.eliminarCliente(clienteM.getCODPER());
    }

    public void listarClienteTabla(DefaultTableModel modeloTablaUsuario, int tipo, String dato) throws Exception {
        clienteD.listarClienteTabla(modeloTablaUsuario, tipo, dato);
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

        if (!"".equals(PnlClienteContainer.txtCodigoCliente.getText().trim())) {
            clienteM.setCODPER(Integer.parseInt((PnlClienteContainer.txtCodigoCliente.getText())));
        }

        clienteM.setNOMPER(PnlClienteContainer.txtNombreCliente.getText());
        clienteM.setAPEPER(PnlClienteContainer.txtApellidoCliente.getText());
        clienteM.setRUCDNIPER(PnlClienteContainer.txtDniCliente.getText());

        JRadioButton jrb = getSelection(PnlClienteContainer.rdGrupoGenero);
        clienteM.setGENPER(jrb.getActionCommand());

        clienteM.setTIPPER("C");
        if(PnlClienteContainer.jckActivoCliente.isSelected()){
            clienteM.setESTAPER("A");
        }else{
            clienteM.setESTAPER("B");
        }
        

    }

    public boolean validarExistenciaCliente(String DNI) throws Exception {

        System.out.println("control " + DNI);

        if (clienteD.validarExistenciaCliente(DNI)) {
            JOptionPane.showMessageDialog(null, "Usuario Existente");
            return true;
        }
        return false;
    }

    public boolean validar() throws Exception {

        if ("".equals(PnlClienteContainer.txtDniCliente.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Ingrese DNI");
            return false;
        }
        
        if(PnlClienteContainer.txtDniCliente.getText().length() <8 ){
            JOptionPane.showMessageDialog(null, "Ingrese longitud correcta de Dni (8 digitos)");
            return false;
        }

        if ("".equals(PnlClienteContainer.txtNombreCliente.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Ingrese Nombre");
            return false;
        }

        if ("".equals(PnlClienteContainer.txtApellidoCliente.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Ingrese Apellido");
            return false;
        }

        if (getSelection(PnlClienteContainer.rdGrupoGenero) == null) {
            JOptionPane.showMessageDialog(null, "Selecione Genero");
            return false;
        }

        return true;
    }

    public void limpiarVariables() {
        PnlClienteContainer.txtCodigoCliente.setText("");
        PnlClienteContainer.txtNombreCliente.setText("");
        PnlClienteContainer.txtApellidoCliente.setText("");
        PnlClienteContainer.txtDniCliente.setText("");

        PnlClienteContainer.rdGrupoGenero.clearSelection();

    }
}
