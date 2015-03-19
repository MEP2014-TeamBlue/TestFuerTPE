package de.hs.mannheim.tpe.smits.group3.impl;

/**
 * Klasse Vektor. F√ºr einen 3 dimensionalen Vektor R3
 * @author alexanderschaaf
 */
public class Vector{

    /**
     * Koordinaten des 3D Vektors
     */
    private double x;
    private double y;
    private double z;

   /**
    * Erzeugt einen Null-Vector, d.h. den Vektor bei dem alle Komponenten den Wert 0 haben.
    * */
    public Vector (){

        this.x = 0.0d;
        this.y = 0.0d;
        this.z = 0.0d;

    }

   /**
    * Erzeugt einen neuen Vektor mit den angebgebenen Elementen
    * @param x Koordinate1
    * @param y Koordinate2
    * @param z Koordinate3
    */
    public Vector( double x, double y, double z){

        this.x = x;
        this.y = y;
        this.z = z;

    }

   /**
    *Addiert den gegebenen Vektor zu diesem.
    *@param vektor Der Vektor der hinzu addiert wird
    */
    public Vector addiere(Vector vektor) throws java.lang.IllegalArgumentException{

        if ( vektor instanceof Vector){
           /*neu berechnete Vektor Koordinaten*/
            double koordinateX = this.getX() + vektor.getX();
            double koordinateY = this.getY() + vektor.getY();
            double koordinateZ = this.getZ() + vektor.getZ();

            return new Vector(koordinateX,koordinateY,koordinateZ);
        }
        else {throw new java.lang.IllegalArgumentException();}


    }

    /**
     * Bestimmt den Betrag (die L√§nge) dieses Vektors.
     * @return Die L√§nge des Vektors
     */
    public double betrag (){

        double exp = 2.0;

        double radikant1 = Math.pow(this.getX(),exp);
        double radikant2 = Math.pow(this.getY(),exp);
        double radikant3 = Math.pow(this.getZ(),exp);

        return Math.sqrt(radikant1 + radikant2 + radikant3);
    }

    /**
     * Liefert einen Vektor zur√ºck, der diesem Vektor bez√ºglich der Richtung entspricht,
     * aber auf die L√§nge 1 normiert ist.

    */
    public Vector einheitsvektor() throws java.lang.IllegalStateException{

        Vector einheitsVektor;
        if (this.betrag() == 0.00){
            throw new java.lang.IllegalStateException("Vektor hat die länge 0.00");
        }else{
            einheitsVektor = multipliziere(1 / this.betrag());
        }


        return einheitsVektor;
    }

    /**
     * Liefert die 1. Komponente des Vektors
     * */
    public double getX(){
        return x;
    }

    /**
     * Liefert die 2. Komponente des Vektors
     * */
    public double getY(){
        return y;
    }

    /**
     * Liefert die 3. Komponente des Vektors
     */
    public double getZ(){
        return z;
    }

    /**
     * Bestimmt das Kreuzprodukt dises mit dem gegebenen Vektor.
     * @param v Vektor
     *          @return kreuzprodukt Das Kreuzprodukt der zwei Vektoren
     *

     */
    public Vector kreuzprodukt(Vector v){

        double neueKoordinateX;
        double neueKoordinateY;
        double neueKoordinateZ;

        double winkel = winkel(v);

        if (winkel <= 180.00){

            neueKoordinateX= (this.getY()* v.getZ())-(this.getZ()*v.getY());
            neueKoordinateY= (this.getZ()* v.getX())-(this.getX()*v.getZ());
            neueKoordinateZ= (this.getX()* v.getY())-(this.getY()*v.getX());

            return new Vector(neueKoordinateX,neueKoordinateY,neueKoordinateZ);

        }
        else{
            return new Vector();
        }

    }

    /**
     * Skalarmultiplikation: Multiplikation des Vektors mit einem Skalar.
     * @param skalar Skalar, mit dem der Vektor multipliziert werden soll
     * */
    public Vector multipliziere(double skalar){

        /*neu berechnete Vektor Koordinaten*/
        double koordinateX = this.getX() * skalar;
        double koordinateY = this.getY() * skalar;
        double koordinateZ = this.getZ() * skalar;

        return new Vector(koordinateX,koordinateY,koordinateZ);
    }

    /**
     * Skalarmultiplikation: Multiplikation des Vektors mit einem Vektor.
     * @param vektor Vektor mit dem multipliziert wird.

    */
    public double multipliziere(Vector vektor)throws java.lang.IllegalArgumentException{

        if ( vektor instanceof Vector){

            /*neu berechnete Vektor Koordinaten*/
            double koordinateX = this.getX() * vektor.getX();
            double koordinateY = this.getY() * vektor.getY();
            double koordinateZ = this.getZ() * vektor.getZ();

            double ergebniss =  koordinateX + koordinateY + koordinateZ;

            return ergebniss;
        }else{ throw new java.lang.IllegalArgumentException();}

    }

    /**
     * Wandelt Degree in Radian.
     * @param rad Double
     */
    public double radToDeg(double rad){
    	return rad*(180/Math.PI);
    }
    
    /**
     * Bestimmt den eingeschlossenen Winkel von diesem und dem gegebenen Vektor.
     * @param v Vector der andere.
     */
    public double winkel(Vector v){

        double skalarProdukt = multipliziere(v);
        double laengenProdukt = this.betrag() * v.betrag();
        double cosPhi = skalarProdukt / laengenProdukt;
        double winkelRad = Math.acos(cosPhi);
        double winkel=radToDeg(winkelRad);

        return winkel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector vector = (Vector) o;

        if (Double.compare(vector.x, x) != 0) return false;
        if (Double.compare(vector.y, y) != 0) return false;
        if (Double.compare(vector.z, z) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    /**
     * Gibt den Vektor aus

     */
    @Override
    public String toString(){
        String ausgabeX = String.format("%.2f",getX());
        String ausgabeY = String.format("%.2f",getY());
        String ausgabeZ = String.format("%.2f",getZ());

        String ausgabe = new String("[ "+ ausgabeX+"  "+ ausgabeY+"  "+ausgabeZ+" ]");
        return ausgabe;
    }

}
