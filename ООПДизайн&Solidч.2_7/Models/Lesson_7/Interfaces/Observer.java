package Lesson_7.Interfaces;

import Lesson_7.JobVacancy;

public interface Observer {

    /**
     * Отправка вакансии
     * @param vacancy Данные о вакансии
     */
    void receiveVacancy(JobVacancy vacancy);

    /**
     * Отправка предложения о работе
     * @param nameCompany
     * @param salary
     */
    Boolean receiveOffer(JobVacancy vacancy, int salaryResult);
}
