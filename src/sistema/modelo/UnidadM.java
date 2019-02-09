/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelo;

/**
 *
 * @author Jose Luis
 */
public class UnidadM {
    String CODUNI;
    String ABRUNI;
    String DESUNI;

    public UnidadM() {
    }

    public UnidadM(String CODUNI, String DESUNI) {
        this.CODUNI = CODUNI;
        this.DESUNI = DESUNI;
    }

    public String getCODUNI() {
        return CODUNI;
    }

    public void setCODUNI(String CODUNI) {
        this.CODUNI = CODUNI;
    }


    public String getDESUNI() {
        return DESUNI;
    }

    public void setDESUNI(String DESUNI) {
        this.DESUNI = DESUNI;
    }

    @Override
    public String toString() {
        return  DESUNI;
    } 
}
