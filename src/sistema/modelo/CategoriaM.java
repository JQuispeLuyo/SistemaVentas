
package sistema.modelo;

public class CategoriaM {
    
    String CODCAT;
    String DESCAT;

    public CategoriaM() {
    }

    public CategoriaM(String CODCAT, String NOMCAT) {
        this.CODCAT = CODCAT;
        this.DESCAT = NOMCAT;
    }

    public String getCODCAT() {
        return CODCAT;
    }

    public void setCODCAT(String CODCAT) {
        this.CODCAT = CODCAT;
    }

    public String getDESCAT() {
        return DESCAT;
    }

    public void setDESCAT(String NOMCAT) {
        this.DESCAT = NOMCAT;
    }

    @Override
    public String toString() {
        return DESCAT;
    }
    
}
