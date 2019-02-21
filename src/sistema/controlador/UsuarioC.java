
package sistema.controlador;

import java.util.ArrayList;
import sistema.dao.UsuarioD;
import static sistema.view.PnlUsuariosContainer.txtApellidoPersona;
import static sistema.view.PnlUsuariosContainer.txtNombrePersona;

/**
 *
 * @author Jose Luis
 */
public class UsuarioC {
    
    UsuarioD usuarioD = new UsuarioD();
    private ArrayList<String> DatosPersona = new ArrayList<String>();
    
    public void resPersona(String dni) {
        
        DatosPersona = usuarioD.resPersona(dni);
        txtNombrePersona.setText(DatosPersona.get(0));
        txtApellidoPersona.setText(DatosPersona.get(1)); 
    }
    
}
