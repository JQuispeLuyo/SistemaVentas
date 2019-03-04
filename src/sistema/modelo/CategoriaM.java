package sistema.modelo;

public class CategoriaM {

    int CODCAT;
    String DESCAT;

    public CategoriaM() {
    }

    public CategoriaM(int CODCAT, String DESCAT) {
        this.CODCAT = CODCAT;
        this.DESCAT = DESCAT;
    }
    
    public int getCODCAT() {
        return CODCAT;
    }

    public void setCODCAT(int CODCAT) {
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
