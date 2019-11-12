package com.ing.tech;


import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class TestExamples {

    @Test
    public void shouldReturnInsuranceName() {
//        Get the name of an insurance policy that a person may have
//        , only if the person’s age is greater than a certain number:
        int age = 18;

        Insurance insurance = new Insurance("ASTRA");
        Car car = new Car(Optional.of(insurance));
        Optional<Person> person = Optional.of(new Person(19, Optional.of(car)));

        Optional<String> s = person
                .filter(p -> p.getAge() > age)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName);

        Assert.assertEquals("ASTRA", s.get());
    }

    @Test
    public void test() {
        Insurance insurance = new Insurance("ASTRA");

        Optional<Insurance> optionalInsurance = Optional.of(insurance);
        Optional<String> s = optionalInsurance.map(Insurance::getName);
        Assert.assertEquals("ASTRA", s.get());


        optionalInsurance = Optional.ofNullable(null);
        Optional<String> s1 = optionalInsurance.map(Insurance::getName);
        Assert.assertEquals(s1, Optional.empty());
    }


    @Test
    public void shouldBeEmptyIfNullValueProvided() {
        Optional opt = Optional.ofNullable(null);

        Assert.assertEquals(Optional.empty(), opt);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNPE() {
        Optional.of(null);
    }

    @Test
    public void shouldHaveTheSameName() {
        String expected = "example";
        String actual = "example";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldHaveADifferentName() {
        String expected = "example";
        String actual = "example1";

        Assert.assertNotEquals(expected, actual);
    }


}
