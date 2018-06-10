package data;

import user.User.Ethnicity;

public class Illness {
    private String name;
    private String symptoms;
    private int criticalAge;
    private Ethnicity[] riskGroups;

    /**
     * Create new illness data type with data.
     * @param name name of illness
     * @param symptoms symptoms of illness
     * @param riskAge mean affected age, or age where illness becomes serious
     * @param riskGroups most common groups affected
     */
    public Illness(String name, String symptoms, int riskAge, Ethnicity[] riskGroups) {
        this.name = name;
        this.symptoms = symptoms;
        this.criticalAge = riskAge;
        this.riskGroups = riskGroups;
    }

    public String getName() {
        return name;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public int getCriticalAge() {
        return criticalAge;
    }

    public Ethnicity[] getRiskGroups() {
        return riskGroups;
    }
}
