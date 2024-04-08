package Lesson_7.Interfaces;

import Lesson_7.JobSeeker;
import Lesson_7.JobVacancy;

public interface Publisher {

    /**
     * Метод отправки предложения о работе
     * @param companyName Имя компании от которой отправляется преложение
     * @param salary ЗП для кандидата
     */
    void sendOffer(JobVacancy vacancy, int salary);

    /**
     * Метод отправки вакансии от компании
     * @param vacancy Данные вакансии
     */
    void sendVacancy(JobVacancy vacancy);

    /**
     * метод регистрации наблюдателя
     * @param observer Наблюдатель
     */
    void registerObserver(JobSeeker observer);

    /**
     * Метод удлаения наблюдателя
     * @param observer Наблюдатель
     */
    void removeObserver(JobSeeker observer);

    /**
     * Получить данные о соискателях имеющихся в агентской компании
     */
    void getJobSeekerInfo();
}
