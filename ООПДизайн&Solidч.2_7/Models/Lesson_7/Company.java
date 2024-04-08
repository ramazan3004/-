package Lesson_7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import Lesson_7.Interfaces.Publisher;

public class Company {

    /** Коллекция вакансий компании */
    private Collection<JobVacancy> vacancys = new ArrayList<>();

    private Random random = new Random();

    /** Наименвоание компании */
    private String name;

    /** Нанятое агенство по поиску сотрудников */
    private Publisher jobAgency;

    /** Уровень заработной платы */
    private int maxSalary;

    /**
     * Конструктор класса
     * @param name Наименвоание компании
     * @param jobAgency Нанятое агенство по поиску сотрудников
     * @param maxSalary
     */
    public Company(String name, Publisher jobAgency, int maxSalary) {
        this.name = name;
        this.jobAgency = jobAgency;
        this.maxSalary = maxSalary;
    }

    /**
     * Получить Наименование компании
     * @return
     */
    public String getName() {
        return name;
    }
    
    /**
     * Добавить вакансию
     * @param vacancy Данные о вакансии
     */
    public void addVacancy(JobVacancy vacancy) {
        vacancys.add(vacancy);
    }

    /**
     * Разослать вакансии кандидатам
     */
    public void sendOutVacancies () {
        for (JobVacancy vacancy : vacancys) {
            jobAgency.sendVacancy(vacancy);
        }
    }
    
    /**
     * Отправить предложение кандидату
     */
    public void needEmployee() {
        int salary = random.nextInt(maxSalary);
        for (JobVacancy vacancy : vacancys) {
            jobAgency.sendOffer(vacancy, salary);
        }
    }

    /**
     * Получить данные о вакансиях компании
     */
    public void getVacancysInfo() {
        for (JobVacancy vacancy : vacancys) {
            System.out.println(vacancy);
        }
    }
}
