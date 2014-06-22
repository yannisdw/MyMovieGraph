package be.dewolf.mg.moviedb.transferobjects;

import be.dewolf.mg.base.Builder;
import com.google.common.base.Preconditions;

import java.util.Date;

/**
 * Created by yannis on 22/06/14.
 */
public class Person {

    private String name;
    private Date birthDate;

    private Person() {

    }

    public static Builder<Person> builder() {
        return new PersonBuilder();
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return new Date(birthDate.getTime());
    }

    public static class PersonBuilder implements Builder<Person> {

        private String name;
        private Date birthDate;

        public PersonBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder setBirthDate(Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        @Override
        public Person build() {

            Preconditions.checkNotNull(name);
            Preconditions.checkState(!name.isEmpty());
            Preconditions.checkNotNull(birthDate);

            Person person = new Person();
            person.name = name;
            person.birthDate = birthDate;

            return person;
        }
    }
}
