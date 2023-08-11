package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.util.*;

public class RegistrationFormDataGenerator {
    private final List<String> HOBBY_LIST = new ArrayList<>(Arrays.asList("Music", "Sports", "Reading"));
    private final List<String> GENDER_LIST = new ArrayList<>(Arrays.asList("Male", "Female", "Other"));
    private final List<String> SUBJECT_LIST = new ArrayList<>(Arrays.asList("Hindi", "English", "Maths",
            "Physics", "Chemistry", "Biology", "Computer Science", "Commerce", "Accounting",
            "Economics", "Arts", "Social Studies", "History", "Civics"));
    private final List<String> STATE_LIST = new ArrayList<>(Arrays.asList("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"));
    private final Map<String, List<String>> STATE_CITY_DATA = new HashMap<>() {{
        put("NCR", Arrays.asList("Delhi", "Gurgaon", "Noida"));
        put("Uttar Pradesh", Arrays.asList("Agra", "Lucknow", "Merrut"));
        put("Haryana", Arrays.asList("Karnal", "Panipat"));
        put("Rajasthan", Arrays.asList("Jaipur", "Jaiselmer"));
    }};

    private Locale locale = new Locale("en-IND");
    private Faker faker = new Faker(locale);
    private Random random = new Random();

    public String generateFirstName() {
        return faker.name().firstName();
    }

    public String generateLastName() {
        return faker.name().lastName();
    }

    public String generateGender() {
        return GENDER_LIST.get(random.nextInt(GENDER_LIST.size()));
    }

    public Date generateBirthDate() {
        return faker.date().birthday();
    }

    public String generateUserEmail() {
        return faker.internet().emailAddress();
    }

    public String generatePhoneNumber() {
        return faker.numerify("##########");
    }

    private List<String> generateRandomItems(List<String> sourceList, int numberOfItems) {
        List<String> generatedItems = new ArrayList<>();

        while (generatedItems.size() < numberOfItems) {
            String newItem = sourceList.get(random.nextInt(sourceList.size()));
            if (!generatedItems.contains(newItem)) {
                generatedItems.add(newItem);
            }
        }
        return generatedItems;
    }

    public List<String> generateSubject(int numberOfItems) {
        return generateRandomItems(SUBJECT_LIST, numberOfItems);
    }

    public List<String> generateHobby(int numberOfItems) {
        return generateRandomItems(HOBBY_LIST, numberOfItems);
    }

    public String generateState() {
        return STATE_LIST.get(random.nextInt(STATE_LIST.size()));
    }

    public String generateCity(String stateName) {
        List<String> cities = STATE_CITY_DATA.get(stateName);
        return cities.get(random.nextInt(cities.size()));
    }

    public String generateAddress() {
        return faker.address().streetAddress();
    }

    public String generatePicture() {
        return "empty.jpg";
    }
}
