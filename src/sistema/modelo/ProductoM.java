package sistema.modelo;

public class ProductoM {

    int CODPRO;
    String DESPRO;
    int CODUNI;
    double PREPRO;
    int CODCAT;

    

    public ProductoM() {
    }

    public int getCODPRO() {
        return CODPRO;
    }

    public void setCODPRO(int CODPRO) {
        this.CODPRO = CODPRO;
    }

    public String getDESPRO() {
        return DESPRO;
    }

    public void setDESPRO(String DESPRO) {
        this.DESPRO = DESPRO;
    }

    public int getCODUNI() {
        return CODUNI;
    }

    public void setCODUNI(int CODUNI) {
        this.CODUNI = CODUNI;
    }

    public double getPREPRO() {
        return PREPRO;
    }

    public void setPREPRO(double PREPRO) {
        this.PREPRO = PREPRO;
    }
    
    public int getCODCAT() {
        return CODCAT;
    }

    public void setCODCAT(int CODCAT) {
        this.CODCAT = CODCAT;
    }

}
