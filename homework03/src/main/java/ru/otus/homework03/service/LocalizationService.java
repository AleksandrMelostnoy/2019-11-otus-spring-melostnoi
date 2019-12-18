package ru.otus.homework03.service;

public interface LocalizationService {

    String outputTextForEnterCorrectAnswer();

    void outputTextForRangeWarningMessage(int maxAnswerNumber);

    void outputTextForExceptionErrorMessage(int maxAnswerNumber);

    void outputTextForEnterFirstName();

    void outputTextForEnterLastName();

    void outputTextForResultMessage(String studentFullName, int correctAnswers, int questionsNumber);

}
