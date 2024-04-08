import Lesson_7.Company;
import Lesson_7.JobAgency;
import Lesson_7.JobSeeker;
import Lesson_7.JobVacancy;
import Lesson_7.Interfaces.Publisher;

public class Lesson_7 {

    public static void main(String[] args) {
        
        Publisher publisher = new JobAgency();
        Company google = new Company("Google", publisher, 120000);
        Company yandex = new Company("Yandex", publisher, 95000);
        Company geekBrains = new Company("GeekBrains", publisher, 98000);

        google.addVacancy(new JobVacancy("Инженер-программист",
                                google.getName(),
                                70000,
                                110000,
                                "Разработка программного обеспечения ПЛК для объектов нефтяной и газовой промышленности",
                                "Знание языков IEC 61131-3 (IL, ST, LD, FBD)",
                                "Оформление в соответствии с ТК РФ"));

        yandex.addVacancy(new JobVacancy("Ведущий Инженер-программист",
                                yandex.getName(),
                                150000,
                                190000,
                                "Разработка программного обеспечения SCADA-систем",
                                "Высшее образование, Знание SQL, VBA, Java",
                                "Размер ЗП определяется по итогам собеседования"));

        geekBrains.addVacancy(new JobVacancy("Главный специалист АСУТП",
                                geekBrains.getName(),
                                90000,
                                130000,
                                "Проведение ПНР на объектах заказчика",
                                "Знание ОС Linux, Windows",
                                "Работа в официально аккредитованной IT компании"));

        google.getVacancysInfo();
        yandex.getVacancysInfo();
        geekBrains.getVacancysInfo();
        

        JobSeeker student1 = new JobSeeker("Студент #1", "Инженер-программист", 90000, 3);
        JobSeeker master1 = new JobSeeker("Мастер #1", "Ведущий Инженер-программист", 120000, 5);
        JobSeeker master2 = new JobSeeker("Мастер #2", "Главный специалист", 150000, 7);

        publisher.registerObserver(student1);
        publisher.registerObserver(master1);
        publisher.registerObserver(master2);

        publisher.getJobSeekerInfo();

        System.out.println("=============================== Рассылка открытых вакансий ===============================");
        for (int i = 0; i < 3; i++){
            google.sendOutVacancies();
            yandex.sendOutVacancies();
            geekBrains.sendOutVacancies();
            System.out.println();
        }

        // System.out.println();

        System.out.println("=============================== Рассылка предложений о работе ===============================");
        for (int i = 0; i < 3; i++){
            google.needEmployee();
            System.out.println();

            yandex.needEmployee();
            System.out.println();

            geekBrains.needEmployee();
            System.out.println();
        }
        
    }
}
