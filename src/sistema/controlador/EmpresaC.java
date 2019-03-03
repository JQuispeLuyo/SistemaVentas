package sistema.controlador;

import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import sistema.dao.EmpresaD;
import sistema.modelo.EmpresaM;
import sistema.view.PnlClienteContainer;
import sistema.view.PnlEmpresaContainer;

/**
 *
 * @author Jose Luis
 */
public class EmpresaC {

    EmpresaD empresaD = new EmpresaD();
    EmpresaM empresaM = new EmpresaM();
    private ArrayList<String> DatosPersona = new ArrayList<String>();

    public void resEmpresa(String dni) {

        DatosPersona = empresaD.resPersona(dni);

        if (!DatosPersona.isEmpty()) {
            PnlEmpresaContainer.txtRazonSocialEmpresa.setText(DatosPersona.get(0));
        }
    }

    public void guardarEmpresa() throws Exception {
        empresaD.guardarEmpresa(empresaM);
    }

    public void editarEmpresa() throws Exception {
        empresaD.editarEmpresa(empresaM);
    }

    public void eliminarEmpresa() throws Exception {
        System.out.println("cadiog cronto " + empresaM.getCODPER());
        empresaD.eliminarEmpresa(empresaM.getCODPER());
    }

    public void listarEmpresaTabla(DefaultTableModel modeloTablaUsuario, int tipo, String dato) throws Exception {
        empresaD.listarEmpresaTabla(modeloTablaUsuario, tipo, dato);
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

        if (!"".equals(PnlEmpresaContainer.txtCodigoEmpresa.getText().trim())) {
            empresaM.setCODPER(Integer.parseInt((PnlEmpresaContainer.txtCodigoEmpresa.getText())));
        }

        empresaM.setNOMPER(PnlEmpresaContainer.txtRazonSocialEmpresa.getText());
        empresaM.setAPEPER(PnlEmpresaContainer.txtNombreEmpresa.getText());
        empresaM.setRUCDNIPER(PnlEmpresaContainer.txtRucEmpresa.getText());


        empresaM.setTIPPER("E");
        if(PnlEmpresaContainer.jckEstadoEmpresa.isSelected()){
            empresaM.setESTAPER("A");
        }else{
            empresaM.setESTAPER("B");
        }
        

    }

    public boolean validarExistenciaEmpresa(String DNI) throws Exception {

        System.out.println("control " + DNI);

        if (empresaD.validarExistenciaEmpresa(DNI)) {
            JOptionPane.showMessageDialog(null, "Empresa Existente");
            return true;
        }
        return false;
    }

    public boolean validar() throws Exception {

        if ("".equals(PnlEmpresaContainer.txtRucEmpresa.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Ingrese RUC");
            return false;
        }
        
        if(PnlEmpresaContainer.txtRucEmpresa.getText().length() <11 ){
            JOptionPane.showMessageDialog(null, "Ingrese longitud correcta de RUC (11 digitos)");
            return false;
        }

        if ("".equals(PnlEmpresaContainer.txtRazonSocialEmpresa.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Ingrese Razon Social");
            return false;
        }

        return true;
    }

    public void limpiarVariables() {
        
        PnlEmpresaContainer.txtCodigoEmpresa.setText("");
        PnlEmpresaContainer.txtNombreEmpresa.setText("");
        PnlEmpresaContainer.txtRazonSocialEmpresa.setText("");
        PnlEmpresaContainer.txtRucEmpresa.setText("");

    }
}
