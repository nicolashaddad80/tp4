package fr.cnam.tp4.polygon;

import fr.cnam.tp1and2.point.Point;


/**
 * ___________________________________________________________<br>
 * NFP121:TP4 <br>
 * Nicolas HADDAD        <br>
 * nicolas.haddad80@gmail.com  <br>
 * _____________________________________________________________<br>
 * La classe Polygon Modelise un Polygone d'un quelconque  degre<br>
 * La modelisation d'un Polygon  est represente par un tableau contenant ses Points sommets dans un attribu <br>
 * ____________________________________________________________________________________<br>
 */
public class Polygon {

    /**
     * L'enssemble des sommets du Polygon
     */
    private Point[] pointSet = new Point[0];


    /**
     * Methode pour afficher notre Polygon
     *
     * @return : La chaine de caracteres representant notre Polygon
     */
    public String toString() {
        StringBuilder l_StringB = new StringBuilder();
        l_StringB.append("[\n");
        for (int i = 0; i < this.pointSet.length; i++) {
            l_StringB.append(this.pointSet[i].toString() + "\n");
        }
        l_StringB.append("]");
        return null;
    }

    /**
     * Methode pour translater notre Polygon d'un ndeplacement selon les deux directions.
     *
     * @param a_x : Le deplacement a appliquer selon l'axe des Abscisses
     * @param a_y : Le deplacement a appliquer selon l'axe des Ordonnees
     */
    public void translate(double a_x, double a_y) {
        for (int i = 0; i < this.pointSet.length; i++) {
            this.pointSet[i].translate(a_x, a_y);
        }
    }

    /**
     * Methode pour obtenir le perimetre de notre Polygon
     *
     * @return : Le perimetre de notre Polygon
     */
    public double getPerimeter() {
        double l_perimetre = 0;
        for (int i = 0; i < this.pointSet.length; i++) {
            l_perimetre += this.pointSet[i].distance(this.pointSet[(i + 1) % this.pointSet.length]);
        }
        return l_perimetre;
    }

    /**
     * Methode pour obtenir la surface de notre Polygon
     *
     * @return : La surface de notre Polygon
     */
    public double getArea() {
        double l_sum = 0;
        for (int i = 0; i < this.pointSet.length; i++) {
            l_sum += this.pointSet[i].getY() * this.pointSet[(i + 1) % this.pointSet.length].getX() - this.pointSet[i].getX() * this.pointSet[(i + 1) % this.pointSet.length].getY();
        }
        return l_sum / 2;
    }

    /**
     * Methode pour obtenir le degre (le nombre de sommets) de notre Polygon
     *
     * @return : Le degre de notre Polygon
     */
    public int getDegree() {
        return this.pointSet.length;
    }

    /**
     * Methode pour rajouter un nouveau sommet a notre Polygone suite au dernier sommet
     *
     * @param a_p : Le nouveau sommet a rajouter a la fin.
     */
    public void addVertex(Point a_p) {
        Point[] l_setPoint = new Point[this.pointSet.length + 1];
        System.arraycopy(this.pointSet, 0, l_setPoint, 0, this.pointSet.length);
        l_setPoint[this.pointSet.length] = a_p;
        this.pointSet = l_setPoint;
    }

    /**
     * Methode pour le sommet de notre Polygone a une position donnee
     *
     * @param a_position : La position du sommet a obtenir
     */
    public Point getVertex(int a_position) {
        assert (a_position > 0) && (a_position <= this.pointSet.length + 1) : "Wrong Position, try again";
        return this.pointSet[a_position - 1];
    }

    /**
     * Methode pour rajouter un nouveau sommet a notre Polygone a une position donnee
     *
     * @param a_p        : Le nouveau sommet a rajouter a la fin.
     * @param a_position : La position a laquelle on doit rajouter le nouveau sommet
     */
    public void addVertex(Point a_p, int a_position) {
        assert (a_position > 0) && (a_position <= this.pointSet.length + 1) : "Wrong Position, try again";
        Point[] l_setPoint = new Point[this.pointSet.length + 1];
        System.arraycopy(this.pointSet, 0, l_setPoint, 0, a_position - 1);
        l_setPoint[a_position - 1] = a_p;
        System.arraycopy(this.pointSet, a_position - 1, l_setPoint, a_position, this.pointSet.length - a_position + 1);
        this.pointSet = l_setPoint;
    }

    /**
     * Methode pour retirer un sommet  a une position donnee de notre Polygone
     *
     * @param a_position : La position du sommet a supprimer
     */
    public void removeVertex(int a_position) {
        assert (a_position > 0) && (a_position <= this.pointSet.length) : "Wrong Position, try again";
        Point[] l_setPoint = new Point[this.pointSet.length - 1];
        System.arraycopy(this.pointSet, 0, l_setPoint, 0, a_position - 1);
        System.arraycopy(this.pointSet, a_position - 1, l_setPoint, a_position - 1, this.pointSet.length - a_position);
        this.pointSet = l_setPoint;

    }
}