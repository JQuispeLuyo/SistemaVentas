/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controlador;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistema.dao.ProductoD;
import sistema.modelo.CategoriaM;
import sistema.modelo.ProductoM;
import sistema.modelo.UnidadM;
import sistema.view.PnlAgregarProductoContainer;
import sistema.view.PnlProductosContainer;
import static sistema.view.PnlProductosContainer.jcCategoria;
import static sistema.view.PnlProductosContainer.jcUnidadMedida;
import static sistema.view.PnlProductosContainer.txtCodigoProducto;
import static sistema.view.PnlProductosContainer.txtProducto;
import static sistema.view.PnlProductosContainer.txtPrecioProducto;

/**
 *
 * @author Jose Luis
 */
public class ProductoC {

    ProductoD productoD = new ProductoD();
    ProductoM productoM = new ProductoM();

    public void mostrarUnidad(JComboBox<UnidadM> jcUnidadMedida) {
        productoD.mostrarUnidad(jcUnidadMedida);
    }

    public void mostrarCategoria(JComboBox<CategoriaM> jcCategoria, JComboBox<CategoriaM> jcCategoriaFiltro) {
        productoD.mostrarCategoria(jcCategoria, jcCategoriaFiltro);
    }
    
    public void mostrarCategoriaFiltroAgregar(JComboBox<CategoriaM> jcCategoriaFiltro) {
        productoD.mostrarCategoriaFiltroAgregar(jcCategoriaFiltro);
    }
    
    public void guardarProducto() throws Exception {
        productoD.guardarProducto(productoM);
    }

    public void editarProducto() throws Exception {
        productoD.editarProducto(productoM);
    }
    
    public void eliminarProducto() throws Exception {
        productoD.eliminarProducto(productoM.getCODPRO());
    }

    public void listarProductoTabla(DefaultTableModel modeloTablaProducto, int tipo, String dato) throws Exception {
        productoD.listarProductoTabla(modeloTablaProducto, tipo, dato);
    }

    public void CargarVariables() {
        if (!"".equals(PnlProductosContainer.txtCodigoProducto.getText().trim())) {
            productoM.setCODPRO(Integer.parseInt((PnlProductosContainer.txtCodigoProducto.getText())));
        }
  
        productoM.setDESPRO(txtProducto.getText().trim());
        productoM.setCODUNI(PnlProductosContainer.jcUnidadMedida.getItemAt(jcUnidadMedida.getSelectedIndex()).getCODUNI());
        productoM.setPREPRO(Double.parseDouble(txtPrecioProducto.getText()));
        productoM.setCODCAT(PnlProductosContainer.jcCategoria.getItemAt(jcCategoria.getSelectedIndex()).getCODCAT());
    }

    public boolean validar() {

        if (jcCategoria.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecione una categoria");
            return false;
        }
        if ("".equals(txtProducto.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Ingrese producto");
            return false;
        }
        
        if (jcUnidadMedida.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecione una unidad de medida");
            return false;
        }
        if ("".equals(txtPrecioProducto.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Ingrese unn precio");
            return false;
        }
        
        
        return true;
    }

    public void limpiarVariables() {
        txtCodigoProducto.setText("");
        txtProducto.setText("");
        jcUnidadMedida.setSelectedIndex(0);
        txtPrecioProducto.setText("");
        jcCategoria.setSelectedIndex(0);
    }
    
    public void limpiarVariablesAgregar() {
        
        PnlAgregarProductoContainer.txtCodigoProducto.setText("");
        PnlAgregarProductoContainer.txtProducto.setText("");
        PnlAgregarProductoContainer.txtUnidadProducto.setText("");
        PnlAgregarProductoContainer.txtPrecioProductoTotal.setText("");
        PnlAgregarProductoContainer.jsCantidadProductoAgregar.setValue(0);
        PnlAgregarProductoContainer.jcCategoriaFiltro.setSelectedIndex(0);
    }

}
