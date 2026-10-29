package com.example.plataformaEscolar.model;

public class PlanMateria {

    private Long id; // Cambiado de int a Long
    private int semestreSugerido;
    private boolean esOptativa;
    private PlanEstudio planEstudio;
    private Materia materia;

    public PlanMateria() {
    }

    public PlanMateria(Long id, int semestreSugerido, boolean esOptativa, PlanEstudio planEstudio, Materia materia) {
        this.id = id;
        this.semestreSugerido = semestreSugerido;
        this.esOptativa = esOptativa;
        this.planEstudio = planEstudio;
        this.materia = materia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSemestreSugerido() {
        return semestreSugerido;
    }

    public void setSemestreSugerido(int semestreSugerido) {
        this.semestreSugerido = semestreSugerido;
    }

    public boolean isEsOptativa() {
        return esOptativa;
    }

    public void setEsOptativa(boolean esOptativa) {
        this.esOptativa = esOptativa;
    }

    public PlanEstudio getPlanEstudio() {
        return planEstudio;
    }

    public void setPlanEstudio(PlanEstudio planEstudio) {
        this.planEstudio = planEstudio;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}