package pl.sda.javapoz19.model;

public enum Specialization {

    NEUROLOGIST("Neurologist"), UROLOGIST("Urologist"), DERMATOLOGIST("Dermatologist")
    , CARDIOLOGIST("Cardiologist"), ALLERGIST("Allergist"), ANESTHESIOLOGIST("Anesthesiologist"), ENDOCRINOLOGIST("Endocrinologist")
    , HEMATOLOGIST("Hematologist"), RADIOLOGIST("Radiologist"), PEDIATRICIAN("Pediatrician"), INTERNIST("Internist"), LARYNGOLOGIST("Laryngologist");


    private final String name;

    Specialization(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
