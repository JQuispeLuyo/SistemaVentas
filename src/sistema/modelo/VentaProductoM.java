/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelo;

import java.sql.Date;

/**
 *
 * @author Jose Luis
 */
public class VentaProductoM {
    
    private int CODVENT;
    private String TIPVENT;
    private Date FECVENT;
    private int EMPLEADO_CODPER;
    private int PERSONA_CODPER;

    public String getTIPVENT() {
        return TIPVENT;
    }

    public void setTIPVENT(String TIPVENT) {
        this.TIPVENT = TIPVENT;
    }

    public Date getFECVENT() {
        return FECVENT;
    }

    public void setFECVENT(Date FECVENT) {
        this.FECVENT = FECVENT;
    }

    public int getCODVENT() {
        return CODVENT;
    }

    public void setCODVENT(int CODVENT) {
        this.CODVENT = CODVENT;
    }




    public int getEMPLEADO_CODPER() {
        return EMPLEADO_CODPER;
    }

    public void setEMPLEADO_CODPER(int EMPLEADO_CODPER) {
        this.EMPLEADO_CODPER = EMPLEADO_CODPER;
    }

    public int getPERSONA_CODPER() {
        return PERSONA_CODPER;
    }

    public void setPERSONA_CODPER(int PERSONA_CODPER) {
        this.PERSONA_CODPER = PERSONA_CODPER;
    }
    
    
}
