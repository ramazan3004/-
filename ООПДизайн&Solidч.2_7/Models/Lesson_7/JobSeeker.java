package Lesson_7;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.text.Position;

import Lesson_7.Interfaces.Observer;

public class JobSeeker implements Observer {

    /** Идентификатор соискателя */
    private static int id;

    /** Имя соискателя */
    private String name;

    /** Желаемая должность */
    private String position;

    /** Желаемая зарплата */
    private int salary;

    /** Опыт работы в жалаемой должности */
    private double experience;

    /** Коллекция вакансий для рассмотрения */
    private Collection<JobVacancy> vacancys = new ArrayList<>();

    /**
     * Конструктор класса
     * @param name Имя соискателя
     * @param position Желаемая должность
     * @param salary Желаемая зарплата
     * @param experience Опыт работы в жалаемой должности
     */
    public JobSeeker(String name, String position, int salary, double experience) {
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.experience = experience;
        id++;
    }
    
    /**
     * Получить идентификатор соискателя
     * @return
     */
    public int getID() {
        return id;
    }
    
    /**
     * Получить имя соискателя
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Получить желаемую должность
     * @return
     */
    public String getPosition() {
        return position;
    }

    /**
     * Получить желаемую зарплату
     * @return
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Получить опыт работы в жалаемой должности
     * @return
     */
    public double getExperience() {
        return experience;
    }

    /**
     * Получить выбранную вакансию
     * @return
     */
    public JobVacancy getSelectedVacancy() {
        int salaryResult = 0;
        JobVacancy vacancyResult = null;
        for (JobVacancy vacancy : vacancys) {
            int maxSalary = vacancy.getMaxSalary();
            if (maxSalary > salaryResult) {
                salaryResult = maxSalary;
                vacancyResult = vacancy;
            }
        }
        return vacancyResult;
    }
    
    @Override
    public String toString() {
        String info = "------ Данные соискателя -------\n" +
                        "* Имя: " + name + ";\n" +
                        "* Желаемая должность: " + position + ";\n" +
                        "* Желаемая зарплата: " + salary + ";\n" +
                        "* Опыт работы: " + experience + "\n";
        return info;
    }

    @Override
    public void receiveVacancy(JobVacancy vacancy) {
        if ((vacancy.getMinSalary() > salary || vacancy.getMaxSalary() > salary) && vacancy.getName() == position) {
            vacancys.add(vacancy);

            System.out.printf("Соискатель %s. Желаемая ЗП: %s. Ваше предложение меня заинтересовало! (компания: %s; заработная плата от %s до %s)\n",
                            name, salary, vacancy.getNameCompany(), vacancy.getMinSalary(), vacancy.getMaxSalary());
        }
        else {
            System.out.printf("Соискатель %s. Желаемая ЗП: %s. Я найду работу получше! (компания: %s; заработная плата от %s до %s)\n",
                            name, salary, vacancy.getNameCompany(), vacancy.getMinSalary(), vacancy.getMaxSalary());
        }
    }

    @Override
    public Boolean receiveOffer(JobVacancy vacancy, int salaryResult) {
        vacancys.remove(vacancy);
        if (this.salary <= salaryResult){
            System.out.printf("Соискатель %s. Желаемая ЗП: %s Мне нужна эта работа! (компания: %s; предложенная ЗП: %d)\n",
                            name, salary, vacancy.getNameCompany(), salaryResult);
            this.salary = salaryResult;
            return true;
        }
        else {
            System.out.printf("Соискатель %s. Желаемая ЗП: %s. Я найду работу получше! (компания: %s; предложенная ЗП: %d)\n",
                            name, salary, vacancy.getNameCompany(), salaryResult);
            return false;
        }
        
    }
}
