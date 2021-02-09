package controller;

public class Mobile {

    int IMEI;
    String marca;
    String modelo;
    String falla;

    public Mobile (int IMEI, String marca, String modelo, String falla){
        this.IMEI = IMEI;
        this.marca = marca;
        this.modelo = modelo;
        this.falla = falla;
    }

    public int getIMEI() {
        return IMEI;
    }

    public void setIMEI(int IMEI) {
        this.IMEI = IMEI;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFalla() {
        return falla;
    }

    public void setFalla(String falla) {
        this.falla = falla;
    }

    public boolean validateMarca(String validM){
        if (validM.equals("Samsung")){
            System.out.println("The cell is  " + validM);
            return true;
        }
        System.out.println(("The cell not is " + validM));
        return false;
    }

    public boolean isGood(){
        if(this.validateMarca("Samsung")){
            System.out.println("The Cell is Ok");
            return true;
        }
        System.out.println("The Cell not is Ok");
        return false;
    }
}
