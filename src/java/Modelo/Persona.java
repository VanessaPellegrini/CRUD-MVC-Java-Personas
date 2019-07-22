
package Modelo;

public class Persona {
    int id;
    String nom;
    String apellido;
    int edad;
    char sexo;

    public Persona() {
    }

    public Persona(int id, String nom, String apellido, int edad, char sexo) {
        this.id = id;
        this.nom = nom;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    
    
}
