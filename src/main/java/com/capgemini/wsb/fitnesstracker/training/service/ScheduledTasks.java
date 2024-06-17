package com.capgemini.wsb.fitnesstracker.training.service;



// PLIK BYŁ UŻYWANY NA POTRZEBY TESTÓW



//import com.capgemini.wsb.fitnesstracker.mail.api.EmailDto;
//import com.capgemini.wsb.fitnesstracker.mail.api.EmailSender;
//import com.capgemini.wsb.fitnesstracker.training.api.Training;
//import com.capgemini.wsb.fitnesstracker.training.internal.TrainingRepository;
//import com.capgemini.wsb.fitnesstracker.user.api.User;
//import com.capgemini.wsb.fitnesstracker.user.internal.UserRepository;
//import org.hibernate.annotations.Comment;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
//@Component
//public class ScheduledTasks {
//
//    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
//
//    // Testy schedulera
//    @Scheduled(fixedRate = 5000)
//    public void reportCurrentTime() {
//        System.out.println("The time is now ");
//    }
//
//
//    @Autowired
//    private TrainingRepository trainingRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private EmailSender emailSender;
//
//
//    // Wysyłanie maili co
//    //@Scheduled(initialDelay=1000, fixedRate=5000) // testy schedulera - maile wysyłają sie prawidłowo
//    //@Scheduled(cron = "30 1 1,15 * *") // ustawienie wysyłania co 2 tygodnie 1 i 15 każdego miesiąca o godzinie 1:30
//
//    // nie jestem w stanie doprowadzić do działania aplikacji z wykorzystaniem crona dlatego podałem 2 tygodnie przeliczone na milisekundy
//    @Scheduled(initialDelay=1000, fixedRate=1209600000)
//    public void sendBIWeeklyReports() {
//        Date endTime = new Date();
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(endTime);
//        calendar.add(Calendar.DAY_OF_YEAR, -7);
//        Date startTime = calendar.getTime();
//
//        List<User> users = userRepository.findAll();
//
//        for (User user : users) {
//            List<Training> trainings = trainingRepository.findTrainingsForUserInTimeRange(user.getId(), startTime, endTime);
//            String reportContent = generateReportContent(user, trainings);
//            sendEmail(user.getEmail(), reportContent);
//            System.out.println("mail sent");
//        }
//    }
//
//    private String generateReportContent(User user, List<Training> trainings) {
//        StringBuilder content = new StringBuilder();
//        content.append("Cześć ").append(user.getFirstName()).append(",\n\n");
//        content.append("Oto podsumowanie Twoich treningów z ostatnich 2 tygodni:\n\n");
//
//        int totalTrainings = trainings.size();
//        content.append("Liczba treningów: ").append(totalTrainings).append("\n");
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//
//        for (Training training : trainings) {
//            content.append("Trening z dnia ").append(sdf.format(training.getStartTime()))
//                    .append(" - ").append(training.getActivityType())
//                    .append(", Dystans: ").append(training.getDistance())
//                    .append(" km, Średnia prędkość: ").append(training.getAverageSpeed())
//                    .append(" km/h\n");
//        }
//
//        content.append("\nTrzymaj tak dalej!\n");
//        return content.toString();
//    }
//
//    private void sendEmail(String toAddress, String content) {
//        EmailDto email = new EmailDto(toAddress, "DwuTygodniowy raport treningowy", content);
//        emailSender.send(email);
//    }
//
//}

