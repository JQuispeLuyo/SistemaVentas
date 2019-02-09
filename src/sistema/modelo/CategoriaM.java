
package sistema.modelo;

public class CategoriaM {
    
    String CODCAT;
    String NOMCAT;
    String DESCAT;

    public CategoriaM() {
    }

    public CategoriaM(String CODCAT, String NOMCAT) {
        this.CODCAT = CODCAT;
        this.NOMCAT = NOMCAT;
    }

    public String getCODCAT() {
        return CODCAT;
    }

    public void setCODCAT(String CODCAT) {
        this.CODCAT = CODCAT;
    }

    public String getNOMCAT() {
        return NOMCAT;
    }

    public void setNOMCAT(String NOMCAT) {
        this.NOMCAT = NOMCAT;
    }

    @Override
    public String toString() {
        return NOMCAT;
    }
    
}
