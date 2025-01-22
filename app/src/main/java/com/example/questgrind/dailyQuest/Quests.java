package com.example.questgrind.dailyQuest;

public class Quests {
    private Boolean flexiones;
    private Boolean abdominales;
    private Boolean sentadillas;
    private Boolean leer;
    private Boolean estudiar;

    private Boolean allCompleted;

    // Declare constructor

    public Quests() {
        flexiones = false;
        abdominales = false;
        sentadillas = false;
        leer = false;
        estudiar = false;
    }

    // Declare setters
    public void setFlexiones(Boolean flexiones) {
        this.flexiones = flexiones;
    }

    public void setAbdominales(Boolean abdominales) {
        this.abdominales = abdominales;
    }

    public void setSentadillas(Boolean sentadillas) {
        this.sentadillas = sentadillas;
    }

    public void setLeer(Boolean leer) {
        this.leer = leer;
    }

    public void setEstudiar(Boolean estudiar) {
        this.estudiar = estudiar;
    }

    public void setAllCompleted(Boolean allCompleted) {
        this.allCompleted = allCompleted;
    }

    // Declare getters
    public Boolean getFlexiones() {
        return flexiones;
    }

    public Boolean getAbdominales() {
        return abdominales;
    }

    public Boolean getSentadillas() {
        return sentadillas;
    }

    public Boolean getLeer() {
        return leer;
    }

    public Boolean getEstudiar() {
        return estudiar;
    }

    public Boolean getAllCompleted() {
        return allCompleted;
    }
}
