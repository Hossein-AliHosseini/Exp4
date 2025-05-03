@tag
Feature: Appointment Management
  As a clinic manager
  I want to manage patient appointments based on insurance status, doctor specialty, and availability
  To prevent scheduling conflicts and maximize patient satisfaction

  Scenario Outline: Manage appointment status based on business rules
    Given a <patientType> patient with <insuranceStatus> insurance
    And Doctor <doctorName> from <department> department is available until <availableUntil>
    When requesting an appointment at <appointmentTime>
    Then the appointment should be <expectedResult>

    Examples:
      | patientType | insuranceStatus | doctorName   | department | availableUntil | appointmentTime       | expectedResult |
      | عادی        | تاییدشده        | دکتر رضوی    | قلب        | 2023-12-31     | 2023-10-10 10:00      | تایید          |
      | اورژانسی    | ردشده          | دکتر حسینی   | اطفال      | 2023-11-15     | 2023-11-20 09:30      | لغو            |
      | عادی        | ردشده          | دکتر محمدی   | ارتوپدی    | 2024-01-10     | 2023-12-25 14:00      | لغو            |