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
public class VentaDetalleProductoM {
    
    private int CODVENTDET;
    private int CODVENT;
    private int CANDETVENT;
    private int CODPRO;

    public int getCODVENTDET() {
        return CODVENTDET;
    }

    public void setCODVENTDET(int CODVENTDET) {
        this.CODVENTDET = CODVENTDET;
    }

    public int getCODVENT() {
        return CODVENT;
    }

    public void setCODVENT(int CODVENT) {
        this.CODVENT = CODVENT;
    }

    public int getCANDETVENT() {
        return CANDETVENT;
    }

    public void setCANDETVENT(int CANDETVENT) {
        this.CANDETVENT = CANDETVENT;
    }

    public int getCODPRO() {
        return CODPRO;
    }

    public void setCODPRO(int CODPRO) {
        this.CODPRO = CODPRO;
    }
    
    
    
    
}
