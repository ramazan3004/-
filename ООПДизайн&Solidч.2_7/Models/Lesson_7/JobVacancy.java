package Lesson_7;

public class JobVacancy {

    /** Идентификатор вакансии */
    private static int id;

    /** Наименование вакансии */
    private String name;

    /** Наименование компании */
    private String nameCompany;

    /** Минимальный уровень заработной платы */
    private int minSalary;

    /** Максимальный уровень заработной платы */
    private int maxSalary;

    /** Обязанности */
    private String responsibilities;

    /** Требования */
    private String requirements;

    /** Условия */
    private String conditions;

    /**
     * Конструктор класса
     * @param name Наименование вакансии
     * @param nameCompany Наименование компании
     * @param minSalary Минимальный уровень заработной платы
     * @param maxSalary Максимальный уровень заработной платы
     * @param responsibilities Обязанности
     * @param requirements Требования
     * @param conditions Условия
     */
    public JobVacancy(String name, String nameCompany, int minSalary, int maxSalary, String responsibilities, String requirements, String conditions) {
        this.name = name;
        this.nameCompany = nameCompany;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.responsibilities = responsibilities;
        this.requirements = requirements;
        this.conditions = conditions;
        id++;
    }

    /** Идентификатор вакансии */
    public int getID() {
        return id;
    }

    /** Наименование вакансии */
    public String getName() {
        return name;
    }

    /** Наименование компании */
    public String getNameCompany() {
        return nameCompany;
    }

    /** Минимальный уровень заработной платы */
    public int getMinSalary() {
        return minSalary;
    }

    /** Максимальный уровень заработной платы */
    public int getMaxSalary() {
        return maxSalary;
    }

    /** Обязанности */
    public String getResponsibilities() {
        return responsibilities;
    }

    /** Требования */
    public String getRequirements() {
        return requirements;
    }

    /** Условия */
    public String getConditions() {
        return conditions;
    }

    @Override
    public String toString() {
        String info = "------ Данные вакансии компании " + nameCompany + " -------\n" +
                        "* Наименование вакансии: " + name + ";\n" +
                        "* Наименование компании: " + nameCompany + ";\n" +
                        "* Минимальный уровень заработной платы: " + minSalary + ";\n" +
                        "* Максимальный уровень заработной платы: " + maxSalary + ";\n" +
                        "* Обязанности: " + responsibilities + ";\n" +
                        "* Требования: " + requirements + ";\n" +
                        "* Условия: " + conditions + "\n";
        return info;
    }


    @Override
    public boolean equals(Object obj) {
        JobVacancy v = (JobVacancy)obj;
        return this.name == v.name &&
            this.nameCompany == v.nameCompany &&
            this.minSalary == v.minSalary &&
            this.maxSalary == v.maxSalary &&
            this.responsibilities == v.responsibilities &&
            this.requirements == v.requirements &&
            this.conditions == v.conditions
        ;
    }
}